/**
 * 
 */
package models;
/**
 * @author G16
 *
 */
public abstract class Alerts {
	
	private TipoAlerta tipoAlerta;
	
	/**
	 * @param tipoAlerta
	 */
	public Alerts(TipoAlerta tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	/**
	 * @return the tipoAlerta
	 */
	public TipoAlerta getTipoAlerta() {
		return tipoAlerta;
	}	
	
}
