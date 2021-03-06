/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter;

/**
 * Interface for modeling bot : define the actions modelised in modeling bot resource.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface IModelingBot {

	/**
	 * Run the scenarios of the modeling bot.
	 * 
	 * @param path
	 *            the path
	 * @throws CoreException
	 * @throws IOException
	 */
	void runModelingBot(String path) throws CoreException, IOException;

	/**
	 * Create a new java project.
	 * 
	 * @param projectName
	 */
	void createProject(String projectName);

	/**
	 * Open a project.
	 * 
	 * @param projectName
	 */
	void openProject(String projectName);

	/**
	 * Close a project.
	 * 
	 * @param projectName
	 */
	void closeProject(String projectName);

	/**
	 * Remove a project.
	 * 
	 * @param projectName
	 */
	void removeProject(String projectName);

	/**
	 * Open a perspective.
	 * 
	 * @param name
	 */
	void openPerspective(String name);

	/**
	 * Open an editor with EEF Reflexive editor.
	 * 
	 * @param path
	 *            editor path from its project
	 */
	void openEEFEditor(String path);

	/**
	 * Close an editor.
	 * 
	 * @param path
	 *            editor path from its project
	 */
	void closeEditor(String path);

	/**
	 * Save an editor.
	 */
	void save();

	/**
	 * Add an element.
	 * 
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @param eContainingFeature
	 * @return
	 */
	EObject add(org.eclipse.emf.eef.components.PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature, EClass type);

	/**
	 * Remove an element.
	 * 
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @param eContainingFeature
	 */
	void remove(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject);

	/**
	 * Set an element.
	 * 
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @param eContainingFeature
	 * @return
	 */
	void set(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, String value);

	/**
	 * Set an element.
	 * 
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @param eContainingFeature
	 */
	void set(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, ReferenceableObject value);

	/**
	 * Unset an element.
	 * 
	 * @param propertiesEditionElement
	 * @param referenceableObject
	 * @param eContainingFeature
	 */
	void unset(PropertiesEditionElement propertiesEditionElement, ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature);

	/**
	 * Create a new resource.
	 * 
	 * @param modelName
	 * @return
	 */
	EObject createModel(String path, String modelName, EClass eClass);

	/**
	 * Cancel.
	 */
	void cancel();

	/**
	 * Set the sequence type : wizard, details page, properties view...
	 * 
	 * @param sequenceType
	 */
	void setSequenceType(SequenceType sequenceType);

	/**
	 * Validate batch editing.
	 */
	void validateBatchEditing();

	/**
	 * Check.
	 */
	void check();

	/**
	 * @return the test model resource.
	 */
	Resource getActiveResource();

	/**
	 * @return the modeling bot interpreter
	 */
	IModelingBotInterpreter getModelingBotInterpreter();

}
