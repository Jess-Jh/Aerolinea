package co.edu.uniquindio.aerolinea.modelo;

import java.util.HashSet;

public class Boeing787 extends Aeronave {

	private static final long serialVersionUID = 1L;

	public Boeing787(CapacidadAsientos capacidadAsientos, double capacidadCarga, Ruta ruta,
			HashSet<Tripulante> listaTripulantes, String numIdentificacionAvion) {
		super(capacidadAsientos, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion);
	}
	
	public Boeing787() {}

}
