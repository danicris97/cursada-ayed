
import java.util.ArrayList;

public class Numero {
	private int valor;
	private boolean primo;
		
	public Numero(int valor) {
		this.setValor(valor);
		this.setPrimo(this.determinaPrimo());
	}
	
	//getters and setters
	public void setValor(int valor) {
		this.valor=valor;
	}
	
	public void setPrimo(boolean primo) {
		this.primo=primo;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public boolean sosPrimo() {
		return this.primo;
	}
	
	//code
	//ejercicio 12 tp1 implementar un algoritmo para determinar primos
	public boolean determinaPrimo() {
		if(Math.abs(this.getValor())<=1) {
			return false;
		}else {
			if(this.resto(Math.abs(this.getValor()),2)==0) {
				if(Math.abs(this.valor)==2) {
					return true;
				}else {
					return false;
				}
			}else {
				boolean ban=true;
				int d=3;
				while(Math.pow(d, 2)<=this.valor && ban) {
					if(this.resto(Math.abs(this.getValor()),d)==0) {
						ban=false;
					}else {
						d=d+2;
					}
				}
				return ban;
			}
		}
	}
	
	//ejercicio 10 tp1 implementar un algoritmo para obtener el cociente resto
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
	
	//ejercicio 19 tp1 implemente un algoritmo que devuelva la criba entre m y n
	public ArrayList<Integer> criba(int m, int n){
		ArrayList<Integer> listado = new ArrayList<>();
		listado.add(0);
		listado.add(0);
		if(n>0 && m<n && m>1) {
			for(int i=2;i<=n;i++) {
				listado.add(i);
			}
			int d=2;
			while(Math.pow(d,2)<=n) {
				for(int i=2;i<=this.cociente(n,d);i++) {
					listado.set(i*d,0);
				}
				d++;
				while(listado.get(d)==0) {
					d++;
				}
			}
			
			for(int i=0;i<=m;i++) {
				listado.set(i, 0);
			}
		}else {
			System.out.println("Error m>n o valor para m<2");
		}
		
		return listado;
	}
	
	//ejercicio 20 tp1 implemente un algoritmo que depure la criba
	public ArrayList<Integer> cribaDepurada(int m, int n){
		ArrayList<Integer> lista = new ArrayList<>();
		
		lista=this.criba(m, n);
		
		int i=0;
		while(i<=lista.size()) {
			if(lista.get(i)==0) {
				lista.remove(i);
			}
			i++;
		}
		
		return lista;
	}
	
	//ejercicio 4 tp2 implemente el algorimo de euclides para mcd
	public int mcd(int n) {
		int a = Math.abs(this.getValor());
		int b = Math.abs(n);
		
		if(a==0 && b==0) {
			System.out.println("Error...");
			return -1;
		}else {
			while(a!=b) {
				if(a>b) {
					a=a-b;
				}else {
					b=b-a;
				}
			}
			return a;
		}
	}
	
	public int mcd(int n, int m) {
		int a = Math.abs(n);
		int b = Math.abs(m);
		
		if(a==0 && b==0) {
			System.out.println("Error...");
			return -1;
		}else {
			while(a!=b) {
				if(a>b) {
					a=a-b;
				}else {
					b=b-a;
				}
			}
			return a;
		}
	}
	
	public int mcm(int b) {
		return this.cociente(this.getValor()*b, this.mcd(b));
	}
	
	public int mcm(int a, int b) {
		return this.cociente(a*b, this.mcd(a, b));
	}
	
	//ejercicio 11 tp2 implemente el algoritmo de euclides extendido para valores st
	public ParOrdenado st(int a,int b) {
		ParOrdenado st=new ParOrdenado();
		
		int r=a;
		int rr=b;
		int s=1;
		int ss=0;
		int t=0;
		int tt=1;
		int c,aux;
		while(rr!=0) {
			c=this.cociente(r,rr);
			
			aux=rr;
			rr=r - c*aux;
			r=aux;
			
			aux=ss;
			ss=s - c*aux;
			s=aux;
			
			aux=tt;
			tt=t - c*aux;
			t=aux;
		}
		
		st.setX(s);
		st.setY(t);
		
		return st;
	}
	
	//ejercicio 13 tp2 implemente un algoritmo para obtener los factores de un numero
	
	public ArrayList<Integer> factores(){
		ArrayList<Integer> lista = new ArrayList<>();
		
		if(this.getValor()!=0) {
			for(int d=1;d<=this.cociente(this.valor, 2);d++){
				if(this.resto(this.getValor(), d)==0) {
					lista.add(d);
				}
			}
			lista.add(this.getValor());
		}else {
			lista.add(0);
		}
		
		return lista;
	}
	
	//ejercicio 10 tp3 implemente un algoritmo para obtener el inverso
	
	public int inverso(int modulo) {
		if(this.mcd(modulo)==1) {
			ParOrdenado st = new ParOrdenado();
			st = this.st(this.getValor(), modulo);
			int s = st.getX();
			if(s<0 || s>=modulo) {
				s = this.resto(s, modulo);
			}
			return s;
		}else {
			return 0;
		}
	}
	
	//ejercicio 11 tp3 implemente un algoritmo para resolver una
	//ecuacion de congruencia cuando tiene una solucion
	
	public int ecuacionCongruenciaCoprimo(int modulo, int b) {
		if(this.mcd(modulo)==1) {
			int inv = this.inverso(modulo);
			b=b*inv;
			if(b>modulo || b<0) {
				Numero n= new Numero(b);
				b=n.inverso(modulo);
			}
			return b;
		}else {
			System.out.println("Tiene mas de una solucion");
			return 0;
		}
	}
	
	//ejercicio 14 tp3 implemente el teorema del resto chino
	
}
