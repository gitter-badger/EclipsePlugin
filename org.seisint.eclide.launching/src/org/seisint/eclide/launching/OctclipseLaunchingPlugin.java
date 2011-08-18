/*******************************************************************************
 * Copyright (c) 2007 Ryan Rusaw
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ryan Rusaw
 *******************************************************************************/
package org.seisint.eclide.launching;

import java.io.IOException;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class OctclipseLaunchingPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.seisint.eclide.launching"; //$NON-NLS-1$
	
	public static final String DEBUGGING_ENGINE = "debuggingEngine"; //$NON-NLS-1$

	// The shared instance
	private static OctclipseLaunchingPlugin plugin;
	
	/**
	 * The constructor
	 */
	public OctclipseLaunchingPlugin() {
		plugin = this;
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
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static OctclipseLaunchingPlugin getDefault() {
		return plugin;
	}

	public static String getUniqueIdentifier() {
		return PLUGIN_ID;
	}
	
	public String getConsoleProxy() throws IOException {
		return "scripts/ConsoleProxy.m";
	}
	
}
