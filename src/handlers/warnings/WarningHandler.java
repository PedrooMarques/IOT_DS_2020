package handlers.warnings;

import ui.output.Output;

public class WarningHandler {

	private static final WarningHandler INSTANCE = new WarningHandler();
	private WarningCatalog warnings;

	private WarningHandler() {
		this.warnings = new WarningCatalog();
	}

	public static WarningHandler getInstance() {
		return INSTANCE;
	}

	public WarningCatalog getWarnings() {
		return this.warnings;
	}

	public void warn(String message) {
		Output.getInstance().showWarning(message);
	}

}
