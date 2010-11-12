/**
 * 
 */
package org.eclipse.emf.eef.runtime.impl.components;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class SinglePartPropertiesEditingComponent extends StandardPropertiesEditionComponent {

	/**
	 * Editing context
	 */
	protected PropertiesEditingContext editingContext;
	
	/**
	 * EObject to edit
	 */
	protected EObject semanticObject;

	/**
	 * Component's part
	 */
	protected IPropertiesEditionPart editingPart;
	
	/**
	 * Key to use to get the Part provider
	 */
	protected java.lang.Object repositoryKey;

	/**
	 * Key to use to get the Part
	 */
	protected java.lang.Object partKey;

	/**
	 * Default constructor
	 * 
	 */
	public SinglePartPropertiesEditingComponent(PropertiesEditingContext editingContext, EObject semanticObject, String editing_mode) {
		this.semanticObject = semanticObject;
		this.editingContext = editingContext;
		if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			semanticAdapter = initializeSemanticAdapter();
			this.semanticObject.eAdapters().add(semanticAdapter);
		}
		this.editing_mode = editing_mode;
	}
	
	/**
	 * @return
	 */
	private String partID() {
		return parts[0];
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Object translatePart(String key) {
		if (partID().equals(key))
			return partKey;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == partKey) {
			this.editingPart = propertiesEditionPart;
			if (semanticAdapter != null)
				semanticAdapter.setPart(editingPart);
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getEditingContext()
	 */
	public PropertiesEditingContext getEditingContext() {
		return editingContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		validate = EEFRuntimePlugin.getEEFValidator().validate(semanticObject);
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			semanticObject.eAdapters().remove(semanticAdapter);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (semanticObject != null && partID().equals(key)) {
			if (editingPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(repositoryKey);
				if (provider != null) {
					editingPart = provider.getPropertiesEditionPart(partKey, kind, this);
					addListener((IPropertiesEditionListener)editingPart);
					if (semanticAdapter != null)
						semanticAdapter.setPart(editingPart);
				}
			}
			return (IPropertiesEditionPart)editingPart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return editingPart.getTitle();
	}

}
