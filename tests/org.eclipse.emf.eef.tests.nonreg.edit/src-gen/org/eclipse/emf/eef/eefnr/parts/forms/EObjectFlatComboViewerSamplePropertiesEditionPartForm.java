/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EObjectFlatComboViewerSamplePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EObjectFlatComboViewerSamplePropertiesEditionPart {

	protected EObjectFlatComboViewer eobjectflatcomboviewerRequiredPropery;
	protected EObjectFlatComboViewer eobjectflatcomboviewerOptionalPropery;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EObjectFlatComboViewerSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EefnrMessages.EObjectFlatComboViewerSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createEobjectflatcomboviewerRequiredProperyFlatComboViewer(propertiesGroup, widgetFactory);
		createEobjectflatcomboviewerOptionalProperyFlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createEobjectflatcomboviewerRequiredProperyFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.EObjectFlatComboViewerSamplePropertiesEditionPart_EobjectflatcomboviewerRequiredProperyLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery, EefnrViewsRepository.FORM_KIND));
		eobjectflatcomboviewerRequiredPropery = new EObjectFlatComboViewer(parent, false);
		eobjectflatcomboviewerRequiredPropery.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eobjectflatcomboviewerRequiredProperyData = new GridData(GridData.FILL_HORIZONTAL);
		eobjectflatcomboviewerRequiredPropery.setLayoutData(eobjectflatcomboviewerRequiredProperyData);
		eobjectflatcomboviewerRequiredPropery.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEobjectflatcomboviewerRequiredPropery()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createEobjectflatcomboviewerOptionalProperyFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.EObjectFlatComboViewerSamplePropertiesEditionPart_EobjectflatcomboviewerOptionalProperyLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery, EefnrViewsRepository.FORM_KIND));
		eobjectflatcomboviewerOptionalPropery = new EObjectFlatComboViewer(parent, true);
		eobjectflatcomboviewerOptionalPropery.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eobjectflatcomboviewerOptionalProperyData = new GridData(GridData.FILL_HORIZONTAL);
		eobjectflatcomboviewerOptionalPropery.setLayoutData(eobjectflatcomboviewerOptionalProperyData);
		eobjectflatcomboviewerOptionalPropery.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EObjectFlatComboViewerSamplePropertiesEditionPartForm.this, EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEobjectflatcomboviewerOptionalPropery()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#getEobjectflatcomboviewerRequiredPropery()
	 */
	public EObject getEobjectflatcomboviewerRequiredPropery() {
		if (eobjectflatcomboviewerRequiredPropery.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eobjectflatcomboviewerRequiredPropery.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#initEobjectflatcomboviewerRequiredPropery(ResourceSet allResources, EObject current)
	 */
	public void initEobjectflatcomboviewerRequiredPropery(ResourceSet allResources, EObject current) {
		eobjectflatcomboviewerRequiredPropery.setInput(allResources);
		if (current != null) {
			eobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#setEobjectflatcomboviewerRequiredPropery(EObject newValue)
	 */
	public void setEobjectflatcomboviewerRequiredPropery(EObject newValue) {
		if (newValue != null) {
			eobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection(newValue));
		} else {
			eobjectflatcomboviewerRequiredPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#setEobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum newValue) {
		eobjectflatcomboviewerRequiredPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#addFilterEobjectflatcomboviewerRequiredPropery(ViewerFilter filter)
	 */
	public void addFilterToEobjectflatcomboviewerRequiredPropery(ViewerFilter filter) {
		eobjectflatcomboviewerRequiredPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#addBusinessFilterEobjectflatcomboviewerRequiredPropery(ViewerFilter filter)
	 */
	public void addBusinessFilterToEobjectflatcomboviewerRequiredPropery(ViewerFilter filter) {
		eobjectflatcomboviewerRequiredPropery.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#getEobjectflatcomboviewerOptionalPropery()
	 */
	public EObject getEobjectflatcomboviewerOptionalPropery() {
		if (eobjectflatcomboviewerOptionalPropery.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eobjectflatcomboviewerOptionalPropery.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#initEobjectflatcomboviewerOptionalPropery(ResourceSet allResources, EObject current)
	 */
	public void initEobjectflatcomboviewerOptionalPropery(ResourceSet allResources, EObject current) {
		eobjectflatcomboviewerOptionalPropery.setInput(allResources);
		if (current != null) {
			eobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#setEobjectflatcomboviewerOptionalPropery(EObject newValue)
	 */
	public void setEobjectflatcomboviewerOptionalPropery(EObject newValue) {
		if (newValue != null) {
			eobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection(newValue));
		} else {
			eobjectflatcomboviewerOptionalPropery.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#setEobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum newValue) {
		eobjectflatcomboviewerOptionalPropery.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#addFilterEobjectflatcomboviewerOptionalPropery(ViewerFilter filter)
	 */
	public void addFilterToEobjectflatcomboviewerOptionalPropery(ViewerFilter filter) {
		eobjectflatcomboviewerOptionalPropery.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart#addBusinessFilterEobjectflatcomboviewerOptionalPropery(ViewerFilter filter)
	 */
	public void addBusinessFilterToEobjectflatcomboviewerOptionalPropery(ViewerFilter filter) {
		eobjectflatcomboviewerOptionalPropery.addBusinessRuleFilter(filter);
	}










	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return EefnrMessages.EObjectFlatComboViewerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
