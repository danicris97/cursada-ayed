package testing;

import java.util.Random;

public class Proceso {
	private static int nextId=1;
	private int id;
	private int tiempo;
	private int cantAntenciones;
	
	public Proceso() {
		this.id = nextId++;
		this.tiempo = new Random().nextInt(10) + 1;
		this.setCantAntenciones(0);
		System.out.println("Proceso id: " + this.id + " Tiempo: " + this.tiempo);
	}
	
	public int getId() { return this.id; }
	public int getTiempo() { return this.tiempo; }
	public int getCantAntenciones() {return cantAntenciones;}

	public void setCantAntenciones(int cantAntenciones) {this.cantAntenciones = cantAntenciones;}
	public void setTiempo(int tiempo) {this.tiempo = tiempo;}
	
	public void incrementarCantAtenciones() {this.cantAntenciones++;}
	
}
