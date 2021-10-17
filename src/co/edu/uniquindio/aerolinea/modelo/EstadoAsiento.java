package co.edu.uniquindio.aerolinea.modelo;

public enum EstadoAsiento {
	
	RESERVADO(0), OCUPADO(1), DISPONIBLE(2);
	
	private static final long serialVersionUID = 1L;
	private int numEstadoAsiento;

	/**
	 * Constructor
	 * @param numEstadoAsiento
	 */
	private EstadoAsiento(int numEstadoAsiento) {
		this.numEstadoAsiento = numEstadoAsiento;
	}
	
	private EstadoAsiento() {}

	//----------Métodos Getters and Setters-------------------------------->
	public int getEstadoAsiento() {
		return numEstadoAsiento;
	}
	public void setEstadoAsiento(int numEstadoAsiento) {
		this.numEstadoAsiento = numEstadoAsiento;
	}
	//---------------------------------------------------------------------|
	
	public EstadoAsiento getEstadoAsiento(int index) {
		
		EstadoAsiento estadoAsiento = switch (index) {
		
			case 0 -> EstadoAsiento.RESERVADO;
			
			case 1 -> EstadoAsiento.OCUPADO;

			case 2 -> EstadoAsiento.DISPONIBLE;
			
			default -> null;
		};
		return estadoAsiento;
	}
}
