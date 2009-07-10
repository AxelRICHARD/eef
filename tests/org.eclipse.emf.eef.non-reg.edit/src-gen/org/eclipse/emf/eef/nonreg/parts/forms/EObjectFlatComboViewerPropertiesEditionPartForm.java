/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.Company;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class EObjectFlatComboViewerPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EObjectFlatComboViewerPropertiesEditionPart {

	protected EObjectFlatComboViewer eobjectflatcomboviewer;
	protected EObjectFlatComboViewer eobjectflatcomboviewerRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public EObjectFlatComboViewerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createEobjectflatcomboviewerFlatComboViewer(view, widgetFactory);
		createEobjectflatcomboviewerROFlatComboViewer(view, widgetFactory);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	/**
	 * @param view
	 */
	protected void createEobjectflatcomboviewerFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.EObjectFlatComboViewerPropertiesEditionPart_EobjectflatcomboviewerLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewer, NonregViewsRepository.FORM_KIND));
		eobjectflatcomboviewer = new EObjectFlatComboViewer(parent, true);
		eobjectflatcomboviewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData eobjectflatcomboviewerData = new GridData(GridData.FILL_HORIZONTAL);
		eobjectflatcomboviewer.setLayoutData(eobjectflatcomboviewerData);
		eobjectflatcomboviewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewer, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEobjectflatcomboviewer()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewer, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param view
	 */
	protected void createEobjectflatcomboviewerROFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.EObjectFlatComboViewerPropertiesEditionPart_EobjectflatcomboviewerROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewerRO, NonregViewsRepository.FORM_KIND));
		eobjectflatcomboviewerRO = new EObjectFlatComboViewer(parent, true);
		eobjectflatcomboviewerRO.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		eobjectflatcomboviewerRO.setEnabled(false);
		eobjectflatcomboviewerRO.setToolTipText(NonregMessages.EObjectFlatComboViewer_ReadOnly);
		GridData eobjectflatcomboviewerROData = new GridData(GridData.FILL_HORIZONTAL);
		eobjectflatcomboviewerRO.setLayoutData(eobjectflatcomboviewerROData);
		eobjectflatcomboviewerRO.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EObjectFlatComboViewerPropertiesEditionPartForm.this, NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewerRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEobjectflatcomboviewerRO()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.EObjectFlatComboViewer.eobjectflatcomboviewerRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#getEobjectflatcomboviewer()
	 */
	public EObject getEobjectflatcomboviewer() {
		if (eobjectflatcomboviewer.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eobjectflatcomboviewer.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#initEobjectflatcomboviewer(ResourceSet allResources, EObject current)
	 */
	public void initEobjectflatcomboviewer(ResourceSet allResources, EObject current) {
		eobjectflatcomboviewer.setInput(allResources);
		if (current != null) {
			eobjectflatcomboviewer.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#setEobjectflatcomboviewer(EObject newValue)
	 */
	public void setEobjectflatcomboviewer(EObject newValue) {
		if (newValue != null) {
			eobjectflatcomboviewer.setSelection(new StructuredSelection(newValue));
		} else {
			eobjectflatcomboviewer.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#setEobjectflatcomboviewerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEobjectflatcomboviewerButtonMode(ButtonsModeEnum newValue) {
		eobjectflatcomboviewer.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#addFilterEobjectflatcomboviewer(ViewerFilter filter)
	 */
	public void addFilterToEobjectflatcomboviewer(ViewerFilter filter) {
		eobjectflatcomboviewer.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#addBusinessFilterEobjectflatcomboviewer(ViewerFilter filter)
	 */
	public void addBusinessFilterToEobjectflatcomboviewer(ViewerFilter filter) {
		eobjectflatcomboviewer.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#getEobjectflatcomboviewerRO()
	 */
	public EObject getEobjectflatcomboviewerRO() {
		if (eobjectflatcomboviewerRO.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) eobjectflatcomboviewerRO.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#initEobjectflatcomboviewerRO(ResourceSet allResources, EObject current)
	 */
	public void initEobjectflatcomboviewerRO(ResourceSet allResources, EObject current) {
		eobjectflatcomboviewerRO.setInput(allResources);
		if (current != null) {
			eobjectflatcomboviewerRO.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#setEobjectflatcomboviewerRO(EObject newValue)
	 */
	public void setEobjectflatcomboviewerRO(EObject newValue) {
		if (newValue != null) {
			eobjectflatcomboviewerRO.setSelection(new StructuredSelection(newValue));
		} else {
			eobjectflatcomboviewerRO.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#setEobjectflatcomboviewerROButtonMode(ButtonsModeEnum newValue)
	 */
	public void setEobjectflatcomboviewerROButtonMode(ButtonsModeEnum newValue) {
		eobjectflatcomboviewerRO.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#addFilterEobjectflatcomboviewerRO(ViewerFilter filter)
	 */
	public void addFilterToEobjectflatcomboviewerRO(ViewerFilter filter) {
		eobjectflatcomboviewerRO.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.EObjectFlatComboViewerPropertiesEditionPart#addBusinessFilterEobjectflatcomboviewerRO(ViewerFilter filter)
	 */
	public void addBusinessFilterToEobjectflatcomboviewerRO(ViewerFilter filter) {
		eobjectflatcomboviewerRO.addBusinessRuleFilter(filter);
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
