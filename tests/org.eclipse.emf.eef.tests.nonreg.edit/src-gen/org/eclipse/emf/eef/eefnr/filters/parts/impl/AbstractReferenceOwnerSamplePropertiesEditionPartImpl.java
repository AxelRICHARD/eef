/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.filters.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnr.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.filters.parts.FiltersViewsRepository;
import org.eclipse.emf.eef.eefnr.filters.providers.FiltersMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AbstractReferenceOwnerSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AbstractReferenceOwnerSamplePropertiesEditionPart {

	protected Text name;
	protected ReferencesTable abstractTarget;
	protected List<ViewerFilter> abstractTargetBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> abstractTargetFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AbstractReferenceOwnerSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence abstractReferenceOwnerSampleStep = new CompositionSequence();
		CompositionStep propertiesStep = abstractReferenceOwnerSampleStep.addStep(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.class);
		propertiesStep.addStep(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name);
		propertiesStep.addStep(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget);
		
		
		composer = new PartComposer(abstractReferenceOwnerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name) {
					return createNameText(parent);
				}
				if (key == FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget) {
					return createAbstractTargetAdvancedReferencesTable(parent);
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
		propertiesGroup.setText(FiltersMessages.AbstractReferenceOwnerSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, FiltersMessages.AbstractReferenceOwnerSamplePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name, FiltersViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.name, FiltersViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createAbstractTargetAdvancedReferencesTable(Composite parent) {
		this.abstractTarget = new ReferencesTable(FiltersMessages.AbstractReferenceOwnerSamplePropertiesEditionPart_AbstractTargetLabel, new ReferencesTableListener() {
			public void handleAdd() { addAbstractTarget(); }
			public void handleEdit(EObject element) { editAbstractTarget(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveAbstractTarget(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromAbstractTarget(element); }
			public void navigateTo(EObject element) { }
		});
		this.abstractTarget.setHelpText(propertiesEditionComponent.getHelpContent(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget, FiltersViewsRepository.SWT_KIND));
		this.abstractTarget.createControls(parent);
		this.abstractTarget.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData abstractTargetData = new GridData(GridData.FILL_HORIZONTAL);
		abstractTargetData.horizontalSpan = 3;
		this.abstractTarget.setLayoutData(abstractTargetData);
		this.abstractTarget.disableMove();
		abstractTarget.setID(FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget);
		abstractTarget.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addAbstractTarget() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(abstractTarget.getInput(), abstractTargetFilters, abstractTargetBusinessFilters,
		"abstractTarget", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				abstractTarget.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveAbstractTarget(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		abstractTarget.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromAbstractTarget(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AbstractReferenceOwnerSamplePropertiesEditionPartImpl.this, FiltersViewsRepository.AbstractReferenceOwnerSample.Properties.abstractTarget, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		abstractTarget.refresh();
	}

	/**
	 * 
	 */
	protected void editAbstractTarget(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				abstractTarget.refresh();
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
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#initAbstractTarget(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initAbstractTarget(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		abstractTarget.setContentProvider(contentProvider);
		abstractTarget.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#updateAbstractTarget()
	 * 
	 */
	public void updateAbstractTarget() {
	abstractTarget.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#addFilterAbstractTarget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAbstractTarget(ViewerFilter filter) {
		abstractTargetFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#addBusinessFilterAbstractTarget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAbstractTarget(ViewerFilter filter) {
		abstractTargetBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.AbstractReferenceOwnerSamplePropertiesEditionPart#isContainedInAbstractTargetTable(EObject element)
	 * 
	 */
	public boolean isContainedInAbstractTargetTable(EObject element) {
		return ((ReferencesTableSettings)abstractTarget.getInput()).contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return FiltersMessages.AbstractReferenceOwnerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}