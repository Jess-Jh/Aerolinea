package co.edu.uniquindio.aerolinea.modelo.servicios;

import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.modelo.Tripulante;

public interface IAerolinea {

	public void realizarAsignacionMateria(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos);
}
