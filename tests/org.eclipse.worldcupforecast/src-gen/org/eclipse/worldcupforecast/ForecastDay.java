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
package org.eclipse.worldcupforecast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forecast Day</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.ForecastDay#getForecasts <em>Forecasts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecastDay()
 * @model
 * @generated
 */
public interface ForecastDay extends Day {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Forecasts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.worldcupforecast.Forecast}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forecasts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forecasts</em>' containment reference list.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecastDay_Forecasts()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Forecast> getForecasts();

} // ForecastDay
