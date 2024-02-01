package Ejercicio8;

import contenedores.PilaArr;

public class PilaEnteros extends PilaArr{
	
	public PilaEnteros(int tam) {
		super(tam);
	}
	
	public void reemplazaInt(int buscado, int remplazo) {
		if(!super.estaVacia()) {
			int i=this.buscaInt(buscado);
			if(i!=-1) {
				super.pila[i]=remplazo;
			}else {
				System.out.println("El elemento no esta en la pila");
			}
		}else {
			System.out.println("La pila esta vacia");
		}
	}
	
	public int buscaInt(int buscado) {
		int i=0;
		
		while(i<super.pila.length && (int)super.pila[i]!=buscado) {
			i++;
		}
		
		if(i<super.pila.length) {
			return i;
		}else {
			return -1;
		}
	}
}
