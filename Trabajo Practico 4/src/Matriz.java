import java.util.ArrayList;

//ejercicio 9

public class Matriz {
	private ArrayList<ArrayList> matriz = new ArrayList<>();
	private int filas;
	private int columnas;
	
	public Matriz(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.iniciarMatriz();
	}
	
	private void iniciarMatriz() {
		for(int i=0;i<this.filas;i++) {
			ArrayList<Integer> fila = new ArrayList<>();
			for(int j=0;j<this.columnas;j++) {
				fila.add(0);
			}
			this.matriz.add(fila);
		}
	}
	
	public int getTamFilas() {
		return this.filas;
	}
	
	public int getTamColumnas() {
		return this.columnas;
	}
	
	public ArrayList<ArrayList> getMatriz(){
		return this.matriz;
	}
	
	public void setMatriz(ArrayList<ArrayList> matriz) {
		this.matriz = matriz;
	}

}
