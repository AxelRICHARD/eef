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
/**
 * Generated with Acceleo
 */
package org.eclipse.worldcupforecast.parts;

// Start of user code for imports
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface WorldCupForecastPLayerPropertiesEditionPart {

	/**
	 * @return the player to add
	 * 
	 */
	public List getPlayerToAdd();

	/**
	 * @return the player to remove
	 * 
	 */
	public List getPlayerToRemove();

	/**
	 * @return the player to move
	 * 
	 */
	public List getPlayerToMove();

	/**
	 * @return the player to edit
	 * 
	 */
	public Map getPlayerToEdit();

	/**
	 * @return the current player table
	 * 
	 */
	public List getPlayerTable();

	/**
	 * Init the player
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initPlayer(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the player
	 * @param newValue the player to update
	 * 
	 */
	public void updatePlayer(EObject newValue);

	/**
	 * Adds the given filter to the player edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToPlayer(ViewerFilter filter);

	/**
	 * Adds the given filter to the player edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToPlayer(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the player table
	 * 
	 */
	public boolean isContainedInPlayerTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
