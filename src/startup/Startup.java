package startup;

import com.bezirk.middleware.Bezirk;
import com.bezirk.middleware.java.proxy.BezirkMiddleware;
import com.google.inject.Guice;
import com.google.inject.Injector;

import persistence.BasicModule;

public class Startup {

	private static final String zirkName = "Main Application";

	public static void main(String[] args) {
		BezirkMiddleware.initialize();
        Bezirk bezirk = BezirkMiddleware.registerZirk(zirkName);
        
        BasicModule basicModule = new BasicModule(bezirk);
		Injector injector = Guice.createInjector(basicModule);
		
		
	}

}
