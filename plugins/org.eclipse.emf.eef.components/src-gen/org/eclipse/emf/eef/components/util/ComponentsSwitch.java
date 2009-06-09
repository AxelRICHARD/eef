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
 * $Id: ComponentsSwitch.java,v 1.2 2009/06/09 15:47:24 sbouchet Exp $
 */
package org.eclipse.emf.eef.components.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.EEFElement;
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.components.PropertiesMultiEditionElement;
import org.eclipse.emf.eef.mapping.AbstractElementBinding;
import org.eclipse.emf.eef.mapping.AbstractPropertyBinding;
import org.eclipse.emf.eef.mapping.Databinding;
import org.eclipse.emf.eef.mapping.DocumentedElement;
import org.eclipse.emf.eef.mapping.EMFElementBinding;
import org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding;
import org.eclipse.emf.eef.mapping.EMFPropertyBinding;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.components.ComponentsPackage
 * @generated
 */
public class ComponentsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComponentsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentsSwitch() {
		if (modelPackage == null) {
			modelPackage = ComponentsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case ComponentsPackage.PROPERTIES_EDITION_CONTEXT: {
			PropertiesEditionContext propertiesEditionContext = (PropertiesEditionContext) theEObject;
			T result = casePropertiesEditionContext(propertiesEditionContext);
			if (result == null)
				result = caseDatabinding(propertiesEditionContext);
			if (result == null)
				result = caseDocumentedElement(propertiesEditionContext);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ComponentsPackage.PROPERTIES_EDITION_COMPONENT: {
			PropertiesEditionComponent propertiesEditionComponent = (PropertiesEditionComponent) theEObject;
			T result = casePropertiesEditionComponent(propertiesEditionComponent);
			if (result == null)
				result = caseEMFElementBinding(propertiesEditionComponent);
			if (result == null)
				result = caseEEFElement(propertiesEditionComponent);
			if (result == null)
				result = caseAbstractElementBinding(propertiesEditionComponent);
			if (result == null)
				result = caseDocumentedElement(propertiesEditionComponent);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ComponentsPackage.PROPERTIES_EDITION_ELEMENT: {
			PropertiesEditionElement propertiesEditionElement = (PropertiesEditionElement) theEObject;
			T result = casePropertiesEditionElement(propertiesEditionElement);
			if (result == null)
				result = caseEMFPropertyBinding(propertiesEditionElement);
			if (result == null)
				result = caseEEFElement(propertiesEditionElement);
			if (result == null)
				result = caseAbstractPropertyBinding(propertiesEditionElement);
			if (result == null)
				result = caseDocumentedElement(propertiesEditionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ComponentsPackage.PROPERTIES_MULTI_EDITION_ELEMENT: {
			PropertiesMultiEditionElement propertiesMultiEditionElement = (PropertiesMultiEditionElement) theEObject;
			T result = casePropertiesMultiEditionElement(propertiesMultiEditionElement);
			if (result == null)
				result = caseEMFMultiPropertiesBinding(propertiesMultiEditionElement);
			if (result == null)
				result = caseEEFElement(propertiesMultiEditionElement);
			if (result == null)
				result = caseAbstractPropertyBinding(propertiesMultiEditionElement);
			if (result == null)
				result = caseDocumentedElement(propertiesMultiEditionElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ComponentsPackage.EEF_ELEMENT: {
			EEFElement eefElement = (EEFElement) theEObject;
			T result = caseEEFElement(eefElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Edition Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Edition Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesEditionContext(PropertiesEditionContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Edition Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Edition Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesEditionComponent(PropertiesEditionComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Edition Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Edition Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesEditionElement(PropertiesEditionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Multi Edition Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Multi Edition Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesMultiEditionElement(
			PropertiesMultiEditionElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EEF Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EEF Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEEFElement(EEFElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedElement(DocumentedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Databinding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Databinding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDatabinding(Databinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractElementBinding(AbstractElementBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMF Element Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMF Element Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMFElementBinding(EMFElementBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Property Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractPropertyBinding(AbstractPropertyBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMF Property Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMF Property Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMFPropertyBinding(EMFPropertyBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EMF Multi Properties Binding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EMF Multi Properties Binding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEMFMultiPropertiesBinding(EMFMultiPropertiesBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //ComponentsSwitch
