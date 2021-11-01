package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public class Tripulante extends Persona {
	
	private static final long serialVersionUID = 1L;
	private String estudiosRealizados;
	private TipoTripulante tipoTripulante;
	
	/**
	 * Constructor
	 * @param identificacion, nombre apellido, direccion, correoElectronico, fechaNacimiento, estudiosRealizados
	 */
	public Tripulante(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
			LocalDate fechaNacimiento, String estudiosRealizados, TipoTripulante tipoTripulante) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento);
		this.estudiosRealizados = estudiosRealizados;
		this.tipoTripulante = tipoTripulante;
	}
	
	public Tripulante() {}

	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getEstudiosRealizados() {
		return estudiosRealizados;
	}
	public void setEstudiosRealizados(String estudiosRealizados) {
		this.estudiosRealizados = estudiosRealizados;
	}
	public TipoTripulante getTipoTripulante() {
		return tipoTripulante;
	}
	public void setTipoTripulante(TipoTripulante tipoTripulante) {
		this.tipoTripulante = tipoTripulante;
	}
	//---------------------------------------------------------------------------------------------||

	@Override
	public String toString() {
		return super.toString() + "," + estudiosRealizados + "," + tipoTripulante;
	}
	
	
}
