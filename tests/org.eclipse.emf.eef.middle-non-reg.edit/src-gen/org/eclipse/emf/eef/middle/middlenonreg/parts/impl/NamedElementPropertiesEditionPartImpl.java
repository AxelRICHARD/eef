/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.middle.middlenonreg.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart;
import org.eclipse.emf.eef.middle.middlenonreg.parts.MiddlenonregViewsRepository;
import org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart;
import org.eclipse.emf.eef.middle.middlenonreg.providers.MiddlenonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;


// End of user code

/**
 * 
 */
public class NamedElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, NamedElementPropertiesEditionPart {

	protected Text name;

	private DocumentedElementPropertiesEditionPart documentedElementPropertiesEditionPart;



	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public NamedElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);
		createDocumentedElement(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(MiddlenonregMessages.NamedElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(propertiesGroup);
	}
	protected void createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, MiddlenonregMessages.NamedElementPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(MiddlenonregViewsRepository.NamedElement.name, MiddlenonregViewsRepository.SWT_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(NamedElementPropertiesEditionPartImpl.this, MiddlenonregViewsRepository.NamedElement.name, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, name.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MiddlenonregViewsRepository.NamedElement.name, MiddlenonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createDocumentedElement(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(AbstractnonregViewsRepository.class);
		documentedElementPropertiesEditionPart = (DocumentedElementPropertiesEditionPart)provider.getPropertiesEditionPart(AbstractnonregViewsRepository.DocumentedElement.class, AbstractnonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)documentedElementPropertiesEditionPart).createControls(container);
	}



	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart#getName()
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForName(String msg, int msgLevel) {

	}

	public void unsetMessageForName() {

	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart#getDocumentedElementReferencedView()
	 */
		public IPropertiesEditionPart getDocumentedElementReferencedView() {
			return (IPropertiesEditionPart) documentedElementPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentedElementPropertiesEditionPart.getDocumentation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		documentedElementPropertiesEditionPart.setDocumentation(newValue);
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {
		documentedElementPropertiesEditionPart.setMessageForDocumentation(msg, msgLevel);
	}

	public void unsetMessageForDocumentation() {
		documentedElementPropertiesEditionPart.unsetMessageForDocumentation();
	}







	// Start of user code additional methods
	
	// End of user code

}
