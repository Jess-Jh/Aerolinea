package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tiquete implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TipoViaje tipoViaje;
	private TipoClase claseServicio;
	private Ruta rutaViaje;
	private LocalDate fechaInicio;
	private LocalDate fechaRegreso;
	private int cantPersonas;
	private double costoPorPersona;
	private double precioFinal;
	private Cliente cliente;
	private ArrayList<String> ocupacionSillas;
	
	/**
	 * Constructor
	 * @param tipoViaje, claseServicio, rutaViaje, fechaInicio, fechaRegreso, cantPersonas, costoPorPersona, precioFinal, cliente
	 * @param ocupacionSillas
	 */
	public Tiquete(TipoViaje tipoViaje, TipoClase claseServicio, Ruta rutaViaje, LocalDate fechaInicio,
			LocalDate fechaRegreso, int cantPersonas, double costoPorPersona, double precioFinal, Cliente cliente,
			ArrayList<String> ocupacionSillas) {
		this.tipoViaje = tipoViaje;
		this.claseServicio = claseServicio;
		this.rutaViaje = rutaViaje;
		this.fechaInicio = fechaInicio;
		this.fechaRegreso = fechaRegreso;
		this.cantPersonas = cantPersonas;
		this.costoPorPersona = costoPorPersona;
		this.precioFinal = precioFinal;
		this.cliente = cliente;
		this.ocupacionSillas = ocupacionSillas;
	}
	
	public Tiquete () {}

	//----------Métodos Getters and Setters-------------------------------->																																																																																																																																																																	
	public TipoViaje getTipoViaje() {
		return tipoViaje;
	}
	public void setTipoViaje(TipoViaje tipoViaje) {
		this.tipoViaje = tipoViaje;
	}
	public TipoClase getClaseServicio() {
		return claseServicio;
	}
	public void setClaseServicio(TipoClase claseServicio) {
		this.claseServicio = claseServicio;
	}
	public Ruta getRutaViaje() {
		return rutaViaje;
	}
	public void setRutaViaje(Ruta rutaViaje) {
		this.rutaViaje = rutaViaje;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaRegreso() {
		return fechaRegreso;
	}
	public void setFechaRegreso(LocalDate fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}
	public int getCantPersonas() {
		return cantPersonas;
	}
	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
	public double getCostoPorPersona() {
		return costoPorPersona;
	}
	public void setCostoPorPersona(double costoPorPersona) {
		this.costoPorPersona = costoPorPersona;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<String> getOcupacionSillas() {
		return ocupacionSillas;
	}
	public void setOcupacionSillas(ArrayList<String> ocupacionSillas) {
		this.ocupacionSillas = ocupacionSillas;
	}
	//---------------------------------------------------------------------|
	
	
	
	
	
	

}
