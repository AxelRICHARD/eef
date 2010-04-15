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
package org.eclipse.emf.eef.eefnr.references.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.references.parts.AbstractEnabledSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.references.parts.ReferencesViewsRepository;
import org.eclipse.emf.eef.eefnr.references.providers.ReferencesMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;




// End of user code	

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferenceEnabledSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ReferenceEnabledSamplePropertiesEditionPart {

	protected EMFListEditUtil referenceEditUtil;
	protected ReferencesTable<? extends EObject> reference;
	protected List<ViewerFilter> referenceBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> referenceFilters = new ArrayList<ViewerFilter>();
	private AbstractEnabledSamplePropertiesEditionPart abstractEnabledSamplePropertiesEditionPart;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ReferenceEnabledSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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

		createAbstractEnabledSample(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ReferencesMessages.ReferenceEnabledSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createReferenceAdvancedReferencesTable(propertiesGroup);
	}

	/**
	 * 
	 */
	protected void createReferenceAdvancedReferencesTable(Composite parent) {
		this.reference = new ReferencesTable<TotalSample>(ReferencesMessages.ReferenceEnabledSamplePropertiesEditionPart_ReferenceLabel, new ReferencesTableListener<TotalSample>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<TotalSample> dialog = new TabElementTreeSelectionDialog<TotalSample>(resourceSet, referenceFilters, referenceBusinessFilters,
				"TotalSample", EefnrPackage.eINSTANCE.getTotalSample(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!referenceEditUtil.getVirtualList().contains(elem))
								referenceEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.reference,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						reference.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(TotalSample element) { editReference(element); }
			public void handleMove(TotalSample element, int oldIndex, int newIndex) { moveReference(element, oldIndex, newIndex); }
			public void handleRemove(TotalSample element) { removeFromReference(element); }
			public void navigateTo(TotalSample element) { }
		});
		this.reference.setHelpText(propertiesEditionComponent.getHelpContent(ReferencesViewsRepository.ReferenceEnabledSample.reference, ReferencesViewsRepository.SWT_KIND));
		this.reference.createControls(parent);
		GridData referenceData = new GridData(GridData.FILL_HORIZONTAL);
		referenceData.horizontalSpan = 3;
		this.reference.setLayoutData(referenceData);
		this.reference.disableMove();
	}

	/**
	 * 
	 */
	protected void moveReference(TotalSample element, int oldIndex, int newIndex) {
		EObject editedElement = referenceEditUtil.foundCorrespondingEObject(element);
		referenceEditUtil.moveElement(element, oldIndex, newIndex);
		reference.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.reference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromReference(TotalSample element) {

		// Start of user code removeFromReference() method body
				EObject editedElement = referenceEditUtil.foundCorrespondingEObject(element);
				referenceEditUtil.removeElement(element);
				reference.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.reference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
				
		// End of user code

	}

	/**
	 * 
	 */
	protected void editReference(TotalSample element) {

		// Start of user code editReference() method body
				EObject editedElement = referenceEditUtil.foundCorrespondingEObject(element);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
				IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
					if (propertiesEditionObject != null) {
						referenceEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						reference.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferenceEnabledSamplePropertiesEditionPartImpl.this, ReferencesViewsRepository.ReferenceEnabledSample.reference, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
					}
				}
				
		// End of user code

	}

	protected void createAbstractEnabledSample(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ReferencesViewsRepository.class);
		abstractEnabledSamplePropertiesEditionPart = (AbstractEnabledSamplePropertiesEditionPart)provider.getPropertiesEditionPart(ReferencesViewsRepository.AbstractEnabledSample.class, ReferencesViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)abstractEnabledSamplePropertiesEditionPart).createControls(container);
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
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getReferenceToAdd()
	 * 
	 */
	public List getReferenceToAdd() {
		return referenceEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getReferenceToRemove()
	 * 
	 */
	public List getReferenceToRemove() {
		return referenceEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getReferenceTable()
	 * 
	 */
	public List getReferenceTable() {
		return referenceEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#initReference(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initReference(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			referenceEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			referenceEditUtil = new EMFListEditUtil(current, feature);
		this.reference.setInput(referenceEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#updateReference(EObject newValue)
	 * 
	 */
	public void updateReference(EObject newValue) {
		if(referenceEditUtil != null){
			referenceEditUtil.reinit(newValue);
			reference.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#addFilterReference(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReference(ViewerFilter filter) {
		referenceFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#addBusinessFilterReference(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReference(ViewerFilter filter) {
		referenceBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#isContainedInReferenceTable(EObject element)
	 * 
	 */
	public boolean isContainedInReferenceTable(EObject element) {
		return referenceEditUtil.contains(element);
	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getAbstractEnabledSampleReferencedView()
	 * 
	 */
		public IPropertiesEditionPart getAbstractEnabledSampleReferencedView() {
			return (IPropertiesEditionPart) abstractEnabledSamplePropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#getEnabled()
	 * 
	 */
	public Boolean getEnabled() {
		return abstractEnabledSamplePropertiesEditionPart.getEnabled();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.ReferenceEnabledSamplePropertiesEditionPart#setEnabled(Boolean newValue)
	 * 
	 */
	public void setEnabled(Boolean newValue) {
		abstractEnabledSamplePropertiesEditionPart.setEnabled(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.AbstractEnabledSamplePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return abstractEnabledSamplePropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.references.parts.AbstractEnabledSamplePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		abstractEnabledSamplePropertiesEditionPart.setName(newValue);
	}








	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ReferencesMessages.ReferenceEnabledSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
