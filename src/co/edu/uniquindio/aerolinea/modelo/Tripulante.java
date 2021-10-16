package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public abstract class Tripulante extends Persona {
	
	private static final long serialVersionUID = 1L;
	private String estudiosRealizados;
	
	/**
	 * Constructor
	 * @param identificacion, nombre apellido, direccion, correoElectronico, fechaNacimiento, estudiosRealizados
	 */
	public Tripulante(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
			LocalDate fechaNacimiento, String estudiosRealizados) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento);
		this.estudiosRealizados = estudiosRealizados;
	}
	
	public Tripulante() {}

	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getEstudiosRealizados() {
		return estudiosRealizados;
	}
	public void setEstudiosRealizados(String estudiosRealizados) {
		this.estudiosRealizados = estudiosRealizados;
	}
	//---------------------------------------------------------------------------------------------||

}
