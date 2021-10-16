package co.edu.uniquindio.aerolinea.modelo;

import java.util.ArrayList;

public class Nacional extends Ruta {

	private static final long serialVersionUID = 1L;

	public Nacional(String ciudadOrigen, ArrayList<String> ciudadDestino, String duracion, String horaSalida) {
		super(ciudadOrigen, ciudadDestino, duracion, horaSalida);
	}

	public Nacional() {}
}
