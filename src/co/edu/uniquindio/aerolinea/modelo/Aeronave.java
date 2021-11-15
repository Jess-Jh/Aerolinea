package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Aeronave implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<String> capacidadAsientos;
	protected double capacidadCarga;
	private Ruta ruta;
	private HashSet<Tripulante> listaTripulantes;
	private String numIdentificacionAvion;
	
	/**
	 * Constructor
	 * @param capacidadAsientos, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion
	 */
	public Aeronave(String nombre, double capacidadCarga, Ruta ruta, String numIdentificacionAvion) {
		this.nombre = nombre;
		this.capacidadAsientos = new ArrayList<>();
		this.ruta = ruta;
		this.listaTripulantes = new HashSet<>();
		this.numIdentificacionAvion = numIdentificacionAvion;
	}
	
	public Aeronave() {}
	
	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public HashSet<Tripulante> getListaTripulantes() {
		return listaTripulantes;
	}
	public void setListaTripulantes(HashSet<Tripulante> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}
	public String getNumIdentificacionAvion() {
		return numIdentificacionAvion;
	}
	public void setNumIdentificacionAvion(String numIdentificacionAvion) {
		this.numIdentificacionAvion = numIdentificacionAvion;
	}
	//-------------------------------------------------------------------------------------------------------||

	@Override
	public String toString() {
		return nombre + "," + capacidadCarga + "," + ruta.getCiudadDestino() + "," + numIdentificacionAvion;
	}
	
	
	
	

}
