package contenedores;
import recursos.*;

public class ColaArr implements OperacionesCL1{
	protected Object[] cola;
	protected int finalC, frenteC;
	protected int tamCola;

	public ColaArr(int tamCola) {
		this.tamCola = tamCola;
		this.cola = new Object[this.tamCola];
		limpiar(); 
	}

	public void limpiar() {
		this.finalC = this.frenteC = tamCola - 1;
	}

	public void meter(Object elemento) {
		if (!estaLlena()) {
			if (this.finalC == this.tamCola - 1){
				this.finalC = 0;
			}else{
				incrementaFinal(); 
			}
			this.cola[this.finalC] = elemento;
		} else {
				System.out.println("Error. Cola llena...");
			}
	}
	
	
	public boolean estaLlena() {
		int p;
		if (this.finalC == this.tamCola - 1){
			p = 0;
		}else{
			p = this.finalC + 1;
		}
		return (p == this.frenteC);
	}
		
	public Object sacar() {
		Object elemento = null;
		if (!estaVacia()){
			if (this.frenteC == this.tamCola - 1){
				this.frenteC = 0;
			}else{
				incrementaFrente();
			}
			elemento = this.cola[this.frenteC];
		} else {
			System.out.println("Error. Cola vacia...");
		}
		return elemento;
	}	
	
	public boolean estaVacia() {//Completar!!!!
		return true;
	}
	
	private void incrementaFinal() { this.finalC++; }
	private void incrementaFrente() { this.frenteC++; }	
	
	
}