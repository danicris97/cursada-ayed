import java.util.ArrayList;

public class ListaEnteros {
	private ArrayList<Integer> lista;
	
	public ListaEnteros() {
		this.lista = new ArrayList<>();
	}
	
	public ArrayList<Integer> getLista(){
		return this.lista;
	}
	
	public void setLista(ArrayList<Integer> lista) {
		this.lista = lista;
	}
	
	public void addElement(int element) {
		this.lista.add(element);
	}
	
	//ejercicio 8
	public int calculaPromedio() {
		int n = this.getLista().size();
		if(n>0) {
			return this.cociente(this.acomulaR(n-1), n);
		}else {
			System.out.println("Error. lista vacia");
			return 0;
		}
	}
	
	
	public int acomulaR(int i) {
		if(i==0) {
			return this.lista.get(i);
		}else {
			return this.lista.get(i) + this.acomulaR(i-1);
		}
	}
	
	//ejercicio 10
	public ArrayList<Boolean> determinaListaPrimos(){
		ArrayList<Boolean> listabool = new ArrayList<>();
		
		for(int i=0;i<=this.lista.size();i++) {
			listabool.add(this.primo(this.lista.get(i)));
		}
		
		return listabool;
	}
	
	//metodos privados
	private int cociente(int a, int b) {
		int c=0;
		if(a>=0 && b>0) {
			while(a>=b) {
				c++;
				a=a-b;
			}
			return c;
		}else {
			System.out.println("\nError...");
			return 0;
		}
	}

	private int resto(int a, int b) {
		if(a>=0 && b>0) {
			while(a>=b) {
				a=a-b;
			}
			return a;
		}else {
			System.out.print("Error...");
			return -1;
		}
	}
	
	private boolean primo(int a) {
		if(Math.abs(a)<=1) {
			return false;
		}else {
			if(this.resto(a, 2)==0) {
				if(Math.abs(a)==2) {
					return true;
				}else {
					return false;
				}
			}else {
				return this.primoR(Math.abs(a),3);
			}
		}
	}
	
	private boolean primoR(int n, int d) {
		if((d*d)>n) {
			return true;
		}else {
			if(this.resto(n, d)==0) {
				return false;
			}else {
				return this.primoR(n, d+2);
			}
		}
	}
}
