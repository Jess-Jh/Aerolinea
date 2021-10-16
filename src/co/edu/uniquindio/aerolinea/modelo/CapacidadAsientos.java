package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class CapacidadAsientos implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<String> listaPasajeros;
	private TipoClase clase;
	
	/**
	 * Constructor
	 * @param listaPasajeros
	 * @param clase
	 */
	public CapacidadAsientos(ArrayList<String> listaPasajeros, TipoClase clase) {
		this.listaPasajeros = listaPasajeros;
		this.clase = clase;
	}
	
	public CapacidadAsientos() {}
	
	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public ArrayList<String> getListaPasajeros() {
		return listaPasajeros;
	}
	public void setListaPasajeros(ArrayList<String> listaPasajeros) {
		this.listaPasajeros = listaPasajeros;
	}
	public TipoClase getClase() {
		return clase;
	}
	public void setClase(TipoClase clase) {
		this.clase = clase;
	}
	//-------------------------------------------------------------------------------------------------------||

	
	
	
	

}
