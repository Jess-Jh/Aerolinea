package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public abstract class Ruta implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ciudadOrigen;
	private String ciudadDestino;
	private String duracion;
	private String horaSalida;
	
	/**
	 * Constructor
	 * @param ciudadOrigen, ciudadDestino, duracion, horaSalida
	 */
	public Ruta(String ciudadOrigen, String ciudadDestino, String duracion, String horaSalida) {
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.duracion = duracion;
		this.horaSalida = horaSalida;
	}

	public Ruta() {}
	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	//-------------------------------------------------------------------------------------------------------||


	
	
	
}
