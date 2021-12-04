package co.edu.uniquindio.aerolinea.modelo;

public class PosicionCarro {

	private double posicion;
	private boolean ocupado;
	private String idCarro;
	
	public PosicionCarro() {};
	
	public PosicionCarro(double posicion) {
		this.posicion = posicion;
		this.ocupado = false;
	}

	public double getPosicion() {
		return posicion;
	}
	public void setPosicion(double posicion) {
		this.posicion = posicion;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public String getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(String idCarro) {
		this.idCarro = idCarro;
	}
	
		

}
