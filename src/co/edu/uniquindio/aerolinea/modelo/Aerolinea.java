package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Aerolinea implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Aeronave> listaAeronaves;
	private HashSet<Tripulante> listaTripulantes;
	private ArrayList<Equipaje> listaEquipajes;
	private HashMap<String, Tiquete> listaTiquetes;
	private ArrayList<Ruta> listaRutas;
	private TreeSet<Cliente> listaClientes;
	private ArrayList<CarroEmbarque> listaCarros;
	
	/**
	 * Constructor clase Aerolinea
	 * @param nombre, listaAeronaves, listaTripulantes, listaEquipajes, listaTiquetes, listaRutas, listaClientes, listaCarros
	 */
	public Aerolinea(String nombre, ArrayList<Aeronave> listaAeronaves, HashSet<Tripulante> listaTripulantes, ArrayList<Equipaje> listaEquipajes, 
			HashMap<String, Tiquete> listaTiquetes, ArrayList<Ruta> listaRutas,TreeSet<Cliente> listaClientes, ArrayList<CarroEmbarque> listaCarros) {
		this.nombre = nombre;
		this.listaAeronaves = new ArrayList<>();
		this.listaTripulantes = new HashSet<>();
		this.listaEquipajes = new ArrayList<>();
		this.listaTiquetes = new HashMap<String, Tiquete>();
		this.listaRutas = new ArrayList<>();
		this.listaClientes = new TreeSet<>();
		this.listaCarros = new ArrayList<>();
	}
	
	public Aerolinea() {}

	//----------------------------- Métodos Getters and Setters ------------------------------------->>
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Aeronave> getListaAeronaves() {
		return listaAeronaves;
	}
	public void setListaAeronaves(ArrayList<Aeronave> listaAeronaves) {
		this.listaAeronaves = listaAeronaves;
	}
	public HashSet<Tripulante> getListaTripulantes() {
		return listaTripulantes;
	}
	public void setListaTripulantes(HashSet<Tripulante> listaTripulantes) {
		this.listaTripulantes = listaTripulantes;
	}
	public ArrayList<Equipaje> getListaEquipajes() {
		return listaEquipajes;
	}
	public void setListaEquipajes(ArrayList<Equipaje> listaEquipajes) {
		this.listaEquipajes = listaEquipajes;
	}
	public HashMap<String, Tiquete> getListaTiquetes() {
		return listaTiquetes;
	}
	public void setListaTiquetes(HashMap<String, Tiquete> listaTiquetes) {
		this.listaTiquetes = listaTiquetes;
	}
	public ArrayList<Ruta> getListaRutas() {
		return listaRutas;
	}
	public void setListaRutas(ArrayList<Ruta> listaRutas) {
		this.listaRutas = listaRutas;
	}
	public TreeSet<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(TreeSet<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<CarroEmbarque> getListaCarros() {
		return listaCarros;
	}
	public void setListaCarros(ArrayList<CarroEmbarque> listaCarros) {
		this.listaCarros = listaCarros;
	}
	//---------------------------------------------------------------------------------------------||

	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", listaAeronaves=" + listaAeronaves + ", listaTripulantes="+ listaTripulantes + ", listaEquipajes=" + listaEquipajes 
				+ ", listaTiquetes=" + listaTiquetes+ ", listaRutas=" + listaRutas + ", listaClientes=" + listaClientes + ", listaCarros=" + listaCarros+ "]";
	}

	public Object buscarViaje(String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, double numeroPersonas) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	

}
