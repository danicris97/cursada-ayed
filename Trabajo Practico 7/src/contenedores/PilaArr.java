package contenedores;
import recursos.*;

public class PilaArr implements OperacionesCL1 {
	protected Object[] pila;
	protected int cabeza;
	protected int tamPila;
	
	public PilaArr(int tamPila) {
		this.tamPila = tamPila;
		this.pila = new Object[this.tamPila];
		limpiar(); 
	}
	
	public void meter(Object elemento) {
		if (!estaLlena()){
		  incrementaCabeza();
		  this.pila[this.cabeza] = elemento;
		} else {
			System.out.println("Error. Pila llena..");
		}
	}
	
	public Object sacar() {
		Object elemento = null;
		if (!estaVacia()){
			elemento = this.pila[this.cabeza];
			decrementaCabeza();
		} else {
			System.out.println("Error. Pila vacia..");
		}
		return elemento; 
	}

	public void limpiar() {
		this.cabeza = -1; 
	}
	
	public boolean estaLlena() {
		return (this.cabeza == this.tamPila - 1);
	}	
		
	public boolean estaVacia() {
		return (this.cabeza == -1);
	}
	
	private void incrementaCabeza() {
		this.cabeza++; 
	}
		
	private void decrementaCabeza(){
		this.cabeza--;
	}	
	
}
