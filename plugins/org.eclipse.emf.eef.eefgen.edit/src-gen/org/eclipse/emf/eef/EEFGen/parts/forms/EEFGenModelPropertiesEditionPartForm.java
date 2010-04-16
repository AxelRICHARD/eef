/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EEFGenModelPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EEFGenModelPropertiesEditionPart {

	protected Text generationDirectory;
	protected Text testsGenerationDirectory;
	protected Button useJMergeToManageUserCode;
	protected Text author;
	protected Text license;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EEFGenModelPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createParametersGroup(widgetFactory, view);

		createLegalGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createParametersGroup(FormToolkit widgetFactory, final Composite view) {
		Section parametersSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		parametersSection.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_ParametersGroupLabel);
		GridData parametersSectionData = new GridData(GridData.FILL_HORIZONTAL);
		parametersSectionData.horizontalSpan = 3;
		parametersSection.setLayoutData(parametersSectionData);
		Composite parametersGroup = widgetFactory.createComposite(parametersSection);
		GridLayout parametersGroupLayout = new GridLayout();
		parametersGroupLayout.numColumns = 3;
		parametersGroup.setLayout(parametersGroupLayout);
		createGenerationDirectoryText(widgetFactory, parametersGroup);
		createTestsGenerationDirectoryText(widgetFactory, parametersGroup);
		createUseJMergeToManageUserCodeCheckbox(widgetFactory, parametersGroup);
		parametersSection.setClient(parametersGroup);
	}

	
	protected void createGenerationDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_GenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.FORM_KIND));
		generationDirectory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		generationDirectory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData generationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		generationDirectory.setLayoutData(generationDirectoryData);
		generationDirectory.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
			}
		});
		generationDirectory.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.generationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, generationDirectory.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.generationDirectory, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createTestsGenerationDirectoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_TestsGenerationDirectoryLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.FORM_KIND));
		testsGenerationDirectory = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		testsGenerationDirectory.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData testsGenerationDirectoryData = new GridData(GridData.FILL_HORIZONTAL);
		testsGenerationDirectory.setLayoutData(testsGenerationDirectoryData);
		testsGenerationDirectory.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
			}
		});
		testsGenerationDirectory.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, testsGenerationDirectory.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.testsGenerationDirectory, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createUseJMergeToManageUserCodeCheckbox(FormToolkit widgetFactory, Composite parent) {
		useJMergeToManageUserCode = widgetFactory.createButton(parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_UseJMergeToManageUserCodeLabel, SWT.CHECK);
		useJMergeToManageUserCode.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.useJMergeToManageUserCode, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(useJMergeToManageUserCode.getSelection())));
			}

		});
		GridData useJMergeToManageUserCodeData = new GridData(GridData.FILL_HORIZONTAL);
		useJMergeToManageUserCodeData.horizontalSpan = 2;
		useJMergeToManageUserCode.setLayoutData(useJMergeToManageUserCodeData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.useJMergeToManageUserCode, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createLegalGroup(FormToolkit widgetFactory, final Composite view) {
		Section legalSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		legalSection.setText(EEFGenMessages.EEFGenModelPropertiesEditionPart_LegalGroupLabel);
		GridData legalSectionData = new GridData(GridData.FILL_HORIZONTAL);
		legalSectionData.horizontalSpan = 3;
		legalSection.setLayoutData(legalSectionData);
		Composite legalGroup = widgetFactory.createComposite(legalSection);
		GridLayout legalGroupLayout = new GridLayout();
		legalGroupLayout.numColumns = 3;
		legalGroup.setLayout(legalGroupLayout);
		createAuthorText(widgetFactory, legalGroup);
		createLicenseTextarea(widgetFactory, legalGroup);
		legalSection.setClient(legalGroup);
	}

	
	protected void createAuthorText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_AuthorLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.FORM_KIND));
		author = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		author.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData authorData = new GridData(GridData.FILL_HORIZONTAL);
		author.setLayoutData(authorData);
		author.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, author.getText()));
			}
		});
		author.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.author, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, author.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.author, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createLicenseTextarea(FormToolkit widgetFactory, Composite parent) {
		Label licenseLabel = FormUtils.createPartLabel(widgetFactory, parent, EEFGenMessages.EEFGenModelPropertiesEditionPart_LicenseLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.FORM_KIND));
		GridData licenseLabelData = new GridData(GridData.FILL_HORIZONTAL);
		licenseLabelData.horizontalSpan = 3;
		licenseLabel.setLayoutData(licenseLabelData);
		license = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData licenseData = new GridData(GridData.FILL_HORIZONTAL);
		licenseData.horizontalSpan = 2;
		licenseData.heightHint = 80;
		licenseData.widthHint = 200;
		license.setLayoutData(licenseData);
		license.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelPropertiesEditionPartForm.this, EEFGenViewsRepository.EEFGenModel.license, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, license.getText()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModel.license, EEFGenViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getGenerationDirectory()
	 * 
	 */
	public String getGenerationDirectory() {
		return generationDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setGenerationDirectory(String newValue)
	 * 
	 */
	public void setGenerationDirectory(String newValue) {
		if (newValue != null) {
			generationDirectory.setText(newValue);
		} else {
			generationDirectory.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getTestsGenerationDirectory()
	 * 
	 */
	public String getTestsGenerationDirectory() {
		return testsGenerationDirectory.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setTestsGenerationDirectory(String newValue)
	 * 
	 */
	public void setTestsGenerationDirectory(String newValue) {
		if (newValue != null) {
			testsGenerationDirectory.setText(newValue);
		} else {
			testsGenerationDirectory.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getUseJMergeToManageUserCode()
	 * 
	 */
	public Boolean getUseJMergeToManageUserCode() {
		return Boolean.valueOf(useJMergeToManageUserCode.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setUseJMergeToManageUserCode(Boolean newValue)
	 * 
	 */
	public void setUseJMergeToManageUserCode(Boolean newValue) {
		if (newValue != null) {
			useJMergeToManageUserCode.setSelection(newValue.booleanValue());
		} else {
			useJMergeToManageUserCode.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getAuthor()
	 * 
	 */
	public String getAuthor() {
		return author.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setAuthor(String newValue)
	 * 
	 */
	public void setAuthor(String newValue) {
		if (newValue != null) {
			author.setText(newValue);
		} else {
			author.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#getLicense()
	 * 
	 */
	public String getLicense() {
		return license.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelPropertiesEditionPart#setLicense(String newValue)
	 * 
	 */
	public void setLicense(String newValue) {
		if (newValue != null) {
			license.setText(newValue);
		} else {
			license.setText("");  //$NON-NLS-1$
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EEFGenMessages.EEFGenModel_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
