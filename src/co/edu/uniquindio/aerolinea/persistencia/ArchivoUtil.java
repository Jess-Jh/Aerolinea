package co.edu.uniquindio.aerolinea.persistencia;

import java.beans.Encoder;
import java.beans.Expression;
import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
	
	/**
	 * Codifica el archivo
	 * @param rutaArchivoModeloGimnasioXml
	 * @param object
	 * @throws FileNotFoundException 
	 */
	public static void guardarRecursoXML(String rutaArchivo, Object object) throws FileNotFoundException {
		XMLEncoder codificarXML;
		
		codificarXML = new XMLEncoder(new FileOutputStream(rutaArchivo));
		
		//--------Conversión de LocalDate y LocalTime a String para poder generar los datos de las fechas y horas en el archivo XML------------->
		codificarXML.setPersistenceDelegate(LocalDate.class, new PersistenceDelegate() {
            @Override
            protected Expression instantiate(Object localDate, Encoder encdr) {
                return new Expression(localDate, LocalDate.class, "parse", new Object[]{localDate.toString()});
            }
        });
		
		codificarXML.setPersistenceDelegate(LocalTime.class, new PersistenceDelegate() {
			@Override
			protected Expression instantiate(Object LocalTime, Encoder encdr) {
				return new Expression(LocalTime, LocalTime.class, "parse", new Object[]{LocalTime.toString()});
			}
		});
		//--------------------------------------------------------------------------------------------------------------------------------------||
		
		codificarXML.writeObject(object);
		codificarXML.close();
	}

	/**
	 * Decodifica el archivo
	 * @param rutaArchivoModeloGimnasioXml
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static Object cargarRecursoXML(String rutaArchivo) throws FileNotFoundException {
		XMLDecoder decodificarXML;
		Object objetoXML;
		
		decodificarXML = new XMLDecoder(new FileInputStream(rutaArchivo));
		objetoXML = decodificarXML.readObject();
		decodificarXML.close();
		
		return objetoXML;
	}

}
