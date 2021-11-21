package co.edu.uniquindio.aerolinea.controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.excepciones.EquipajeException;
import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Cliente;
import co.edu.uniquindio.aerolinea.modelo.Equipaje;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoClase;
import co.edu.uniquindio.aerolinea.modelo.TipoViaje;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;
import co.edu.uniquindio.aerolinea.modelo.servicios.IModelFactory;
import co.edu.uniquindio.aerolinea.persistencia.Persistencia;
import javafx.collections.ObservableList;

/**
 * Clase Singleton
 * @author Jessica Ospina
 */
public class ModelFactoryController implements Runnable, IModelFactory {
	
	Aerolinea aerolinea;
	Persistencia persistencia;
	AplicacionAerolinea aplicacionAerolinea;
	private ArrayList<String> listaPuestosCliente = new ArrayList<>();
	
	public ArrayList<String> getListaPuestosCliente() {
		return listaPuestosCliente;
	}
	public void setListaPuestosCliente(ArrayList<String> listaPuestosCliente) {
		this.listaPuestosCliente = listaPuestosCliente;
	}

	//--------------------Singleton---------------------------------------------------------->
	private static class singletonHolder {
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}
	
	//Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return singletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {
		inicializarDatos();
	}
	
	private void inicializarDatos() {	
		
		aerolinea = new Aerolinea("Caribe Airlines");
		
		cargarDatos();
		aerolinea.datosViajes();	
		cargarRecursoXML();
		guardarRecursoXML();
	}

	/**
	 * Cargar datos de los archivos .txt
	 */
	private void cargarDatos() {
		try {
			Persistencia.cargarDatosAeronaves(aerolinea);
			Persistencia.cargarDatosTripulante(aerolinea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	//-----------------RECURSOS BINARIO Y XML----------------------------------------------->
	public void guardarRecursoXML() {
		try {
			Persistencia.guardarRecursoXMLAerolinea(aerolinea);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public void cargarRecursoXML() {
		try {
			aerolinea = Persistencia.cargarRecursoXMLAerolinea();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	//-------------------------------------------------------------------------------------||

	@Override
	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) throws VueloException {
		aerolinea.realizarAsignacionVuelo(idVueloSeleccionado, listaTripulantesVuelos);
		guardarRecursoXML();
	}
	
	public Tiquete buscarViaje(String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, double numeroPersonas) {
		Tiquete tiquete = new Tiquete();
		Ruta ruta;
		int cantPersonas = (int) numeroPersonas;

		ruta = aerolinea.confirmarRuta(destino);
		
		tiquete.setRutaViaje(ruta);
		
		if(viajeSeleccionado.equalsIgnoreCase("Ida")) tiquete.setTipoViaje(TipoViaje.IDA);
		else tiquete.setTipoViaje(TipoViaje.IDA_Y_VUELTA);
		
		if(clase.equalsIgnoreCase("Ejecutiva")) tiquete.setClaseServicio(TipoClase.EJECUTIVA);
		else tiquete.setClaseServicio(TipoClase.ECONOMICA);
		
		tiquete.setFechaInicio(fechaSalida);
		tiquete.setFechaRegreso(fechaRegreso);
		tiquete.setCantPersonas(cantPersonas);
				
		return tiquete;
	}

	/**
	 * Lista de los puestos en el avión seleccionados por el cliente
	 * @param listaSillasCliente
	 */
	public void ocupacionSillasCliente(ArrayList<String> listaSillasCliente) {
		listaPuestosCliente.addAll(listaSillasCliente);
	}
	/**
	 * Agregar un cliente a la Aerolinea
	 * @param tiquete 
	 * @param identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento
	 * @param direccionResidencia, tarjetaDebitoCredito
	 * @return
	 */
	public Cliente agregarCliente(String identificacionOPasaporte, String nombre, String apellido, String direccion, String correoElectronico, 
			LocalDate fechaNacimiento, String direccionResidencia, String tarjetaDebitoCredito, Tiquete tiquete) {
		
		Cliente cliente = aerolinea.agregarCliente(identificacionOPasaporte, nombre, apellido, direccion, correoElectronico, fechaNacimiento, direccionResidencia, tarjetaDebitoCredito, tiquete);
		guardarRecursoXML();
		return cliente;
	}
	
	/**
	 * Modificar el tiquete comprado por el cliente
	 * @param identificacionOPasaporte
	 * @param tiquete
	 * @return
	 */
	public void modificarTiqueteCliente(String identificacionOPasaporte, Tiquete tiquete) {
		aerolinea.modificarTiqueteCliente(identificacionOPasaporte, tiquete);
		guardarRecursoXML();
	}
	
	/**
	 * Agregar un tiquete a la Aerolinea
	 * @param string 
	 * @param costoTotalViaje 
	 * @param viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numPersonas, cliente
	 * @param listaPuestosCliente
	 * @return
	 */
	public Tiquete agregarCompraTiquete(String idAvion, String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, int numPersonas, double costoTotalViaje, Cliente cliente,
			ArrayList<String> listaPuestosCliente) {
		
		Tiquete tiquete = aerolinea.agregarTiquete(idAvion, viajeSeleccionado, clase, origen, destino, fechaSalida, fechaRegreso, numPersonas, costoTotalViaje, cliente, listaPuestosCliente);
		guardarRecursoXML();
		return tiquete;
	}
	@Override
	public void run() {	}
	
	/**
	 * Agregar un equipaje a la aerolinea
	 * @param identificacion, pesoTotalEquipaje, pesoEquipaje1, dimensionEquipaje1, pesoEquipaje2, totalDimensionEquipaje2, totalDimensionEquipajeMano, pesoAdicional, 
	 * altoEquipaje1, anchoEquipaje1, largoEquipaje1, altoEquipaje2, anchoEquipaje2, largoEquipaje2, altoEquipajeMano, anchoEquipajeMano, largoEquipajeMano, idAvion
	 * @return
	 */
	public Equipaje agregarEquipaje(String idEquipaje, String identificacion, double pesoTotalEquipaje, String pesoEquipaje1, String dimensionEquipaje1, String pesoEquipaje2, 
			String totalDimensionEquipaje2, String totalDimensionEquipajeMano, String pesoAdicional, String altoEquipaje1, String anchoEquipaje1, String largoEquipaje1, 
			String altoEquipaje2, String anchoEquipaje2, String largoEquipaje2, String altoEquipajeMano, String anchoEquipajeMano, String largoEquipajeMano, String idAvion) {
		
		Equipaje equipaje = aerolinea.agregarEquipaje(idEquipaje, identificacion, pesoTotalEquipaje, pesoEquipaje1, dimensionEquipaje1, pesoEquipaje2, totalDimensionEquipaje2, totalDimensionEquipajeMano, pesoAdicional, 
				  altoEquipaje1, anchoEquipaje1, largoEquipaje1, altoEquipaje2, anchoEquipaje2, largoEquipaje2, altoEquipajeMano, anchoEquipajeMano, largoEquipajeMano, idAvion);
		guardarRecursoXML();
		return equipaje;
	}
	
	/**
	 * Actualizar un equipaje
	 * @param idEquipaje, pesoTotalEquipaje, pesoEquipaje1, dimensionEquipaje1, pesoEquipaje2, totalDimensionEquipaje2, totalDimensionEquipajeMano
	 * @param pesoAdicional, altoEquipaje1, anchoEquipaje1, largoEquipaje1, altoEquipaje2, anchoEquipaje2, largoEquipaje2, altoEquipajeMano
	 * @param anchoEquipajeMano, largoEquipajeMano
	 * @return
	 */
	public Equipaje actualizarEquipaje(String idEquipaje, double pesoTotalEquipaje, String pesoEquipaje1, String dimensionEquipaje1, String pesoEquipaje2, 
			String totalDimensionEquipaje2, String totalDimensionEquipajeMano, String pesoAdicional, String altoEquipaje1, String anchoEquipaje1,
			String largoEquipaje1, String altoEquipaje2, String anchoEquipaje2, String largoEquipaje2, String altoEquipajeMano, String anchoEquipajeMano, String largoEquipajeMano) {
		
		Equipaje equipaje = aerolinea.actualizarEquipaje(idEquipaje, pesoTotalEquipaje, pesoEquipaje1, dimensionEquipaje1, pesoEquipaje2, 
				 totalDimensionEquipaje2, totalDimensionEquipajeMano, pesoAdicional, altoEquipaje1, anchoEquipaje1,
				 largoEquipaje1, altoEquipaje2, anchoEquipaje2, largoEquipaje2, altoEquipajeMano, anchoEquipajeMano, largoEquipajeMano);
		guardarRecursoXML();
		return equipaje;
	}
	/**
	 * Eliminar un equipaje
	 * @param idEquipaje
	 */
	public boolean eliminarEquipaje(String idEquipaje) {
		
		if(aerolinea.eliminarEquipaje(idEquipaje)) {
			guardarRecursoXML();
			return true;
		}
		return false;
	}


	

}
