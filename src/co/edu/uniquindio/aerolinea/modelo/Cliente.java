package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public class Cliente extends Persona implements Comparable<Cliente>{
	
	private static final long serialVersionUID = 1L;
	private String direccionResidencia;
	private String numTarjetaDebitoCredito;
	private Tiquete tiquete;
	
	/**
	 * Constructor
	 * @param identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia
	 * @param numTarjetaDebitoCredito
	 */
	public Cliente(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
			LocalDate fechaNacimiento, String direccionResidencia, String numTarjetaDebitoCredito, Tiquete tiquete) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento);
		this.direccionResidencia = direccionResidencia;
		this.numTarjetaDebitoCredito = numTarjetaDebitoCredito;
		this.tiquete = tiquete;
	}
	
	public Cliente() {}

	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getDireccionResidencia() {
		return direccionResidencia;
	}
	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}
	public String getNumTarjetaDebitoCredito() {
		return numTarjetaDebitoCredito;
	}
	public void setNumTarjetaDebitoCredito(String numTarjetaDebitoCredito) {
		this.numTarjetaDebitoCredito = numTarjetaDebitoCredito;
	}
	public Tiquete getTiquete() {
		return tiquete;
	}
	public void setTiquete(Tiquete tiquete) {
		this.tiquete = tiquete;
	}	
	//-------------------------------------------------------------------------------------------------------||


	@Override
	public int compareTo(Cliente cliente) {
		return this.getIdentificacion().compareToIgnoreCase(cliente.getIdentificacion());
	}
	
	
	
	

}
