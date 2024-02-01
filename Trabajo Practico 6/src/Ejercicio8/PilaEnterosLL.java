package Ejercicio8;

import contenedores.PilaSLinkedList;
import recursos.Nodo;

public class PilaEnterosLL extends PilaSLinkedList{
	
	public PilaEnterosLL() {
		super();
	}
	
	public void reemplazaInt(int buscado, int reemplazo) {
		if(!super.estaVacia()) {
			Nodo aux=this.pila;
			while(aux!=null && (int)aux.getNodoInfo()==buscado) {
				aux=aux.getNextNodo();
			}
			if(aux!=null) {
				aux.setNodoInfo(reemplazo);
			}else {
				System.out.println("El elemento no pertenece a la pila");
			}
		}else {
			System.out.println("La pila esta vacia");
		}
	}
	
}
