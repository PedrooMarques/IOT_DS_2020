/**
 * 
 */
package models;

import java.time.LocalDateTime;

/**
 * @author G16
 *
 */
public class Alerts {
	
	private TipoAlerta tipoAlerta;
	private int duracao;
	private String divisao;
	private Period periodo;
	private LocalDateTime timeStamp;

	/**
	 * @param tipoAlerta
	 * @param duracao
	 * @param divisao
	 * @param periodo
	 */
	public Alerts(TipoAlerta tipoAlerta, int duracao,
			String divisao, Period periodo, LocalDateTime timeStamp) {
		this.tipoAlerta = tipoAlerta;
		this.duracao = duracao;
		this.divisao = divisao;
		this.periodo = periodo;
		this.timeStamp = timeStamp;
	}
	
	/**
	 * @return the tipoAlerta
	 */
	public TipoAlerta getTipoAlerta() {
		return tipoAlerta;
	}

	/**
	 * @return the duracao
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * @return the divisao
	 */
	public String getDivisao() {
		return divisao;
	}

	/**
	 * @return the periodo
	 */
	public Period getPeriodo() {
		return periodo;
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	
}
