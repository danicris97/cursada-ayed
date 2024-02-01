
public class Matriz implements Operaciones{
	private int filas;
	private int columnas;
	private int[][] matriz;
	
	public Matriz(int filas, int columnas) {
		this.setFilas(filas);
		this.setColumnas(columnas);
		this.matriz = new int[this.getFilas()][this.getColumnas()];
		for(int i=0;i<this.getFilas();i++) {
			for(int j=0;j<this.getColumnas();j++) {
				this.matriz[i][j]=0;
			}
		}
	}
	
	public Matriz() {
		this.setFilas(0);
		this.setColumnas(0);
		this.matriz = new int[this.getFilas()][this.getColumnas()];
		this.matriz[0][0]=0;
	}
	
	public Matriz(int filas, int columnas, int min, int max) {
		this.setFilas(filas);
		this.setColumnas(columnas);
		this.matriz = new int[this.getFilas()][this.getColumnas()];
		for(int i=0;i<this.getFilas();i++) {
			for(int j=0;j<this.getColumnas();j++) {
				this.matriz[i][j]=(int)(Math.random()*max + min);
			}
		}
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz, int filas, int columnas) {
		if(this.filas==filas && this.columnas==columnas) {
			this.matriz = matriz;
		}else {
			System.out.println("Error... Matrices de distinto tamaño");
		}
	}

	@Override
	public void sumar(Object a, Object b) {
		Matriz aux1=(Matriz)a;
		Matriz aux2=(Matriz)b;
		this.setFilas(aux1.getFilas());
		this.setColumnas(aux1.getColumnas());
		this.matriz=new int[this.getFilas()][this.getColumnas()];
		
		if(aux1.getFilas()==aux2.getFilas() && aux1.getFilas()==aux2.getColumnas()) {
			for(int i=0;i<aux1.getFilas();i++) {
				for(int j=0;j<aux1.getColumnas();j++) {
					this.matriz[i][j]=aux1.getMatriz()[i][j]+aux2.getMatriz()[i][j];
				}
			}
		}else {
			System.out.println("Error... Matrices de distinto orden");
		}
	}

	@Override
	public void restar(Object a, Object b) {
		Matriz aux1=(Matriz)a;
		Matriz aux2=(Matriz)b;
		this.setFilas(aux1.getFilas());
		this.setColumnas(aux1.getColumnas());
		this.matriz=new int[this.getFilas()][this.getColumnas()];
		
		if(aux1.getFilas()==aux2.getFilas() && aux1.getFilas()==aux2.getColumnas()) {
			for(int i=0;i<aux1.getFilas();i++) {
				for(int j=0;j<aux1.getColumnas();j++) {
					this.matriz[i][j]=aux1.getMatriz()[i][j]-aux2.getMatriz()[i][j];
				}
			}
		}else {
			System.out.println("Error... Matrices de distinto orden");
		}
	}

	@Override
	public void multiplicar(Object a, Object b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void potencia(Object base, int exponente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean igualdad(Object otro) {
		Matriz aux = (Matriz)otro;
		if(aux.getFilas()==this.getFilas() && aux.getColumnas()==this.getColumnas()) {
			int i=0;
			int j=0;
			while(i<this.getFilas()) {
				while(j<this.getColumnas() && aux.getMatriz()[i][j]==this.getMatriz()[i][j]) {
					j++;
				}
				if(j<this.getColumnas()) {
					return false;
				}else {
					i++;
				}
			}
			return true;
		}else {
			return false;
		}
	}
	
	public void productoEscalar(Matriz a, int escalar) {
		this.setFilas(a.getFilas());
		this.setColumnas(a.getColumnas());
		this.matriz=new int[this.getFilas()][this.getColumnas()];
		
		for(int i=0;i<a.getFilas();i++) {
			for(int j=0;j<a.getFilas();j++) {
				this.matriz[i][j]=a.getMatriz()[i][j]*escalar;
			}
		}
	}
	
	public void transpuesta(Matriz a) {
		this.setFilas(a.getColumnas());
		this.setColumnas(a.getFilas());
		this.matriz=new int[this.getFilas()][this.getColumnas()];
		
		for(int i=0;i<this.getFilas();i++) {
			for(int j=0;j<this.getColumnas();j++) {
				this.matriz[i][j]=a.getMatriz()[j][i];
			}
		}
	}
}
