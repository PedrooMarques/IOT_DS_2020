/**
 * 
 */
package models;

/**
 * @author G16
 *
 */
public class MotionDetectionAlert extends Alerts {

	private String divisao;
	private Period periodo;
	
	/**
	 * @param tipoAlerta
	 */
	public MotionDetectionAlert(TipoAlerta tipoAlerta) {
		super(tipoAlerta);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the divisao
	 */
	public String getDivisao() {
		return divisao;
	}

	/**
	 * @param divisao the divisao to set
	 */
	public void setDivisao(String divisao) {
		this.divisao = divisao;
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

}
