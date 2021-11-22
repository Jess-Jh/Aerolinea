package co.edu.uniquindio.aerolinea.pilaBicolaListaEnlazada;

public class Pila<T> {

	private Nodo<T> cima;
	private int tamano;
	
	/**
	 * Verifica si la Pila está vacía
	 * @return true si está vacía
	 */
	public boolean estaVacia() {
		return cima == null;
	}
	
	/**
	 * Inserta un elemento en la Pila - push
	 * @param dato elemento a guardar en la pila
	 */
	public void push(T dato) {		
		Nodo<T> nodo = new Nodo<>(dato);
		nodo.setSiguienteNodo(cima);
		cima = nodo;			
		tamano++;
	}
	
	/**
	 * Retorna y elimina el elemento que está en la cima de la Pila - pop
	 * @return Elemento de la cima
	 */
	public T pop() {
		
		if(estaVacia()) throw new RuntimeException("La Pila está vacía");
		
		T dato = cima.getValorNodo();
		cima = cima.getSiguienteNodo();
		tamano--;
		
		return dato;		
	}
	
	
	/**
	 * Borra toda la Pila
	 */
	public void borrarPila() {
		cima = null;
		tamano = 0;
	}
	
	public void setCima(Nodo<T> cima) {
		this.cima = cima;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public int getTamano() {
		return tamano;
	}
	
	public T obtenerCima() {
		return cima.getValorNodo();
	}
	
	public Nodo<T> obtenerValor(){

		if(cima == null) return null;
		else {
			Nodo<T> nodo = cima;
			cima = cima.getSiguienteNodo();
			return nodo;
		}
	}
	
	/**
	 * @return the cima - peek
	 */
	public Nodo<T> getCima() {
		return cima;
	}

	
	/**
	 * Agrega una Pila nueva
	 * @param pila nueva Pila
	 */
	public void agregar(Pila<T> pila) {
		
		Pila<T> clon = pila.clone();
		Pila<T> aux = new Pila<>();
		
		while(!clon.estaVacia()) {
			aux.push(clon.pop());
		}
		
		while(!aux.estaVacia()) {
			push(aux.pop());
		}
	}
	
	/**
	 * Imprime una pila en consola
	 */
	public void imprimir() {
		Nodo<T> aux = cima;
		while(aux!=null) {
			System.out.print(aux.getValorNodo() + "  ");
			aux = aux.getSiguienteNodo();
		}
		System.out.println();
	}
	
	@Override
	protected Pila<T> clone(){

		Pila<T> pilaFinal = new Pila<>();		
		Nodo<T> nodoCima = null;
		
		for (Nodo<T> aux = cima; aux != null; aux = aux.getSiguienteNodo()) {
			
			Nodo<T> nuevo = new Nodo<>( aux.getValorNodo() );
			
			if(pilaFinal.estaVacia()) {
				pilaFinal.cima = nuevo;
				nodoCima = nuevo;
			} else {
				pilaFinal.cima.setSiguienteNodo(nuevo);
				pilaFinal.cima = nuevo;
			}			
			pilaFinal.tamano++;
		}
		pilaFinal.cima = nodoCima;
		
		return pilaFinal;
	}
	
}