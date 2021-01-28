package ui.output;

public class Output {

	private static final Output INSTANCE = new Output();

	private Output() {

	}

	public static Output getInstance() {
		return INSTANCE;
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public void showWarning(String message) {
		System.err.println(message);
	}

	public void showAlert(String message) {
		System.err.println(message);
	}

}
