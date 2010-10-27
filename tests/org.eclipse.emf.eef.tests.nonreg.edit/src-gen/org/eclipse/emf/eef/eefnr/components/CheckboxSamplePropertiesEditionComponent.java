/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.eefnr.CheckboxSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.parts.CheckboxSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class CheckboxSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public CheckboxSamplePropertiesEditionComponent(EObject checkboxSample, String editing_mode) {
		super(checkboxSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.CheckboxSample.class;
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
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final CheckboxSample checkboxSample = (CheckboxSample)elt;
			final CheckboxSamplePropertiesEditionPart basePart = (CheckboxSamplePropertiesEditionPart)editingPart;
			// init values
								basePart.setCheckboxRequiredProperty(checkboxSample.isCheckboxRequiredProperty());
					
								basePart.setCheckboxOptionalProperty(checkboxSample.isCheckboxOptionalProperty());
					
			// init filters


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
		CheckboxSample checkboxSample = (CheckboxSample)semanticObject;
		if (EefnrViewsRepository.CheckboxSample.checkboxRequiredProperty == event.getAffectedEditor()) {
			checkboxSample.setCheckboxRequiredProperty((Boolean)event.getNewValue());	
		}
		if (EefnrViewsRepository.CheckboxSample.checkboxOptionalProperty == event.getAffectedEditor()) {
			checkboxSample.setCheckboxOptionalProperty((Boolean)event.getNewValue());	
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		CheckboxSamplePropertiesEditionPart basePart = (CheckboxSamplePropertiesEditionPart)editingPart;
				if (EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxRequiredProperty().equals(msg.getFeature()) && basePart != null)
					basePart.setCheckboxRequiredProperty((Boolean)msg.getNewValue());
		
				if (EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxOptionalProperty().equals(msg.getFeature()) && basePart != null)
					basePart.setCheckboxOptionalProperty((Boolean)msg.getNewValue());
		
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.CheckboxSample.checkboxRequiredProperty;
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
				if (EefnrViewsRepository.CheckboxSample.checkboxRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.CheckboxSample.checkboxOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getCheckboxSample_CheckboxOptionalProperty().getEAttributeType(), newValue);
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
