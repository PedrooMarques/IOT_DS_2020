import i18n.I18N;

public aspect English {
	before() : execution(* *.main(..)) {
		I18N.setInstance(new I18N("en","US"));
		System.err.println("This product speaks english.");
	}
}