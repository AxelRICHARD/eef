/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.middle.middlenonreg.parts.MiddlenonregViewsRepository;
import org.eclipse.emf.eef.middle.middlenonreg.parts.NamedElementPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.SuperCiblePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


// End of user code

/**
 * 
 */
public class SuperCiblePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SuperCiblePropertiesEditionPart {


	private NamedElementPropertiesEditionPart namedElementPropertiesEditionPart;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SuperCiblePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createNamedElement(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createNamedElement(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MiddlenonregViewsRepository.class);
		namedElementPropertiesEditionPart = (NamedElementPropertiesEditionPart)provider.getPropertiesEditionPart(MiddlenonregViewsRepository.NamedElement.class, MiddlenonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)namedElementPropertiesEditionPart).createControls(container);
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
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SuperCiblePropertiesEditionPart#getNamedElementReferencedView()
	 */
		public IPropertiesEditionPart getNamedElementReferencedView() {
			return (IPropertiesEditionPart) namedElementPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SuperCiblePropertiesEditionPart#getName()
	 */
	public String getName() {
		return namedElementPropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.SuperCiblePropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		namedElementPropertiesEditionPart.setName(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {
		namedElementPropertiesEditionPart.setMessageForName(msg, msgLevel);
	}

	public void unsetMessageForName() {
		namedElementPropertiesEditionPart.unsetMessageForName();
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.NamedElementPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return namedElementPropertiesEditionPart.getDocumentation();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelNavigation.parts.NamedElementPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		namedElementPropertiesEditionPart.setDocumentation(newValue);
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {
		namedElementPropertiesEditionPart.setMessageForDocumentation(msg, msgLevel);
	}

	public void unsetMessageForDocumentation() {
		namedElementPropertiesEditionPart.unsetMessageForDocumentation();
	}








	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return NonregMessages.SuperCible_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
