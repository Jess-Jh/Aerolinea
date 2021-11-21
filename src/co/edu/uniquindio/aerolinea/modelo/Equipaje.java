package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

/**
 * Clase Equipaje
 * @author Jessica Ospina
 */
public class Equipaje implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idEquipaje;
	private String identificacionCliente;
	private String pesoEquipaje1 = "", pesoEquipaje2 = "", dimensionEquipaje1 = "", dimensionEquipaje2 = "", dimensionEquipajeMano = "", pesoAdicional = ""; 
	private String altoEquipaje1 = "", anchoEquipaje1 = "", largoEquipaje1 = "", altoEquipaje2 = "", anchoEquipaje2 = "", largoEquipaje2 = "";
	private String altoEquipajeMano = "", anchoEquipajeMano = "", largoEquipajeMano = "";
	private double pesoTotal;
	private String numAvion;
	
	/**
	 * Contructor
	 */
	public Equipaje() {}

	// ------------------------------ Métodos Getters and Setters ----------------------------------------------->>
	public String getIdEquipaje() {
		return idEquipaje;
	}	
	public void setIdEquipaje(String idEquipaje) {
		this.idEquipaje = idEquipaje;
	}
	public String getIdentificacionCliente() {
		return identificacionCliente;
	}
	public void setIdentificacionCliente(String identificacionCliente) {
		this.identificacionCliente = identificacionCliente;
	}
	public double getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public String getPesoEquipaje1() {
		return pesoEquipaje1;
	}
	public void setPesoEquipaje1(String pesoEquipaje1) {
		this.pesoEquipaje1 = pesoEquipaje1;
	}
	public String getPesoEquipaje2() {
		return pesoEquipaje2;
	}
	public void setPesoEquipaje2(String pesoEquipaje2) {
		this.pesoEquipaje2 = pesoEquipaje2;
	}
	public String getDimensionEquipaje1() {
		return dimensionEquipaje1;
	}
	public void setDimensionEquipaje1(String dimensionEquipaje1) {
		this.dimensionEquipaje1 = dimensionEquipaje1;
	}
	public String getDimensionEquipaje2() {
		return dimensionEquipaje2;
	}
	public void setDimensionEquipaje2(String dimensionEquipaje2) {
		this.dimensionEquipaje2 = dimensionEquipaje2;
	}
	public String getDimensionEquipajeMano() {
		return dimensionEquipajeMano;
	}
	public void setDimensionEquipajeMano(String dimensionEquipajeMano) {
		this.dimensionEquipajeMano = dimensionEquipajeMano;
	}
	public String getPesoAdicional() {
		return pesoAdicional;
	}
	public void setPesoAdicional(String pesoAdicional) {
		this.pesoAdicional = pesoAdicional;
	}
	public String getAltoEquipaje1() {
		return altoEquipaje1;
	}
	public void setAltoEquipaje1(String altoEquipaje1) {
		this.altoEquipaje1 = altoEquipaje1;
	}
	public String getAnchoEquipaje1() {
		return anchoEquipaje1;
	}
	public void setAnchoEquipaje1(String anchoEquipaje1) {
		this.anchoEquipaje1 = anchoEquipaje1;
	}
	public String getLargoEquipaje1() {
		return largoEquipaje1;
	}
	public void setLargoEquipaje1(String largoEquipaje1) {
		this.largoEquipaje1 = largoEquipaje1;
	}
	public String getAltoEquipaje2() {
		return altoEquipaje2;
	}
	public void setAltoEquipaje2(String altoEquipaje2) {
		this.altoEquipaje2 = altoEquipaje2;
	}
	public String getAnchoEquipaje2() {
		return anchoEquipaje2;
	}
	public void setAnchoEquipaje2(String anchoEquipaje2) {
		this.anchoEquipaje2 = anchoEquipaje2;
	}
	public String getLargoEquipaje2() {
		return largoEquipaje2;
	}
	public void setLargoEquipaje2(String largoEquipaje2) {
		this.largoEquipaje2 = largoEquipaje2;
	}
	public String getAltoEquipajeMano() {
		return altoEquipajeMano;
	}
	public void setAltoEquipajeMano(String altoEquipajeMano) {
		this.altoEquipajeMano = altoEquipajeMano;
	}
	public String getAnchoEquipajeMano() {
		return anchoEquipajeMano;
	}
	public void setAnchoEquipajeMano(String anchoEquipajeMano) {
		this.anchoEquipajeMano = anchoEquipajeMano;
	}
	public String getLargoEquipajeMano() {
		return largoEquipajeMano;
	}
	public void setLargoEquipajeMano(String largoEquipajeMano) {
		this.largoEquipajeMano = largoEquipajeMano;
	}
	public String getNumAvion() {
		return numAvion;
	}
	public void setNumAvion(String numAvion) {
		this.numAvion = numAvion;
	}
	//------------------------------------------------------------------------------||
	
	
	
	
	
	
	
	
	
	
}
