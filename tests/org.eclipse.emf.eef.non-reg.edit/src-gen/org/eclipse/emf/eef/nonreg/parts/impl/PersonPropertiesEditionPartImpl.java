/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.RadioViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * 
 */
public class PersonPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PersonPropertiesEditionPart {

	protected Text firstname;
	protected Text lastname;
	protected Text age;
	protected Button eclipseCommiter;
	protected Button isRegistered;
	protected RadioViewer genderRadioViewer;
	private AdvancedEObjectFlatComboViewer<Company> workFor;
	protected ViewerFilter workForFilter;

	private AccreditationsPropertiesEditionPart accreditationsPropertiesEditionPart;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PersonPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);

		createAccreditations(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(NonregMessages.PersonPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createFirstnameText(propertiesGroup);
		createLastnameText(propertiesGroup);
		createAgeText(propertiesGroup);
		createEclipseCommiterCheckbox(propertiesGroup);
		createIsRegisteredCheckbox(propertiesGroup);
		createGenderRadioViewer(propertiesGroup);
		createWorkForAdvancedFlatComboViewer(propertiesGroup);
	}

	protected void createFirstnameText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.PersonPropertiesEditionPart_FirstnameLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.firstname, NonregViewsRepository.SWT_KIND));
		firstname = new Text(parent, SWT.BORDER);
		GridData firstnameData = new GridData(GridData.FILL_HORIZONTAL);
		firstname.setLayoutData(firstnameData);
		firstname.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, NonregViewsRepository.Person.firstname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, firstname.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.firstname, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createLastnameText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.PersonPropertiesEditionPart_LastnameLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.lastname, NonregViewsRepository.SWT_KIND));
		lastname = new Text(parent, SWT.BORDER);
		GridData lastnameData = new GridData(GridData.FILL_HORIZONTAL);
		lastname.setLayoutData(lastnameData);
		lastname.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, NonregViewsRepository.Person.lastname, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, lastname.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.lastname, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createAgeText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.PersonPropertiesEditionPart_AgeLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.age, NonregViewsRepository.SWT_KIND));
		age = new Text(parent, SWT.BORDER);
		GridData ageData = new GridData(GridData.FILL_HORIZONTAL);
		age.setLayoutData(ageData);
		age.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, NonregViewsRepository.Person.age, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, age.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.age, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createEclipseCommiterCheckbox(Composite parent) {
		eclipseCommiter = new Button(parent, SWT.CHECK);
		eclipseCommiter.setText(NonregMessages.PersonPropertiesEditionPart_EclipseCommiterLabel);
		GridData eclipseCommiterData = new GridData(GridData.FILL_HORIZONTAL);
		eclipseCommiterData.horizontalSpan = 2;
		eclipseCommiter.setLayoutData(eclipseCommiterData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.eclipseCommiter, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createIsRegisteredCheckbox(Composite parent) {
		isRegistered = new Button(parent, SWT.CHECK);
		isRegistered.setText(NonregMessages.PersonPropertiesEditionPart_IsRegisteredLabel);
		GridData isRegisteredData = new GridData(GridData.FILL_HORIZONTAL);
		isRegisteredData.horizontalSpan = 2;
		isRegistered.setLayoutData(isRegisteredData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.isRegistered, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createGenderRadioViewer(Composite parent) {
		genderRadioViewer = new RadioViewer(parent, SWT.CHECK);
		GridData genderData = new GridData(GridData.FILL_HORIZONTAL);
		genderData.horizontalSpan = 2;
		genderRadioViewer.setLayoutData(genderData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.gender, NonregViewsRepository.SWT_KIND), null);
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createWorkForAdvancedFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.PersonPropertiesEditionPart_WorkForLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Person.workFor, NonregViewsRepository.SWT_KIND));
		// create callback listener
		EObjectFlatComboViewerListener<Company> listener = new EObjectFlatComboViewerListener<Company>(){
			public void handleSet(Company element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, NonregViewsRepository.Person.workFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(Company element){ }
			
			public Company handleCreate() {
				Company eObject = NonregFactory.eINSTANCE.createCompany();
				if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null) {
					eObject = (Company) EcoreUtil.copy(((Person)current).getWorkFor());
				}
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(eObject);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(propertiesEditionComponent, eObject,resourceSet));
					if (propertiesEditionObject != null) {
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersonPropertiesEditionPartImpl.this, NonregViewsRepository.Person.workFor, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertiesEditionObject));
						return (Company)propertiesEditionObject;
					}
					if (current != null && current instanceof Person && ((Person)current).getWorkFor() != null)
						return eObject;
					return null;
				}
				return null;
			}
		};
		//create widget
		workFor = new AdvancedEObjectFlatComboViewer<Company>(NonregMessages.PersonPropertiesEditionPart_WorkForLabel,
			resourceSet, workForFilter, NonregPackage.eINSTANCE.getCompany(), listener);
		workFor.createControls(parent);
		GridData workForData = new GridData(GridData.FILL_HORIZONTAL);
		workFor.setLayoutData(workForData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Person.workFor, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createAccreditations(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
		accreditationsPropertiesEditionPart = (AccreditationsPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.Accreditations.class, NonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)accreditationsPropertiesEditionPart).createControls(container);
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
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getFirstname()
	 */
	public String getFirstname() {
		return firstname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setFirstname(String newValue)
	 */
	public void setFirstname(String newValue) {
		if (newValue != null) {
			firstname.setText(newValue);
		} else {
			firstname.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForFirstname(String msg, int msgLevel) {

	}

	public void unsetMessageForFirstname() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getLastname()
	 */
	public String getLastname() {
		return lastname.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setLastname(String newValue)
	 */
	public void setLastname(String newValue) {
		if (newValue != null) {
			lastname.setText(newValue);
		} else {
			lastname.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForLastname(String msg, int msgLevel) {

	}

	public void unsetMessageForLastname() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAge()
	 */
	public String getAge() {
		return age.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setAge(String newValue)
	 */
	public void setAge(String newValue) {
		if (newValue != null) {
			age.setText(newValue);
		} else {
			age.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForAge(String msg, int msgLevel) {

	}

	public void unsetMessageForAge() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getEclipseCommiter()
	 */
	public Boolean getEclipseCommiter() {
		return Boolean.valueOf(eclipseCommiter.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setEclipseCommiter(Boolean newValue)
	 */
	public void setEclipseCommiter(Boolean newValue) {
		if (newValue != null) {
			eclipseCommiter.setSelection(newValue.booleanValue());
		} else {
			eclipseCommiter.setSelection(false);
		}
	}

	public void setMessageForEclipseCommiter(String msg, int msgLevel) {

	}

	public void unsetMessageForEclipseCommiter() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getIsRegistered()
	 */
	public Boolean getIsRegistered() {
		return Boolean.valueOf(isRegistered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setIsRegistered(Boolean newValue)
	 */
	public void setIsRegistered(Boolean newValue) {
		if (newValue != null) {
			isRegistered.setSelection(newValue.booleanValue());
		} else {
			isRegistered.setSelection(false);
		}
	}

	public void setMessageForIsRegistered(String msg, int msgLevel) {

	}

	public void unsetMessageForIsRegistered() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getGender()
	 */
	public Object getGender() {
		return genderRadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initGender(EEnum eenum, Enumerator current)
	 */
	public void initGender(EEnum eenum, Enumerator current) {
		genderRadioViewer.setInput(eenum.getELiterals());
		genderRadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setGender(Object newValue)
	 */
	public void setGender(Object newValue) {
		genderRadioViewer.setSelection(newValue);
	}

	public void setMessageForGender(String msg, int msgLevel) {

	}

	public void unsetMessageForGender() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getWorkFor()
	 */
	public EObject getWorkFor() {
		return workFor.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initWorkFor(ResourceSet allResources, EObject current)
	 */
	public void initWorkFor(ResourceSet allResources, EObject current) {
		workFor.setInput(allResources);
		if (current != null) {
			workFor.setSelection(new StructuredSelection(current));
			workFor.setMainResource(current.eResource());
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setWorkFor(EObject newValue)
	 */
	public void setWorkFor(EObject newValue) {
		if (newValue != null) {
			workFor.setSelection(new StructuredSelection(newValue));
		} else {
			workFor.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#setWorkForButtonMode(ButtonsModeEnum newValue)
	 */
	public void setWorkForButtonMode(ButtonsModeEnum newValue) {
		workFor.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addFilterWorkFor(ViewerFilter filter)
	 */
	public void addFilterToWorkFor(ViewerFilter filter) {
		workFor.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addBusinessFilterWorkFor(ViewerFilter filter)
	 */
	public void addBusinessFilterToWorkFor(ViewerFilter filter) {
		workFor.addBusinessRuleFilter(filter);
	}

	public void setMessageForWorkFor(String msg, int msgLevel) {

	}

	public void unsetMessageForWorkFor() {

	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsReferencedView()
	 */
		public IPropertiesEditionPart getAccreditationsReferencedView() {
			return (IPropertiesEditionPart) accreditationsPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsToAdd()
	 */
	public List getAccreditationsToAdd() {
		return accreditationsPropertiesEditionPart.getAccreditationsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsToRemove()
	 */
	public List getAccreditationsToRemove() {
		return accreditationsPropertiesEditionPart.getAccreditationsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#getAccreditationsTable()
	 */
	public List getAccreditationsTable() {
		return accreditationsPropertiesEditionPart.getAccreditationsTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#initAccreditations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAccreditations(EObject current, EReference containingFeature, EReference feature) {
		accreditationsPropertiesEditionPart.initAccreditations(current, containingFeature, feature);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#updateAccreditations(EObject newValue)
	 */
	public void updateAccreditations(EObject newValue) {
		accreditationsPropertiesEditionPart.updateAccreditations(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addFilterAccreditations(ViewerFilter filter)
	 */
	public void addFilterToAccreditations(ViewerFilter filter) {
		accreditationsPropertiesEditionPart.addFilterToAccreditations(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#addBusinessFilterAccreditations(ViewerFilter filter)
	 */
	public void addBusinessFilterToAccreditations(ViewerFilter filter) {
		accreditationsPropertiesEditionPart.addBusinessFilterToAccreditations(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart#isContainedInAccreditationsTable(EObject element)
	 */
	public boolean isContainedInAccreditationsTable(EObject element) {
		return accreditationsPropertiesEditionPart.isContainedInAccreditationsTable(element);
	}











	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return NonregMessages.Person_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
