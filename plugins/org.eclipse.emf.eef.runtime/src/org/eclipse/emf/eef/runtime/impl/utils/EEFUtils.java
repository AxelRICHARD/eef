/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.osgi.framework.Bundle;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EEFUtils {

	public static final String JDT_CORE_SYMBOLIC_NAME = "org.eclipse.jdt.core";
	
	/**
	 * @deprecated
	 */
	public static Object choiceOfValues(AdapterFactory adapterFactory, EObject eObject,
			EStructuralFeature feature, ResourceSet allResources) {
		return choiceOfValues(eObject, feature, allResources);
	}

	/**
	 * @deprecated
	 */
	public static Object choiceOfValues(EObject eObject, EStructuralFeature feature, ResourceSet allResources) {
		return choiceOfValues(eObject, feature);
	}
	
	public static Object choiceOfValues(EObject eObject, EStructuralFeature feature){
		Object choiceOfValues = null;
		IItemPropertySource ps = (IItemPropertySource)EMFPropertiesRuntime.getDefault().getAdapterFactory()
				.adapt(eObject, IItemPropertySource.class);
		if (ps != null) {
			IItemPropertyDescriptor propertyDescriptor = ps.getPropertyDescriptor(eObject, feature);
			if (propertyDescriptor != null)
				choiceOfValues = propertyDescriptor.getChoiceOfValues(eObject);
		}
		if (choiceOfValues == null && eObject.eResource() != null && eObject.eResource().getResourceSet() != null)
			choiceOfValues = eObject.eResource().getResourceSet();
		return choiceOfValues;
	}
	
	public static List<EClass> instanciableTypesInHierarchy(EClassifier eClassifier) {
		List<EClass> result = new ArrayList<EClass>();
		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass) eClassifier;
			if (!eClass.isAbstract())
				result.add(eClass);
			result.addAll(instanciableSubTypes(eClass));
		}
		return result;
	}
	
	private static List<EClass> instanciableSubTypes(EClass eClass) {
		List<EClass> result = new ArrayList<EClass>();
		for (EPackage ePackage : allPackages(eClass)) {
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass2 = (EClass) eClassifier;
					if (!eClass2.equals(eClass) && eClass.isSuperTypeOf(eClass2) && !eClass2.isAbstract() && !eClass2.isInterface())
						result.add(eClass2);
				}
			}
		}
		
		return result;
	}
	
	private static List<EPackage> allPackages(EClass eClass) {
		List<EPackage> result = new ArrayList<EPackage>();
		if (eClass.eResource() != null) {
			EcoreUtil.resolveAll(eClass);
			List<Resource> resourcesToProcess = null;
			if (eClass.eResource().getResourceSet() != null)
				resourcesToProcess = eClass.eResource().getResourceSet().getResources();
			else {
				resourcesToProcess = new ArrayList<Resource>();
				resourcesToProcess.add(eClass.eResource());
			}
			for (Resource resource : resourcesToProcess) 
				result.addAll(allPackageOfResource(resource));
		}
		else {
			EPackage rootPackage = eClass.getEPackage();
			while (rootPackage.getESuperPackage() != null) 
				rootPackage = rootPackage.getESuperPackage();
			result.addAll(allSubPackages(rootPackage));
		}
		return result;
	}
	
	private static List<EPackage> allSubPackages(EPackage ePackage) {
		List<EPackage> result = new ArrayList<EPackage>();
		for (EPackage subPackage : ePackage.getESubpackages()) 
			result.addAll(allSubPackages(subPackage));
		return result;
	}

	private static List<EPackage> allPackageOfResource(Resource resource) {
		List<EPackage> result = new ArrayList<EPackage>();
		for (Iterator iterator = resource.getAllContents(); iterator.hasNext();) {
			EObject type = (EObject) iterator.next();
			if (type instanceof EPackage)
				result .add((EPackage)type);
		}
		return result;
	}
	
	/**
	 * Convert a treeIterator in Object list
	 * @param iter the iterator
	 * @return the result list
	 */
	public static List<Object> asList(TreeIterator<Object> iter) {
		List<Object> result = new ArrayList<Object>();
		while (iter.hasNext())
			result.add(iter.next());
		return result;
	}
	
	/**
	 * Convert a treeIterator in EObject list
	 * @param iter the iterator
	 * @return the result list
	 */
	public static List<EObject> asEObjectList(TreeIterator<EObject> iter) {
		List<EObject> result = new ArrayList<EObject>();
		while (iter.hasNext())
			result.add(iter.next());
		return result;
	}
	
	/**
	 * method defining if a bundle is loaded or not
	 * @param name the searched bundle
	 * @return <code>true</code> when the bundle is loaded
	 */
	public static boolean isBundleLoaded(String name) {
		Bundle bundle = Platform.getBundle(name);
		return bundle != null && bundle.getState() == Bundle.ACTIVE;
	}
	
}
