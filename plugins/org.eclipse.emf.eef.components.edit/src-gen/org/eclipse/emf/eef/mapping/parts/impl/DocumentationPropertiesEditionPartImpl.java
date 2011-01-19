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
 * $Id: DocumentationPropertiesEditionPartImpl.java,v 1.1 2009/04/30 17:09:48 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.parts.impl;

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

import org.eclipse.emf.eef.mapping.DocumentedElement	;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.components.providers.ComponentsMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.mapping.parts.DocumentationPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.impl.DocumentationPropertiesEditionPartImpl;



// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class DocumentationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DocumentationPropertiesEditionPart {

	private Text documentation;
		
	public DocumentationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createDocumentationGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}
	
	private void createDocumentationGroup(Composite parent) {
		Group documentationGroup = new Group(parent, SWT.NONE);
		documentationGroup.setText(ComponentsMessages.DocumentationPropertiesEditionPart_DocumentationGroupLabel);
		GridData documentationGroupData = new GridData(GridData.FILL_HORIZONTAL);
		documentationGroupData.horizontalSpan = 3;
		documentationGroup.setLayoutData(documentationGroupData);
		GridLayout documentationGroupLayout = new GridLayout();
		documentationGroupLayout.numColumns = 3;
		documentationGroup.setLayout(documentationGroupLayout);
		createDocumentationTextarea(documentationGroup);
   	}

	protected void createDocumentationTextarea(Composite parent) {
		Label documentationLabel = SWTUtils.createPartLabel(parent, ComponentsMessages.DocumentationPropertiesEditionPart_DocumentationLabel, false);
		GridData documentationLabelData = new GridData(GridData.FILL_HORIZONTAL);
		documentationLabelData.horizontalSpan = 3;
		documentationLabel.setLayoutData(documentationLabelData);
		documentation = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData documentationData = new GridData(GridData.FILL_HORIZONTAL);
		documentationData.horizontalSpan = 2;
		documentationData.heightHint = 80;
		documentation.setLayoutData(documentationData);
		SWTUtils.createHelpButton(parent, "The documentation of the element", null); //$NON-NLS-1$
	}		


	public void initComponent(EObject eObject, ResourceSet allResources) {
		DocumentedElement documentedElement = (DocumentedElement)eObject;
		if (documentedElement.getDocumentation() != null){
			documentation.setText(documentedElement.getDocumentation());
		}	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.DocumentationPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.DocumentationPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		documentation.setText(newValue);
	}

	public void setMessageForDocumentation (String msg, int msgLevel) {
	
	}
	
	public void unsetMessageForDocumentation () {
	
	}




	// Start of user code additional methods
 	
	// End of user code

}	