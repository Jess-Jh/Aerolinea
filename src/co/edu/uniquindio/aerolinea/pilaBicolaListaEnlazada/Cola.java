package co.edu.uniquindio.aerolinea.pilaBicolaListaEnlazada;

public class Cola<T> {
	
	protected Nodo<T> primero;
	protected Nodo<T> ultimo;
	private int tamaño;
	/**
	 * Constructor con la Cola vacia
	 */
	public Cola() {
		primero = null;
		ultimo = null;
		tamaño = 0;
	}
	
	public Nodo<T> getPrimero() {
		return primero;
	}
	public void setPrimero(Nodo<T> primero) {
		this.primero = primero;
	}
	public Nodo<T> getUltimo() {
		return ultimo;
	}
	public void setUltimo(Nodo<T> ultimo) {
		this.ultimo = ultimo;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	/**
	 * Método que comprueba si la Cola está vacía o no.
	 * @return: True si está vacía, false si no.
	 */
	public boolean isVacia() {
		
		if(primero == null) return true;
		else return false;
	}
	/**
	 * Método que devuelve el numero de elementos que hay en la pila.
	 * @return: int.
	 */
	public int longitud() {
		int cont=0;
		Nodo<T> aux = primero;
		while(aux != null) {
			aux = aux.getSiguienteNodo();
			cont++;
		}
		return cont;
	}
	
	/**
	 * Método que retorna el primer elemento de la Cola.
	 * @return: Elemento de tipo genérico.
	 */
	public T primero() {
		return primero.getValorNodo();
	}
	/**
	 * Método que vacia la cola.
	 */
	public void vaciar() {
		primero = null;
	}
	/**
	 * Método que inserta un elemento de tipo genérico en la Cola.
	 * @param element: Elemento de tipo genérico.
	 */
	public void insertar(T element) {
		
		Nodo<T> aux= new Nodo<T>(element, null);
		
		if(isVacia()) {
			primero = aux;
			ultimo = aux;
		} else if(longitud() == 1) {
			primero.setSiguienteNodo(aux);
			ultimo = aux;
		} else {
			ultimo.setSiguienteNodo(aux);
			ultimo=aux;
		}
		tamaño++;
	}
	/**
	 * Método que extrae un elemento de la Cola.
	 * @throws Exception : la cola está vacía
	 */
	public void extraer() throws Exception {
		
		if(isVacia()) {
			throw new Exception("la cola está vacía");
		} else {
			Nodo<T> aux = primero.getSiguienteNodo();
			primero = null;
			primero = aux;
			tamaño--;
		}
	}
	/**
	 * Método que extrae un elemento de la Cola.
	 * @throws Exception : la cola está vacía
	 */
	public T extraer(T valor) throws Exception {
		
		Nodo<T> nodo = primero;
		Nodo<T> previo = null;
		Nodo<T> siguiente = null;
		boolean encontrado = false;

		//buscar el nodo previo
		while(nodo!=null) {
			if( nodo.getValorNodo() == valor ) {
				encontrado = true;
				break;
			}
			previo = nodo;
			nodo = nodo.getSiguienteNodo();
		}

		if(encontrado) {
			siguiente = nodo.getSiguienteNodo();
			if( previo==null ) {
				primero = siguiente;
			}else {
				previo.setSiguienteNodo(siguiente);
			}

			if(siguiente==null) {
				ultimo = previo;
			}else {
				nodo.setSiguienteNodo(null);
			}

			nodo = null;
			tamaño--;
			return valor;
		}
		throw new RuntimeException("El elemento no existe");
	}
	
	/**
	 * Retorna y elimina el elemento que está al incio de la Cola
	 * @return Primer elemento de la Cola
	 */
	public T desencolar() {
		
		if(isVacia()) throw new RuntimeException("La Cola está vacía");
		
		T dato = primero.getValorNodo();
		primero = primero.getSiguienteNodo();
		
		if(primero==null) ultimo = null;
		
		tamaño--;
		return dato;
	}
	
	@Override
	protected Cola<T> clone() {
		
		Cola<T> nueva = new Cola<>();
		Nodo<T> aux = getPrimero();
		
		while(aux!=null) {
			nueva.insertar( aux.getValorNodo() );
			aux = aux.getSiguienteNodo();
		}
		return nueva;		
	}
	
	/**
	 * Verifica si la Cola es idéntica a la actual
	 * @param cola Cola a comparar
	 * @return True si son iguales
	 */
	public boolean sonIdenticas(Cola<T> cola) {
		
		Cola<T> clon1 = clone();
		Cola<T> clon2 = cola.clone();
		
		if(clon1.getTamaño() == clon2.getTamaño()) {
			
			while( !clon1.isVacia() ) {				
				if( !clon1.desencolar().equals( clon2.desencolar() )) 
					return false;				
			}	
		} else return false;
		
		return  true;
	}
	
	public String toString() {
		
		String texto = "";
		Nodo<T> aux = primero;
		while(aux != null) {
			texto += "\n" + aux.getValorNodo();
			aux = aux.getSiguienteNodo();
		}
		return texto;
	}
	
	public void mostrar(){
		Nodo<T> puntero = primero;
		String datos = "";
		while(puntero != null){
			datos += puntero.getValorNodo() + "   ";
			puntero = puntero.getSiguienteNodo();
		}
		System.out.println(datos);
	}

}
