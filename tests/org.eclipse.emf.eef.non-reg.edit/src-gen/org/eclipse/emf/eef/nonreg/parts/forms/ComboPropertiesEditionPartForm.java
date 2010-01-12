/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
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

// End of user code

/**
 * 
 */
public class ComboPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ComboPropertiesEditionPart {

	protected EMFComboViewer combo;
	protected EMFComboViewer comboRO;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ComboPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createComboEMFComboViewer(widgetFactory, view);

		createComboROEMFComboViewer(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createComboEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.ComboPropertiesEditionPart_ComboLabel, true);
		combo = new EMFComboViewer(parent);
		GridData comboData = new GridData(GridData.FILL_HORIZONTAL);
		combo.getCombo().setLayoutData(comboData);
		combo.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		combo.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComboPropertiesEditionPartForm.this, NonregViewsRepository.Combo.combo, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCombo()));
			}

		});
		combo.setContentProvider(new EMFListContentProvider());
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Combo.combo, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createComboROEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.ComboPropertiesEditionPart_ComboROLabel, true);
		comboRO = new EMFComboViewer(parent);
		comboRO.setEnabled(false);
		comboRO.setToolTipText(NonregMessages.Combo_ReadOnly);
		GridData comboROData = new GridData(GridData.FILL_HORIZONTAL);
		comboRO.getCombo().setLayoutData(comboROData);
		comboRO.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		comboRO.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComboPropertiesEditionPartForm.this, NonregViewsRepository.Combo.comboRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getComboRO()));
			}

		});
		comboRO.setContentProvider(new EMFListContentProvider());
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Combo.comboRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#getCombo()
	 */
	public Object getCombo() {
		if (combo.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) combo.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#initCombo(ResourceSet allResources, EObject current)
	 */
	public void initCombo(ResourceSet allResources, EObject current) {
		combo.setInput(allResources);
		if (current != null) {
			combo.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#setCombo(Object newValue)
	 */
	public void setCombo(Object newValue) {
		if (newValue != null) {
			combo.modelUpdating(new StructuredSelection(newValue));
		} else {
			combo.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#addFilterCombo(ViewerFilter filter)
	 */
	public void addFilterToCombo(ViewerFilter filter) {
		combo.addFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#getComboRO()
	 */
	public Object getComboRO() {
		if (comboRO.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) comboRO.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#initComboRO(ResourceSet allResources, EObject current)
	 */
	public void initComboRO(ResourceSet allResources, EObject current) {
		comboRO.setInput(allResources);
		if (current != null) {
			comboRO.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#setComboRO(Object newValue)
	 */
	public void setComboRO(Object newValue) {
		if (newValue != null) {
			comboRO.modelUpdating(new StructuredSelection(newValue));
		} else {
			comboRO.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#addFilterComboRO(ViewerFilter filter)
	 */
	public void addFilterToComboRO(ViewerFilter filter) {
		comboRO.addFilter(filter);
	}










	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return NonregMessages.Combo_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
