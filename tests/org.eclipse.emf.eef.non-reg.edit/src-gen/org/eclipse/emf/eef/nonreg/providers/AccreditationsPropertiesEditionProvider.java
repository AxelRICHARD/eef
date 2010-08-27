/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.nonreg.components.AccreditationsPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * 
 * @generated
 */
public class AccreditationsPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public boolean provides(EObject eObject) {
    return (eObject instanceof Person) && (NonregPackage.eINSTANCE.getPerson() == eObject.eClass());
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * @generated
	 */
	public boolean provides(EObject eObject, String part) {
    return (eObject instanceof Person) && (AccreditationsPropertiesEditionComponent.BASE_PART.equals(part));
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * @generated
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
    return (eObject instanceof Person) && (refinement == AccreditationsPropertiesEditionComponent.class);
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * @generated
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
    return (eObject instanceof Person) && ((AccreditationsPropertiesEditionComponent.BASE_PART.equals(part) && refinement == AccreditationsPropertiesEditionComponent.class));
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * @generated
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
    if (eObject instanceof Person) {
      return new AccreditationsPropertiesEditionComponent(eObject, editing_mode);
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * @generated
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
    if (eObject instanceof Person) {
      if (AccreditationsPropertiesEditionComponent.BASE_PART.equals(part))
        return new AccreditationsPropertiesEditionComponent(eObject, editing_mode);
    }
    return null;
  }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * @generated
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
    if (eObject instanceof Person) {
      if (AccreditationsPropertiesEditionComponent.BASE_PART.equals(part)
        && refinement == AccreditationsPropertiesEditionComponent.class)
        return new AccreditationsPropertiesEditionComponent(eObject, editing_mode);
    }
    return null;
  }

}