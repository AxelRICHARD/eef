/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EMFMultiPropertiesBinding.java,v 1.4 2010/03/15 10:22:29 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.mapping.navigation.ModelNavigation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Multi Properties Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding#getNavigation <em>Navigation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getEMFMultiPropertiesBinding()
 * @model
 * @generated
 */
public interface EMFMultiPropertiesBinding extends AbstractPropertyBinding {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getEMFMultiPropertiesBinding_Model()
	 * @model required="true"
	 * @generated
	 */
	EList<EStructuralFeature> getModel();

	/**
	 * Returns the value of the '<em><b>Navigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigation</em>' containment reference.
	 * @see #setNavigation(ModelNavigation)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getEMFMultiPropertiesBinding_Navigation()
	 * @model containment="true"
	 * @generated
	 */
	ModelNavigation getNavigation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding#getNavigation <em>Navigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigation</em>' containment reference.
	 * @see #getNavigation()
	 * @generated
	 */
	void setNavigation(ModelNavigation value);

} // EMFMultiPropertiesBinding
