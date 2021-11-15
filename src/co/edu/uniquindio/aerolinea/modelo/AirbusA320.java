package co.edu.uniquindio.aerolinea.modelo;

import java.util.ArrayList;

public class AirbusA320 extends Aeronave {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> capacidadAsientos;
	private double capacidadCarga;

	/**
	 * Constructor 
	 * @param nombre, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion
	 */
	public AirbusA320(String nombre, double capacidadCarga, Ruta ruta, String numIdentificacionAvion) {
		super(nombre, capacidadCarga, ruta, numIdentificacionAvion);
		capacidadAsientos = new ArrayList<>(150);
	}
	
	public AirbusA320() {}

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

	@Override
	public String toString() {
		return super.toString();
	}

	
	

}
