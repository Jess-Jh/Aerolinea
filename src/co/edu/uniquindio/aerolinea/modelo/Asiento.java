package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public class Asiento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idCliente;
	private String posicion;
	private EstadoAsiento estadoAsiento;
	
	/**
	 * Constructor
	 * @param idCliente, posicion, estadoAsiento
	 */
	public Asiento(String idCliente, String posicion, EstadoAsiento estadoAsiento) {
		this.idCliente = idCliente;
		this.posicion = posicion;
		this.estadoAsiento = estadoAsiento;
	}

	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public EstadoAsiento getEstadoAsiento() {
		return estadoAsiento;
	}
	public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
		this.estadoAsiento = estadoAsiento;
	}
	//-------------------------------------------------------------------------------------------------------||

	
	

	
	
}
