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
 * $Id$
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface OCLFilterPropertiesEditionPart {

	/**
	 * @return the OCLExpressionBody
	 */
	public String getOCLExpressionBody();

	/**
	 * Defines a new OCLExpressionBody
	 * @param newValue the new OCLExpressionBody to set
	 */
	public void setOCLExpressionBody(String newValue);

	public void setMessageForOCLExpressionBody(String msg, int msgLevel);

	public void unsetMessageForOCLExpressionBody();



	/**
	 * @return the Filter properties referenced view
	 */
	public IPropertiesEditionPart getFilterPropertiesReferencedView();
	/**
	 * @return the Name
	 */
	public String getName();

	/**
	 * Defines a new Name
	 * @param newValue the new Name to set
	 */
	public void setName(String newValue);

	public void setMessageForName(String msg, int msgLevel);

	public void unsetMessageForName();

	/**
	 * @return the Mandatory
	 */
	public Boolean getMandatory();

	/**
	 * Defines a new Mandatory
	 * @param newValue the new Mandatory to set
	 */
	public void setMandatory(Boolean newValue);









	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
