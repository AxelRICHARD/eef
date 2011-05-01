/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.properties;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * @deprecated use {@link TabbedPropertySheetPage} instead now.
 */
public class TabbedPropertiesEditingSheetPage extends TabbedPropertySheetPage {

	/**
	 * the hockey league model editor.
	 */
	protected ITabbedPropertySheetPageContributor editor;

	private AdapterFactory adapterFactory;

	private EditingDomain editingDomain;

	/**
	 * Constructor for this property sheet page.
	 * 
	 * @param tabbedPropertySheetPageContributor
	 *            the editor contributor of the property sheet page.
	 */
	public TabbedPropertiesEditingSheetPage(ITabbedPropertySheetPageContributor editor) {
		super(editor);
		this.editor = editor;
		if (editor instanceof IEditingDomainProvider) {
			editingDomain = ((IEditingDomainProvider)editor).getEditingDomain();
			if (editingDomain instanceof AdapterFactoryEditingDomain)
				this.adapterFactory = ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();
		}
	}

	protected void initializePage() {
		editingDomain = null;
		adapterFactory = null;
		if (editor != null && editor instanceof IEditorPart) {
			if (editor instanceof IEditingDomainProvider) {
				editingDomain = ((IEditingDomainProvider)editor).getEditingDomain();
				if (editingDomain instanceof AdapterFactoryEditingDomain)
					adapterFactory = ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();
			} else if ((((IEditorPart)editor).getAdapter(IEditingDomainItemProvider.class)) != null) {
				editingDomain = ((IEditingDomainProvider)((IEditorPart)editor)
						.getAdapter(IEditingDomainItemProvider.class)).getEditingDomain();
				if (editingDomain instanceof AdapterFactoryEditingDomain)
					adapterFactory = ((AdapterFactoryEditingDomain)editingDomain).getAdapterFactory();
			}

		}
	}

	/**
	 * Get the EMF AdapterFactory for this editor.
	 * 
	 * @return the EMF AdapterFactory for this editor.
	 */
	public ITabbedPropertySheetPageContributor getEditor() {
		return editor;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * Get the EMF AdapterFactory for this editor.
	 * 
	 * @return the EMF AdapterFactory for this editor.
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	public Map getDescriptor() {
		Field descriptorToTabField = null;
		boolean oldAccessible = false;
		try {
			Class<?> cls = this.getClass();
			while (!cls.equals(TabbedPropertySheetPage.class)) {
				cls = cls.getSuperclass();
			}
			descriptorToTabField = cls.getDeclaredField("descriptorToTab"); //$NON-NLS-1$
			oldAccessible = descriptorToTabField.isAccessible();
			descriptorToTabField.setAccessible(true);
			return (Map)descriptorToTabField.get(this);

		} catch (SecurityException e) {

			EEFRuntimePlugin.getDefault().logError(
					EEFRuntimeUIMessages.TabbedPropertiesEditingSheetPage_descriptorToTab_not_found, e);
		} catch (NoSuchFieldException e) {

			EEFRuntimePlugin.getDefault().logError(
					EEFRuntimeUIMessages.TabbedPropertiesEditingSheetPage_descriptorToTab_not_found, e);
		} catch (IllegalArgumentException e) {

			EEFRuntimePlugin.getDefault().logError(
					EEFRuntimeUIMessages.TabbedPropertiesEditingSheetPage_descriptorToTab_not_found, e);
		} catch (IllegalAccessException e) {

			EEFRuntimePlugin.getDefault().logError(
					EEFRuntimeUIMessages.TabbedPropertiesEditingSheetPage_descriptorToTab_not_found, e);
		} finally {
			if (descriptorToTabField != null) {
				descriptorToTabField.setAccessible(oldAccessible);
			}
		}
		return null;
	}

	@Override
	public void refresh() {
		boolean isCurrentTabNull = true;
		try {
			try {
				Class.forName("org.eclipse.ui.internal.views.properties.tabbed.view.Tab"); //$NON-NLS-1$
				// We are in eclipse 3.3
				final Method searchMethod = this.getClass().getMethod("getCurrentTab", null); //$NON-NLS-1$
				isCurrentTabNull = searchMethod.invoke(this) == null;
			} catch (final ClassNotFoundException cnfe) {
				// We are in eclipse 3.4
				final Method searchMethod = this.getClass().getMethod("getCurrentTab", null); //$NON-NLS-1$
				isCurrentTabNull = searchMethod.invoke(this) == null;
			}
		} catch (final SecurityException e) {
			// Do nothing
		} catch (final NoSuchMethodException e) {
			// Do nothing
		} catch (final IllegalArgumentException e) {
			// Do nothing
		} catch (final IllegalAccessException e) {
			// Do nothing
		} catch (final InvocationTargetException e) {
			// Do nothing
		}

		if (!isCurrentTabNull) {
			super.refresh();
		}
	}
}
