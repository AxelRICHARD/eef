/**
 * <copyright>
 * </copyright>
 *
 * $Id: RemoveProject.java,v 1.1 2011/04/06 13:07:27 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EclipseActions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject#getProjectName <em>Project Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage#getRemoveProject()
 * @model
 * @generated
 */
public interface RemoveProject extends EclipseAction {
	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage#getRemoveProject_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

} // RemoveProject