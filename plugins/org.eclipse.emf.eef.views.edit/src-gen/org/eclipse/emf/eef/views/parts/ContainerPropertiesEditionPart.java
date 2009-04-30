/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ContainerPropertiesEditionPart.java,v 1.2 2009/04/30 17:49:39 nlepine Exp $
 */
package org.eclipse.emf.eef.views.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface ContainerPropertiesEditionPart {

	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);
	
	public void setMessageForName(String msg, int msgLevel);
	
	public void unsetMessageForName();
	
	/**
	 * @return the representation
	 */
	public EObject getRepresentation();
	
	/**
	 * Init the representation
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initRepresentation(ResourceSet allResources, EObject current);

/**
	 * Defines a new representation
	 * @param newValue the new representation to set
	 */
	public void setRepresentation(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}

