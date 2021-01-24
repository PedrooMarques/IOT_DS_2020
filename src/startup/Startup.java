package startup;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;

public class Startup {

	private static final String zirkName = "Main Application";

	public static void main(String[] args) {
		BezirkMiddleware.initialize();
        Bezirk bezirk = BezirkMiddleware.registerZirk(zirkName);
	}

}
