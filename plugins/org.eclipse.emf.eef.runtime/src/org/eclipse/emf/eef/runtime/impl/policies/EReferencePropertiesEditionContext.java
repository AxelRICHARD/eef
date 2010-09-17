/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.policies;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EReferencePropertiesEditionContext implements
		IPropertiesEditionContext {

	/**
	 * the source EditionComponent
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * the EReference to edit
	 */
	protected EReference eReference;

	/**
	 * The ResourceSet where the EObjects are located
	 */
	protected ResourceSet resourceSet;

	private ChangeRecorder changeRecorder;

	/**
	 * @param propertiesEditionComponent
	 * @param eReference
	 * @param resourceSet
	 */
	public EReferencePropertiesEditionContext(IPropertiesEditionComponent propertiesEditionComponent, EReference eReference, ResourceSet resourceSet) {
		this.propertiesEditionComponent = propertiesEditionComponent;
		this.eReference = eReference;
		this.resourceSet = resourceSet;
		this.changeRecorder = new ChangeRecorder(resourceSet);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext#getChangeRecorder()
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
	 * @return the eReference
	 */
	public EReference getEReference() {
		return eReference;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}