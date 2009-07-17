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

import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.SourcePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.emf.eef.nonreg.modelNavigation.SuperCible;
import org.eclipse.emf.eef.nonreg.modelNavigation.RealCible;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationFactory;

import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.nonreg.modelNavigation.SuperCible;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code

/**
 * 
 */
public class SourcePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, SourcePropertiesEditionPart {

	protected AdvancedEObjectFlatComboViewer<SuperCible> advancedUniqueRef;
	protected ViewerFilter advancedUniqueRefFilter;
	private EMFListEditUtil advancedMultipleContainmentEditUtil;
	protected ReferencesTable<? extends EObject> advancedMultipleContainment;
	protected List<ViewerFilter> advancedMultipleContainmentBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> advancedMultipleContainmentFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SourcePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropsGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createPropsGroup(FormToolkit widgetFactory, final Composite view) {
		Section propsSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propsSection.setText(NonregMessages.SourcePropertiesEditionPart_PropsGroupLabel);
		GridData propsSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propsSectionData.horizontalSpan = 3;
		propsSection.setLayoutData(propsSectionData);
		Composite propsGroup = widgetFactory.createComposite(propsSection);
		GridLayout propsGroupLayout = new GridLayout();
		propsGroupLayout.numColumns = 3;
		propsGroup.setLayout(propsGroupLayout);
		createAdvancedUniqueRefFlatComboViewer(propsGroup, widgetFactory);
		createAdvancedMultipleContainmentReferencesTable(widgetFactory, propsGroup);
		propsSection.setClient(propsGroup);
	}
	/**
	 * @param propsGroup
	 */
	protected void createAdvancedUniqueRefFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.FORM_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<SuperCible> listener = new EObjectFlatComboViewerListener<SuperCible>(){
			public void handleSet(SuperCible element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedUniqueRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(SuperCible element){ }

			public SuperCible handleCreate() {
				SuperCible eObject = ModelNavigationFactory.eINSTANCE.createRealCible();
				if (current != null && current instanceof RealCible && ((RealCible)current).getRef() != null) {
					eObject = (SuperCible)EcoreUtil.copy(((RealCible)current).getRef());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedUniqueRef, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (SuperCible)propertiesEditionObject;
					}
					if (current != null && current instanceof RealCible && ((RealCible)current).getRef() != null)
						return eObject;
					return null;
				}
				return null;
			}

		};
		//create widget
		advancedUniqueRef = new AdvancedEObjectFlatComboViewer<SuperCible>(NonregMessages.SourcePropertiesEditionPart_AdvancedUniqueRefLabel, 
			resourceSet, advancedUniqueRefFilter, ModelNavigationPackage.eINSTANCE.getSuperCible(), listener);
		advancedUniqueRef.createControls(parent, widgetFactory);
		GridData advancedUniqueRefData = new GridData(GridData.FILL_HORIZONTAL);
		advancedUniqueRef.setLayoutData(advancedUniqueRefData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Source.advancedUniqueRef, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createAdvancedMultipleContainmentReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.advancedMultipleContainment = new ReferencesTable<SuperCible>(NonregMessages.SourcePropertiesEditionPart_AdvancedMultipleContainmentLabel, new ReferencesTableListener<SuperCible>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<SuperCible> dialog = new TabElementTreeSelectionDialog<SuperCible>(resourceSet, advancedMultipleContainmentFilters, advancedMultipleContainmentBusinessFilters,
				"SuperCible", ModelNavigationPackage.eINSTANCE.getSuperCible(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!advancedMultipleContainmentEditUtil.getVirtualList().contains(elem))
								advancedMultipleContainmentEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedMultipleContainment,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						advancedMultipleContainment.refresh();
					}
				};
				dialog.open();
			}
			public void handleEdit(SuperCible element) { editAdvancedMultipleContainment(element); }
			public void handleMove(SuperCible element, int oldIndex, int newIndex) { moveAdvancedMultipleContainment(element, oldIndex, newIndex); }
			public void handleRemove(SuperCible element) { removeFromAdvancedMultipleContainment(element); }
			public void navigateTo(SuperCible element) { }
		});
		this.advancedMultipleContainment.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.Source.advancedMultipleContainment, NonregViewsRepository.FORM_KIND));
		this.advancedMultipleContainment.createControls(parent, widgetFactory);
		GridData advancedMultipleContainmentData = new GridData(GridData.FILL_HORIZONTAL);
		advancedMultipleContainmentData.horizontalSpan = 3;
		this.advancedMultipleContainment.setLayoutData(advancedMultipleContainmentData);
		this.advancedMultipleContainment.disableMove();
	}

	/**
	 * 
	 */
	protected void moveAdvancedMultipleContainment(SuperCible element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void removeFromAdvancedMultipleContainment(SuperCible element) {
		// Start of user code for the removeFromAdvancedMultipleContainment() method body
		EObject editedElement = advancedMultipleContainmentEditUtil.foundCorrespondingEObject(element);
		advancedMultipleContainmentEditUtil.removeElement(element);
		advancedMultipleContainment.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedMultipleContainment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAdvancedMultipleContainment(SuperCible element) {
		// Start of user code editAdvancedMultipleContainment() method body
		
		EObject editedElement = advancedMultipleContainmentEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				advancedMultipleContainmentEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				advancedMultipleContainment.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SourcePropertiesEditionPartForm.this, NonregViewsRepository.Source.advancedMultipleContainment, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#getAdvancedUniqueRef()
	 */
	public EObject getAdvancedUniqueRef() {
		return advancedUniqueRef.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#initAdvancedUniqueRef(ResourceSet allResources, EObject current)
	 */
	public void initAdvancedUniqueRef(ResourceSet allResources, EObject current) {
		advancedUniqueRef.setInput(allResources);
		if (current != null) {
			advancedUniqueRef.setSelection(new StructuredSelection(current));
			advancedUniqueRef.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#setAdvancedUniqueRef(EObject newValue)
	 */
	public void setAdvancedUniqueRef(EObject newValue) {
		if (newValue != null) {
			advancedUniqueRef.setSelection(new StructuredSelection(newValue));
		} else {
			advancedUniqueRef.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#setAdvancedUniqueRefButtonMode(ButtonsModeEnum newValue)
	 */
	public void setAdvancedUniqueRefButtonMode(ButtonsModeEnum newValue) {
		advancedUniqueRef.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addFilterAdvancedUniqueRef(ViewerFilter filter)
	 */
	public void addFilterToAdvancedUniqueRef(ViewerFilter filter) {
		advancedUniqueRef.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addBusinessFilterAdvancedUniqueRef(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedUniqueRef(ViewerFilter filter) {
		advancedUniqueRef.addBusinessRuleFilter(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#getAdvancedMultipleContainmentToAdd()
	 */
	public List getAdvancedMultipleContainmentToAdd() {
		return advancedMultipleContainmentEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#getAdvancedMultipleContainmentToRemove()
	 */
	public List getAdvancedMultipleContainmentToRemove() {
		return advancedMultipleContainmentEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#getAdvancedMultipleContainmentTable()
	 */
	public List getAdvancedMultipleContainmentTable() {
		return advancedMultipleContainmentEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#initAdvancedMultipleContainment(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedMultipleContainment(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			advancedMultipleContainmentEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			advancedMultipleContainmentEditUtil = new EMFListEditUtil(current, feature);
		this.advancedMultipleContainment.setInput(advancedMultipleContainmentEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#updateAdvancedMultipleContainment(EObject newValue)
	 */
	public void updateAdvancedMultipleContainment(EObject newValue) {
		if(advancedMultipleContainmentEditUtil != null){
			advancedMultipleContainmentEditUtil.reinit(newValue);
			advancedMultipleContainment.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addFilterAdvancedMultipleContainment(ViewerFilter filter)
	 */
	public void addFilterToAdvancedMultipleContainment(ViewerFilter filter) {
		advancedMultipleContainmentFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#addBusinessFilterAdvancedMultipleContainment(ViewerFilter filter)
	 */
	public void addBusinessFilterToAdvancedMultipleContainment(ViewerFilter filter) {
		advancedMultipleContainmentBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SourcePropertiesEditionPart#isContainedInAdvancedMultipleContainmentTable(EObject element)
	 */
	public boolean isContainedInAdvancedMultipleContainmentTable(EObject element) {
		return advancedMultipleContainmentEditUtil.contains(element);
	}











	
	// Start of user code additional methods
	
	// End of user code

}	
