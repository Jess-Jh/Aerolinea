package co.edu.uniquindio.aerolinea.persistencia;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.modelo.Aerolinea;
import co.edu.uniquindio.aerolinea.modelo.Aeronave;
import co.edu.uniquindio.aerolinea.modelo.AirbusA320;
import co.edu.uniquindio.aerolinea.modelo.Ruta;

public class Persistencia {
	
	private static final String RUTA_ARCHIVO_AERONAVES = "src/resource/archivos/archivoAeronaves.txt";
	
	/**
	 * Método para cargar los datos de un cliente
	 * @param gimnasio
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
			
			aeronave = new AirbusA320(split[0], Double.parseDouble(split[1]), ruta, split[3]);
			aerolinea.getListaAeronaves().add(aeronave);
		}
	}

}
