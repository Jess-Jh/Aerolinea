package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public class Piloto extends Tripulante {

	private static final long serialVersionUID = 1L;

	public Piloto(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
			LocalDate fechaNacimiento, String estudiosRealizados) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento, estudiosRealizados);
	}
	
	public Piloto() {}
	

}
