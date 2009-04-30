/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import java.util.List;

import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EENumViewer extends AbstractListViewer {

	/**
	 * This viewer's list control.
	 */
	private Combo combo;

	private boolean updating = false;

	/**
	 * Creates a combo viewer on a newly-created combo control under the given parent. The viewer has no
	 * input, no content provider, a default label provider, no sorter, and no filters.
	 * 
	 * @param parent
	 *            the parent control
	 */
	public EENumViewer(Composite parent) {
		this(parent, SWT.READ_ONLY | SWT.BORDER);
	}

	/**
	 * Creates a combo viewer on a newly-created combo control under the given parent. The combo control is
	 * created using the given SWT style bits. The viewer has no input, no content provider, a default label
	 * provider, no sorter, and no filters.
	 * 
	 * @param parent
	 *            the parent control
	 * @param style
	 *            the SWT style bits
	 */
	public EENumViewer(Composite parent, int style) {
		this(new Combo(parent, style));
	}

	/**
	 * Creates a combo viewer on the given combo control. The viewer has no input, no content provider, a
	 * default label provider, no sorter, and no filters.
	 * 
	 * @param list
	 *            the combo control
	 */
	public EENumViewer(Combo list) {
		this.combo = list;
		hookControl(list);
	}

	protected void listAdd(String string, int index) {
		combo.add(string, index);
	}

	protected void listSetItem(int index, String string) {
		combo.setItem(index, string);
	}

	protected int[] listGetSelectionIndices() {
		return new int[] {combo.getSelectionIndex()};
	}

	protected int listGetItemCount() {
		return combo.getItemCount();
	}

	protected void listSetItems(String[] labels) {
		combo.setItems(labels);
	}

	protected void listRemoveAll() {
		combo.removeAll();
	}

	protected void listRemove(int index) {
		combo.remove(index);
	}

	/*
	 * (non-Javadoc) Method declared on Viewer.
	 */
	public Control getControl() {
		return combo;
	}

	/**
	 * Returns this list viewer's list control.
	 * 
	 * @return the list control
	 */
	public Combo getCombo() {
		return combo;
	}

	/*
	 * Do nothing -- combos only display the selected element, so there is no way we can ensure that the given
	 * element is visible without changing the selection. Method defined on StructuredViewer.
	 */
	public void reveal(Object element) {
		return;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.AbstractListViewer#listSelectAndShow(int[])
	 */
	protected void listSetSelection(int[] ixs) {
		for (int idx = 0; idx < ixs.length; idx++) {
			combo.select(ixs[idx]);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.AbstractListViewer#listDeselectAll()
	 */
	protected void listDeselectAll() {
		combo.deselectAll();
		combo.clearSelection();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.AbstractListViewer#listShowSelection()
	 */
	protected void listShowSelection() {
		// nothing
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.AbstractListViewer#setSelectionToWidget(java.util.List, boolean)
	 */
	protected void setSelectionToWidget(List in, boolean reveal) {
		if (in == null || in.size() == 0) { // clear selection
			listDeselectAll();
		} else {
			Object elem = in.get(0);
			// For Eclipse 3.2
			// if (!(elem instanceof AbstractEnumerator)) {
			// listDeselectAll();
			// } else {
			// AbstractEnumerator toSelect = (AbstractEnumerator)elem;
			int[] ixs = new int[1];
			ixs[0] = -1;
			String[] literals = getCombo().getItems();
			String literalToSelect = elem.toString();
			for (int i = 0; i < literals.length; i++) {
				String literal = literals[i];
				if (literal.equals(literalToSelect)) {
					ixs[0] = i;
					break;
				}
			}
			listSetSelection(ixs);
			if (reveal) {
				listShowSelection();
			}
			// }
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.StructuredViewer#updateSelection(org.eclipse.jface.viewers.ISelection)
	 */
	protected void updateSelection(ISelection selection) {
		if (!updating)
			super.updateSelection(selection);
	}

	public void modelUpdating(ISelection selection) {
		updating = true;
		setSelection(selection);
		updating = false;
	}

}
