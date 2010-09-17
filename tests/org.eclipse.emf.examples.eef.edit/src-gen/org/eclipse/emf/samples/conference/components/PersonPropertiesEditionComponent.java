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
package org.eclipse.emf.samples.conference.components;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.samples.conference.Person;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.samples.conference.parts.PresencePropertiesEditionPart;


/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @generated
 */
public class PersonPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private PersonPropertiesEditionPart basePart;

	/**
	 * The PersonBasePropertiesEditionComponent sub component
	 */
	protected PersonBasePropertiesEditionComponent personBasePropertiesEditionComponent;

	/**
	 * The Presence part
	 */
	private PresencePropertiesEditionPart presencePart;

	/**
	 * The PersonPresencePropertiesEditionComponent sub component
	 */
	protected PersonPresencePropertiesEditionComponent personPresencePropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param person
	 *            the EObject to edit
	 */
	public PersonPropertiesEditionComponent(EObject person, String editing_mode) {
		super(editing_mode);
		if (person instanceof Person) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(person);
			personBasePropertiesEditionComponent = (PersonBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(person, editing_mode, PersonBasePropertiesEditionComponent.BASE_PART);
			addSubComponent(personBasePropertiesEditionComponent);
			personPresencePropertiesEditionComponent = (PersonPresencePropertiesEditionComponent)provider.getPropertiesEditionComponent(person, editing_mode, PersonPresencePropertiesEditionComponent.PRESENCE_PART);
			addSubComponent(personPresencePropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (PersonBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (PersonPropertiesEditionPart)personBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		if (PersonPresencePropertiesEditionComponent.PRESENCE_PART.equals(key)) {
			presencePart = (PresencePropertiesEditionPart)personPresencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)presencePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ConferenceViewsRepository.Person.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (PersonPropertiesEditionPart)propertiesEditionPart;
		}
		if (ConferenceViewsRepository.Presence.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			presencePart = (PresencePropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ConferenceViewsRepository.Person.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == ConferenceViewsRepository.Presence.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
	
	/**
	 * @generated NOT
	 */
	public void keep() {
		Map<String, String> map = new HashMap<String, String>();
	}
}