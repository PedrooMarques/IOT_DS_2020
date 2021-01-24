import ui.output.Output;

public aspect TextToSpeech {

	void around(): execution(void Output.showMessage()) {
		proceed();
		System.out.println("**Text-to-Speech");
	}

	void around(): execution(void Output.showAlert()) {
		proceed();
		System.out.println("**Text-to-Speech");
	}

}
