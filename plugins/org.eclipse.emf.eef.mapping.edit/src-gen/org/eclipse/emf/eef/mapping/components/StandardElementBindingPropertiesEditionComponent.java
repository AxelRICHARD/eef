/**
 *  Copyright (c) 2008-2010 Obeo.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.mapping.StandardElementBinding;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.StandardElementBindingPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class StandardElementBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private StandardElementBindingPropertiesEditionPart basePart;

	/**
	 * The StandardElementBindingBasePropertiesEditionComponent sub component
	 */
	protected StandardElementBindingBasePropertiesEditionComponent standardElementBindingBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param standardElementBinding
	 *            the EObject to edit
	 */
	public StandardElementBindingPropertiesEditionComponent(EObject standardElementBinding, String editing_mode) {
		super(editing_mode);
		if (standardElementBinding instanceof StandardElementBinding) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(standardElementBinding);
			standardElementBindingBasePropertiesEditionComponent = (StandardElementBindingBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(standardElementBinding, editing_mode, StandardElementBindingBasePropertiesEditionComponent.BASE_PART);
			addSubComponent(standardElementBindingBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(standardElementBinding, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART);
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (StandardElementBindingBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (StandardElementBindingPropertiesEditionPart)standardElementBindingBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (MappingViewsRepository.StandardElementBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (StandardElementBindingPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == MappingViewsRepository.StandardElementBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == MappingViewsRepository.Documentation.class) {
			super.initPart(key, kind, element, allResource);
		
		}
	}
}
