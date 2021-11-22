package co.edu.uniquindio.aerolinea.modelo;

public class PosicionCarro {

	private int posicion;
	private boolean ocupado;
	
	public PosicionCarro(int posicion) {
		this.posicion = posicion;
		this.ocupado = false;
	}

	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
		

}
