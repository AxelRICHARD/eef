/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow.impl;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.CodeGenEcorePlugin;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.eef.codegen.flow.var.WorkflowVariable;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class GenerateEMFEditCode extends GenerateEMFCode {

	/**
	 * @param name
	 * @param genmodel
	 */
	public GenerateEMFEditCode(String name, Object genmodel) {
		super(name, genmodel);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFCode#invokeGeneration(org.eclipse.emf.codegen.ecore.genmodel.GenModel, org.eclipse.emf.codegen.ecore.generator.Generator)
	 */
	protected void invokeGeneration(GenModel genModel, Generator generator) {
		generator.generate(genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, CodeGenEcorePlugin.INSTANCE.getString("_UI_EditProject_name"), BasicMonitor.toMonitor(new NullProgressMonitor()));		
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFCode#genprojectVarName()
	 */
	protected String genprojectVarName() {
		return "GENERATE_EMF_EDIT_CODE_" + name + "_GEN_PROJECT";
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.impl.GenerateEMFCode#valuateGenerationProject()
	 */
	protected void valuateGenerationProject() {
		((WorkflowVariable)genProject()).setValue(extractProject(getGenModel().getEditProjectDirectory()));
	}

}
