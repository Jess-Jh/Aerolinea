package co.edu.uniquindio.aerolinea.modelo;

public enum TipoTripulante {
	
	PILOTO(0), COPILOTO(1), AUXILIAR_VUELO;
	
	private static final long serialVersionUID = 1L;
	private int numTripulante;

	/**
	 * Constructor
	 * @param numViaje
	 */
	private TipoTripulante(int numTripulante) {
		this.numTripulante = numTripulante;
	}
	
	private TipoTripulante() {}

	//----------Métodos Getters and Setters-------------------------------->
	public int getnumTripulante() {
		return numTripulante;
	}
	public void setnumTripulante(int numTripulante) {
		this.numTripulante = numTripulante;
	}
	//---------------------------------------------------------------------|
	
	public TipoTripulante getTipoTripulante(int index) {
		
		TipoTripulante tipoTripulante = switch (index) {
		
			case 0 -> TipoTripulante.PILOTO;
			
			case 1 -> TipoTripulante.COPILOTO;

			case 3 -> TipoTripulante.AUXILIAR_VUELO;
			
			default -> null;
		};
		return tipoTripulante;
	}

}
