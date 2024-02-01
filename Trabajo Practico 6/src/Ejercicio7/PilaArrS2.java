package Ejercicio7;

import contenedores.PilaSLinkedList;

public class PilaArrS2 extends PilaSLinkedList{
	
	public PilaArrS2() {
		super();
	}
	
	public Object topePila() {
		Object elemento = null;
		
		if(!super.estaVacia()) {
			elemento = super.pila.getNodoInfo();
		}else {
			System.out.println("Error sacar. Pila vacia");
		}
		
		return elemento;
	}
	public Object topePilaApp() {
		Object elemento = null;
		
		if(!super.estaVacia()) {
			elemento = super.sacar();
			super.meter(elemento);
		}else {
			System.out.println("Error sacar. Pila vacia");
		}
		
		return elemento;
	}
}
