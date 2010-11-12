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
package org.eclipse.emf.eef.views.components;

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
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.views.DocumentedElement;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.parts.DocumentationPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class DocumentedElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String DOCUMENTATION_PART = "Documentation"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public DocumentedElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject documentedElement, String editing_mode) {
		super(editingContext, documentedElement, editing_mode);
		parts = new String[] { DOCUMENTATION_PART };
		repositoryKey = ViewsViewsRepository.class;
		partKey = ViewsViewsRepository.Documentation.class;
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
			final DocumentedElement documentedElement = (DocumentedElement)elt;
			final DocumentationPropertiesEditionPart documentationPart = (DocumentationPropertiesEditionPart)editingPart;
			// init values
			if (documentedElement.getDocumentation() != null)
				documentationPart.setDocumentation(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), documentedElement.getDocumentation()));
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
		DocumentedElement documentedElement = (DocumentedElement)semanticObject;
		if (ViewsViewsRepository.Documentation.Documentation_.documentation__ == event.getAffectedEditor()) {
			documentedElement.setDocumentation((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		DocumentationPropertiesEditionPart documentationPart = (DocumentationPropertiesEditionPart)editingPart;
		if (ViewsPackage.eINSTANCE.getDocumentedElement_Documentation().equals(msg.getFeature()) && documentationPart != null){
			if (msg.getNewValue() != null) {
				documentationPart.setDocumentation(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				documentationPart.setDocumentation("");
			}
		}
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 * 
	 */
	public String getHelpContent(String key, int kind) {
		if (key == ViewsViewsRepository.Documentation.Documentation_.documentation__)
			return "The documentation of the element"; //$NON-NLS-1$
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
				if (ViewsViewsRepository.Documentation.Documentation_.documentation__ == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ViewsPackage.eINSTANCE.getDocumentedElement_Documentation().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ViewsPackage.eINSTANCE.getDocumentedElement_Documentation().getEAttributeType(), newValue);
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
