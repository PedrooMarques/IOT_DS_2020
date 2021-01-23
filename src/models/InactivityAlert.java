/**
 * 
 */
package models;

/**
 * @author G16
 *
 */
public class InactivityAlert extends Alerts {
	
	private int duracao;
	private Period periodo;
	
	//TODO timer

	/**
	 * @param tipoAlerta
	 */
	public InactivityAlert(TipoAlerta tipoAlerta) {
		super(tipoAlerta);
	}

	/**
	 * @return the periodo
	 */
	public Period getPeriodo() {
		return periodo;
	}

	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Period periodo) {
		this.periodo = periodo;
	}

	/**
	 * @return the duracao
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * @param duracao the duracao to set
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	

}
