/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.context.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EObjectPropertiesEditionContext implements PropertiesEditingContext {

	/**
	 * the source EditionComponent
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * the EObject to edit
	 */
	protected EObject eObject;

	/**
	 * 
	 */
	protected ChangeRecorder changeRecorder;

	/**
	 * The AdapterFactory to use in the editing context
	 */
	protected AdapterFactory adapterFactory;

	/**
	 * The parent context (can be null)
	 */
	protected PropertiesEditingContext parentContext;

	/**
	 * @param parentContext
	 *            the parent context
	 * @param propertiesEditionComponent
	 *            editingComponent holding the EObject editing
	 * @param eObject
	 *            eObject to edit
	 * @param adapterFactory
	 *            adapterFactory to use to get editing providers
	 */
	public EObjectPropertiesEditionContext(PropertiesEditingContext parentContext,
			IPropertiesEditionComponent propertiesEditionComponent, EObject eObject,
			AdapterFactory adapterFactory) {
		this.parentContext = parentContext;
		this.propertiesEditionComponent = propertiesEditionComponent;
		this.eObject = eObject;
		this.adapterFactory = adapterFactory;
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet != null) {
			this.changeRecorder = new ChangeRecorder(resourceSet);
		}
	}

	/**
	 * @return the parentContext
	 */
	public PropertiesEditingContext getParentContext() {
		return parentContext;
	}

	/**
	 * @return the changeRecorder
	 */
	public ChangeRecorder getChangeRecorder() {
		return changeRecorder;
	}

	/**
	 * @return the propertiesEditionComponent
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent() {
		return propertiesEditionComponent;
	}

	/**
	 * @return the eObject
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		if (eObject != null && eObject.eResource() != null && eObject.eResource().getResourceSet() != null)
			return eObject.eResource().getResourceSet();
		if (parentContext != null)
			return parentContext.getResourceSet();
		return null;
	}

	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

}
