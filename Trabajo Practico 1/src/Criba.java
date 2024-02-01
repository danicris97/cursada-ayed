
public class Criba {
	private int n;
	private int m;
	private int[] listado;
	
	public Criba(int m, int n) {
		this.setn(n);
		this.setm(m);
		this.listado = new int[n+1];
		this.listado[0]=0;
	}
	
	public int getn() {
		return this.n;
	}
	
	public int getm() {
		return this.m;
	}
	
	public int[] getListado() {
		return this.listado;
	}
	
	public void setn(int n) {
		this.n = n;
	}
	
	public void setm(int m) {
		this.m = m;
	}
	
	public void criba(){
		int n=this.getn();
		int m=this.getm();
		if(n>0 && m<n && m>1) {
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
			
			for(int i=0;i<=m;i++) {
				listado[i]=0;
			}
			
			this.listado=listado;
		}else {
			System.out.println("Error m>n o valor para m<2");
		}
		
	}
	
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
	
	public String listaCompleta() {
		String cadena="[";
		for(int i=0;i<=this.getn();i++) {
			cadena+=this.listado[i] +  ",";
		}
		cadena+="]";
		
		return cadena;
	}
	
	public String listaDepurada() {
		String cadena="[";
		for(int i=0;i<=this.getn();i++) {
			if(this.listado[i]!=0)
				cadena+=this.listado[i] +  ",";
		}
		cadena+="]";
		
		return cadena;
	}
}
