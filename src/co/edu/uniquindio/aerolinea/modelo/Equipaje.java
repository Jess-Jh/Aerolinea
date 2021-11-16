package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public class Equipaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private String identificacionCliente;
	private double peso;
	private double dimension;
	private String numAvion;
	
	/**
	 * Constructor
	 * @param identificacionCliente, cantidad, peso, dimension, numAvion
	 */
	public Equipaje(String identificacionCliente, double peso, double dimension, String numAvion) {
		this.identificacionCliente = identificacionCliente;
		this.peso = peso;
		this.dimension = dimension;
		this.numAvion = numAvion;
	}
	
	public Equipaje() {}

	//--------------------------------------------- Métodos Getters and Setters ---------------------------------------------------------------------------------->>
	public String getIdentificacionCliente() {
		return identificacionCliente;
	}
	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getDimension() {
		return dimension;
	}
	public void setDimension(double dimension) {
		this.dimension = dimension;
	}
	public String getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(String numAvion) {
		this.numAvion = numAvion;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------||

	
	
	
	
}
