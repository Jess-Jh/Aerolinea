package co.edu.uniquindio.aerolinea.modelo.servicios;

import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;

public interface IAerolinea {

	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) throws VueloException;

}
