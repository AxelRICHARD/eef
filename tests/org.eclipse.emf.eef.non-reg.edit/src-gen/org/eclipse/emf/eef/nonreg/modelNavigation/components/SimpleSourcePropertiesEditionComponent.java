/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.modelNavigation.components;

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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationFactory;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.nonreg.modelNavigation.RealCible;
import org.eclipse.emf.eef.nonreg.modelNavigation.Source;
import org.eclipse.emf.eef.nonreg.modelNavigation.SuperCible;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.SourcePropertiesEditionPart;
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
public class SimpleSourcePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String SOURCE_PART = "Source"; //$NON-NLS-1$

	private String[] parts = {SOURCE_PART};

	/**
	 * The EObject to edit
	 */
	private Source source;

	/**
	 * The Source part
	 */
	private SourcePropertiesEditionPart sourcePart;

	/**
	 * Default constructor
	 */
	public SimpleSourcePropertiesEditionComponent(EObject source, String editing_mode) {
		if (source instanceof Source) {
			this.source = (Source)source;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.source.eAdapters().add(semanticAdapter);
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
				if (sourcePart == null)
					SimpleSourcePropertiesEditionComponent.this.dispose();
				else {
					if (ModelNavigationPackage.eINSTANCE.getSource_UniqueRef().equals(msg.getFeature())) {
						if (source.getUniqueRef() instanceof RealCible)
							sourcePart.setAdvancedUniqueRef(((RealCible)source.getUniqueRef()).getRef());
						else 
							sourcePart.setAdvancedUniqueRef(null);
					}


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
		if (SOURCE_PART.equals(key))
			return NonregViewsRepository.Source.class;
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
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (source != null && SOURCE_PART.equals(key)) {
			if (sourcePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					sourcePart = (SourcePropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.Source.class, kind, this);
					addListener((IPropertiesEditionListener)sourcePart);
				}
			}
			return (IPropertiesEditionPart)sourcePart;
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
		if (key == NonregViewsRepository.Source.class)
			this.sourcePart = (SourcePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (sourcePart != null && key == NonregViewsRepository.Source.class) {
			((IPropertiesEditionPart)sourcePart).setContext(elt, allResource);
			Source source = (Source)elt;
			// init values
			if (source.getUniqueRef() instanceof RealCible)
				sourcePart.initAdvancedUniqueRef(allResource, ((RealCible)source.getUniqueRef()).getRef());
			else 
				sourcePart.initAdvancedUniqueRef(allResource, null);
			// set the button mode
			sourcePart.setAdvancedUniqueRefButtonMode(ButtonsModeEnum.BROWSE);
			
			// init filters
			sourcePart.addFilterToAdvancedUniqueRef(new EObjectFilter(ModelNavigationPackage.eINSTANCE.getSuperCible()));
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
		if (source != null) {
			if (sourcePart.getAdvancedUniqueRef() == null) {
				cc.append(SetCommand.create(editingDomain, source, ModelNavigationPackage.eINSTANCE.getSource_UniqueRef(), null));
			} else if (source.eGet(ModelNavigationPackage.eINSTANCE.getSource_UniqueRef()) == null || !source.eGet(ModelNavigationPackage.eINSTANCE.getSource_UniqueRef()).equals(sourcePart.getAdvancedUniqueRef())) {
				RealCible realCible = ModelNavigationFactory.eINSTANCE.createRealCible();
				cc.append(SetCommand.create(editingDomain, realCible, ModelNavigationPackage.eINSTANCE.getRealCible_Ref(), sourcePart.getAdvancedUniqueRef()));
				cc.append(SetCommand.create(editingDomain, source, ModelNavigationPackage.eINSTANCE.getSource_UniqueRef(), realCible));
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
		if (source instanceof Source) {
			Source sourceToUpdate = (Source)source;
			SuperCible refFromAdvancedUniqueRef = (SuperCible)sourcePart.getAdvancedUniqueRef();
			RealCible realCibleFromAdvancedUniqueRef = ModelNavigationFactory.eINSTANCE.createRealCible();
			realCibleFromAdvancedUniqueRef.setRef(refFromAdvancedUniqueRef);
			sourceToUpdate.setUniqueRef(realCibleFromAdvancedUniqueRef);


			return sourceToUpdate;
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
			if (NonregViewsRepository.Source.advancedUniqueRef == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind() && event.getNewValue() != null) {
					RealCible realCible = ModelNavigationFactory.eINSTANCE.createRealCible();
					command.append(SetCommand.create(liveEditingDomain, realCible, ModelNavigationPackage.eINSTANCE.getRealCible_Ref(), event.getNewValue()));
					command.append(SetCommand.create(liveEditingDomain, source, ModelNavigationPackage.eINSTANCE.getSource_UniqueRef(), realCible));
				}
				if (PropertiesEditionEvent.SET == event.getKind() && event.getNewValue() == null) {
					command.append(RemoveCommand.create(liveEditingDomain, source.getUniqueRef()));
					command.append(SetCommand.create(liveEditingDomain, source, ModelNavigationPackage.eINSTANCE.getSource_UniqueRef(), null));
				}
			}


			liveEditingDomain.getCommandStack().execute(command);
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
			validate = Diagnostician.INSTANCE.validate(source);
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
			source.eAdapters().remove(semanticAdapter);
	}

}

