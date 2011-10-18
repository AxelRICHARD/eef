/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen;

import org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;

/**
 * The Acceleo Standalone compiler.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class EEFCodegenCompiler extends AbstractAcceleoCompiler {

	/**
	 * The entry point of the compilation.
	 * 
	 * @param args
	 *            The arguments used in the compilation: the source folder, the output folder, a boolean
	 *            indicating if we should use binary resource serialization and finally the dependencies of
	 *            the project.
	 */
	public static void main(String[] args) {
		if (args.length < 3) {
			throw new IllegalArgumentException("Missing parameters"); //$NON-NLS-1$
		}
		EEFCodegenCompiler acceleoCompiler = new EEFCodegenCompiler();
		acceleoCompiler.setSourceFolder(args[0]);
		acceleoCompiler.setOutputFolder(args[1]);
		acceleoCompiler.setBinaryResource(Boolean.valueOf(args[2]).booleanValue());
		if (args.length == 4 && args[3] != null && !"".equals(args[3])) { //$NON-NLS-1$
			acceleoCompiler.setDependencies(args[3]);
		}
		acceleoCompiler.doCompile(new BasicMonitor());
	}

	/**
	 * Launches the compilation of the mtl files in the generator.
	 * 
	 * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#doCompile(org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void doCompile(Monitor monitor) {
		super.doCompile(monitor);
	}

	/**
	 * Registers the packages of the metamodels used in the generator.
	 * 
	 * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#registerPackages()
	 */
	@Override
	protected void registerPackages() {
		super.registerPackages();
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.components.ComponentsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.components.ComponentsPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.mapping.MappingPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.mapping.MappingPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.mapping.navigation.NavigationPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.mapping.navigation.NavigationPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.mapping.filters.FiltersPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.mapping.filters.FiltersPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.ecore.EcorePackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.views.ViewsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.views.ViewsPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.toolkits.ToolkitsPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.toolkits.ToolkitsPackage.eINSTANCE);
		org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.put(
				org.eclipse.emf.eef.EEFGen.EEFGenPackage.eINSTANCE.getNsURI(),
				org.eclipse.emf.eef.EEFGen.EEFGenPackage.eINSTANCE);
	}

	/**
	 * Registers the resource factories.
	 * 
	 * @see org.eclipse.acceleo.parser.compiler.AbstractAcceleoCompiler#registerResourceFactories()
	 */
	@Override
	protected void registerResourceFactories() {
		super.registerResourceFactories();
		/*
		 * If you want to add other resource factories, for example if your metamodel uses a specific
		 * serialization:
		 * org.eclipse.emf.ecore.resource.Resource.Factory.Registry.getExtensionToFactoryMap().put
		 * (UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
		 */
	}
}
