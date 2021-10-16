package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public class AuxiliarVuelo extends Tripulante {

	private static final long serialVersionUID = 1L;

	public AuxiliarVuelo(String identificacion, String nombre, String apellido, String direccion,
							String correoElectronico, LocalDate fechaNacimiento, String estudiosRealizados) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento, estudiosRealizados);
	}
	
	public AuxiliarVuelo() {}

}
