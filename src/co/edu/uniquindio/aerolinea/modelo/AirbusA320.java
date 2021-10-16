package co.edu.uniquindio.aerolinea.modelo;

import java.util.HashSet;

public class AirbusA320 extends Aeronave {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor 
	 * @param capacidadAsientos, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion
	 */
	public AirbusA320(CapacidadAsientos capacidadAsientos, double capacidadCarga, Ruta ruta,
			HashSet<Tripulante> listaTripulantes, String numIdentificacionAvion) {
		super(capacidadAsientos, capacidadCarga, ruta, listaTripulantes, numIdentificacionAvion);
	}
	
	public AirbusA320() {}

}
