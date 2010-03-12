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

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart;
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


/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TextSampleFirstTabPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TextSampleFirstTabPropertiesEditionPart {

	protected Text textRequiredPropertyInFirstTab;
	protected Text textOptionalPropertyInFirstTab;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public TextSampleFirstTabPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
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
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EefnrMessages.TextSampleFirstTabPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createTextRequiredPropertyInFirstTabText(widgetFactory, propertiesGroup);
		createTextOptionalPropertyInFirstTabText(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createTextRequiredPropertyInFirstTabText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.TextSampleFirstTabPropertiesEditionPart_TextRequiredPropertyInFirstTabLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab, EefnrViewsRepository.FORM_KIND));
		textRequiredPropertyInFirstTab = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		textRequiredPropertyInFirstTab.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textRequiredPropertyInFirstTabData = new GridData(GridData.FILL_HORIZONTAL);
		textRequiredPropertyInFirstTab.setLayoutData(textRequiredPropertyInFirstTabData);
		textRequiredPropertyInFirstTab.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleFirstTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRequiredPropertyInFirstTab.getText()));
			}
		});
		textRequiredPropertyInFirstTab.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleFirstTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRequiredPropertyInFirstTab.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createTextOptionalPropertyInFirstTabText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EefnrMessages.TextSampleFirstTabPropertiesEditionPart_TextOptionalPropertyInFirstTabLabel, propertiesEditionComponent.isRequired(EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab, EefnrViewsRepository.FORM_KIND));
		textOptionalPropertyInFirstTab = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		textOptionalPropertyInFirstTab.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textOptionalPropertyInFirstTabData = new GridData(GridData.FILL_HORIZONTAL);
		textOptionalPropertyInFirstTab.setLayoutData(textOptionalPropertyInFirstTabData);
		textOptionalPropertyInFirstTab.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleFirstTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textOptionalPropertyInFirstTab.getText()));
			}
		});
		textOptionalPropertyInFirstTab.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextSampleFirstTabPropertiesEditionPartForm.this, EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textOptionalPropertyInFirstTab.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab, EefnrViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart#getTextRequiredPropertyInFirstTab()
	 * 
	 */
	public String getTextRequiredPropertyInFirstTab() {
		return textRequiredPropertyInFirstTab.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart#setTextRequiredPropertyInFirstTab(String newValue)
	 * 
	 */
	public void setTextRequiredPropertyInFirstTab(String newValue) {
		if (newValue != null) {
			textRequiredPropertyInFirstTab.setText(newValue);
		} else {
			textRequiredPropertyInFirstTab.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForTextRequiredPropertyInFirstTab(String msg, int msgLevel) {
		messageManager.addMessage("TextRequiredPropertyInFirstTab_key", msg, null, msgLevel, textRequiredPropertyInFirstTab);
	}

	public void unsetMessageForTextRequiredPropertyInFirstTab() {
		messageManager.removeMessage("TextRequiredPropertyInFirstTab_key", textRequiredPropertyInFirstTab);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart#getTextOptionalPropertyInFirstTab()
	 * 
	 */
	public String getTextOptionalPropertyInFirstTab() {
		return textOptionalPropertyInFirstTab.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart#setTextOptionalPropertyInFirstTab(String newValue)
	 * 
	 */
	public void setTextOptionalPropertyInFirstTab(String newValue) {
		if (newValue != null) {
			textOptionalPropertyInFirstTab.setText(newValue);
		} else {
			textOptionalPropertyInFirstTab.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForTextOptionalPropertyInFirstTab(String msg, int msgLevel) {
		messageManager.addMessage("TextOptionalPropertyInFirstTab_key", msg, null, msgLevel, textOptionalPropertyInFirstTab);
	}

	public void unsetMessageForTextOptionalPropertyInFirstTab() {
		messageManager.removeMessage("TextOptionalPropertyInFirstTab_key", textOptionalPropertyInFirstTab);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.TextSampleFirstTab_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
