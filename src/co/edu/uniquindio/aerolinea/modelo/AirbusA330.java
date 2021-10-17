package co.edu.uniquindio.aerolinea.modelo;

import java.util.HashSet;

public class AirbusA330 extends Aeronave {

	private static final long serialVersionUID = 1L;
	
	public AirbusA330(String nombre, CapacidadAsientos capacidadAsientos, double capacidadCarga, Ruta ruta,
						HashSet<Tripulante> listaTripulantes, String numIdentificacionAvion) {
		super(nombre, capacidadAsientos, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion);
	}

	public AirbusA330() {}
}
