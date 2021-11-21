package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeSet;

import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.servicios.IAerolinea;

/**
 * @author Jessica Johana Ospina P.
 */
public class Aerolinea implements Serializable, IAerolinea {
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Aeronave> listaAeronaves;
	private HashSet<Tripulante> listaTripulantes;
	private HashMap<String, String> listadoTripulantesAsignados;
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
		this.listadoTripulantesAsignados = new HashMap<String, String>();
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
	public HashMap<String, String> getListadoTripulantesAsignados() {
		return listadoTripulantesAsignados;
	}
	public void setListadoTripulantesAsignados(HashMap<String, String> listadoTripulantesAsignados) {
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
	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) throws VueloException {
		String cedulasTripulantes = "";
		
		for (HashMap.Entry<String, String> entry : listadoTripulantesAsignados.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(idVueloSeleccionado))
				throw new VueloException("El vuelo ya tiene registrados unos tripulantes.");
	    }
		
		for (Tripulante tripulante : listaTripulantesVuelos) {
			cedulasTripulantes += tripulante.getIdentificacion() + "-";
		}
		listadoTripulantesAsignados.put(idVueloSeleccionado, cedulasTripulantes);
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
	 * Retornar los datos del tiquete comprado por el usuario
	 * @param identificacionCliente
	 * @return
	 */
	public CruceAeronavesRutas datosViajeUsuario(String identificacionCliente) {
		CruceAeronavesRutas viaje = new CruceAeronavesRutas();
		
		for (Entry<String, Tiquete> entry : listaTiquetes.entrySet()) {
			if(entry.getKey().equalsIgnoreCase(identificacionCliente)) {
				Tiquete tiquete = entry.getValue();
				viaje.setIdAvion(tiquete.getIdAvion());
				viaje.setCiudadDestino(tiquete.getRutaViaje().getCiudadDestino());
				viaje.setCiudadOrigen(tiquete.getClaseServicio().toString());
				viaje.setDuracionViaje(tiquete.getRutaViaje().getDuracion());
				viaje.setNombreAeronave(String.valueOf(tiquete.getCantPersonas()));
				break;
			}
	    }
		return viaje;
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

	/**
	 * Agregar Cliente a la Aerolinea
	 * @param identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia
	 * @param tarjetaDebitoCredito
	 * @return
	 */
	public Cliente agregarCliente(String identificacionOPasaporte, String nombre, String apellido, String direccion, String correoElectronico, 
			LocalDate fechaNacimiento, String direccionResidencia, String tarjetaDebitoCredito) {
		
		Cliente cliente = new Cliente(identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia, tarjetaDebitoCredito);
		listaClientes.add(cliente);
		
		return cliente;
	}

	/**
	 * Agregar un tiquete a la Aerolinea
	 * @param idAvion, destino, costoTotalViaje, viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numPersonas, cliente
	 * @param listaPuestosCliente
	 * @return
	 */
	public Tiquete agregarTiquete(String idAvion, String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, int numPersonas, double costoTotalViaje, Cliente cliente,
			ArrayList<String> listaPuestosCliente) {
		TipoViaje tipoViaje = null;
		TipoClase claseCliente = null;
		
		Ruta ruta = confirmarRuta(destino);
		
		for (Aeronave aeronave : listaAeronaves) {
			if(aeronave.getNumIdentificacionAvion().equalsIgnoreCase(idAvion)) {
				aeronave.getCapacidadAsientos().addAll(listaPuestosCliente);
			}
		}
		if(viajeSeleccionado.equalsIgnoreCase("ida")) tipoViaje = TipoViaje.IDA;
		if(viajeSeleccionado.equalsIgnoreCase("idaYVuelta")) tipoViaje = TipoViaje.IDA_Y_VUELTA;
		
		if(clase.equalsIgnoreCase("Ejecutiva")) claseCliente = TipoClase.EJECUTIVA;
		if(clase.equalsIgnoreCase("Económica")) claseCliente = TipoClase.ECONOMICA;
		
		Tiquete tiquete = new Tiquete(idAvion, tipoViaje, claseCliente, ruta, fechaSalida, fechaRegreso, numPersonas, costoTotalViaje, cliente, listaPuestosCliente);
		listaTiquetes.put(cliente.getIdentificacion(), tiquete);
		
		return tiquete;
	}

	
	/**
	 * Agregr un equipaje a la aerolinea
	 * @param identificacion, pesoTotalEquipaje, pesoEquipaje1, dimensionEquipaje1, pesoEquipaje2, totalDimensionEquipaje2
	 * @param totalDimensionEquipajeMano, pesoAdicional, altoEquipaje1, anchoEquipaje1, largoEquipaje1, altoEquipaje2
	 * @param anchoEquipaje2, largoEquipaje2, altoEquipajeMano, anchoEquipajeMano, largoEquipajeMano, idAvion
	 * @return
	 */

	public Equipaje agregarEquipaje(String identificacion, double pesoTotalEquipaje, String pesoEquipaje1, String dimensionEquipaje1, String pesoEquipaje2, String totalDimensionEquipaje2,
			String totalDimensionEquipajeMano, String pesoAdicional, String altoEquipaje1, String anchoEquipaje1, String largoEquipaje1, String altoEquipaje2, String anchoEquipaje2, String largoEquipaje2,
			String altoEquipajeMano, String anchoEquipajeMano, String largoEquipajeMano, String idAvion) {
		
		Equipaje equipaje = new Equipaje();
		equipaje.setIdentificacionCliente(identificacion); 
		equipaje.setPesoTotal(pesoTotalEquipaje);
		equipaje.setNumAvion(idAvion);
		
		if(!(pesoEquipaje1.equals(""))) {
			equipaje.setPesoEquipaje1(pesoEquipaje1);
			equipaje.setDimensionEquipaje1(dimensionEquipaje1);
			equipaje.setAltoEquipaje1(altoEquipaje1);
			equipaje.setAnchoEquipaje1(anchoEquipaje1);
			equipaje.setLargoEquipaje1(largoEquipaje1);
		}
		if(!(pesoEquipaje2.equals(""))) {
			equipaje.setPesoEquipaje2(pesoEquipaje2);
			equipaje.setDimensionEquipaje2(totalDimensionEquipaje2);
			equipaje.setAltoEquipaje2(altoEquipaje2);
			equipaje.setAnchoEquipaje2(anchoEquipaje2);
			equipaje.setLargoEquipaje2(largoEquipaje2);
		}
		if(!(totalDimensionEquipajeMano.equals(""))) {
			equipaje.setDimensionEquipajeMano(totalDimensionEquipajeMano);
			equipaje.setAltoEquipajeMano(altoEquipajeMano);
			equipaje.setAnchoEquipajeMano(anchoEquipajeMano);
			equipaje.setLargoEquipajeMano(largoEquipajeMano);
		}
		
		if(!(totalDimensionEquipajeMano.equals(""))) 
			equipaje.setPesoAdicional(pesoAdicional);

		listaEquipajes.add(equipaje);
		
		return equipaje;
	}

}
