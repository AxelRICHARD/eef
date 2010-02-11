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
package org.eclipse.emf.eef.eefnr.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TextSampleSecondTabPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TextSampleSecondTabPropertiesEditionPart {

	protected Text textRequiredPropertyInSecondTab;
	protected Text textOptionalPropertyInSecondTab;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TextSampleSecondTabPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EefnrMessages.TextSampleSecondTabPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createTextRequiredPropertyInSecondTabText(widgetFactory, propertiesGroup);
		createTextOptionalPropertyInSecondTabText(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	protected void createTextRequiredPropertyInSecondTabText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.TextSampleSecondTabPropertiesEditionPart_TextRequiredPropertyInSecondTabLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.TextSampleSecondTab.textRequiredPropertyInSecondTab, EefnrViewsRepository.FORM_KIND));
		textRequiredPropertyInSecondTab = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		textRequiredPropertyInSecondTab.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textRequiredPropertyInSecondTabData = new GridData(GridData.FILL_HORIZONTAL);
		textRequiredPropertyInSecondTab.setLayoutData(textRequiredPropertyInSecondTabData);
		textRequiredPropertyInSecondTab.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleSecondTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleSecondTab.textRequiredPropertyInSecondTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRequiredPropertyInSecondTab.getText()));
			}
		});
		textRequiredPropertyInSecondTab.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleSecondTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleSecondTab.textRequiredPropertyInSecondTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRequiredPropertyInSecondTab.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.TextSampleSecondTab.textRequiredPropertyInSecondTab, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	protected void createTextOptionalPropertyInSecondTabText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.TextSampleSecondTabPropertiesEditionPart_TextOptionalPropertyInSecondTabLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.TextSampleSecondTab.textOptionalPropertyInSecondTab, EefnrViewsRepository.FORM_KIND));
		textOptionalPropertyInSecondTab = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		textOptionalPropertyInSecondTab.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textOptionalPropertyInSecondTabData = new GridData(GridData.FILL_HORIZONTAL);
		textOptionalPropertyInSecondTab.setLayoutData(textOptionalPropertyInSecondTabData);
		textOptionalPropertyInSecondTab.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleSecondTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleSecondTab.textOptionalPropertyInSecondTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textOptionalPropertyInSecondTab.getText()));
			}
		});
		textOptionalPropertyInSecondTab.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleSecondTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleSecondTab.textOptionalPropertyInSecondTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textOptionalPropertyInSecondTab.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.TextSampleSecondTab.textOptionalPropertyInSecondTab, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart#getTextRequiredPropertyInSecondTab()
	 */
	public String getTextRequiredPropertyInSecondTab() {
		return textRequiredPropertyInSecondTab.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart#setTextRequiredPropertyInSecondTab(String newValue)
	 */
	public void setTextRequiredPropertyInSecondTab(String newValue) {
		if (newValue != null) {
			textRequiredPropertyInSecondTab.setText(newValue);
		} else {
			textRequiredPropertyInSecondTab.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForTextRequiredPropertyInSecondTab(String msg, int msgLevel) {
		messageManager.addMessage("TextRequiredPropertyInSecondTab_key", msg, null, msgLevel, textRequiredPropertyInSecondTab);
	}

	public void unsetMessageForTextRequiredPropertyInSecondTab() {
		messageManager.removeMessage("TextRequiredPropertyInSecondTab_key", textRequiredPropertyInSecondTab);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart#getTextOptionalPropertyInSecondTab()
	 */
	public String getTextOptionalPropertyInSecondTab() {
		return textOptionalPropertyInSecondTab.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart#setTextOptionalPropertyInSecondTab(String newValue)
	 */
	public void setTextOptionalPropertyInSecondTab(String newValue) {
		if (newValue != null) {
			textOptionalPropertyInSecondTab.setText(newValue);
		} else {
			textOptionalPropertyInSecondTab.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForTextOptionalPropertyInSecondTab(String msg, int msgLevel) {
		messageManager.addMessage("TextOptionalPropertyInSecondTab_key", msg, null, msgLevel, textOptionalPropertyInSecondTab);
	}

	public void unsetMessageForTextOptionalPropertyInSecondTab() {
		messageManager.removeMessage("TextOptionalPropertyInSecondTab_key", textOptionalPropertyInSecondTab);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return EefnrMessages.TextSampleSecondTab_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
