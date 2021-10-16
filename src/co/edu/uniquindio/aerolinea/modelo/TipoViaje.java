package co.edu.uniquindio.aerolinea.modelo;

public enum TipoViaje {
	
	IDA_Y_VUELTA(0), IDA(1);
	
	private static final long serialVersionUID = 1L;
	private int numViaje;

	/**
	 * Constructor
	 * @param numViaje
	 */
	private TipoViaje(int numViaje) {
		this.numViaje = numViaje;
	}
	
	private TipoViaje() {}

	//----------Métodos Getters and Setters-------------------------------->
	public int getnumViaje() {
		return numViaje;
	}
	public void setnumViaje(int numViaje) {
		this.numViaje = numViaje;
	}
	//---------------------------------------------------------------------|
	
	public TipoViaje getTipoViaje(int index) {
		
		TipoViaje tipoViaje = switch (index) {
		
			case 0 -> TipoViaje.IDA_Y_VUELTA;
			
			case 1 -> TipoViaje.IDA;
			
			default -> null;
		};
		return tipoViaje;
	}
}
