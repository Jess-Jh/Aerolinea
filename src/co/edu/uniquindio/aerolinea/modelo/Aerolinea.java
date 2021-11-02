package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import co.edu.uniquindio.aerolinea.modelo.servicios.IAerolinea;

public class Aerolinea implements Serializable, IAerolinea {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Aeronave> listaAeronaves;
	private HashSet<Tripulante> listaTripulantes;
	private HashMap<String, Tripulante> listadoTripulantesAsignados;
	private ArrayList<Equipaje> listaEquipajes;
	private HashMap<String, Tiquete> listaTiquetes;
	private ArrayList<Ruta> listaRutas;
	private TreeSet<Cliente> listaClientes;
	private ArrayList<CarroEmbarque> listaCarros;
	private ArrayList<CruceAeronavesRutas> listaViajes;
	
	/**
	 * Constructor clase Aerolinea
	 * @param nombre, listaAeronaves, listaTripulantes, listaEquipajes, listaTiquetes, listaRutas, listaClientes, listaCarros
	 */
	public Aerolinea(String nombre) {
		this.nombre = nombre;
		this.listaAeronaves = new ArrayList<>();
		this.listaTripulantes = new HashSet<>();
		this.listaEquipajes = new ArrayList<>();
		this.listaTiquetes = new HashMap<String, Tiquete>();
		this.listadoTripulantesAsignados = new HashMap<String, Tripulante>();
		this.listaRutas = new ArrayList<>();
		this.listaClientes = new TreeSet<>();
		this.listaCarros = new ArrayList<>();
		this.listaViajes = new ArrayList<>();
		
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
	public HashMap<String, Tripulante> getListadoTripulantesAsignados() {
		return listadoTripulantesAsignados;
	}
	public void setListadoTripulantesAsignados(HashMap<String, Tripulante> listadoTripulantesAsignados) {
		this.listadoTripulantesAsignados = listadoTripulantesAsignados;
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
	public ArrayList<CruceAeronavesRutas> getListaViajes() {
		return listaViajes;
	}
	public void setListaViajes(ArrayList<CruceAeronavesRutas> listaViajes) {
		this.listaViajes = listaViajes;
	}	
	//---------------------------------------------------------------------------------------------||


	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", listaAeronaves=" + listaAeronaves + ", listaTripulantes="+ listaTripulantes + ", listaEquipajes=" + listaEquipajes 
				+ ", listaTiquetes=" + listaTiquetes+ ", listaRutas=" + listaRutas + ", listaClientes=" + listaClientes + ", listaCarros=" + listaCarros+ "]";
	}
	
	@Override
	public void realizarAsignacionMateria(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) {
		
		for (Tripulante tripulante : listaTripulantesVuelos) {
			listadoTripulantesAsignados.put(idVueloSeleccionado, tripulante);
		}
	}	

	/**
	 * Confirmar una ruta para cargar los datos del archivo
	 * @param string
	 * @return
	 */
	public Ruta confirmarRuta(String destinoRuta) {
		Ruta ruta = null;
		if(destinoRuta.equalsIgnoreCase("Monterrey")) {
			ruta = new Nacional("CDMX", "Monterrey", "2 H 45 Min", "6:00am");
			listaRutas.add(ruta);
		}
		if(destinoRuta.equalsIgnoreCase("Cancún")) {
			ruta = new Nacional("CDMX", "Cancún", "3 H 12 Min", "8:00am");
			listaRutas.add(ruta);
		}
		if(destinoRuta.equalsIgnoreCase("Buenos Aires")) {
			ruta = new Internacional("CDMX", "Buenos Aires", "9 H 5 Min", "11:30pm");
			listaRutas.add(ruta);
		}
		if(destinoRuta.equalsIgnoreCase("Los Ángeles")) {
			ruta = new Internacional("CDMX", "Los Ángeles", "3 H 25 Min", "9:45am");
			listaRutas.add(ruta);
		}
		if(destinoRuta.equalsIgnoreCase("Bogotá")) {
			ruta = new Internacional("CDMX", "Bogotá", "3 H 45 Min", "1:30pm");
			listaRutas.add(ruta);
		}
		if(destinoRuta.equalsIgnoreCase("Panamá")) {
			ruta = new Internacional("CDMX", "Panamá", "2 H 55 Min", "2:45pm");
			listaRutas.add(ruta);
		}
		return ruta;
	}
	
	/**
	 * Llenar los datos de la lista de los viajes para mostrar en la tableView
	 * @return
	 */
	public ArrayList<CruceAeronavesRutas> datosViajes() {
		ArrayList<CruceAeronavesRutas> listaViajes = new ArrayList<>();
		CruceAeronavesRutas viaje = null;
		
		for (int i = 0; i < listaAeronaves.size(); i++) {
			viaje = new CruceAeronavesRutas(listaAeronaves.get(i).getNombre(), listaAeronaves.get(i).getNumIdentificacionAvion(), 
					listaRutas.get(i).getCiudadOrigen(), listaRutas.get(i).getCiudadDestino(), listaRutas.get(i).getDuracion(), listaRutas.get(i).getHoraSalida());
			
			listaViajes.add(viaje);
		}
		return listaViajes;
	}
	
	/**
	 * Llenar los datos de la lista de los viajes para mostrar en la tableView con un destino definido
	 * @return
	 */
	public ArrayList<CruceAeronavesRutas> datosViajes(String destino) {
		ArrayList<CruceAeronavesRutas> listaViajes = new ArrayList<>();
		CruceAeronavesRutas viaje = null;
		
		for (int i = 0; i < listaAeronaves.size(); i++) {	
			if(listaRutas.get(i).getCiudadDestino().equalsIgnoreCase(destino)) {
				viaje = new CruceAeronavesRutas(listaAeronaves.get(i).getNombre(), listaAeronaves.get(i).getNumIdentificacionAvion(), 
						listaRutas.get(i).getCiudadOrigen(), listaRutas.get(i).getCiudadDestino(), listaRutas.get(i).getDuracion(), listaRutas.get(i).getHoraSalida());
				
				listaViajes.add(viaje);				
			}
		}
		return listaViajes;
	}

	/**
	 * Confirmar el tipo de tripulante 
	 * @param string
	 * @return
	 */
	public TipoTripulante confirmarTipoTripulante(String tipoTripulante) {
		TipoTripulante cargoTripulante = null;
		
		if(tipoTripulante.equalsIgnoreCase("Piloto")) cargoTripulante = TipoTripulante.PILOTO;
		
		if(tipoTripulante.equalsIgnoreCase("Copiloto")) cargoTripulante = TipoTripulante.COPILOTO;

		if(tipoTripulante.equalsIgnoreCase("AUXILIAR_VUELO")) cargoTripulante = TipoTripulante.AUXILIAR_VUELO;
			
		return cargoTripulante;
	}



	

}
