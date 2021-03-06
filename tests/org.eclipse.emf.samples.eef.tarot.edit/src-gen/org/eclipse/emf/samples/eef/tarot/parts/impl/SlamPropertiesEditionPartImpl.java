/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code	

/**
 * 
 * 
 */
public class SlamPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SlamPropertiesEditionPart {

	protected EMFComboViewer side;
	protected Button announced;
	protected Button achieved;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SlamPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
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
	 * 
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(TarotMessages.SlamPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createSideEMFComboViewer(propertiesGroup);
		createAnnouncedCheckbox(propertiesGroup);
		createAchievedCheckbox(propertiesGroup);
	}

	
	protected void createSideEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.SlamPropertiesEditionPart_SideLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.Slam.side, TarotViewsRepository.SWT_KIND));
		side = new EMFComboViewer(parent);
		side.setContentProvider(new ArrayContentProvider());
		side.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData sideData = new GridData(GridData.FILL_HORIZONTAL);
		side.getCombo().setLayoutData(sideData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.side, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createAnnouncedCheckbox(Composite parent) {
		announced = new Button(parent, SWT.CHECK);
		announced.setText(TarotMessages.SlamPropertiesEditionPart_AnnouncedLabel);
		GridData announcedData = new GridData(GridData.FILL_HORIZONTAL);
		announcedData.horizontalSpan = 2;
		announced.setLayoutData(announcedData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.announced, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createAchievedCheckbox(Composite parent) {
		achieved = new Button(parent, SWT.CHECK);
		achieved.setText(TarotMessages.SlamPropertiesEditionPart_AchievedLabel);
		GridData achievedData = new GridData(GridData.FILL_HORIZONTAL);
		achievedData.horizontalSpan = 2;
		achieved.setLayoutData(achievedData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.achieved, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getSide()
	 * 
	 */
	public Enumerator getSide() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) side.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#initSide(EEnum eenum, Enumerator current)
	 */
	public void initSide(EEnum eenum, Enumerator current) {
		side.setInput(eenum.getELiterals());
		side.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setSide(Enumerator newValue)
	 * 
	 */
	public void setSide(Enumerator newValue) {
		side.modelUpdating(new StructuredSelection(newValue));
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getAnnounced()
	 * 
	 */
	public Boolean getAnnounced() {
		return Boolean.valueOf(announced.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setAnnounced(Boolean newValue)
	 * 
	 */
	public void setAnnounced(Boolean newValue) {
		if (newValue != null) {
			announced.setSelection(newValue.booleanValue());
		} else {
			announced.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getAchieved()
	 * 
	 */
	public Boolean getAchieved() {
		return Boolean.valueOf(achieved.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setAchieved(Boolean newValue)
	 * 
	 */
	public void setAchieved(Boolean newValue) {
		if (newValue != null) {
			achieved.setSelection(newValue.booleanValue());
		} else {
			achieved.setSelection(false);
		}
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.Slam_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
