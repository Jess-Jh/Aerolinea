package co.edu.uniquindio.aerolinea.modelo.servicios;

import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.modelo.Tripulante;

public interface IModelFactory {
	
	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos);

}
