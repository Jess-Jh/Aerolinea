package co.edu.uniquindio.aerolinea.controladores;

import co.edu.uniquindio.aerolinea.aplicacion.AplicacionAerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aerolinea;

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

}
