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
package org.eclipse.emf.eef.runtime;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * The activator class controls the plug-in life cycle
 * @deprecated use {@link EEFRuntimePlugin}
 */
public class EMFPropertiesRuntime extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.emf.eef.runtime";  //$NON-NLS-1$

	// The shared instance
	private static EMFPropertiesRuntime plugin;

	// Shared adapterFactory
	private static AdapterFactory adapterFactory;

	public static final String ICONS_16x16 = "icons/16x16/";  //$NON-NLS-1$

	private static ImageRegistry registry = null;

	/**
	 * @return the Image associated to the key
	 */
	public Image getRegisteredImage(String key) {
		return getImageRegistry().get(key);
	}

	/**
	 * @param key
	 * @param path
	 */
	public void registerImage(String key, String path) {
		getImageRegistry().remove(key);
		getImageRegistry().put(key, ImageDescriptor.createFromFile(null, path));
	}

	public ImageRegistry getImageRegistry() {
		if (registry == null)
			registry = new ImageRegistry();
		return registry;
	}

	/**
	 * The constructor
	 */
	public EMFPropertiesRuntime() {
		plugin = this;
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		registry.dispose();
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static EMFPropertiesRuntime getDefault() {
		return plugin;
	}

	/**
	 * Returns the shared adapterFactory
	 * 
	 * @return the shared adapterFactory
	 */
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @param msg
	 *            a description message
	 * @param e
	 *            the error
	 */
	public void logError(String msg, Exception e) {
		getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, msg, e));
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory
	 * <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if (image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory
	 * <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @return the Image
	 */
	public static ImageDescriptor getImageDescriptor(String key) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
	}

}
