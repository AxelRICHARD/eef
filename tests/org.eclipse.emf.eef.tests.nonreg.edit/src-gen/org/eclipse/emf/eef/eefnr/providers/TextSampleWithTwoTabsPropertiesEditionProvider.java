/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.providers;

import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TextSampleWithTwoTabs;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsPropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TextSampleWithTwoTabsPropertiesEditionProvider extends PropertiesEditingProviderImpl {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext) {
		return (editingContext.getEObject() instanceof TextSampleWithTwoTabs) 
					&& (EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs() == editingContext.getEObject().eClass());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part) {
		return (editingContext.getEObject() instanceof TextSampleWithTwoTabs) && (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part) || TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, Class refinement) {
		return (editingContext.getEObject() instanceof TextSampleWithTwoTabs) && (refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class || refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, String part, Class refinement) {
		return (editingContext.getEObject() instanceof TextSampleWithTwoTabs) && ((TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part) && refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class) || (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part) && refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode) {
		if (editingContext.getEObject() instanceof TextSampleWithTwoTabs) {
			return new TextSampleWithTwoTabsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part) {
		if (editingContext.getEObject() instanceof TextSampleWithTwoTabs) {
			if (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part))
				return new TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part))
				return new TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part, Class refinement) {
		if (editingContext.getEObject() instanceof TextSampleWithTwoTabs) {
			if (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part)
				&& refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class)
				return new TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part)
				&& refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class)
				return new TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

}
