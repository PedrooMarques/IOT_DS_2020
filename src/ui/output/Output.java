package ui.output;

public class Output {

	private static Output instance;

	private Output() {
		
	}

	public static Output getInstance() {
		if (instance == null) {
			instance = new Output();
		}
		return instance;
	}

	public void showMessage(String message) {
		Sytem.out.println(message);
	}

	public void showWarning(String message) {
		Sytem.err.println(message);
	}

	public void showAlert(String message) {
		Sytem.err.println(message);
	}

}
