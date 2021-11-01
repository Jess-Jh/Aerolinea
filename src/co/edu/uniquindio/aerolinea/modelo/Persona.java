package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String identificacion;
	private String nombre;
	private String apellido;
	private String direccion;
	private String correoElectronico;
	private LocalDate fechaNacimiento;
	
	/**
	 * Constructor
	 * @param identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento
	 */
	public Persona(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
					LocalDate fechaNacimiento) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona() {}
	
	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//-------------------------------------------------------------------------------------------------------||

	@Override
	public String toString() {
		return identificacion + "," + nombre + "," + apellido + "," + direccion + "," + correoElectronico + "," + fechaNacimiento;
	}

	
	
	
	
	
	

}
