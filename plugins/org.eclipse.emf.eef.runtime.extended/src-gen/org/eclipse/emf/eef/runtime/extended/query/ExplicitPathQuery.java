/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExplicitPathQuery.java,v 1.1 2010/12/22 14:23:49 glefur Exp $
 */
package org.eclipse.emf.eef.runtime.extended.query;

import org.eclipse.emf.eef.mapping.navigation.ModelNavigation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Explicit Path Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.runtime.extended.query.ExplicitPathQuery#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.runtime.extended.query.QueryPackage#getExplicitPathQuery()
 * @model
 * @generated
 */
public interface ExplicitPathQuery extends EEFUnderstandableQuery {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' reference.
	 * @see #setQuery(ModelNavigation)
	 * @see org.eclipse.emf.eef.runtime.extended.query.QueryPackage#getExplicitPathQuery_Query()
	 * @model required="true"
	 * @generated
	 */
	ModelNavigation getQuery();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.runtime.extended.query.ExplicitPathQuery#getQuery <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' reference.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(ModelNavigation value);

} // ExplicitPathQuery
