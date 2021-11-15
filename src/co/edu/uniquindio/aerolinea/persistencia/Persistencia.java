package co.edu.uniquindio.aerolinea.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.AirbusA320;
import co.edu.uniquindio.aerolinea.modelo.AirbusA330;
import co.edu.uniquindio.aerolinea.modelo.Boeing787;
import co.edu.uniquindio.aerolinea.modelo.Ruta;
import co.edu.uniquindio.aerolinea.modelo.TipoTripulante;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;

public class Persistencia {
	
	private static final String RUTA_ARCHIVO_AERONAVES = "src/resource/archivos/archivoAeronaves.txt";
	private static final String RUTA_ARCHIVO_TRIPULANTES = "src/resource/archivos/archivoTripulantes.txt";
	private static final String RUTA_ARCHIVO_AEROLINEA_XML = "src/resource/archivos/archivoAerolinea.xml";
	
	//-------------------GUARDAR Y CARGAR RECURSO XML------------------------------------------------------->
	public static void guardarRecursoXMLAerolinea(Aerolinea aerolinea) throws FileNotFoundException {
		ArchivoUtil.guardarRecursoXML(RUTA_ARCHIVO_AEROLINEA_XML, aerolinea);
	}

	public static Aerolinea cargarRecursoXMLAerolinea() throws FileNotFoundException {
		Object object = null;
		Aerolinea aerolinea = null;
		
		object = ArchivoUtil.cargarRecursoXML(RUTA_ARCHIVO_AEROLINEA_XML);
		aerolinea = (Aerolinea) object;
		
		return aerolinea;
	}
	//-----------------------------------------------------------------------------------------------------||

	/**
	 * Cargar los datos de una Aeronave
	 * @param aerolínea
	 * @throws IOException 
	 */
	public static void cargarDatosAeronaves(Aerolinea aerolinea) throws IOException {
		
		ArrayList<String> contenido = new ArrayList<>();
		Aeronave aeronave = null;
		Ruta ruta;

		contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_AERONAVES);
		aerolinea.getListaAeronaves().clear();
		
		for (String lineaAeronave : contenido) {
			
			String[] split = lineaAeronave.split(",");
			ruta = aerolinea.confirmarRuta(split[2]);
			
			if(split[0].equalsIgnoreCase("Airbus A320")) {
				aeronave = new AirbusA320(split[0], Double.parseDouble(split[1]), ruta, split[3]);
				aerolinea.getListaAeronaves().add(aeronave);				
			}
			if(split[0].equalsIgnoreCase("Airbus A330")) {
				aeronave = new AirbusA330(split[0], Double.parseDouble(split[1]), ruta, split[3]);
				aerolinea.getListaAeronaves().add(aeronave);				
			}
			if(split[0].equalsIgnoreCase("Boeing 787")) {
				aeronave = new Boeing787(split[0], Double.parseDouble(split[1]), ruta, split[3]);
				aerolinea.getListaAeronaves().add(aeronave);				
			}
		}
	}
	
	/**
	 * Cargar los datos de un Tripulante
	 * @param aerolínea
	 * @throws IOException 
	 */
	public static void cargarDatosTripulante(Aerolinea aerolinea) throws IOException {
		
		ArrayList<String> contenido = new ArrayList<>();
		Tripulante tripulante = null;
		TipoTripulante tipoTripulante;
		
		contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_TRIPULANTES);
		aerolinea.getListaTripulantes().clear();
		
		for (String lineaTripulante : contenido) {
			
			String[] split = lineaTripulante.split(",");
			
			String fecha = split[5];			
			LocalDate fechaNacimiento = LocalDate.parse(fecha);
			
			tipoTripulante = aerolinea.confirmarTipoTripulante(split[7]);
			
			tripulante = new Tripulante(split[0], split[1], split[2], split[3], split[4], fechaNacimiento, split[6], tipoTripulante);
			aerolinea.getListaTripulantes().add(tripulante);	
		}
	}
	


}
