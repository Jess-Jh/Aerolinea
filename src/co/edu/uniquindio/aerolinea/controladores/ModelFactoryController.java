package co.edu.uniquindio.aerolinea.controladores;

import java.time.LocalDate;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Internacional;
import co.edu.uniquindio.aerolinea.modelo.Nacional;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoClase;
import co.edu.uniquindio.aerolinea.modelo.TipoViaje;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;

public class ModelFactoryController implements Runnable {
	
	Aerolinea aerolinea;
	AplicacionAerolinea aplicacionAerolinea;
	
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
//		guardarRecursoXML();
//		cargarRecursoXML();
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
	
	public Tiquete buscarViaje(String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, double numeroPersonas) {
		Tiquete tiquete = new Tiquete();
		Ruta ruta;
		int cantPersonas = (int) numeroPersonas;

		if(destino.equalsIgnoreCase("Monterrey") || destino.equalsIgnoreCase("Cancún")) ruta = new Nacional(origen, destino);
		else ruta = new Internacional(origen, destino);
		
		tiquete.setRutaViaje(ruta);
		
		if(viajeSeleccionado.equalsIgnoreCase("Ida")) tiquete.setTipoViaje(TipoViaje.IDA);
		else tiquete.setTipoViaje(TipoViaje.IDA_Y_VUELTA);
		
		if(clase.equalsIgnoreCase("Ejecutiva")) tiquete.setClaseServicio(TipoClase.EJECUTIVA);
		else tiquete.setClaseServicio(TipoClase.ECONOMICA);
		
		tiquete.setFechaInicio(fechaSalida);
		tiquete.setFechaRegreso(fechaRegreso);
		tiquete.setCantPersonas(cantPersonas);
		
		DetalleVueloController detalleVueloController;
		
		return tiquete;
	}

}
