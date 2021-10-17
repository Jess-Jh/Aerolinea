package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class CapacidadAsientos implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Asiento> listaPasajeros;
	private TipoClase clase;
	
	/**
	 * Constructor
	 * @param listaPasajeros
	 * @param clase
	 */
	public CapacidadAsientos(ArrayList<Asiento> listaPasajeros, TipoClase clase) {
		this.listaPasajeros = listaPasajeros;
		this.clase = clase;
	}
	
	public CapacidadAsientos() {}
	
	//-------------------- Métodos Getters and Setters -------------------------------------------->>
	public ArrayList<Asiento> getListaPasajeros() {
		return listaPasajeros;
	}
	public void setListaPasajeros(ArrayList<Asiento> listaPasajeros) {
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
