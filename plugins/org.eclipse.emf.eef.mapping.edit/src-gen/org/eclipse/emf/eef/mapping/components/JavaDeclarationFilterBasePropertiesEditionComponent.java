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
package org.eclipse.emf.eef.mapping.components;

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
import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.filters.JavaDeclarationFilter;
import org.eclipse.emf.eef.mapping.parts.JavaDeclarationFilterPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class JavaDeclarationFilterBasePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public JavaDeclarationFilterBasePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject javaDeclarationFilter, String editing_mode) {
		super(editingContext, javaDeclarationFilter, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = MappingViewsRepository.class;
		partKey = MappingViewsRepository.JavaDeclarationFilter.class;
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
			final JavaDeclarationFilter javaDeclarationFilter = (JavaDeclarationFilter)elt;
			final JavaDeclarationFilterPropertiesEditionPart basePart = (JavaDeclarationFilterPropertiesEditionPart)editingPart;
			// init values
			if (javaDeclarationFilter.getMethodName() != null)
				basePart.setMethodName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), javaDeclarationFilter.getMethodName()));
			
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
		JavaDeclarationFilter javaDeclarationFilter = (JavaDeclarationFilter)semanticObject;
		if (MappingViewsRepository.JavaDeclarationFilter.FilterExpression.methodName == event.getAffectedEditor()) {
			javaDeclarationFilter.setMethodName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		JavaDeclarationFilterPropertiesEditionPart basePart = (JavaDeclarationFilterPropertiesEditionPart)editingPart;
		if (FiltersPackage.eINSTANCE.getJavaDeclarationFilter_MethodName().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setMethodName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setMethodName("");
			}
		}
		
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
				if (MappingViewsRepository.JavaDeclarationFilter.FilterExpression.methodName == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getJavaDeclarationFilter_MethodName().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getJavaDeclarationFilter_MethodName().getEAttributeType(), newValue);
				}
				if (MappingViewsRepository.FilterProperties.FilterProperties_.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newValue);
				}
				if (MappingViewsRepository.FilterProperties.FilterProperties_.mandatory == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newValue);
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
