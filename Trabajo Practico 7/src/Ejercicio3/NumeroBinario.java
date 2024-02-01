package Ejercicio3;

import contenedores.Lista1DLinkedL;

public class NumeroBinario extends Lista1DLinkedL{
	
	public NumeroBinario() {
		this.limpiar();
	}
	
	public NumeroBinario(String numero) {
		this.cargar(numero);
	}
	
	public void cargar(String numero) {
		for(int i=0;i<numero.length();i++) {
			char b = numero.charAt(i);
			if(b==0 || b==1) {
				this.insertar(b, i);
			}
		}
	}
	
	public String getNumero() {
		if(!this.estaVacia()) {
			StringBuilder builder = new StringBuilder();
		
			for(int i=0;i<=this.tamanio();i++) {
				builder.append(this.devolver(i));
			}
		
			return builder.toString();
		}else {
			System.out.println("Numero nulo");
			return null;
		}
	}
	
	@Override
	public boolean iguales(Object elementoL, Object elemento) {
		NumeroBinario aux1 = (NumeroBinario)elementoL;
		NumeroBinario aux2 = (NumeroBinario)elemento;
		
		if(aux1.getNumero()==aux2.getNumero()) {
			return true;
		}else {
			return false;
		}
	}
	
}
