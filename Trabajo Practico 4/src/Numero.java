import java.util.ArrayList;

//tp 4 recursividad
public class Numero {
	private int valor;
	
	public Numero() {
		this.setValor(0);
	}
	
	public Numero(int valor) {
		this.setValor(valor);
	}
	
	public void setValor(int valor) {
		this.valor=valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	//metodos
	public int cociente(int a, int b) {
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

	public int resto(int a, int b) {
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
	
	public ParOrdenado division(Numero divisor) {
		ParOrdenado cr = new ParOrdenado();
		int b=Math.abs(divisor.getValor());
		if(b!=0) {
			int r=Math.abs(this.getValor());
			int c=0;
			while(r>=b) {
				c++;
				r=r-b;
			}
			if(this.getValor()>=0 && divisor.getValor()<0) {
				cr.setX(-c);
				cr.setY(r);
			}else if(this.getValor()<=0 && divisor.getValor()>0) {
				if(r==0) {
					cr.setX(-c);
					cr.setY(0);
				}else {
					cr.setX(-c-1);
					cr.setY(b-r);
				}
			}else if(this.getValor()<=0 && divisor.getValor()<0) {
				if(r==0) {
					cr.setX(c);
					cr.setY(r);
				}else {
					cr.setX(c+1);
					cr.setY(-b-r);
				}
			}
			System.out.println("Cociente: " + cr.getX());
			System.out.println("Resto: " + cr.getY());
		}else {
			System.out.println("\nError. No se puede dividir por cero");
		}
		return cr;
	}
	
	public ParOrdenado division(int b) {
		ParOrdenado cr = new ParOrdenado();
		if(b!=0) {
			int r=Math.abs(this.getValor());
			int c=0;
			while(r>=b) {
				c++;
				r=r-b;
			}
			if(this.getValor()>=0 && b<0) {
				cr.setX(-c);
				cr.setY(r);
			}else if(this.getValor()<=0 && b>0) {
				if(r==0) {
					cr.setX(-c);
					cr.setY(0);
				}else {
					cr.setX(-c-1);
					cr.setY(b-r);
				}
			}else if(this.getValor()<=0 && b<0) {
				if(r==0) {
					cr.setX(c);
					cr.setY(r);
				}else {
					cr.setX(c+1);
					cr.setY(-b-r);
				}
			}
			System.out.println("Cociente: " + cr.getX());
			System.out.println("Resto: " + cr.getY());
		}else {
			System.out.println("\nError. No se puede dividir por cero");
		}
		return cr;
	}
	
	//ejercicio 1
	public int potencia(int exponente) {
		if(exponente>=0) {
			if(exponente==0) {
				return 1;
			}else{
				return this.getValor()*this.potencia(exponente-1);
			}
		}else {
			System.out.println("El exponente es negativo, por lo tanto el resultado no es entero");
			return 0;
		}
	}
	
	//ejercicio 2
	public boolean primo() {
		int a = this.getValor();
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
	
	//ejercicio 3
	public int cantidadDigitos() {
		return cantidadDigitosR(this.getValor());
	}
	
	private int cantidadDigitosR(int n) {
		if(n<10) {
			return 1;
		}else {
			return 1 + this.cantidadDigitosR(this.cociente(n, 10));
		}
	}
	
	//ejercicio 4
	public int mcd(int n) {
		int a = Math.abs(this.getValor());
		int b = Math.abs(n);
		if(a==0 && b==0) {
			System.out.println("Error");
			return -1;
		}else {
			return this.mcdR(b,this.resto(a, b));
		}
	}
	
	private int mcdR(int a, int b) {
		if(b==0) {
			return a;
		}else {
			return this.mcdR(b, this.resto(a, b));
		}
	}
	
	//ejercicio 5
	public ParOrdenado st(int b){
		return stR(this.getValor(),b);
	}
	
	private ParOrdenado stR(int a, int b) {
		if(b==0) {
			ParOrdenado st = new ParOrdenado();
			st.setX(Math.abs(a));
			st.setY(0);
			return st;
		}else {
			ParOrdenado cr = new ParOrdenado();
			ParOrdenado st = new ParOrdenado();
			cr = this.division(b);
			st = this.stR(b, cr.getY());
			ParOrdenado sstt = new ParOrdenado(st.getY(),st.getX()-st.getY()*cr.getX());
			return sstt;
		}
	}
	
	//ejercicio 6
	public ArrayList<Integer> factoresPrimos(){
		ArrayList<Integer> lista = new ArrayList();
		
		return this.factoresPrimosR(Math.abs(this.getValor()), 2, lista);
	}
	
	private ArrayList<Integer> factoresPrimosR(int num, int divisor, ArrayList<Integer> lista){
		if(num!=1) {
			if(this.resto(num,divisor)==0) {
				lista.add(divisor);
				return this.factoresPrimosR(this.cociente(num,divisor),divisor,lista);
			}else {
				return this.factoresPrimosR(num, divisor+1, lista);
			}
		}else {
			return lista;
		}
	}
	
	//ejercicio 7
	public ArrayList<Integer> factores(){
		ArrayList<Integer> lista = new ArrayList();
		if(this.getValor()!=0) {
			lista.add(1);
			lista = this.factoresR(Math.abs(this.getValor()),2,lista);
			lista.add(this.getValor());
		}else {
			lista.add(0);
		}
		
		return lista;
	}
	
	private ArrayList<Integer> factoresR(int num, int divisor, ArrayList<Integer> lista){
		if(divisor<=this.cociente(num, 2)) {
			 if(this.resto(num, divisor)==0) {
				 lista.add(divisor);
			 }
			 return this.factoresR(num, divisor+1, lista);
		}else {
			return lista;
		}
	}
	
	//ejercicio 11
	public void bomba(int b) {
		this.bombaR(this.valor, b);
	}
	
	private void bombaR(int n, int b) {
		if(b<n) {
			bombaR(this.cociente(n, b),b);
			bombaR(this.cociente(-n, b),b);
		}else {
			System.out.println("Fragmento: " + n);
		}
	}
}
