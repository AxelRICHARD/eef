/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: SpecificElementEditorPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:16:52 glefur Exp $
 */
package org.eclipse.emf.eef.views.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.views.SpecificElementEditor	;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.providers.ViewsMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.impl.SpecificElementEditorPropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.toolkits.Widget;	






// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SpecificElementEditorPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SpecificElementEditorPropertiesEditionPart {

	protected SpecificElementEditor current;
	protected ResourceSet resourceSet;
	private Text name;
	private EObjectFlatComboViewer representation;
	private Button readOnly;
		
	public SpecificElementEditorPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);	
		
		createControls(view);
		
		return view;
	}
	
	public void createControls(Composite view) { 
		createPropertiesGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ViewsMessages.SpecificElementEditorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
		createRepresentationFlatComboViewer(propertiesGroup);
		createReadOnlyCheckbox(propertiesGroup);
   	}

	private void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ViewsMessages.SpecificElementEditorPropertiesEditionPart_NameLabel, true);
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(SpecificElementEditorPropertiesEditionPartImpl.this, ViewsViewsRepository.SpecificElementEditor.name, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, "The element name", null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createRepresentationFlatComboViewer(Composite parent) {
	
		SWTUtils.createPartLabel(parent, ViewsMessages.SpecificElementEditorPropertiesEditionPart_RepresentationLabel, false);		
		representation = new EObjectFlatComboViewer(parent, true);
		representation.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		representation.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof Widget); //$NON-NLS-1$ 			
			}

		});
		representation.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(SpecificElementEditorPropertiesEditionPartImpl.this, ViewsViewsRepository.SpecificElementEditor.representation, PathedPropertiesEditionEvent.CHANGE, PathedPropertiesEditionEvent.SET, null, getRepresentation()));
			}

		});
		GridData representationData = new GridData(GridData.FILL_HORIZONTAL);
		representation.setLayoutData(representationData);
		SWTUtils.createHelpButton(parent, "The representation of this part of view", null); //$NON-NLS-1$
	}

	protected void createReadOnlyCheckbox(Composite parent) {
		readOnly = new Button(parent, SWT.CHECK);
		readOnly.setText(ViewsMessages.SpecificElementEditorPropertiesEditionPart_ReadOnlyLabel);
		GridData readOnlyData = new GridData(GridData.FILL_HORIZONTAL);
		readOnlyData.horizontalSpan = 2;
		readOnly.setLayoutData(readOnlyData);
		SWTUtils.createHelpButton(parent, "Defines that this editor is in read only mode", null); //$NON-NLS-1$
	}


	public void initComponent(EObject eObject, ResourceSet allResources) {
		SpecificElementEditor specificElementEditor = (SpecificElementEditor)eObject;
		current = specificElementEditor;
		resourceSet = allResources;
		representation.setInput(allResources);
		if (specificElementEditor.getRepresentation() != null){
			representation.setSelection(new StructuredSelection(specificElementEditor.getRepresentation()));
		}
		// Start of user code for representation filters initialisation

 		// End of user code
	
		if (specificElementEditor.getName() != null){
			name.setText(specificElementEditor.getName());
		}	
		readOnly.setSelection(specificElementEditor.isReadOnly());	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		name.setText(newValue);
	}

	public void setMessageForName (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForName () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#getRepresentation()
	 */
	public EObject getRepresentation() {
		if (representation.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) representation.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#setRepresentation(EObject newValue)
	 */
	public void setRepresentation(EObject newValue) {
		if (newValue != null)
			representation.setSelection(new StructuredSelection(newValue));
		else
			representation.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForRepresentation (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForRepresentation () {
	
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#getReadOnly()
	 */
	public Boolean getReadOnly() {
		return Boolean.valueOf(readOnly.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart#setReadOnly(Boolean newValue)
	 */
	public void setReadOnly(Boolean newValue) {
		readOnly.setSelection(newValue.booleanValue());
	}

	public void setMessageForReadOnly (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForReadOnly () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	
