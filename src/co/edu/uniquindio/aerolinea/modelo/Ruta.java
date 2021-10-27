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
	public Ruta(String ciudadOrigen, String ciudadDestino) {
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;

		duracionYHoraSalidaViajes();
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

	/**
	 * Duración y hora de salida de cada viaje dependiendo el destino
	 */
	protected void duracionYHoraSalidaViajes() {
		if(ciudadDestino.equalsIgnoreCase("Monterrey")) {
			duracion = "2 horas 45 minutos";
			horaSalida = "6:00 am";
		}
		if(ciudadDestino.equalsIgnoreCase("Cancún")) {
			duracion = "3 horas 12 minutos";
			horaSalida = "8:00 am";
		}
		if(ciudadDestino.equalsIgnoreCase("Buenos Aires")) {
			duracion = "9 horas 5 minutos";
			horaSalida = "11:30 pm";
		}
		if(ciudadDestino.equalsIgnoreCase("Los Ángeles")) {
			duracion = "3 horas 25 minutos";
			horaSalida = "9:45 am";
		}
		if(ciudadDestino.equalsIgnoreCase("Bogotá")) {
			duracion = "3 horas 45 minutos";
			horaSalida = "1:30 pm";
		}
		if(ciudadDestino.equalsIgnoreCase("Panamá")) {
			duracion = "2 horas 55 minutos";
			horaSalida = "2:45 pm";
		}
	}
	
	
	
}
