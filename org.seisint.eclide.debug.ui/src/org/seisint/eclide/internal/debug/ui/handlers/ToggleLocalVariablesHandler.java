package org.seisint.eclide.internal.debug.ui.handlers;


import org.eclipse.dltk.debug.ui.handlers.AbstractToggleLocalVariableHandler;
import org.eclipse.dltk.ui.PreferencesAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.seisint.eclide.debug.OctaveDebugConstants;
import org.seisint.eclide.debug.OctclipseDebugPlugin;

public class ToggleLocalVariablesHandler extends
		AbstractToggleLocalVariableHandler {

	protected String getModelId() {
		return OctaveDebugConstants.DEBUG_MODEL_ID;
	}

	protected IPreferenceStore getPreferenceStore() {
		return new PreferencesAdapter(OctclipseDebugPlugin.getDefault()
				.getPluginPreferences());
	}
}