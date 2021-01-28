/**
 * 
 */
package handlers.warnings;

import java.io.IOException;
import java.util.ArrayList;

import handlers.ICatalog;
import helpers.PersistanceManager;

/**
 * @author G16
 *
 */
public class WarningCatalog implements ICatalog<Warning> {
	
	private ArrayList<Warning> warnings;
	private PersistanceManager<ArrayList<Warning>> persistenceManager;
	
	public WarningCatalog() {
		this.warnings = new ArrayList<Warning>();
		this.persistenceManager = new PersistanceManager<ArrayList<Warning>>("warnings.db");
		try {
			this.warnings = this.persistenceManager.read();
		} catch (IOException | ClassNotFoundException e) {}
	}

	public ArrayList<Warning> list() {
		return this.warnings;
	}

	public Warning add(Warning warning) {
		this.warnings.add(warning);
		try {
			this.persistenceManager.write(this.warnings);
		} catch (IOException e) {}
		return warning;
	}

	public Warning remove(Warning warning) {
		this.warnings.remove(warning);
		try {
			this.persistenceManager.write(this.warnings);
		} catch (IOException e) {}
		return warning;
	}

}
