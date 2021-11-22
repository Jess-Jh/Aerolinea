package co.edu.uniquindio.aerolinea.pilaBicolaListaEnlazada;

public class Bicola<T> extends Cola<T>{
	
	public Bicola() {}
	
	// inserta por el final de la Bicola
	public void ponerFinal(T dato) {
		insertar(dato); 
	}
	
	// inserta por el frente; m�todo propio de Bicola
	public void ponerFrente(T dato) {
		Nodo<T> nuevoNodo;
		nuevoNodo = new Nodo<T>(dato);
		
		if (isVacia()) ultimo = nuevoNodo;
		
		nuevoNodo.setSiguienteNodo(primero);
		primero = nuevoNodo;
	}
	
	// retira elemento frente de la Bicola
	public T quitarFrente() {
		T valor = desencolar();
		return valor; 
	}
	
	// retira elemento final; m�todo propio de Bicola.
	// Es necesario recorrer la bicola para situarse en
	// el nodo anterior al final, para despu�s enlazar.
	public T quitarFinal() throws Exception {
		T aux;
		
		if (!isVacia()) {
			if (primero == ultimo) // la Bicola dispone de un solo nodo
				aux = desencolar();
			else {
				Nodo<T> nodo = primero;
				while (nodo.getSiguienteNodo() != ultimo) {
//				while (nodo.getSiguienteNodo() != null){
					nodo = nodo.getSiguienteNodo();
				}
					
				aux = nodo.getSiguienteNodo().getValorNodo();
				// siguiente del nodo anterior se pone a null
				nodo.setSiguienteNodo(null);
				ultimo = nodo;
			}
		}
		else throw new Exception("Eliminar de una bicola vac�a");
		
		return aux;
	}
	

}
