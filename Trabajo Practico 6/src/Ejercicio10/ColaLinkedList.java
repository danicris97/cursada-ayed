package Ejercicio10;

import contenedores.ColaSLinkedList;
import recursos.Nodo;

public class ColaLinkedList extends ColaSLinkedList{
	
	public ColaLinkedList() {
		super();
	}
	
	public int cardinal() {
		if(!this.estaVacia()) {
			int contador=0;
			ColaLinkedList aux = new ColaLinkedList();
			Object elemento;
			while(!this.estaVacia()) {
				elemento=this.sacar();
				aux.meter(elemento);
				contador++;
			}
			
			aux.moverElementos(this);
			
			return contador;
		}else {
			return 0;
		}
	}
	
	public void moverElementos(ColaLinkedList aux){
		if(!aux.estaVacia()) {
			while(!aux.estaVacia()){
				this.meter(aux.sacar());
			}
		}else {
			System.out.println("Esta vacia");
		}
	}
	
	public void invertirCola() {
		if(!this.estaVacia()) {
			Nodo aux=null;
			
			aux=this.finalC;
			this.finalC=this.frenteC;
			this.frenteC=aux;
			
		}else {
			System.out.println("Esta vacia");
		}
	}
	
	public void concatenarCola(ColaLinkedList b) {
		if(!b.estaVacia()) {
			while(!b.estaVacia()) {
				this.meter(b.sacar());
			}
		}
	}
}
