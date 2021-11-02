package co.edu.uniquindio.aerolinea.controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.AirbusA320;
import co.edu.uniquindio.aerolinea.modelo.AirbusA330;
import co.edu.uniquindio.aerolinea.modelo.Boeing787;
import co.edu.uniquindio.aerolinea.modelo.Internacional;
import co.edu.uniquindio.aerolinea.modelo.Nacional;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoClase;
import co.edu.uniquindio.aerolinea.modelo.TipoViaje;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;
import co.edu.uniquindio.aerolinea.modelo.servicios.IModelFactory;
import co.edu.uniquindio.aerolinea.persistencia.Persistencia;

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
		
			
//		guardarRecursoXML();
//		cargarRecursoXML();
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
	
	//-----------------RECURSOS XML----------------------------------------------->

	public void guardarRecursoXML() {
		
//		hiloServicio_guardarXML = new Thread(this);
//		hiloServicio_guardarXML.start();		
//	}
//	
//	public void cargarRecursoXML() {
//		try {
//			aerolinea = Persistencia.cargarRecursoXMLGimnasio();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
	}
	//-------------------------------------------------------------------------------------||


	public void run() {
		
	}
	
	@Override
	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) {
		aerolinea.realizarAsignacionMateria(idVueloSeleccionado, listaTripulantesVuelos);
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

	

}
