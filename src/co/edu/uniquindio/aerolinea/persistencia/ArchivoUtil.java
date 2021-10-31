package co.edu.uniquindio.aerolinea.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoUtil {
	
	public static ArrayList<String> leerArchivo(String rutaArchivo) throws IOException  {
		
		ArrayList<String> contenido = new ArrayList<>();
		FileReader fileReader = new FileReader(rutaArchivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String linea = "";
		
		while ((linea = bufferedReader.readLine()) != null) {
			contenido.add(linea);
		}		
		bufferedReader.close();
		
		return contenido;
	}

}
