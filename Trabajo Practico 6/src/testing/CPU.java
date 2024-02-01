package testing;

import contenedores.ColaArr;

public class CPU {
	private int tiempoCPU;
	private ColaArr cola;
	
	public CPU(int tiempoCPU, int n) {
		this.setTiempoCPU(tiempoCPU);
		this.cola = new ColaArr(n+1);
	}

	public int getTiempoCPU() {
		return tiempoCPU;
	}

	public void setTiempoCPU(int tiempoCPU) {
		this.tiempoCPU = tiempoCPU;
	}

	public ColaArr getCola() {
		return cola;
	}

	public void setCola(ColaArr cola) {
		this.cola = cola;
	}
	
	public void cargar() {
		while(!this.cola.estaLlena()) {
			this.cola.meter(new Proceso());
		}
	}
	
	public void atender() {
		while(!this.cola.estaVacia()) {
			Proceso aux = (Proceso)this.cola.sacar();
			aux.incrementarCantAtenciones();
			if(aux.getTiempo()>this.tiempoCPU) {
				aux.setTiempo(aux.getTiempo()-this.tiempoCPU);
				this.cola.meter(aux);
			}else {
				aux.setTiempo(0);
				System.out.println("Proceso con id: " + aux.getId() + " tiempo osocio: " + (this.tiempoCPU - aux.getTiempo()));
				System.out.println("Cantidad de veces que se atendio: " + aux.getCantAntenciones());
			}
		}
	}
}
