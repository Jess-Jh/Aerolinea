package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public class CarroEmbarque implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double peso;
	private Equipaje equipaje;
	private String numIdentificacion;
	private String numAvion;
	
	/**
	 * Constructor
	 * @param peso, equipaje, numIdentificacion, numAvion
	 */
	public CarroEmbarque(double peso, Equipaje equipaje, String numIdentificacion, String numAvion) {
		this.peso = peso;
		this.equipaje = equipaje;
		this.numIdentificacion = numIdentificacion;
		this.numAvion = numAvion;
	}
	
	public CarroEmbarque() {}

	//--------------------------------------------- Métodos Getters and Setters ---------------------------------------------------------------------------------->>
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Equipaje getEquipaje() {
		return equipaje;
	}
	public void setEquipaje(Equipaje equipaje) {
		this.equipaje = equipaje;
	}
	public String getNumIdentificacion() {
		return numIdentificacion;
	}
	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	public String getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(String numAvion) {
		this.numAvion = numAvion;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------||

	
	
	

}
