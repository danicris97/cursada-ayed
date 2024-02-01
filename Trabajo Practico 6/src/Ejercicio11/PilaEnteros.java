package Ejercicio11;

import contenedores.PilaSLinkedList;
import contenedores.ColaSLinkedList;

public class PilaEnteros extends PilaSLinkedList{
	
	public PilaEnteros() {
		super();
	}
	
	public void reemplazaValor(int buscado, int nuevo) {
		if(!this.estaVacia()) {
			PilaEnteros aux = new PilaEnteros();
			
			//modifica la pila pero da vuelta los valores
			while(!this.estaVacia()) {
				int valor = (int)this.sacar();
				if(valor==buscado) {
					valor=nuevo;
				}
				aux.meter(valor);
			}
		
			//los devuelve a su orden original
			while(!aux.estaVacia()) {
				int valor = (int)aux.sacar();
				this.meter(valor);
			}
		}else {
			System.out.println("Pila vacia");
		}
	}
	
	public ColaSLinkedList generaColaCapicuas() {
		ColaSLinkedList cola = new ColaSLinkedList();
		PilaEnteros aux = new PilaEnteros();
		int n;
		
		if(!this.estaVacia()) {
			while(!this.estaVacia()) {
				n=(int)this.sacar();
				if(this.determinaCapicua(n)) {
					cola.meter(n);
				}
				aux.meter(n);
			}
		}
		
		aux.copiaPilaInvertida(this);
		
		return cola;
	}
	
	public void copiaPilaInvertida(PilaEnteros aux) {
		if(!this.estaVacia()) {
			int valor=0;
			while(!this.estaVacia()) {
				valor=(int)this.sacar();
				aux.meter(valor);
			}
		}else {
			System.out.println("Error. Pila vacia");
		}
	}
	
	private boolean determinaCapicua(int num) {
		int aux=num,i=0,d=0,n=0;
		
		while(num!=0) {
			d=num%10;
			n=(int)(d*Math.pow(10,i));
			i++;
			num=(int)num/10;
		}
		
		if(n==aux) {
			return true;
		}else {
			return false;
		}
	}
}
