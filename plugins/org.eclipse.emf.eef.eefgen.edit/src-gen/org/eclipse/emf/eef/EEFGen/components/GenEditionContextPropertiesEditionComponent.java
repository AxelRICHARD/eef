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
package org.eclipse.emf.eef.EEFGen.components;

// Start of user code for imports

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class GenEditionContextPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for propertiesEditionContext EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings propertiesEditionContextSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public GenEditionContextPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject genEditionContext, String editing_mode) {
		super(editingContext, genEditionContext, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EEFGenViewsRepository.class;
		partKey = EEFGenViewsRepository.GenEditionContext.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final GenEditionContext genEditionContext = (GenEditionContext)elt;
			final GenEditionContextPropertiesEditionPart basePart = (GenEditionContextPropertiesEditionPart)editingPart;
			// init values
			if (genEditionContext.getBasePackage() != null)
				basePart.setBasePackage(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), genEditionContext.getBasePackage()));
			
			if (genEditionContext.getDescriptorsContributorID() != null)
				basePart.setDescriptorsContributorID(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), genEditionContext.getDescriptorsContributorID()));
			
			basePart.setGenericPropertiesViewsDescriptors(genEditionContext.isDescriptorsGenericPropertiesViews());
			
			basePart.setGMFSpecificPropertiesViews(genEditionContext.isGmfPropertiesViews());
			
			// init part
			propertiesEditionContextSettings = new EObjectFlatComboSettings(genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext());
			basePart.initPropertiesEditionContext(propertiesEditionContextSettings);
			// set the button mode
			basePart.setPropertiesEditionContextButtonMode(ButtonsModeEnum.BROWSE);
			basePart.setJUnitTestCases(genEditionContext.isGenerateJunitTestCases());
			
			// init filters
			
			
			
			
			basePart.addFilterToPropertiesEditionContext(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof PropertiesEditionContext);
				}
			
			});
			// Start of user code for additional businessfilters for propertiesEditionContext
																																	
																																	// End of user code
			
			
		}
		// init values for referenced views
		
		// init filters for referenced views
		
		setInitializing(false);
	}









	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		GenEditionContext genEditionContext = (GenEditionContext)semanticObject;
		if (EEFGenViewsRepository.GenEditionContext.Parameters.basePackage == event.getAffectedEditor()) {
			genEditionContext.setBasePackage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EEFGenViewsRepository.GenEditionContext.Parameters.descriptorsContributorID == event.getAffectedEditor()) {
			genEditionContext.setDescriptorsContributorID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EEFGenViewsRepository.GenEditionContext.Activation.genericPropertiesViewsDescriptors == event.getAffectedEditor()) {
			genEditionContext.setDescriptorsGenericPropertiesViews((Boolean)event.getNewValue());	
		}
		if (EEFGenViewsRepository.GenEditionContext.Activation.gMFSpecificPropertiesViews == event.getAffectedEditor()) {
			genEditionContext.setGmfPropertiesViews((Boolean)event.getNewValue());	
		}
		if (EEFGenViewsRepository.GenEditionContext.Reference.propertiesEditionContext == event.getAffectedEditor()) {
			propertiesEditionContextSettings.setToReference((PropertiesEditionContext)event.getNewValue());
		}
		if (EEFGenViewsRepository.GenEditionContext.Activation.jUnitTestCases == event.getAffectedEditor()) {
			genEditionContext.setGenerateJunitTestCases((Boolean)event.getNewValue());	
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		GenEditionContextPropertiesEditionPart basePart = (GenEditionContextPropertiesEditionPart)editingPart;
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setBasePackage(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setBasePackage("");
			}
		}
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setDescriptorsContributorID(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setDescriptorsContributorID("");
			}
		}
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().equals(msg.getFeature()) && basePart != null)
			basePart.setGenericPropertiesViewsDescriptors((Boolean)msg.getNewValue());
		
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().equals(msg.getFeature()) && basePart != null)
			basePart.setGMFSpecificPropertiesViews((Boolean)msg.getNewValue());
		
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext().equals(msg.getFeature()) && basePart != null)
			basePart.setPropertiesEditionContext((EObject)msg.getNewValue());
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().equals(msg.getFeature()) && basePart != null)
			basePart.setJUnitTestCases((Boolean)msg.getNewValue());
		
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EEFGenViewsRepository.GenEditionContext.Reference.propertiesEditionContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EEFGenViewsRepository.GenEditionContext.Parameters.basePackage)
			return "The base package for all the generated code"; //$NON-NLS-1$
		if (key == EEFGenViewsRepository.GenEditionContext.Reference.propertiesEditionContext)
			return "The PropertiesEditioContext to describe"; //$NON-NLS-1$
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
				if (EEFGenViewsRepository.GenEditionContext.Parameters.basePackage == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.Parameters.descriptorsContributorID == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.Activation.genericPropertiesViewsDescriptors == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.Activation.gMFSpecificPropertiesViews == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.Activation.jUnitTestCases == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
