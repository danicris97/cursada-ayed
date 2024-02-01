
public class Racional implements Operaciones{
	private int p;
	private int q;
	
	public Racional(int p, int q) {
		if(q!=0) {
			this.setP(p);
			this.setQ(q);
		}else {
			this.setP(0);
			this.setQ(0);
			System.out.println("Valor q no permitido");
		}
	}
	
	public Racional() {
		this.setP(0);
		this.setQ(1);
	}
	
	public void setP(int p) {
		this.p = p;
	}
	
	public void setQ(int q) {
		this.q = q;
	}
	
	public int getP() {
		return this.p;
	}
	
	public int getQ() {
		return this.q;
	}

	@Override
	public void sumar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		
		if(aux1.getQ()==aux2.getQ()) {
			this.setP((aux1.getP()*aux2.getQ())+(aux2.getP()*aux1.getQ()));
			this.setQ(aux1.getQ()*aux2.getQ());
		}else {
			this.setP(aux1.getP()+aux2.getP());
			this.setQ(aux1.getQ());
		}
	}

	@Override
	public void restar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		
		if(aux1.getQ()==aux2.getQ()) {
			this.setP((aux1.getP()*aux2.getQ())-(aux2.getP()*aux1.getQ()));
			this.setQ(aux1.getQ()*aux2.getQ());
		}else {
			this.setP(aux1.getP()-aux2.getP());
			this.setQ(aux1.getQ());
		}
	}

	@Override
	public void multiplicar(Object a, Object b) {
		Racional aux1 = (Racional)a;
		Racional aux2 = (Racional)b;
		
		this.setP((aux1.getP()*aux2.getP()));
		this.setQ(aux1.getQ()*aux2.getQ());
	}

	@Override
	public void potencia(Object base, int exponente) {
		Racional aux1 = (Racional)base;
		
		this.setP((int)Math.pow(aux1.getP(), exponente));
		this.setQ((int)Math.pow(aux1.getQ(), exponente));
	}

	@Override
	public boolean igualdad(Object otro) {
		Racional aux1 = this;
		Racional aux2 =(Racional)otro;
		
		aux1.simplificar();
		aux2.simplificar();
		
		if(aux1.getP()==aux2.getP() && aux1.getQ()==aux2.getQ()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void simplificar() {
		int mcd = this.mcd(this.getP(), this.getQ());
		if(mcd!=1) {
			this.setP(this.cociente(this.getP(), mcd));
			this.setQ(this.cociente(this.getQ(), mcd));
			this.simplificar();
		}
	}
	
	public String toString() {
		return "" + this.getP() + "/" + this.getQ();
	}
	
	private int mcd(int c, int d) {
		int a = Math.abs(c);
		int b = Math.abs(d);
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
}
