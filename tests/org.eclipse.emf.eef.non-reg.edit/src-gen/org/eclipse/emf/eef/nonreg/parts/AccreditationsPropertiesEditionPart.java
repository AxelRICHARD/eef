/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 */
public interface AccreditationsPropertiesEditionPart {

	/**
	 * @return the accreditations to add
	 */
	public List getAccreditationsToAdd();

	/**
	 * @return the accreditations to remove
	 */
	public List getAccreditationsToRemove();

	/**
	 * @return the current accreditations table
	 */
	public List getAccreditationsTable();

	/**
	 * Init the accreditations
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initAccreditations(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the accreditations
	 * @param newValue the accreditations to update
	 */
	public void updateAccreditations(EObject newValue);

	/**
	 * Adds the given filter to the accreditations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToAccreditations(ViewerFilter filter);

	/**
	 * Adds the given filter to the accreditations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToAccreditations(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the accreditations table
	 */
	public boolean isContainedInAccreditationsTable(EObject element);









	// Start of user code for additional methods
	
	// End of user code

}
