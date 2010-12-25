/**
 * 
 */
package org.eclipse.emf.eef.codegen.extended.initializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.eef.EEFGen.EEFGenFactory;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;
import org.eclipse.emf.eef.codegen.core.initializer.AbstractPropertiesInitializer;
import org.eclipse.emf.eef.codegen.core.util.EMFHelper;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.views.ViewsRepository;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFEditorModelInitializer extends AbstractPropertiesInitializer {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.core.initializer.IPropertiesInitializer#initialize(org.eclipse.emf.common.util.URI, org.eclipse.core.resources.IContainer)
	 */
	public void initialize(URI modelURI, IContainer targetFolder) throws IOException, CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		registerResourceFactories(resourceSet);
		registerPackages(resourceSet);
		EObject model = EMFHelper.load(modelURI, resourceSet);

		if (!targetFolder.exists()) {
			if (targetFolder instanceof IFolder)
				((IFolder)targetFolder).create(true, true, new NullProgressMonitor());
			else
				return;
		}
		EEFPagesTransformer pagesTransformer = new EEFPagesTransformer();
		TreeIterator<EObject> allContents = model.eAllContents();
		Map<ViewsRepository, String> repositories = new HashMap<ViewsRepository, String>();
		List<PropertiesEditionContext> contexts = new ArrayList<PropertiesEditionContext>();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof GenPackage) {
				GenPackage genPack = (GenPackage)next;
				if (genPack.eContents().size() >= 1) {
					ViewsRepository repository = pagesTransformer.genPackage2ViewsRepository(genPack);
					String completePackage = genPack.getBasePackage();
					if (completePackage != null && completePackage.length() > 0) {
						completePackage += "." + ecoreStringHierarchy(genPack);
					} else {
						completePackage = ecoreStringHierarchy(genPack);
					}
					repositories.put(repository, completePackage);
					EEFEditorContributionTransformer contributionTransformer = new EEFEditorContributionTransformer(pagesTransformer.getWorkingResolvTemp());
					PropertiesEditionContext context = contributionTransformer.genPackage2Context(genPack);
					contexts.add(context);
				}
			}
		}

		String contributionsFilePath = targetFolder.getFullPath() + "/" + model.eResource().getURI().trimFileExtension().lastSegment() + "-editor.components";
		URI contributionsModelUri = URI.createPlatformResourceURI(contributionsFilePath, false);
		Resource contributionsResource = model.eResource().getResourceSet().createResource(contributionsModelUri);
		for (PropertiesEditionContext context : contexts)
			contributionsResource.getContents().add(context);
		for (ViewsRepository repository : repositories.keySet())
			contributionsResource.getContents().add(repository);
		EEFGenModel eefGenModel = createEEFGenModel((GenModel) model, repositories, contexts, targetFolder);
		contributionsResource.save(Collections.EMPTY_MAP);
		String eefgenFilePath = targetFolder.getFullPath() + "/" + model.eResource().getURI().trimFileExtension().lastSegment() + "-editor.eefgen";
		URI eefgenModelUri = URI.createPlatformResourceURI(eefgenFilePath, false);
		Resource eefgenResource = model.eResource().getResourceSet().createResource(eefgenModelUri);
		eefgenResource.getContents().add(eefGenModel);
		eefgenResource.save(Collections.EMPTY_MAP);
		return;

	}
	
	public String ecoreStringHierarchy(GenPackage genPack) {
		String result = "";
		List<EPackage> ecorePackageHierarchy = ecorePackageHierarchy(genPack);
		for (int i = ecorePackageHierarchy.size() - 1; i >= 0; i--) {
			EPackage next = ecorePackageHierarchy.get(i);
			result += next.getName();
			if (i > 0)
				result += ".";
		}
		return genPack.getEcorePackage().getName();
	}

	public List<EPackage> ecorePackageHierarchy(GenPackage genPack) {
		List<EPackage> hierarchy = new ArrayList<EPackage>();
		EObject current = genPack.getEcorePackage();
		while (current instanceof EPackage) {
			hierarchy.add((EPackage) current);
			current = current.eContainer();
		}
		return hierarchy;
	}

	private EEFGenModel createEEFGenModel(GenModel inputGenmodel, Map<ViewsRepository, String> repositories, List<PropertiesEditionContext> contexts, IContainer targetFolder) {
		EEFGenModel eefGenModel = EEFGenFactory.eINSTANCE.createEEFGenModel();
		eefGenModel.setGenDirectory(findGenDirectory(inputGenmodel));
		for (PropertiesEditionContext context : contexts)
			eefGenModel.getEditionContexts().add(createGenEditionContext(context));
		String contextPackage = "";
		if (contexts.size() > 0) {
			String findBasePackage = findBasePackage(contexts.get(0).getModel());
			if (findBasePackage != null && !findBasePackage.equals("")) {
				contextPackage = findBasePackage + ".";
			}
			contextPackage = contextPackage + contexts.get(0).getModel().getEcorePackage().getName().toLowerCase();
		}
		for (ViewsRepository repository : repositories.keySet())
			eefGenModel.getViewsRepositories().add(createGenViewsRepository(repository, repositories.get(repository)));
		return eefGenModel;
	}

	private GenEditionContext createGenEditionContext(PropertiesEditionContext context) {
		GenEditionContext genEditionContext = EEFGenFactory.eINSTANCE.createGenEditionContext();
		genEditionContext.setPropertiesEditionContext(context);
		if (context.getModel() != null)
			genEditionContext.setBasePackage(findBasePackage(context.getModel()));
		genEditionContext.setDescriptorsGenericPropertiesViews(true);
		return genEditionContext;
	}

	private GenViewsRepository createGenViewsRepository(ViewsRepository repository, String contextPackage) {
		GenViewsRepository genViewsRepository = EEFGenFactory.eINSTANCE.createGenViewsRepository();
		genViewsRepository.setViewsRepository(repository);
		genViewsRepository.setBasePackage(contextPackage);
		genViewsRepository.setSwtViews(true);
		genViewsRepository.setFormViews(true);
		return genViewsRepository;
	}

	private String findBasePackage(GenPackage genPackage) {
		if (genPackage.getBasePackage() != null)
			return genPackage.getBasePackage();
		return "";
	}

	private String findGenDirectory(GenModel genmodel) {
		return genmodel.getEditorDirectory();
	}

}
