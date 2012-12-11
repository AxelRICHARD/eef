/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.tests.nonreg.wizard;

/**
 * @author <a href="mailto:riadh.hajamor@obeo.fr">Riadh HAJ AMOR</a>
 */
public class WizardMBotUndoSetReferenceFlatRefTable extends org.eclipse.emf.eef.modelingBot.testcase.AbstractComposedModelingBotTestCase {

	public void testModelingBot() throws Exception {
		bot.runModelingBot("org.eclipse.emf.eef.tests.nonreg.junit/models/wizard_nonreg/undoSetReferenceFlatRefTable.modelingbot");
	}

}
