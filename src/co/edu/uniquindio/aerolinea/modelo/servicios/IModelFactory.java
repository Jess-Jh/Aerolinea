package co.edu.uniquindio.aerolinea.modelo.servicios;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.aerolinea.excepciones.VueloException;
import co.edu.uniquindio.aerolinea.modelo.CarroEmbarque;
import co.edu.uniquindio.aerolinea.modelo.Cliente;
import co.edu.uniquindio.aerolinea.modelo.Equipaje;
import co.edu.uniquindio.aerolinea.modelo.Tiquete;
import co.edu.uniquindio.aerolinea.modelo.Tripulante;

public interface IModelFactory {
	
	public void realizarAsignacionVuelo(String idVueloSeleccionado, ArrayList<Tripulante> listaTripulantesVuelos) throws VueloException;

	public Cliente agregarCliente(String identificacionOPasaporte, String nombre, String apellido, String direccion, String correoElectronico, 
			LocalDate fechaNacimiento, String direccionResidencia, String tarjetaDebitoCredito, Tiquete tiquete);
	
	public Tiquete agregarCompraTiquete(String idAvion, String viajeSeleccionado, String clase, String origen, String destino, LocalDate fechaSalida, LocalDate fechaRegreso, int numPersonas, double costoTotalViaje, Cliente cliente,
			ArrayList<String> listaPuestosCliente);
	
	public Equipaje agregarEquipaje(String idEquipaje, String identificacion, double pesoTotalEquipaje, String pesoEquipaje1, String dimensionEquipaje1, String pesoEquipaje2, 
			String totalDimensionEquipaje2, String totalDimensionEquipajeMano, String pesoAdicional, String altoEquipaje1, String anchoEquipaje1, String largoEquipaje1, 
			String altoEquipaje2, String anchoEquipaje2, String largoEquipaje2, String altoEquipajeMano, String anchoEquipajeMano, String largoEquipajeMano, String idAvion);
	
	public Equipaje actualizarEquipaje(String idEquipaje, double pesoTotalEquipaje, String pesoEquipaje1, String dimensionEquipaje1, String pesoEquipaje2, 
			String totalDimensionEquipaje2, String totalDimensionEquipajeMano, String pesoAdicional, String altoEquipaje1, String anchoEquipaje1,
			String largoEquipaje1, String altoEquipaje2, String anchoEquipaje2, String largoEquipaje2, String altoEquipajeMano, String anchoEquipajeMano, String largoEquipajeMano);
	
	public boolean eliminarEquipaje(String idEquipaje);
	
	public void guardarCarroEmbarque(CarroEmbarque carroSalida);
}
