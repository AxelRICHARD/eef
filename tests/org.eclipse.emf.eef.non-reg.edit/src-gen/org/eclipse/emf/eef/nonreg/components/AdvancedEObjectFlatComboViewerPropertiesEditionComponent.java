/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.parts.AdvancedEObjectFlatComboViewerPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

// End of user code

/**
 * 
 */
public class AdvancedEObjectFlatComboViewerPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private Person person;

	/**
	 * The Base part
	 */
	private AdvancedEObjectFlatComboViewerPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public AdvancedEObjectFlatComboViewerPropertiesEditionComponent(EObject person, String editing_mode) {
		if (person instanceof Person) {
			this.person = (Person)person;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.person.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (basePart == null)
					AdvancedEObjectFlatComboViewerPropertiesEditionComponent.this.dispose();
				else {
					if (NonregPackage.eINSTANCE.getPerson_WorkFor().equals(msg.getFeature()) && basePart != null)
						basePart.setAdvancedeobjectflatcomboviewer((EObject)msg.getNewValue());
					if (NonregPackage.eINSTANCE.getPerson_WorkFor().equals(msg.getFeature()) && basePart != null)
						basePart.setAdvancedeobjectflatcomboviewerRO((EObject)msg.getNewValue());


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return NonregViewsRepository.AdvancedEObjectFlatComboViewer.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (person != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					basePart = (AdvancedEObjectFlatComboViewerPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.AdvancedEObjectFlatComboViewer.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == NonregViewsRepository.AdvancedEObjectFlatComboViewer.class)
			this.basePart = (AdvancedEObjectFlatComboViewerPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == NonregViewsRepository.AdvancedEObjectFlatComboViewer.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Person person = (Person)elt;
			// init values
			basePart.initAdvancedeobjectflatcomboviewer(allResource, person.getWorkFor());
			// set the button mode
			basePart.setAdvancedeobjectflatcomboviewerButtonMode(ButtonsModeEnum.BROWSE);
			basePart.initAdvancedeobjectflatcomboviewerRO(allResource, person.getWorkFor());
			// set the button mode
			basePart.setAdvancedeobjectflatcomboviewerROButtonMode(ButtonsModeEnum.BROWSE);
			
			// init filters
			basePart.addFilterToAdvancedeobjectflatcomboviewer(new EObjectFilter(NonregPackage.eINSTANCE.getCompany()));
			basePart.addFilterToAdvancedeobjectflatcomboviewerRO(new EObjectFilter(NonregPackage.eINSTANCE.getCompany()));
		}
		// init values for referenced views

		// init filters for referenced views

	}






	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (person != null) {
			if (person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()) == null || !person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()).equals(basePart.getAdvancedeobjectflatcomboviewer())) {
				cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), basePart.getAdvancedeobjectflatcomboviewer()));
			}
			if (person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()) == null || !person.eGet(NonregPackage.eINSTANCE.getPerson_WorkFor()).equals(basePart.getAdvancedeobjectflatcomboviewerRO())) {
				cc.append(SetCommand.create(editingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), basePart.getAdvancedeobjectflatcomboviewerRO()));
			}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof Person) {
			Person personToUpdate = (Person)source;
			personToUpdate.setWorkFor((Company)basePart.getAdvancedeobjectflatcomboviewer());
			personToUpdate.setWorkFor((Company)basePart.getAdvancedeobjectflatcomboviewerRO());


			return personToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewer == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), event.getNewValue()));
			if (NonregViewsRepository.AdvancedEObjectFlatComboViewer.advancedeobjectflatcomboviewerRO == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, person, NonregPackage.eINSTANCE.getPerson_WorkFor(), event.getNewValue()));


			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {




			} else {




			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate =  Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(person);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			person.eAdapters().remove(semanticAdapter);
	}

}
