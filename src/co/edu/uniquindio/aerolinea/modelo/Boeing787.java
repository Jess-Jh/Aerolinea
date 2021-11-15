package co.edu.uniquindio.aerolinea.modelo;

import java.util.ArrayList;

public class Boeing787 extends Aeronave {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> capacidadAsientos;
	private double capacidadCarga;
	
	/**
	 * Constructor
	 * @param nombre, ruta, numIdentificacionAvion, capacidadAsientos, capacidadCarga
	 */
	public Boeing787(String nombre, double capacidadCarga, Ruta ruta, String numIdentificacionAvion) {
		super(nombre, capacidadCarga, ruta, numIdentificacionAvion);
		this.capacidadAsientos = new ArrayList<>(250);
		this.capacidadCarga = 50000.0;
	}

	public Boeing787() {}
	
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
