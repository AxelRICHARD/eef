/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.editors.pages;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AbstractEEFEditorPage extends FormPage implements EEFEditorPage {

	/**
	 * Form of this page
	 */
	protected ScrolledForm form;

	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected EditingDomain editingDomain;

	/**
	 * AdapterFactory to use
	 */
	protected AdapterFactory adapterFactory;

	/**
	 * Page input
	 */
	protected Object input;

	/**
	 * Page title
	 */
	private String pageTitle;

	/**
	 * Page image
	 */
	private Image pageImage;


	/**
	 * @param editor containing editor
	 * @param id page id
	 * @param name page name
	 */
	public AbstractEEFEditorPage(FormEditor editor, String id, String name) {
		super(editor, id, name);
	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}



	/**
	 * @return the adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}



	/**
	 * @param adapterFactory the adapterFactory to set
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
	}



	/**
	 * Defines the title of the page
	 * 
	 * @param title
	 *            the title to define
	 */
	public void setPageTitle(String title) {
		if (title != null) {
			this.pageTitle = title;
			if (formInitialized())
				refreshFormTitle();
		}
	}

	/**
	 * Sets the image to be rendered to the left of the title.
	 * @param image 
	 * the title image
	 */
	public void setImage(Image image) {
		if (image != null) {
			this.pageImage = image;
			if (formInitialized()) {
				refreshFormImage();
			}
		}
	}

	/**
	 * @return <code>true</code> if the form is initialized
	 */
	protected boolean formInitialized() {
		return form != null;
	}

	/**
	 * @param input the input of the page
	 */
	public void setInput(Object newEObject) {
		if (newEObject != input) {
			input = newEObject;
			refresh();
		}
	}

	public void refresh() {
		if (formInitialized()) {
			refreshFormContents();
			refreshFormTitle();
			refreshFormImage();
		}
	}

	/**
	 * Refresh the form title
	 */
	protected void refreshFormTitle() {
		if (pageTitle != null) {
			form.setText(pageTitle);
		} else {
			Object titleProvider = null;
			if (input instanceof ResourceSet) {
				titleProvider = ((ResourceSet)input).getResources().get(0);
			}
			else  {
				titleProvider =  input;
			}
			if (adapterFactory != null) {
				form.setText(new AdapterFactoryLabelProvider(adapterFactory).getText(titleProvider));
			}
		}
	}

	/**
	 * Refresh the image form
	 */
	protected void refreshFormImage() {
		if (pageImage != null) {
			form.setImage(pageImage);
		} else {
			Object imageProvider = null;
			if (input instanceof ResourceSet) {
				imageProvider = ((ResourceSet)input).getResources().get(0);
			}
			else  {
				imageProvider =  input;
			}
			if (adapterFactory != null) {
				form.setImage(new AdapterFactoryLabelProvider(adapterFactory).getImage(imageProvider));
			}
		}
	}

	/**
	 * Graphical refresh of the page
	 */
	protected abstract void refreshFormContents();
}