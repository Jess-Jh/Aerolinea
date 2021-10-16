package co.edu.uniquindio.aerolinea.modelo;

import java.io.Serializable;

public enum TipoClase implements Serializable {
	
	EJECUTIVA(0), ECONOMICA(1);
	
	private static final long serialVersionUID = 1L;
	private int numClase;

	/**
	 * Constructor
	 * @param numPlan
	 */
	private TipoClase(int numClase) {
		this.numClase = numClase;
	}
	
	private TipoClase() {}

	//----------Métodos Getters and Setters-------------------------------->
	public int getnumClase() {
		return numClase;
	}
	public void setnumClase(int numClase) {
		this.numClase = numClase;
	}
	//---------------------------------------------------------------------|
	
	public TipoClase getTipoPlan(int index) {
		
		TipoClase tipoClase = switch (index) {
		
			case 0 -> TipoClase.EJECUTIVA;
			
			case 1 -> TipoClase.ECONOMICA;
			
			default -> null;
		};
		return tipoClase;
	}

}
