//Ejercicio 12 y 20

public class Numero {
	private int valor;
	private boolean primo;
	/*private ArrayList<Integer> divisores;*/
	
	public Numero(int valor) {
		this.setValor(valor);
		this.setPrimo(this.determinaPrimo());
		/*this.divisores = new ArrayList<Integer>();*/
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
	
	/*public ArrayList<Integer> getDivisores() {
		return this.divisores;
	}*/
	
	//code
	private boolean determinaPrimo() {
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
	
	public int[] division(Numero divisor) {
		int [] cr = {0,0};
		int b=Math.abs(divisor.getValor());
		if(b!=0) {
			int r=Math.abs(this.getValor());
			int c=0;
			while(r>=b) {
				c++;
				r=r-b;
			}
			if(this.getValor()>=0 && divisor.getValor()<0) {
				cr[0]=-c;
				cr[1]=r;
			}else if(this.getValor()<=0 && divisor.getValor()>0) {
				if(r==0) {
					cr[0]=-c;
					cr[1]=0;
				}else {
					cr[0]=(-c-1);
					cr[1]=(b-r);
				}
			}else if(this.getValor()<=0 && divisor.getValor()<0) {
				if(r==0) {
					cr[0]=c;
					cr[1]=r;
				}else {
					cr[0]=(c+1);
					cr[1]=(-b-r);
				}
			}
			System.out.println("Cociente: " + cr[0]);
			System.out.println("Resto: " + cr[1]);
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
	
/*	public int[] criba(){
		int n=this.getValor();
		int[] listado = new int[n+1];
		listado[0]=0;
		listado[1]=0;
		for(int i=2;i<=n;i++) {
			listado[i]=i;
		}
		int d=2;
		while(Math.pow(d,2)<=n) {
			for(int i=2;i<=this.cociente(n,d);i++) {
				int indice = i*d;
				listado[indice]=0;
			}
			d++;
			while(listado[d]==0) {
				d++;
			}
		}
		
		return listado;
	}*/
}
