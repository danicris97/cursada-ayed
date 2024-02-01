package testing;

import contenedores.ColaSLinkedList;

public class CpuLinkedList {
	private int tiempoCPU;
	private ColaSLinkedList cola;
	
	public CpuLinkedList(int tiempoCPU) {
		this.setTiempoCPU(tiempoCPU);
		this.cola = new ColaSLinkedList();
	}

	public int getTiempoCPU() {
		return tiempoCPU;
	}

	public void setTiempoCPU(int tiempoCPU) {
		this.tiempoCPU = tiempoCPU;
	}

	public ColaSLinkedList getCola() {
		return cola;
	}

	public void setCola(ColaSLinkedList cola) {
		this.cola = cola;
	}
	
	public void cargar() {
		this.cola.meter(new Proceso());
	}
	
	public void cargar(int n) {
		for(int i=0; i<n; i++) {
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
				System.out.println("Proceso con id: " + aux.getId() + " tiempo osocio: " + (this.tiempoCPU - aux.getTiempo()));
				System.out.println("Cantidad de veces que se atendio: " + aux.getCantAntenciones());
			}
		}
	}
}

