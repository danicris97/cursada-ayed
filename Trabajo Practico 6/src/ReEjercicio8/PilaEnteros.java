package ReEjercicio8;

import contenedores.PilaSLinkedList;

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
}
