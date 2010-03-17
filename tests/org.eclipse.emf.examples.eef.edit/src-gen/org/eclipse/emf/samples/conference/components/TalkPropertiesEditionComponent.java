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
package org.eclipse.emf.samples.conference.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.Person;
import org.eclipse.emf.samples.conference.TALK_TYPE;
import org.eclipse.emf.samples.conference.Talk;
import org.eclipse.emf.samples.conference.Topic;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.TalkPropertiesEditionPart;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class TalkPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private Talk talk;

	/**
	 * The Base part
	 * 
	 */
	protected TalkPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
	 */
	public TalkPropertiesEditionComponent(EObject talk, String editing_mode) {
		if (talk instanceof Talk) {
			this.talk = (Talk)talk;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.talk.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					TalkPropertiesEditionComponent.this.dispose();
				else {
					Runnable updateRunnable = new Runnable() {
						public void run() {
							runUpdateRunnable(msg);
						}
					};
					if (null == Display.getCurrent()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
					} else {
						updateRunnable.run();
					}
				}
			}

		};
	}

	/**
	 * Used to update the views
	 * 
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (ConferencePackage.eINSTANCE.getTalk_Title().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setTitle_(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setTitle_("");
			}
		}
		if (ConferencePackage.eINSTANCE.getTalk_Topic().equals(msg.getFeature()) && basePart != null)
			basePart.setTopic((EObject)msg.getNewValue());
		if (ConferencePackage.eINSTANCE.getTalk_Type().equals(msg.getFeature()) && basePart != null)
			basePart.setType((Enumerator)msg.getNewValue());

		if (ConferencePackage.eINSTANCE.getTalk_Presenter().equals(msg.getFeature()) && basePart != null)
			basePart.setPresenter((EObject)msg.getNewValue());
		if (ConferencePackage.eINSTANCE.getTalk_Creator().equals(msg.getFeature()) && basePart != null)
			basePart.setCreator((EObject)msg.getNewValue());
		if (ConferencePackage.eINSTANCE.getTalk_Documentation().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setDocumentation(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setDocumentation("");
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return ConferenceViewsRepository.Talk.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 * 
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (talk != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ConferenceViewsRepository.class);
				if (provider != null) {
					basePart = (TalkPropertiesEditionPart)provider.getPropertiesEditionPart(ConferenceViewsRepository.Talk.class, kind, this);
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
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == ConferenceViewsRepository.Talk.class)
			this.basePart = (TalkPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == ConferenceViewsRepository.Talk.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final Talk talk = (Talk)elt;
			// init values
			if (talk.getTitle() != null)
				basePart.setTitle_(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), talk.getTitle()));

			// init part
			basePart.initTopic(allResource, talk.getTopic());
			// set the button mode
			basePart.setTopicButtonMode(ButtonsModeEnum.BROWSE);
			basePart.initType((EEnum) ConferencePackage.eINSTANCE.getTalk_Type().getEType(), talk.getType());
			// init part
			basePart.initPresenter(allResource, talk.getPresenter());
			// set the button mode
			basePart.setPresenterButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initCreator(allResource, talk.getCreator());
			// set the button mode
			basePart.setCreatorButtonMode(ButtonsModeEnum.BROWSE);
			if (talk.getDocumentation() != null)
				basePart.setDocumentation(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), talk.getDocumentation()));
			// init filters

			basePart.addFilterToTopic(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Topic);
				}

			});
			// Start of user code for additional businessfilters for topic
			
			// End of user code


			basePart.addFilterToPresenter(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof Person);
				}

			});
			// Start of user code for additional businessfilters for presenter
			
			// End of user code

			basePart.addFilterToCreator(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Person); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for creator
			
			// End of user code


		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}










	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((talk != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Title(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTitle_())));
			if (talk.eGet(ConferencePackage.eINSTANCE.getTalk_Topic()) == null || !talk.eGet(ConferencePackage.eINSTANCE.getTalk_Topic()).equals(basePart.getTopic())) {
				cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Topic(), basePart.getTopic()));
			}
			cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Type(), basePart.getType()));

			if (talk.eGet(ConferencePackage.eINSTANCE.getTalk_Presenter()) == null || !talk.eGet(ConferencePackage.eINSTANCE.getTalk_Presenter()).equals(basePart.getPresenter())) {
				cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Presenter(), basePart.getPresenter()));
			}
			if (talk.eGet(ConferencePackage.eINSTANCE.getTalk_Creator()) == null || !talk.eGet(ConferencePackage.eINSTANCE.getTalk_Creator()).equals(basePart.getCreator())) {
				cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Creator(), basePart.getCreator()));
			}
			cc.append(SetCommand.create(editingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Documentation(), EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getDocumentation())));

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
	 * 
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof Talk) {
			Talk talkToUpdate = (Talk)source;
			talkToUpdate.setTitle((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTitle_()));

			talkToUpdate.setTopic((Topic)basePart.getTopic());
			talkToUpdate.setType((TALK_TYPE)basePart.getType());

			talkToUpdate.setPresenter((Person)basePart.getPresenter());
			talkToUpdate.setCreator((Person)basePart.getCreator());
			talkToUpdate.setDocumentation((java.lang.String)EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getDocumentation()));

			return talkToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (ConferenceViewsRepository.Talk.title_ == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Title(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (ConferenceViewsRepository.Talk.topic == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Topic(), event.getNewValue()));
			if (ConferenceViewsRepository.Talk.type == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Type(), event.getNewValue()));

			if (ConferenceViewsRepository.Talk.presenter == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Presenter(), event.getNewValue()));
			if (ConferenceViewsRepository.Talk.creator == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Creator(), event.getNewValue()));
			if (ConferenceViewsRepository.Talk.documentation == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, talk, ConferencePackage.eINSTANCE.getTalk_Documentation(), EcoreUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}

				if (!command.isEmpty() && !command.canExecute()) {
					EEFRuntimePlugin.getDefault().logError("Cannot perform model change command.", null);
				} else {
					liveEditingDomain.getCommandStack().execute(command);
				}
			}
			if (valueDiagnostic.getSeverity() != Diagnostic.OK && valueDiagnostic instanceof BasicDiagnostic)
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, valueDiagnostic));
			else {
				Diagnostic validate = validate();
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, validate));
			}
			super.firePropertiesChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == ConferenceViewsRepository.Talk.title_ || key == ConferenceViewsRepository.Talk.topic || key == ConferenceViewsRepository.Talk.presenter || key == ConferenceViewsRepository.Talk.documentation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 * 
	 */
	public String getHelpContent(String key, int kind) {
		if (key == ConferenceViewsRepository.Talk.title_)
			return "The title of the talk"; //$NON-NLS-1$
		if (key == ConferenceViewsRepository.Talk.topic)
			return "Topics discussed during the talk"; //$NON-NLS-1$
		if (key == ConferenceViewsRepository.Talk.type)
			return "Type of the talk"; //$NON-NLS-1$
		if (key == ConferenceViewsRepository.Talk.presenter)
			return "Person presenting the talk"; //$NON-NLS-1$
		if (key == ConferenceViewsRepository.Talk.creator)
			return "Person who created the talk"; //$NON-NLS-1$
		if (key == ConferenceViewsRepository.Talk.documentation)
			return "Description of the talk"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (ConferenceViewsRepository.Talk.title_ == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTalk_Title().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTalk_Title().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Talk.type == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTalk_Type().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTalk_Type().getEAttributeType(), newValue);
				}
				if (ConferenceViewsRepository.Talk.documentation == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ConferencePackage.eINSTANCE.getTalk_Documentation().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ConferencePackage.eINSTANCE.getTalk_Documentation().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(talk);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(talk);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			talk.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
