package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public class CruceAeronavesRutas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombreAeronave;
	private String idAvion;
	private String ciudadOrigen;
	private String ciudadDestino;
	private String duracionViaje;
	private String horaSalida;
	
	public CruceAeronavesRutas(String nombreAeronave, String idAvion, String ciudadOrigen, String ciudadDestino,
			String duracionViaje, String horaSalida) {		
		this.nombreAeronave = nombreAeronave;
		this.idAvion = idAvion;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.duracionViaje = duracionViaje;
		this.horaSalida = horaSalida;
		
	}
	public CruceAeronavesRutas() {}
	
	public String getNombreAeronave() {
		return nombreAeronave;
	}
	public void setNombreAeronave(String nombreAeronave) {
		this.nombreAeronave = nombreAeronave;
	}
	public String getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(String idAvion) {
		this.idAvion = idAvion;
	}
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
	public String getDuracionViaje() {
		return duracionViaje;
	}
	public void setDuracionViaje(String duracionViaje) {
		this.duracionViaje = duracionViaje;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	

}
