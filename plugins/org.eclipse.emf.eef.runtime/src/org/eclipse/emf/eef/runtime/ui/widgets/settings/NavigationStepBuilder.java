/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

/**
 * @author glefur
 * @since 1.0
 * 
 */
public class NavigationStepBuilder {
	private EReference reference;
	private int index;
	private EClassifier discriminator;

	/**
	 * Prevent external instanciation.
	 */
	private NavigationStepBuilder() { };

	/**
	 * @param eReference 
	 * @return a new {@link NavigationStep} instance.
	 */
	public static NavigationStepBuilder create(EReference reference) {
		NavigationStepBuilder navigationStepBuilder = new NavigationStepBuilder();
		navigationStepBuilder.reference = reference;
		return navigationStepBuilder;
	}

	public NavigationStepBuilder index(int index) {
		this.index = index;
		return this;
	}

	public NavigationStepBuilder discriminator(EClassifier discriminator) {
		this.discriminator = discriminator;
		return this;
	}

	public NavigationStep build() {
		NavigationStepImpl build = new NavigationStepImpl();
		build.reference = this.reference;
		build.index = this.index;
		build.discriminator = this.discriminator;
		return build;
	}

	class NavigationStepImpl implements NavigationStep {

		private EReference reference;
		private int index;
		private EClassifier discriminator;
		
		private NavigationStepImpl() {
			index = NavigationStep.NOT_INITIALIZED;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStep#getReference()
		 */
		public EReference getReference() {
			return reference;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStep#getIndex()
		 */
		public int getIndex() {
			return index;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStep#getDiscriminator()
		 */
		public EClassifier getDiscriminator() {
			return discriminator;
		}
	}

}
