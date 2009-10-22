/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
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
 * 
 */
public class AccreditationsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AccreditationsPropertiesEditionPart {

	protected EMFListEditUtil accreditationsEditUtil;
	protected ReferencesTable<? extends EObject> accreditations;
	protected List<ViewerFilter> accreditationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> accreditationsFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public AccreditationsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createListOfAccreditationsGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createListOfAccreditationsGroup(Composite parent) {
		Group listOfAccreditationsGroup = new Group(parent, SWT.NONE);
		listOfAccreditationsGroup.setText(NonregMessages.AccreditationsPropertiesEditionPart_ListOfAccreditationsGroupLabel);
		GridData listOfAccreditationsGroupData = new GridData(GridData.FILL_HORIZONTAL);
		listOfAccreditationsGroupData.horizontalSpan = 3;
		listOfAccreditationsGroup.setLayoutData(listOfAccreditationsGroupData);
		GridLayout listOfAccreditationsGroupLayout = new GridLayout();
		listOfAccreditationsGroupLayout.numColumns = 3;
		listOfAccreditationsGroup.setLayout(listOfAccreditationsGroupLayout);
		createAccreditationsAdvancedReferencesTable(listOfAccreditationsGroup);
	}
	protected void createAccreditationsAdvancedReferencesTable(Composite parent) {
		this.accreditations = new ReferencesTable<Site>(NonregMessages.AccreditationsPropertiesEditionPart_AccreditationsLabel, new ReferencesTableListener<Site>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Site> dialog = new TabElementTreeSelectionDialog<Site>(resourceSet, accreditationsFilters, accreditationsBusinessFilters,
				"Site", NonregPackage.eINSTANCE.getSite(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!accreditationsEditUtil.getVirtualList().contains(elem))
								accreditationsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AccreditationsPropertiesEditionPartImpl.this, NonregViewsRepository.Accreditations.accreditations,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						accreditations.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(Site element) { editAccreditations(element); }
			public void handleMove(Site element, int oldIndex, int newIndex) { moveAccreditations(element, oldIndex, newIndex); }
			public void handleRemove(Site element) { removeFromAccreditations(element); }
			public void navigateTo(Site element) { }
		});
		this.accreditations.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.Accreditations.accreditations, NonregViewsRepository.SWT_KIND));
		this.accreditations.createControls(parent);
		GridData accreditationsData = new GridData(GridData.FILL_HORIZONTAL);
		accreditationsData.horizontalSpan = 3;
		this.accreditations.setLayoutData(accreditationsData);
		this.accreditations.disableMove();
	}

	/**
	 * 
	 */
	protected void moveAccreditations(Site element, int oldIndex, int newIndex) {
		EObject editedElement = accreditationsEditUtil.foundCorrespondingEObject(element);
		accreditationsEditUtil.moveElement(element, oldIndex, newIndex);
		accreditations.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AccreditationsPropertiesEditionPartImpl.this, NonregViewsRepository.Accreditations.accreditations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromAccreditations(Site element) {

		// Start of user code removeFromAccreditations() method body
		EObject editedElement = accreditationsEditUtil.foundCorrespondingEObject(element);
		accreditationsEditUtil.removeElement(element);
		accreditations.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AccreditationsPropertiesEditionPartImpl.this, NonregViewsRepository.Accreditations.accreditations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	protected void editAccreditations(Site element) {

		// Start of user code editAccreditations() method body
		EObject editedElement = accreditationsEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				accreditationsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				accreditations.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AccreditationsPropertiesEditionPartImpl.this, NonregViewsRepository.Accreditations.accreditations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#getAccreditationsToAdd()
	 */
	public List getAccreditationsToAdd() {
		return accreditationsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#getAccreditationsToRemove()
	 */
	public List getAccreditationsToRemove() {
		return accreditationsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#getAccreditationsTable()
	 */
	public List getAccreditationsTable() {
		return accreditationsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#initAccreditations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAccreditations(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			accreditationsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			accreditationsEditUtil = new EMFListEditUtil(current, feature);
		this.accreditations.setInput(accreditationsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#updateAccreditations(EObject newValue)
	 */
	public void updateAccreditations(EObject newValue) {
		if(accreditationsEditUtil != null){
			accreditationsEditUtil.reinit(newValue);
			accreditations.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#addFilterAccreditations(ViewerFilter filter)
	 */
	public void addFilterToAccreditations(ViewerFilter filter) {
		accreditationsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#addBusinessFilterAccreditations(ViewerFilter filter)
	 */
	public void addBusinessFilterToAccreditations(ViewerFilter filter) {
		accreditationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.AccreditationsPropertiesEditionPart#isContainedInAccreditationsTable(EObject element)
	 */
	public boolean isContainedInAccreditationsTable(EObject element) {
		return accreditationsEditUtil.contains(element);
	}

	public void setMessageForAccreditations(String msg, int msgLevel) {

	}

	public void unsetMessageForAccreditations() {

	}








	// Start of user code additional methods
	
	// End of user code

}
