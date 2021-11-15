package co.edu.uniquindio.aerolinea.modelo;

import java.util.ArrayList;

public class AirbusA330 extends Aeronave {

	private static final long serialVersionUID = 1L;
	ArrayList<String> capacidadAsientos;
	private double capacidadCarga;
	
	/**
	 * Contructor
	 * @param nombre, ruta, numIdentificacionAvion, capaciAsientos, capacidadCarga
	 */
	public AirbusA330(String nombre, double capacidadCarga, Ruta ruta, String numIdentificacionAvion) {
		super(nombre, capacidadCarga, ruta, numIdentificacionAvion);
		this.capacidadAsientos = new ArrayList<>(252);
		this.capacidadCarga = 52000.0;
	}
	
	public AirbusA330() {}

	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public ArrayList<String> getCapacidadAsientos() {
		return capacidadAsientos;
	}
	public void setCapacidadAsientos(ArrayList<String> capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}
	public double getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setCapacidadCarga(double capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	//-------------------------------------------------------------------------------------------------------||
	
}
