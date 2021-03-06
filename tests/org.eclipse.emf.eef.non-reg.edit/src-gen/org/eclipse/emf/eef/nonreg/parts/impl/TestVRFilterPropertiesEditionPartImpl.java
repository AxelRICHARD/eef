/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.TestFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.TestVRFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


// End of user code

/**
 * 
 */
public class TestVRFilterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TestVRFilterPropertiesEditionPart {


	private TestFilterPropertiesEditionPart testFilterPropertiesEditionPart;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TestVRFilterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createTestFilter(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createTestFilter(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
		testFilterPropertiesEditionPart = (TestFilterPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.TestFilter.class, NonregViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)testFilterPropertiesEditionPart).createControls(container);
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
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestFilterReferencedView()
	 */
		public IPropertiesEditionPart getTestFilterReferencedView() {
			return (IPropertiesEditionPart) testFilterPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestEOFCV()
	 */
	public EObject getTestEOFCV() {
		return testFilterPropertiesEditionPart.getTestEOFCV();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestEOFCV(ResourceSet allResources, EObject current)
	 */
	public void initTestEOFCV(ResourceSet allResources, EObject current) {
		testFilterPropertiesEditionPart.initTestEOFCV(allResources, current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestEOFCV(EObject newValue)
	 */
	public void setTestEOFCV(EObject newValue) {
		testFilterPropertiesEditionPart.setTestEOFCV(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestEOFCVButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTestEOFCVButtonMode(ButtonsModeEnum newValue) {
		testFilterPropertiesEditionPart.setTestEOFCVButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestEOFCV(ViewerFilter filter)
	 */
	public void addFilterToTestEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestEOFCV(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestEOFCV(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestEOFCV(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTToAdd()
	 */
	public List getTestARTToAdd() {
		return testFilterPropertiesEditionPart.getTestARTToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTToRemove()
	 */
	public List getTestARTToRemove() {
		return testFilterPropertiesEditionPart.getTestARTToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestARTTable()
	 */
	public List getTestARTTable() {
		return testFilterPropertiesEditionPart.getTestARTTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestART(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTestART(EObject current, EReference containingFeature, EReference feature) {
		testFilterPropertiesEditionPart.initTestART(current, containingFeature, feature);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#updateTestART(EObject newValue)
	 */
	public void updateTestART(EObject newValue) {
		testFilterPropertiesEditionPart.updateTestART(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestART(ViewerFilter filter)
	 */
	public void addFilterToTestART(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestART(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestART(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestART(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestART(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#isContainedInTestARTTable(EObject element)
	 */
	public boolean isContainedInTestARTTable(EObject element) {
		return testFilterPropertiesEditionPart.isContainedInTestARTTable(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestAEOFCV()
	 */
	public EObject getTestAEOFCV() {
		return testFilterPropertiesEditionPart.getTestAEOFCV();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestAEOFCV(ResourceSet allResources, EObject current)
	 */
	public void initTestAEOFCV(ResourceSet allResources, EObject current) {
		testFilterPropertiesEditionPart.initTestAEOFCV(allResources, current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestAEOFCV(EObject newValue)
	 */
	public void setTestAEOFCV(EObject newValue) {
		testFilterPropertiesEditionPart.setTestAEOFCV(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#setTestAEOFCVButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTestAEOFCVButtonMode(ButtonsModeEnum newValue) {
		testFilterPropertiesEditionPart.setTestAEOFCVButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestAEOFCV(ViewerFilter filter)
	 */
	public void addFilterToTestAEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestAEOFCV(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestAEOFCV(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestAEOFCV(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestAEOFCV(filter);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTToAdd()
	 */
	public List getTestRTToAdd() {
		return testFilterPropertiesEditionPart.getTestRTToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTToRemove()
	 */
	public List getTestRTToRemove() {
		return testFilterPropertiesEditionPart.getTestRTToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#getTestRTTable()
	 */
	public List getTestRTTable() {
		return testFilterPropertiesEditionPart.getTestRTTable();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#initTestRT(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initTestRT(EObject current, EReference containingFeature, EReference feature) {
		testFilterPropertiesEditionPart.initTestRT(current, containingFeature, feature);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#updateTestRT(EObject newValue)
	 */
	public void updateTestRT(EObject newValue) {
		testFilterPropertiesEditionPart.updateTestRT(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addFilterTestRT(ViewerFilter filter)
	 */
	public void addFilterToTestRT(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addFilterToTestRT(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#addBusinessFilterTestRT(ViewerFilter filter)
	 */
	public void addBusinessFilterToTestRT(ViewerFilter filter) {
		testFilterPropertiesEditionPart.addBusinessFilterToTestRT(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.subPackageNonRegForFilters.parts.TestVRFilterPropertiesEditionPart#isContainedInTestRTTable(EObject element)
	 */
	public boolean isContainedInTestRTTable(EObject element) {
		return testFilterPropertiesEditionPart.isContainedInTestRTTable(element);
	}











	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return NonregMessages.TestVRFilter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
