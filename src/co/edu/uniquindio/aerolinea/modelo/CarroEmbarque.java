package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Carro Embarque
 * @author Jessica Ospina
 */
public class CarroEmbarque implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private double peso;
	private ArrayList<Equipaje> listaEquipajes;
	private String numIdentificacion;
	
	/**
	 * Constructor
	 * @param peso, listaEquipajes, numIdentificacion
	 */
	public CarroEmbarque(String numIdentificacion) {
		this.peso = 500.0;
		this.listaEquipajes = new ArrayList<>();
		this.numIdentificacion = numIdentificacion;
	}

	public CarroEmbarque() {}

	//--------------------------------------------- Métodos Getters and Setters ---------------------------------------------------------------------------------->>
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public ArrayList<Equipaje> getListaEquipajes() {
		return listaEquipajes;
	}
	public void setListaEquipajes(ArrayList<Equipaje> listaEquipajes) {
		this.listaEquipajes = listaEquipajes;
	}
	public String getNumIdentificacion() {
		return numIdentificacion;
	}
	public void setNumIdentificacion(String numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------||

	
	
	

}
