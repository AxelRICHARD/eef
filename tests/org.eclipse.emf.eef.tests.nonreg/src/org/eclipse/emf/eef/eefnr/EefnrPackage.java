/**
 * <copyright>
 * </copyright>
 *
 * $Id: EefnrPackage.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.EefnrFactory
 * @model kind="package"
 * @generated
 */
public interface EefnrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eefnr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/nonreg/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eefnr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EefnrPackage eINSTANCE = org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.RootImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Samples</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SAMPLES = 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.AbstractSampleImpl <em>Abstract Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.AbstractSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAbstractSample()
	 * @generated
	 */
	int ABSTRACT_SAMPLE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_SAMPLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.TotalSampleImpl <em>Total Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.TotalSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTotalSample()
	 * @generated
	 */
	int TOTAL_SAMPLE = 2;

	/**
	 * The feature id for the '<em><b>Text Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TEXT_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TEXT_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Checkbox Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__CHECKBOX_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Checkbox Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__CHECKBOX_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Textarea Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TEXTAREA_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Textarea Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TEXTAREA_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Radio Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__RADIO_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Radio Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__RADIO_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Eobjectflatcomboviewer Required Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__EOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Eobjectflatcomboviewer Optional Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__EOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Referencestable Required Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__REFERENCESTABLE_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Referencestable Optional Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__REFERENCESTABLE_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Emfcomboviewer Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__EMFCOMBOVIEWER_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Emfcomboviewer Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__EMFCOMBOVIEWER_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Multivaluededitor Required Property</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__MULTIVALUEDEDITOR_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Multivaluededitor Optional Property</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__MULTIVALUEDEDITOR_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Tablecomposition Required Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TABLECOMPOSITION_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Tablecomposition Optional Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__TABLECOMPOSITION_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Advancedreferencestable Required Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDREFERENCESTABLE_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Advancedreferencestable Optional Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDREFERENCESTABLE_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Advancedeobjectflatcomboviewer Required Propery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERY = ABSTRACT_SAMPLE_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Advancedeobjectflatcomboviewer Optional Propery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERY = ABSTRACT_SAMPLE_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Advancedtablecomposition Required Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Advancedtablecomposition Optional Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 23;

	/**
	 * The number of structural features of the '<em>Total Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOTAL_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 24;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.TextSampleImpl <em>Text Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.TextSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTextSample()
	 * @generated
	 */
	int TEXT_SAMPLE = 3;

	/**
	 * The feature id for the '<em><b>Text Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Text Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.CheckboxSampleImpl <em>Checkbox Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.CheckboxSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getCheckboxSample()
	 * @generated
	 */
	int CHECKBOX_SAMPLE = 4;

	/**
	 * The feature id for the '<em><b>Checkbox Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_SAMPLE__CHECKBOX_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Checkbox Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_SAMPLE__CHECKBOX_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Checkbox Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKBOX_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.TextareaSampleImpl <em>Textarea Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.TextareaSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTextareaSample()
	 * @generated
	 */
	int TEXTAREA_SAMPLE = 5;

	/**
	 * The feature id for the '<em><b>Textarea Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTAREA_SAMPLE__TEXTAREA_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Textarea Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTAREA_SAMPLE__TEXTAREA_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Textarea Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTAREA_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.RadioSampleImpl <em>Radio Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.RadioSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getRadioSample()
	 * @generated
	 */
	int RADIO_SAMPLE = 6;

	/**
	 * The feature id for the '<em><b>Radio Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_SAMPLE__RADIO_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Radio Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_SAMPLE__RADIO_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Radio Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RADIO_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.EObjectFlatComboViewerSampleImpl <em>EObject Flat Combo Viewer Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.EObjectFlatComboViewerSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getEObjectFlatComboViewerSample()
	 * @generated
	 */
	int EOBJECT_FLAT_COMBO_VIEWER_SAMPLE = 7;

	/**
	 * The feature id for the '<em><b>Eobjectflatcomboviewer Required Propery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__EOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Eobjectflatcomboviewer Optional Propery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__EOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EObject Flat Combo Viewer Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EOBJECT_FLAT_COMBO_VIEWER_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.ReferencesTableSampleImpl <em>References Table Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.ReferencesTableSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getReferencesTableSample()
	 * @generated
	 */
	int REFERENCES_TABLE_SAMPLE = 8;

	/**
	 * The feature id for the '<em><b>Referencestable Required Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCES_TABLE_SAMPLE__REFERENCESTABLE_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referencestable Optional Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCES_TABLE_SAMPLE__REFERENCESTABLE_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>References Table Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCES_TABLE_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.EMFComboViewerSampleImpl <em>EMF Combo Viewer Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.EMFComboViewerSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getEMFComboViewerSample()
	 * @generated
	 */
	int EMF_COMBO_VIEWER_SAMPLE = 9;

	/**
	 * The feature id for the '<em><b>Emfcomboviewer Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_COMBO_VIEWER_SAMPLE__EMFCOMBOVIEWER_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Emfcomboviewer Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_COMBO_VIEWER_SAMPLE__EMFCOMBOVIEWER_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EMF Combo Viewer Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_COMBO_VIEWER_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.MultiValuedEditorSampleImpl <em>Multi Valued Editor Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.MultiValuedEditorSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getMultiValuedEditorSample()
	 * @generated
	 */
	int MULTI_VALUED_EDITOR_SAMPLE = 10;

	/**
	 * The feature id for the '<em><b>Multivaluededitor Required Property</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_EDITOR_SAMPLE__MULTIVALUEDEDITOR_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Multivaluededitor Optional Property</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_EDITOR_SAMPLE__MULTIVALUEDEDITOR_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Valued Editor Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_VALUED_EDITOR_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.TableCompositionEditorSampleImpl <em>Table Composition Editor Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.TableCompositionEditorSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTableCompositionEditorSample()
	 * @generated
	 */
	int TABLE_COMPOSITION_EDITOR_SAMPLE = 11;

	/**
	 * The feature id for the '<em><b>Tablecomposition Required Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_COMPOSITION_EDITOR_SAMPLE__TABLECOMPOSITION_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tablecomposition Optional Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_COMPOSITION_EDITOR_SAMPLE__TABLECOMPOSITION_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Table Composition Editor Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_COMPOSITION_EDITOR_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedReferencesTableSampleImpl <em>Advanced References Table Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedReferencesTableSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedReferencesTableSample()
	 * @generated
	 */
	int ADVANCED_REFERENCES_TABLE_SAMPLE = 12;

	/**
	 * The feature id for the '<em><b>Advancedreferencestable Required Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_REFERENCES_TABLE_SAMPLE__ADVANCEDREFERENCESTABLE_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Advancedreferencestable Optional Property</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_REFERENCES_TABLE_SAMPLE__ADVANCEDREFERENCESTABLE_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Advanced References Table Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_REFERENCES_TABLE_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl <em>Advanced EObject Flat Combo Viewer Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedEObjectFlatComboViewerSample()
	 * @generated
	 */
	int ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE = 13;

	/**
	 * The feature id for the '<em><b>Advancedeobjectflatcomboviewer Required Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Advancedeobjectflatcomboviewer Optional Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Advanced EObject Flat Combo Viewer Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl <em>Advanced Table Composition Editor Sample</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedTableCompositionEditorSample()
	 * @generated
	 */
	int ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE = 14;

	/**
	 * The feature id for the '<em><b>Advancedtablecomposition Required Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Advancedtablecomposition Optional Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY = ABSTRACT_SAMPLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Advanced Table Composition Editor Sample</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE_FEATURE_COUNT = ABSTRACT_SAMPLE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE <em>ENUM SAMPLE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getENUM_SAMPLE()
	 * @generated
	 */
	int ENUM_SAMPLE = 15;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.emf.eef.eefnr.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.Root#getSamples <em>Samples</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Samples</em>'.
	 * @see org.eclipse.emf.eef.eefnr.Root#getSamples()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_Samples();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.AbstractSample <em>Abstract Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AbstractSample
	 * @generated
	 */
	EClass getAbstractSample();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.TotalSample <em>Total Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Total Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample
	 * @generated
	 */
	EClass getTotalSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTextRequiredProperty <em>Text Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTextRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_TextRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTextOptionalProperty <em>Text Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTextOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_TextOptionalProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#isCheckboxRequiredProperty <em>Checkbox Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkbox Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#isCheckboxRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_CheckboxRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#isCheckboxOptionalProperty <em>Checkbox Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkbox Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#isCheckboxOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_CheckboxOptionalProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTextareaRequiredProperty <em>Textarea Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textarea Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTextareaRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_TextareaRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTextareaOptionalProperty <em>Textarea Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textarea Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTextareaOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_TextareaOptionalProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getRadioRequiredProperty <em>Radio Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radio Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getRadioRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_RadioRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getRadioOptionalProperty <em>Radio Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radio Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getRadioOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_RadioOptionalProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.TotalSample#getEobjectflatcomboviewerRequiredProperty <em>Eobjectflatcomboviewer Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eobjectflatcomboviewer Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getEobjectflatcomboviewerRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_EobjectflatcomboviewerRequiredProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.TotalSample#getEobjectflatcomboviewerOptionalProperty <em>Eobjectflatcomboviewer Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eobjectflatcomboviewer Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getEobjectflatcomboviewerOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_EobjectflatcomboviewerOptionalProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getReferencestableRequiredProperty <em>Referencestable Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencestable Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getReferencestableRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_ReferencestableRequiredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getReferencestableOptionalProperty <em>Referencestable Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencestable Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getReferencestableOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_ReferencestableOptionalProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getEmfcomboviewerRequiredProperty <em>Emfcomboviewer Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emfcomboviewer Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getEmfcomboviewerRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_EmfcomboviewerRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TotalSample#getEmfcomboviewerOptionalProperty <em>Emfcomboviewer Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emfcomboviewer Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getEmfcomboviewerOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_EmfcomboviewerOptionalProperty();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getMultivaluededitorRequiredProperty <em>Multivaluededitor Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multivaluededitor Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getMultivaluededitorRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_MultivaluededitorRequiredProperty();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getMultivaluededitorOptionalProperty <em>Multivaluededitor Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multivaluededitor Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getMultivaluededitorOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EAttribute getTotalSample_MultivaluededitorOptionalProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTablecompositionRequiredProperty <em>Tablecomposition Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tablecomposition Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTablecompositionRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_TablecompositionRequiredProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getTablecompositionOptionalProperty <em>Tablecomposition Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tablecomposition Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getTablecompositionOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_TablecompositionOptionalProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedreferencestableRequiredProperty <em>Advancedreferencestable Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Advancedreferencestable Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedreferencestableRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedreferencestableRequiredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedreferencestableOptionalProperty <em>Advancedreferencestable Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Advancedreferencestable Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedreferencestableOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedreferencestableOptionalProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedeobjectflatcomboviewerRequiredPropery <em>Advancedeobjectflatcomboviewer Required Propery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Advancedeobjectflatcomboviewer Required Propery</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedeobjectflatcomboviewerRequiredPropery()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedeobjectflatcomboviewerOptionalPropery <em>Advancedeobjectflatcomboviewer Optional Propery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Advancedeobjectflatcomboviewer Optional Propery</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedeobjectflatcomboviewerOptionalPropery()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedtablecompositionRequiredProperty <em>Advancedtablecomposition Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advancedtablecomposition Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedtablecompositionRequiredProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedtablecompositionRequiredProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedtablecompositionOptionalProperty <em>Advancedtablecomposition Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advancedtablecomposition Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TotalSample#getAdvancedtablecompositionOptionalProperty()
	 * @see #getTotalSample()
	 * @generated
	 */
	EReference getTotalSample_AdvancedtablecompositionOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.TextSample <em>Text Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextSample
	 * @generated
	 */
	EClass getTextSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TextSample#getTextRequiredProperty <em>Text Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextSample#getTextRequiredProperty()
	 * @see #getTextSample()
	 * @generated
	 */
	EAttribute getTextSample_TextRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TextSample#getTextOptionalProperty <em>Text Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextSample#getTextOptionalProperty()
	 * @see #getTextSample()
	 * @generated
	 */
	EAttribute getTextSample_TextOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.CheckboxSample <em>Checkbox Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checkbox Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.CheckboxSample
	 * @generated
	 */
	EClass getCheckboxSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxRequiredProperty <em>Checkbox Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkbox Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxRequiredProperty()
	 * @see #getCheckboxSample()
	 * @generated
	 */
	EAttribute getCheckboxSample_CheckboxRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxOptionalProperty <em>Checkbox Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checkbox Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxOptionalProperty()
	 * @see #getCheckboxSample()
	 * @generated
	 */
	EAttribute getCheckboxSample_CheckboxOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.TextareaSample <em>Textarea Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Textarea Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextareaSample
	 * @generated
	 */
	EClass getTextareaSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaRequiredProperty <em>Textarea Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textarea Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaRequiredProperty()
	 * @see #getTextareaSample()
	 * @generated
	 */
	EAttribute getTextareaSample_TextareaRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaOptionalProperty <em>Textarea Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Textarea Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaOptionalProperty()
	 * @see #getTextareaSample()
	 * @generated
	 */
	EAttribute getTextareaSample_TextareaOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.RadioSample <em>Radio Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Radio Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.RadioSample
	 * @generated
	 */
	EClass getRadioSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioRequiredProperty <em>Radio Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radio Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.RadioSample#getRadioRequiredProperty()
	 * @see #getRadioSample()
	 * @generated
	 */
	EAttribute getRadioSample_RadioRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioOptionalProperty <em>Radio Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Radio Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.RadioSample#getRadioOptionalProperty()
	 * @see #getRadioSample()
	 * @generated
	 */
	EAttribute getRadioSample_RadioOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample <em>EObject Flat Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EObject Flat Combo Viewer Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample
	 * @generated
	 */
	EClass getEObjectFlatComboViewerSample();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample#getEobjectflatcomboviewerRequiredPropery <em>Eobjectflatcomboviewer Required Propery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eobjectflatcomboviewer Required Propery</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample#getEobjectflatcomboviewerRequiredPropery()
	 * @see #getEObjectFlatComboViewerSample()
	 * @generated
	 */
	EReference getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample#getEobjectflatcomboviewerOptionalPropery <em>Eobjectflatcomboviewer Optional Propery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Eobjectflatcomboviewer Optional Propery</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample#getEobjectflatcomboviewerOptionalPropery()
	 * @see #getEObjectFlatComboViewerSample()
	 * @generated
	 */
	EReference getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample <em>References Table Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>References Table Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.ReferencesTableSample
	 * @generated
	 */
	EClass getReferencesTableSample();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableRequiredProperty <em>Referencestable Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencestable Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableRequiredProperty()
	 * @see #getReferencesTableSample()
	 * @generated
	 */
	EReference getReferencesTableSample_ReferencestableRequiredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableOptionalProperty <em>Referencestable Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referencestable Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableOptionalProperty()
	 * @see #getReferencesTableSample()
	 * @generated
	 */
	EReference getReferencesTableSample_ReferencestableOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.EMFComboViewerSample <em>EMF Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Combo Viewer Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EMFComboViewerSample
	 * @generated
	 */
	EClass getEMFComboViewerSample();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.EMFComboViewerSample#getEmfcomboviewerRequiredProperty <em>Emfcomboviewer Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emfcomboviewer Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EMFComboViewerSample#getEmfcomboviewerRequiredProperty()
	 * @see #getEMFComboViewerSample()
	 * @generated
	 */
	EAttribute getEMFComboViewerSample_EmfcomboviewerRequiredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.eefnr.EMFComboViewerSample#getEmfcomboviewerOptionalProperty <em>Emfcomboviewer Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Emfcomboviewer Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.EMFComboViewerSample#getEmfcomboviewerOptionalProperty()
	 * @see #getEMFComboViewerSample()
	 * @generated
	 */
	EAttribute getEMFComboViewerSample_EmfcomboviewerOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample <em>Multi Valued Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Valued Editor Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.MultiValuedEditorSample
	 * @generated
	 */
	EClass getMultiValuedEditorSample();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorRequiredProperty <em>Multivaluededitor Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multivaluededitor Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorRequiredProperty()
	 * @see #getMultiValuedEditorSample()
	 * @generated
	 */
	EAttribute getMultiValuedEditorSample_MultivaluededitorRequiredProperty();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorOptionalProperty <em>Multivaluededitor Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Multivaluededitor Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorOptionalProperty()
	 * @see #getMultiValuedEditorSample()
	 * @generated
	 */
	EAttribute getMultiValuedEditorSample_MultivaluededitorOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample <em>Table Composition Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table Composition Editor Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TableCompositionEditorSample
	 * @generated
	 */
	EClass getTableCompositionEditorSample();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionRequiredProperty <em>Tablecomposition Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tablecomposition Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionRequiredProperty()
	 * @see #getTableCompositionEditorSample()
	 * @generated
	 */
	EReference getTableCompositionEditorSample_TablecompositionRequiredProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionOptionalProperty <em>Tablecomposition Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tablecomposition Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionOptionalProperty()
	 * @see #getTableCompositionEditorSample()
	 * @generated
	 */
	EReference getTableCompositionEditorSample_TablecompositionOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample <em>Advanced References Table Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced References Table Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample
	 * @generated
	 */
	EClass getAdvancedReferencesTableSample();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableRequiredProperty <em>Advancedreferencestable Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Advancedreferencestable Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableRequiredProperty()
	 * @see #getAdvancedReferencesTableSample()
	 * @generated
	 */
	EReference getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableOptionalProperty <em>Advancedreferencestable Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Advancedreferencestable Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableOptionalProperty()
	 * @see #getAdvancedReferencesTableSample()
	 * @generated
	 */
	EReference getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample <em>Advanced EObject Flat Combo Viewer Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced EObject Flat Combo Viewer Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample
	 * @generated
	 */
	EClass getAdvancedEObjectFlatComboViewerSample();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample#getAdvancedeobjectflatcomboviewerRequiredProperty <em>Advancedeobjectflatcomboviewer Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Advancedeobjectflatcomboviewer Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample#getAdvancedeobjectflatcomboviewerRequiredProperty()
	 * @see #getAdvancedEObjectFlatComboViewerSample()
	 * @generated
	 */
	EReference getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerRequiredProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample#getAdvancedeobjectflatcomboviewerOptionalProperty <em>Advancedeobjectflatcomboviewer Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Advancedeobjectflatcomboviewer Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample#getAdvancedeobjectflatcomboviewerOptionalProperty()
	 * @see #getAdvancedEObjectFlatComboViewerSample()
	 * @generated
	 */
	EReference getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerOptionalProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample <em>Advanced Table Composition Editor Sample</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advanced Table Composition Editor Sample</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample
	 * @generated
	 */
	EClass getAdvancedTableCompositionEditorSample();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionRequiredProperty <em>Advancedtablecomposition Required Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advancedtablecomposition Required Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionRequiredProperty()
	 * @see #getAdvancedTableCompositionEditorSample()
	 * @generated
	 */
	EReference getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionOptionalProperty <em>Advancedtablecomposition Optional Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advancedtablecomposition Optional Property</em>'.
	 * @see org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionOptionalProperty()
	 * @see #getAdvancedTableCompositionEditorSample()
	 * @generated
	 */
	EReference getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE <em>ENUM SAMPLE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ENUM SAMPLE</em>'.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @generated
	 */
	EEnum getENUM_SAMPLE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EefnrFactory getEefnrFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.RootImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Samples</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SAMPLES = eINSTANCE.getRoot_Samples();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.AbstractSampleImpl <em>Abstract Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.AbstractSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAbstractSample()
		 * @generated
		 */
		EClass ABSTRACT_SAMPLE = eINSTANCE.getAbstractSample();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.TotalSampleImpl <em>Total Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.TotalSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTotalSample()
		 * @generated
		 */
		EClass TOTAL_SAMPLE = eINSTANCE.getTotalSample();

		/**
		 * The meta object literal for the '<em><b>Text Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__TEXT_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_TextRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Text Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__TEXT_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_TextOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Checkbox Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__CHECKBOX_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_CheckboxRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Checkbox Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__CHECKBOX_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_CheckboxOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Textarea Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__TEXTAREA_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_TextareaRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Textarea Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__TEXTAREA_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_TextareaOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Radio Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__RADIO_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_RadioRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Radio Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__RADIO_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_RadioOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Eobjectflatcomboviewer Required Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__EOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Eobjectflatcomboviewer Optional Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__EOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Referencestable Required Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__REFERENCESTABLE_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_ReferencestableRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Referencestable Optional Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__REFERENCESTABLE_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_ReferencestableOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Emfcomboviewer Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__EMFCOMBOVIEWER_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Emfcomboviewer Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__EMFCOMBOVIEWER_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Multivaluededitor Required Property</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__MULTIVALUEDEDITOR_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Multivaluededitor Optional Property</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOTAL_SAMPLE__MULTIVALUEDEDITOR_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Tablecomposition Required Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__TABLECOMPOSITION_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_TablecompositionRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Tablecomposition Optional Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__TABLECOMPOSITION_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_TablecompositionOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedreferencestable Required Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDREFERENCESTABLE_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedreferencestable Optional Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDREFERENCESTABLE_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedeobjectflatcomboviewer Required Propery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERY = eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery();

		/**
		 * The meta object literal for the '<em><b>Advancedeobjectflatcomboviewer Optional Propery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERY = eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery();

		/**
		 * The meta object literal for the '<em><b>Advancedtablecomposition Required Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY = eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedtablecomposition Optional Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOTAL_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY = eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.TextSampleImpl <em>Text Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.TextSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTextSample()
		 * @generated
		 */
		EClass TEXT_SAMPLE = eINSTANCE.getTextSample();

		/**
		 * The meta object literal for the '<em><b>Text Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY = eINSTANCE.getTextSample_TextRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Text Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY = eINSTANCE.getTextSample_TextOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.CheckboxSampleImpl <em>Checkbox Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.CheckboxSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getCheckboxSample()
		 * @generated
		 */
		EClass CHECKBOX_SAMPLE = eINSTANCE.getCheckboxSample();

		/**
		 * The meta object literal for the '<em><b>Checkbox Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKBOX_SAMPLE__CHECKBOX_REQUIRED_PROPERTY = eINSTANCE.getCheckboxSample_CheckboxRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Checkbox Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECKBOX_SAMPLE__CHECKBOX_OPTIONAL_PROPERTY = eINSTANCE.getCheckboxSample_CheckboxOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.TextareaSampleImpl <em>Textarea Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.TextareaSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTextareaSample()
		 * @generated
		 */
		EClass TEXTAREA_SAMPLE = eINSTANCE.getTextareaSample();

		/**
		 * The meta object literal for the '<em><b>Textarea Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTAREA_SAMPLE__TEXTAREA_REQUIRED_PROPERTY = eINSTANCE.getTextareaSample_TextareaRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Textarea Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTAREA_SAMPLE__TEXTAREA_OPTIONAL_PROPERTY = eINSTANCE.getTextareaSample_TextareaOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.RadioSampleImpl <em>Radio Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.RadioSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getRadioSample()
		 * @generated
		 */
		EClass RADIO_SAMPLE = eINSTANCE.getRadioSample();

		/**
		 * The meta object literal for the '<em><b>Radio Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RADIO_SAMPLE__RADIO_REQUIRED_PROPERTY = eINSTANCE.getRadioSample_RadioRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Radio Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RADIO_SAMPLE__RADIO_OPTIONAL_PROPERTY = eINSTANCE.getRadioSample_RadioOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.EObjectFlatComboViewerSampleImpl <em>EObject Flat Combo Viewer Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.EObjectFlatComboViewerSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getEObjectFlatComboViewerSample()
		 * @generated
		 */
		EClass EOBJECT_FLAT_COMBO_VIEWER_SAMPLE = eINSTANCE.getEObjectFlatComboViewerSample();

		/**
		 * The meta object literal for the '<em><b>Eobjectflatcomboviewer Required Propery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__EOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERY = eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery();

		/**
		 * The meta object literal for the '<em><b>Eobjectflatcomboviewer Optional Propery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__EOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERY = eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.ReferencesTableSampleImpl <em>References Table Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.ReferencesTableSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getReferencesTableSample()
		 * @generated
		 */
		EClass REFERENCES_TABLE_SAMPLE = eINSTANCE.getReferencesTableSample();

		/**
		 * The meta object literal for the '<em><b>Referencestable Required Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCES_TABLE_SAMPLE__REFERENCESTABLE_REQUIRED_PROPERTY = eINSTANCE.getReferencesTableSample_ReferencestableRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Referencestable Optional Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCES_TABLE_SAMPLE__REFERENCESTABLE_OPTIONAL_PROPERTY = eINSTANCE.getReferencesTableSample_ReferencestableOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.EMFComboViewerSampleImpl <em>EMF Combo Viewer Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.EMFComboViewerSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getEMFComboViewerSample()
		 * @generated
		 */
		EClass EMF_COMBO_VIEWER_SAMPLE = eINSTANCE.getEMFComboViewerSample();

		/**
		 * The meta object literal for the '<em><b>Emfcomboviewer Required Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_COMBO_VIEWER_SAMPLE__EMFCOMBOVIEWER_REQUIRED_PROPERTY = eINSTANCE.getEMFComboViewerSample_EmfcomboviewerRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Emfcomboviewer Optional Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_COMBO_VIEWER_SAMPLE__EMFCOMBOVIEWER_OPTIONAL_PROPERTY = eINSTANCE.getEMFComboViewerSample_EmfcomboviewerOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.MultiValuedEditorSampleImpl <em>Multi Valued Editor Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.MultiValuedEditorSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getMultiValuedEditorSample()
		 * @generated
		 */
		EClass MULTI_VALUED_EDITOR_SAMPLE = eINSTANCE.getMultiValuedEditorSample();

		/**
		 * The meta object literal for the '<em><b>Multivaluededitor Required Property</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_VALUED_EDITOR_SAMPLE__MULTIVALUEDEDITOR_REQUIRED_PROPERTY = eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Multivaluededitor Optional Property</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_VALUED_EDITOR_SAMPLE__MULTIVALUEDEDITOR_OPTIONAL_PROPERTY = eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.TableCompositionEditorSampleImpl <em>Table Composition Editor Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.TableCompositionEditorSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getTableCompositionEditorSample()
		 * @generated
		 */
		EClass TABLE_COMPOSITION_EDITOR_SAMPLE = eINSTANCE.getTableCompositionEditorSample();

		/**
		 * The meta object literal for the '<em><b>Tablecomposition Required Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_COMPOSITION_EDITOR_SAMPLE__TABLECOMPOSITION_REQUIRED_PROPERTY = eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Tablecomposition Optional Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE_COMPOSITION_EDITOR_SAMPLE__TABLECOMPOSITION_OPTIONAL_PROPERTY = eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedReferencesTableSampleImpl <em>Advanced References Table Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedReferencesTableSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedReferencesTableSample()
		 * @generated
		 */
		EClass ADVANCED_REFERENCES_TABLE_SAMPLE = eINSTANCE.getAdvancedReferencesTableSample();

		/**
		 * The meta object literal for the '<em><b>Advancedreferencestable Required Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_REFERENCES_TABLE_SAMPLE__ADVANCEDREFERENCESTABLE_REQUIRED_PROPERTY = eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedreferencestable Optional Property</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_REFERENCES_TABLE_SAMPLE__ADVANCEDREFERENCESTABLE_OPTIONAL_PROPERTY = eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl <em>Advanced EObject Flat Combo Viewer Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedEObjectFlatComboViewerSample()
		 * @generated
		 */
		EClass ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE = eINSTANCE.getAdvancedEObjectFlatComboViewerSample();

		/**
		 * The meta object literal for the '<em><b>Advancedeobjectflatcomboviewer Required Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY = eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedeobjectflatcomboviewer Optional Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY = eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl <em>Advanced Table Composition Editor Sample</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getAdvancedTableCompositionEditorSample()
		 * @generated
		 */
		EClass ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE = eINSTANCE.getAdvancedTableCompositionEditorSample();

		/**
		 * The meta object literal for the '<em><b>Advancedtablecomposition Required Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY = eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty();

		/**
		 * The meta object literal for the '<em><b>Advancedtablecomposition Optional Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY = eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE <em>ENUM SAMPLE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
		 * @see org.eclipse.emf.eef.eefnr.impl.EefnrPackageImpl#getENUM_SAMPLE()
		 * @generated
		 */
		EEnum ENUM_SAMPLE = eINSTANCE.getENUM_SAMPLE();

	}

} //EefnrPackage
