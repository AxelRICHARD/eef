/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
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
import org.eclipse.emf.eef.runtime.context.ExtendedPropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.ViewHelper;
import org.eclipse.emf.eef.runtime.ui.parts.impl.BindingViewHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EObjectPropertiesEditionContext implements ExtendedPropertiesEditingContext {

	/**
	 * the source EditionComponent
	 * @since 1.1
	 */
	protected IPropertiesEditionComponent parentPropertiesEditionComponent;

	/**
	 * Helper for created graphical elements of the view
	 */
	private ViewHelper helper;

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
	 * The {@link IPropertiesEditionComponent} of the context
	 */
	private IPropertiesEditionComponent propertiesEditingComponent;

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
		this.parentPropertiesEditionComponent = propertiesEditionComponent;
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
	 * @return the eObject
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * @param eObject
	 */
	public void seteObject(EObject eObject) {
		this.eObject = eObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.context.PropertiesEditingContext#createPropertiesEditingComponent(java.lang.String)
	 * @since 1.1
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode) {
		if (propertiesEditingComponent == null) {
			PropertiesEditingProvider propertiesEditionProvider = (PropertiesEditingProvider)adapterFactory
					.adapt(eObject, PropertiesEditingProvider.class);
			if (propertiesEditionProvider != null) {
				this.propertiesEditingComponent = propertiesEditionProvider.getPropertiesEditingComponent(
						this, mode);
			}
		}
		return propertiesEditingComponent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.context.PropertiesEditingContext#createPropertiesEditingComponent(java.lang.String,
	 *      java.lang.String)
	 * @since 1.1
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode, String part) {
		if (propertiesEditingComponent == null) {
			PropertiesEditingProvider propertiesEditionProvider = (PropertiesEditingProvider)adapterFactory
					.adapt(eObject, PropertiesEditingProvider.class);
			if (propertiesEditionProvider != null) {
				this.propertiesEditingComponent = propertiesEditionProvider.getPropertiesEditingComponent(
						this, mode, part);
			}
		}
		return propertiesEditingComponent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.context.PropertiesEditingContext#createPropertiesEditingComponent(java.lang.String,
	 *      java.lang.String, java.lang.Class)
	 * @since 1.1
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode, String part,
			Class<?> refinement) {
		if (propertiesEditingComponent == null) {
			PropertiesEditingProvider propertiesEditionProvider = (PropertiesEditingProvider)adapterFactory
					.adapt(eObject, PropertiesEditingProvider.class);
			if (propertiesEditionProvider != null) {
				this.propertiesEditingComponent = propertiesEditionProvider.getPropertiesEditingComponent(
						this, mode, part, refinement);
			}
		}
		return propertiesEditingComponent;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.context.PropertiesEditingContext#getPropertiesEditingComponent()
	 * @since 1.1
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent() {
		return propertiesEditingComponent;
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

	/**
	 * Dispose the change recorder
	 */
	public void dispose() {
		if (changeRecorder != null)
			changeRecorder.dispose();
	}

	/**
	 * @return the {@link ViewHelper} of the context.
	 * @since 1.1
	 */
	public ViewHelper getHelper() {
		if (helper == null) {
			helper = new BindingViewHelper(this);
		}
		return helper;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.context.PropertiesEditingContext#setHelper(org.eclipse.emf.eef.runtime.ui.parts.ViewHelper)
	 * @since 1.1
	 */
	public void setHelper(ViewHelper helper) {
		this.helper = helper;
	}

}
