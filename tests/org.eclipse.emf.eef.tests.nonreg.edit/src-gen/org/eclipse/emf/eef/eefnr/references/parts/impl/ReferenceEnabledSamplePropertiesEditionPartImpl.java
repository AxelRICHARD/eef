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
package org.eclipse.emf.eef.eefnr.references.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnr.references.parts.AbstractEnabledSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.references.parts.ReferencesViewsRepository;
import org.eclipse.emf.eef.eefnr.references.providers.ReferencesMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
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
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferenceEnabledSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ReferenceEnabledSamplePropertiesEditionPart {

	protected ReferencesTable reference;
	protected List<ViewerFilter> referenceBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> referenceFilters = new ArrayList<ViewerFilter>();
	private AbstractEnabledSamplePropertiesEditionPart abstractEnabledSamplePropertiesEditionPart;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ReferenceEnabledSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence referenceEnabledSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		referenceEnabledSampleStep
			.addStep(ReferencesViewsRepository.ReferenceEnabledSample.Properties.class)
			.addStep(ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference);
		
		referenceEnabledSampleStep.addStep(ReferencesViewsRepository.ReferenceEnabledSample.abstractEnabledSampleReference);
		
		composer = new PartComposer(referenceEnabledSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ReferencesViewsRepository.ReferenceEnabledSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference) {
					return createReferenceAdvancedReferencesTable(parent);
				}
				if (key == ReferencesViewsRepository.ReferenceEnabledSample.abstractEnabledSampleReference) {
					return createAbstractEnabledSample(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ReferencesMessages.ReferenceEnabledSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * 
	 */
	protected Composite createReferenceAdvancedReferencesTable(Composite parent) {
		String label = getDescription(ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference, ReferencesMessages.ReferenceEnabledSamplePropertiesEditionPart_ReferenceLabel);		 
		this.reference = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addReference(); }
			public void handleEdit(EObject element) { editReference(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveReference(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromReference(element); }
			public void navigateTo(EObject element) { }
		});
		this.reference.setHelpText(propertiesEditionComponent.getHelpContent(ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference, ReferencesViewsRepository.SWT_KIND));
		this.reference.createControls(parent);
		this.reference.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData referenceData = new GridData(GridData.FILL_HORIZONTAL);
		referenceData.horizontalSpan = 3;
		this.reference.setLayoutData(referenceData);
		this.reference.disableMove();
		reference.setID(ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference);
		reference.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addReference() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(reference.getInput(), referenceFilters, referenceBusinessFilters,
		"reference", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				reference.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveReference(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		reference.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromReference(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.Properties.reference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		reference.refresh();
	}

	/**
	 * 
	 */
	protected void editReference(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				reference.refresh();
			}
		}
	}

	protected Composite createAbstractEnabledSample(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ReferencesViewsRepository.class);
		abstractEnabledSamplePropertiesEditionPart = (AbstractEnabledSamplePropertiesEditionPart)provider.getPropertiesEditionPart(ReferencesViewsRepository.AbstractEnabledSample.class, ReferencesViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)abstractEnabledSamplePropertiesEditionPart).createControls(container);
		return container;
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
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#initReference(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initReference(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		reference.setContentProvider(contentProvider);
		reference.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#updateReference()
	 * 
	 */
	public void updateReference() {
	reference.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#addFilterReference(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReference(ViewerFilter filter) {
		referenceFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#addBusinessFilterReference(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReference(ViewerFilter filter) {
		referenceBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#isContainedInReferenceTable(EObject element)
	 * 
	 */
	public boolean isContainedInReferenceTable(EObject element) {
		return ((ReferencesTableSettings)reference.getInput()).contains(element);
	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getAbstractEnabledSampleReferencedView()
	 * 
	 */
		public IPropertiesEditionPart getAbstractEnabledSampleReferencedView() {
			return (IPropertiesEditionPart) abstractEnabledSamplePropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getEnabled()
	 * 
	 */
	public Boolean getEnabled() {
		return abstractEnabledSamplePropertiesEditionPart.getEnabled();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.ReferenceEnabledSamplePropertiesEditionPart#setEnabled(Boolean newValue)
	 * 
	 */
	public void setEnabled(Boolean newValue) {
		abstractEnabledSamplePropertiesEditionPart.setEnabled(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.AbstractEnabledSamplePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return abstractEnabledSamplePropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.references.parts.AbstractEnabledSamplePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		abstractEnabledSamplePropertiesEditionPart.setName(newValue);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ReferencesMessages.ReferenceEnabledSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
