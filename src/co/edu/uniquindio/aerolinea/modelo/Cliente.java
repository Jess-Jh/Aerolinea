package co.edu.uniquindio.aerolinea.modelo;

import java.time.LocalDate;

public class Cliente extends Persona implements Comparable<Cliente>{
	
	private static final long serialVersionUID = 1L;
	private String direccionResidencia;
	private String numTarjetaDebitoCredito;
	
	/**
	 * Constructor
	 * @param identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia
	 * @param numTarjetaDebitoCredito
	 */
	public Cliente(String identificacion, String nombre, String apellido, String direccion, String correoElectronico,
			LocalDate fechaNacimiento, String direccionResidencia, String numTarjetaDebitoCredito) {
		super(identificacion, nombre, apellido, direccion, correoElectronico, fechaNacimiento);
		this.direccionResidencia = direccionResidencia;
		this.numTarjetaDebitoCredito = numTarjetaDebitoCredito;
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
	//-------------------------------------------------------------------------------------------------------||

	@Override
	public int compareTo(Cliente cliente) {
		return this.getIdentificacion().compareToIgnoreCase(cliente.getIdentificacion());
	}
	
	
	
	

}
