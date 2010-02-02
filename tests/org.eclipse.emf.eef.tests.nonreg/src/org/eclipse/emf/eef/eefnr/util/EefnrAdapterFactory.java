/**
 * <copyright>
 * </copyright>
 *
 * $Id: EefnrAdapterFactory.java,v 1.3 2010/02/02 10:03:51 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.eefnr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage
 * @generated
 */
public class EefnrAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EefnrPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EefnrAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EefnrPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EefnrSwitch<Adapter> modelSwitch =
		new EefnrSwitch<Adapter>() {
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter caseAbstractSample(AbstractSample object) {
				return createAbstractSampleAdapter();
			}
			@Override
			public Adapter caseTotalSample(TotalSample object) {
				return createTotalSampleAdapter();
			}
			@Override
			public Adapter caseTextSample(TextSample object) {
				return createTextSampleAdapter();
			}
			@Override
			public Adapter caseCheckboxSample(CheckboxSample object) {
				return createCheckboxSampleAdapter();
			}
			@Override
			public Adapter caseTextareaSample(TextareaSample object) {
				return createTextareaSampleAdapter();
			}
			@Override
			public Adapter caseRadioSample(RadioSample object) {
				return createRadioSampleAdapter();
			}
			@Override
			public Adapter caseEObjectFlatComboViewerSample(EObjectFlatComboViewerSample object) {
				return createEObjectFlatComboViewerSampleAdapter();
			}
			@Override
			public Adapter caseReferencesTableSample(ReferencesTableSample object) {
				return createReferencesTableSampleAdapter();
			}
			@Override
			public Adapter caseEMFComboViewerSample(EMFComboViewerSample object) {
				return createEMFComboViewerSampleAdapter();
			}
			@Override
			public Adapter caseMultiValuedEditorSample(MultiValuedEditorSample object) {
				return createMultiValuedEditorSampleAdapter();
			}
			@Override
			public Adapter caseTableCompositionEditorSample(TableCompositionEditorSample object) {
				return createTableCompositionEditorSampleAdapter();
			}
			@Override
			public Adapter caseAdvancedReferencesTableSample(AdvancedReferencesTableSample object) {
				return createAdvancedReferencesTableSampleAdapter();
			}
			@Override
			public Adapter caseAdvancedEObjectFlatComboViewerSample(AdvancedEObjectFlatComboViewerSample object) {
				return createAdvancedEObjectFlatComboViewerSampleAdapter();
			}
			@Override
			public Adapter caseAdvancedTableCompositionEditorSample(AdvancedTableCompositionEditorSample object) {
				return createAdvancedTableCompositionEditorSampleAdapter();
			}
			@Override
			public Adapter caseFlatReferencesTableSample(FlatReferencesTableSample object) {
				return createFlatReferencesTableSampleAdapter();
			}
			@Override
			public Adapter caseSample(Sample object) {
				return createSampleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.AbstractSample <em>Abstract Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.AbstractSample
	 * @generated
	 */
	public Adapter createAbstractSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.TotalSample <em>Total Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample
	 * @generated
	 */
	public Adapter createTotalSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.TextSample <em>Text Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.TextSample
	 * @generated
	 */
	public Adapter createTextSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.CheckboxSample <em>Checkbox Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.CheckboxSample
	 * @generated
	 */
	public Adapter createCheckboxSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.TextareaSample <em>Textarea Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.TextareaSample
	 * @generated
	 */
	public Adapter createTextareaSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.RadioSample <em>Radio Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.RadioSample
	 * @generated
	 */
	public Adapter createRadioSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample <em>EObject Flat Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample
	 * @generated
	 */
	public Adapter createEObjectFlatComboViewerSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample <em>References Table Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.ReferencesTableSample
	 * @generated
	 */
	public Adapter createReferencesTableSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.EMFComboViewerSample <em>EMF Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.EMFComboViewerSample
	 * @generated
	 */
	public Adapter createEMFComboViewerSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample <em>Multi Valued Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.MultiValuedEditorSample
	 * @generated
	 */
	public Adapter createMultiValuedEditorSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample <em>Table Composition Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.TableCompositionEditorSample
	 * @generated
	 */
	public Adapter createTableCompositionEditorSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample <em>Advanced References Table Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample
	 * @generated
	 */
	public Adapter createAdvancedReferencesTableSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample <em>Advanced EObject Flat Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample
	 * @generated
	 */
	public Adapter createAdvancedEObjectFlatComboViewerSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample <em>Advanced Table Composition Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample
	 * @generated
	 */
	public Adapter createAdvancedTableCompositionEditorSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.FlatReferencesTableSample <em>Flat References Table Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.FlatReferencesTableSample
	 * @generated
	 */
	public Adapter createFlatReferencesTableSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.eef.eefnr.Sample <em>Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.eef.eefnr.Sample
	 * @generated
	 */
	public Adapter createSampleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EefnrAdapterFactory
