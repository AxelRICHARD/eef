/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.samples.conference.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public interface PersonPropertiesEditionPart {

	/**
	 * @return the firstname
	 * 
	 */
	public String getFirstname();

	/**
	 * Defines a new firstname
	 * @param newValue the new firstname to set
	 * 
	 */
	public void setFirstname(String newValue);

	public void setMessageForFirstname(String msg, int msgLevel);

	public void unsetMessageForFirstname();


	/**
	 * @return the lastname
	 * 
	 */
	public String getLastname();

	/**
	 * Defines a new lastname
	 * @param newValue the new lastname to set
	 * 
	 */
	public void setLastname(String newValue);

	public void setMessageForLastname(String msg, int msgLevel);

	public void unsetMessageForLastname();


	/**
	 * @return the age
	 * 
	 */
	public String getAge();

	/**
	 * Defines a new age
	 * @param newValue the new age to set
	 * 
	 */
	public void setAge(String newValue);

	public void setMessageForAge(String msg, int msgLevel);

	public void unsetMessageForAge();


	/**
	 * @return the gender
	 * 
	 */
	public Enumerator getGender();

	/**
	 * Init the gender
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initGender(EEnum eenum, Enumerator current);

	/**
	 * Defines a new gender
	 * @param newValue the new gender to set
	 * 
	 */
	public void setGender(Enumerator newValue);






	/**
	 * @return the eclipseCommiter
	 * 
	 */
	public Boolean getEclipseCommiter();

	/**
	 * Defines a new eclipseCommiter
	 * @param newValue the new eclipseCommiter to set
	 * 
	 */
	public void setEclipseCommiter(Boolean newValue);






	/**
	 * @return the isRegistered
	 * 
	 */
	public Boolean getIsRegistered();

	/**
	 * Defines a new isRegistered
	 * @param newValue the new isRegistered to set
	 * 
	 */
	public void setIsRegistered(Boolean newValue);










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
