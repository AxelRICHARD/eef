/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.views.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.emf.eef.views.providers.ViewsMessages;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ViewReferencePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ViewReferencePropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer referencedView;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ViewReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
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
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(ViewsMessages.ViewReferencePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(widgetFactory, propertiesGroup);
		createReferencedViewFlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ViewsMessages.ViewReferencePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(ViewsViewsRepository.ViewReference.name, ViewsViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewReferencePropertiesEditionPartForm.this, ViewsViewsRepository.ViewReference.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewReferencePropertiesEditionPartForm.this, ViewsViewsRepository.ViewReference.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, ViewsViewsRepository.ViewReference.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewsViewsRepository.ViewReference.name, ViewsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 * 
	 */
	protected void createReferencedViewFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, ViewsMessages.ViewReferencePropertiesEditionPart_ReferencedViewLabel, propertiesEditionComponent.isRequired(ViewsViewsRepository.ViewReference.referencedView, ViewsViewsRepository.FORM_KIND));
		referencedView = new EObjectFlatComboViewer(parent, false);
		referencedView.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData referencedViewData = new GridData(GridData.FILL_HORIZONTAL);
		referencedView.setLayoutData(referencedViewData);
		referencedView.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ViewReferencePropertiesEditionPartForm.this, ViewsViewsRepository.ViewReference.referencedView, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getReferencedView()));
			}

		});
		referencedView.setID(ViewsViewsRepository.ViewReference.referencedView);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ViewsViewsRepository.ViewReference.referencedView, ViewsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// Nothing to do
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#getReferencedView()
	 * 
	 */
	public EObject getReferencedView() {
		if (referencedView.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) referencedView.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#initReferencedView(EObjectFlatComboSettings)
	 */
	public void initReferencedView(EObjectFlatComboSettings settings) {
		referencedView.setInput(settings);
		if (current != null) {
			referencedView.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#setReferencedView(EObject newValue)
	 * 
	 */
	public void setReferencedView(EObject newValue) {
		if (newValue != null) {
			referencedView.setSelection(new StructuredSelection(newValue));
		} else {
			referencedView.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#setReferencedViewButtonMode(ButtonsModeEnum newValue)
	 */
	public void setReferencedViewButtonMode(ButtonsModeEnum newValue) {
		referencedView.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#addFilterReferencedView(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReferencedView(ViewerFilter filter) {
		referencedView.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.ViewReferencePropertiesEditionPart#addBusinessFilterReferencedView(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReferencedView(ViewerFilter filter) {
		referencedView.addBusinessRuleFilter(filter);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ViewsMessages.ViewReference_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
