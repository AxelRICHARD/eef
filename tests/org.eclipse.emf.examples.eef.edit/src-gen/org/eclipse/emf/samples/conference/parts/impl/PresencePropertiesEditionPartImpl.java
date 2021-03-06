/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.samples.conference.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class PresencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PresencePropertiesEditionPart {

	protected ReferencesTable assists;
	protected List<ViewerFilter> assistsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> assistsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PresencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence presenceStep = new BindingCompositionSequence(propertiesEditionComponent);
		presenceStep
			.addStep(ConferenceViewsRepository.Presence.Talks.class)
			.addStep(ConferenceViewsRepository.Presence.Talks.assists);
		
		
		composer = new PartComposer(presenceStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ConferenceViewsRepository.Presence.Talks.class) {
					return createTalksGroup(parent);
				}
				if (key == ConferenceViewsRepository.Presence.Talks.assists) {
					return createAssistsAdvancedReferencesTable(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createTalksGroup(Composite parent) {
		Group talksGroup = new Group(parent, SWT.NONE);
		talksGroup.setText(ConferenceMessages.PresencePropertiesEditionPart_TalksGroupLabel);
		GridData talksGroupData = new GridData(GridData.FILL_HORIZONTAL);
		talksGroupData.horizontalSpan = 3;
		talksGroup.setLayoutData(talksGroupData);
		GridLayout talksGroupLayout = new GridLayout();
		talksGroupLayout.numColumns = 3;
		talksGroup.setLayout(talksGroupLayout);
		return talksGroup;
	}

	/**
	 * 
	 */
	protected Composite createAssistsAdvancedReferencesTable(Composite parent) {
		String label = getDescription(ConferenceViewsRepository.Presence.Talks.assists, ConferenceMessages.PresencePropertiesEditionPart_AssistsLabel);		 
		this.assists = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addAssists(); }
			public void handleEdit(EObject element) { editAssists(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAssists(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAssists(element); }
			public void navigateTo(EObject element) { }
		});
		this.assists.setHelpText(propertiesEditionComponent.getHelpContent(ConferenceViewsRepository.Presence.Talks.assists, ConferenceViewsRepository.SWT_KIND));
		this.assists.createControls(parent);
		this.assists.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Presence.Talks.assists, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData assistsData = new GridData(GridData.FILL_HORIZONTAL);
		assistsData.horizontalSpan = 3;
		this.assists.setLayoutData(assistsData);
		this.assists.disableMove();
		assists.setID(ConferenceViewsRepository.Presence.Talks.assists);
		assists.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addAssists() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(assists.getInput(), assistsFilters, assistsBusinessFilters,
		"assists", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Presence.Talks.assists,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				assists.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAssists(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Presence.Talks.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		assists.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAssists(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, ConferenceViewsRepository.Presence.Talks.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		assists.refresh();
	}

	/**
	 * 
	 */
	protected void editAssists(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				assists.refresh();
			}
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#initAssists(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAssists(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		assists.setContentProvider(contentProvider);
		assists.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#updateAssists()
	 * 
	 */
	public void updateAssists() {
	assists.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#addFilterAssists(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAssists(ViewerFilter filter) {
		assistsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#addBusinessFilterAssists(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAssists(ViewerFilter filter) {
		assistsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart#isContainedInAssistsTable(EObject element)
	 * 
	 */
	public boolean isContainedInAssistsTable(EObject element) {
		return ((ReferencesTableSettings)assists.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ConferenceMessages.Presence_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
