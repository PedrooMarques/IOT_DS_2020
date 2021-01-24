import ui.output.Output;

public aspect TextToSpeech {

	void around(): execution(void Output.showMessage()) {
		proceed();
		System.out.println("**Text-to-Speech Message**");
	}

	void around(): execution(void Output.showWarning()) {
		proceed();
		System.out.println("**Text-to-Speech Warning**");
	}

	void around(): execution(void Output.showAlert()) {
		proceed();
		System.out.println("**Text-to-Speech Alert**");
	}

}
