package contenedores;
import recursos.*;


public class ColaSLinkedList implements OperacionesCL1 {
	protected Nodo frenteC, finalC;
	
	public ColaSLinkedList() {
		limpiar();
	}

	public boolean estaVacia() {
		return (this.frenteC == null);
	} 

	//Ojo: este metodo fue modificado para que no funcione. corregir! ;)
	public void meter(Object elemento) {
		if (!estaVacia()) {
			this.finalC.setNextNodo(new Nodo(elemento));
			this.finalC = this.finalC.getNextNodo();
			// nuevo nodo es el ultimo.
		}else{
			this.frenteC = null;
		}
	}
	
	public Object sacar() {
		Object elemento = null;
		if (!estaVacia()) {
			elemento = this.frenteC.getNodoInfo();
			this.frenteC = this.frenteC.getNextNodo();
			if (estaVacia()) {
				this.finalC = null; 
			}
		}else{
			System.out.println("Error sacar. Cola vacia");
		}
		return elemento;
	}
	
	public void limpiar() {
		this.frenteC = this.finalC = null;
	}	
	
}
