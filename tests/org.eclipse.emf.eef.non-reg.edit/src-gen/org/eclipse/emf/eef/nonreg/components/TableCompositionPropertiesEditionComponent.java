/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.emf.eef.nonreg.EclipseSummit;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;



import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.NonregFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.parts.TableCompositionPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.Viewer;

import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

// End of user code

/**
 * 
 */
public class TableCompositionPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private EclipseSummit eclipseSummit;

	/**
	 * The Base part
	 */
	private TableCompositionPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public TableCompositionPropertiesEditionComponent(EObject eclipseSummit, String editing_mode) {
		if (eclipseSummit instanceof EclipseSummit) {
			this.eclipseSummit = (EclipseSummit)eclipseSummit;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eclipseSummit.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (basePart == null)
					TableCompositionPropertiesEditionComponent.this.dispose();
				else {
					if (msg.getFeature() != null && 
							(((EStructuralFeature)msg.getFeature()) == NonregPackage.eINSTANCE.getEclipseSummit_Sites()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == NonregPackage.eINSTANCE.getSite())) {
						basePart.updateTablecomposition(eclipseSummit);
					}
					if (msg.getFeature() != null && 
							(((EStructuralFeature)msg.getFeature()) == NonregPackage.eINSTANCE.getEclipseSummit_Sites()
							|| ((EStructuralFeature)msg.getFeature()).getEContainingClass() == NonregPackage.eINSTANCE.getSite())) {
						basePart.updateTablecompositionRO(eclipseSummit);
					}


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return NonregViewsRepository.TableComposition.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (eclipseSummit != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					basePart = (TableCompositionPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.TableComposition.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == NonregViewsRepository.TableComposition.class)
			this.basePart = (TableCompositionPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == NonregViewsRepository.TableComposition.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final EclipseSummit eclipseSummit = (EclipseSummit)elt;
			// init values
			basePart.initTablecomposition(eclipseSummit, null, NonregPackage.eINSTANCE.getEclipseSummit_Sites());
			basePart.initTablecompositionRO(eclipseSummit, null, NonregPackage.eINSTANCE.getEclipseSummit_Sites());
			
			// init filters
			basePart.addFilterToTablecomposition(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Site); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for tablecomposition
			
			// End of user code
			basePart.addFilterToTablecompositionRO(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Site); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for tablecompositionRO
			
			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

	}






	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (eclipseSummit != null) {
			List sitesToAddFromTablecomposition = basePart.getTablecompositionToAdd();
			for (Iterator iter = sitesToAddFromTablecomposition.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), iter.next()));
			Map sitesToRefreshFromTablecomposition = basePart.getTablecompositionToEdit();
			for (Iterator iter = sitesToRefreshFromTablecomposition.keySet().iterator(); iter.hasNext();) {
				
				
				
				Site nextElement = (Site) iter.next();
				Site sites = (Site) sitesToRefreshFromTablecomposition.get(nextElement);
				
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, sites.eGet(feature)));
					}
				}
				
				
				
			}
			List sitesToRemoveFromTablecomposition = basePart.getTablecompositionToRemove();
			for (Iterator iter = sitesToRemoveFromTablecomposition.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List sitesToMoveFromTablecomposition = basePart.getTablecompositionToMove();
			for (Iterator iter = sitesToMoveFromTablecomposition.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), moveElement.getElement(), moveElement.getIndex()));
			}
			List sitesToAddFromTablecompositionRO = basePart.getTablecompositionROToAdd();
			for (Iterator iter = sitesToAddFromTablecompositionRO.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), iter.next()));
			Map sitesToRefreshFromTablecompositionRO = basePart.getTablecompositionROToEdit();
			for (Iterator iter = sitesToRefreshFromTablecompositionRO.keySet().iterator(); iter.hasNext();) {
				
				
				
				Site nextElement = (Site) iter.next();
				Site sites = (Site) sitesToRefreshFromTablecompositionRO.get(nextElement);
				
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, sites.eGet(feature)));
					}
				}
				
				
				
			}
			List sitesToRemoveFromTablecompositionRO = basePart.getTablecompositionROToRemove();
			for (Iterator iter = sitesToRemoveFromTablecompositionRO.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List sitesToMoveFromTablecompositionRO = basePart.getTablecompositionROToMove();
			for (Iterator iter = sitesToMoveFromTablecompositionRO.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), moveElement.getElement(), moveElement.getIndex()));
			}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof EclipseSummit) {
			EclipseSummit eclipseSummitToUpdate = (EclipseSummit)source;
			eclipseSummitToUpdate.getSites().addAll(basePart.getTablecompositionToAdd());
			eclipseSummitToUpdate.getSites().addAll(basePart.getTablecompositionROToAdd());


			return eclipseSummitToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (NonregViewsRepository.TableComposition.tablecomposition == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Site oldValue = (Site)event.getOldValue();
					Site newValue = (Site)event.getNewValue();
					
					
					// TODO: Complete the eclipseSummit update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), event.getNewValue(), event.getNewIndex()));
			}
			if (NonregViewsRepository.TableComposition.tablecompositionRO == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Site oldValue = (Site)event.getOldValue();
					Site newValue = (Site)event.getNewValue();
					
					
					// TODO: Complete the eclipseSummit update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getEclipseSummit_Sites(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eclipseSummit, NonregPackage.eINSTANCE.getSite(), event.getNewValue(), event.getNewIndex()));
			}


			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {




			} else {




			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate =  Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(eclipseSummit);
		// Start of user code for custom validation check
		
		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			eclipseSummit.eAdapters().remove(semanticAdapter);
	}

}

