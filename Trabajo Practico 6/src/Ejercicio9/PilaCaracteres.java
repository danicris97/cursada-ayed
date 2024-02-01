package Ejercicio9;

import contenedores.PilaSLinkedList;

public class PilaCaracteres extends PilaSLinkedList{
	
	public PilaCaracteres() {
		super();
	}
	
	public boolean parentesisBalanceados() {
		if(!this.estaVacia()) {
			PilaCaracteres aux = new PilaCaracteres();
			int controlador=0;
			char valor;
			
			while(!this.estaVacia() && controlador>=0) {
				valor=(char)this.sacar();
				aux.meter(valor);
				if(valor=='(') {
					controlador++;
				}else if(valor==')'){
					controlador--;
				}
			}
			
			aux.invertirPila(this);
			
			if(controlador==0) {
				return true;
			}else {
				return false;
			}
		}else {
			System.out.println("Pila vacia");
			return false;
		}
	}
	
	public void invertirPila(PilaCaracteres aux) {
		if(!this.estaVacia()) {
			char c;
			while(!this.estaVacia()) {
				c=(char)this.sacar();
				aux.meter(c);
			}
		}else {
			System.out.println("Pila vacia");
		}
	}
}
