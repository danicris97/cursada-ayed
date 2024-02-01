
public class Entero implements Operaciones{
	private int valor;
	
	public Entero(int valor) {
		this.setValor(valor);
	}
	
	public Entero() {
		this.setValor(0);
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String toString() {
		return "" + this.valor;
	}

	@Override
	public void sumar(Object a, Object b) {
		Entero aux1 = (Entero)a;
		Entero aux2 = (Entero)b;
		
		this.valor = aux1.getValor() + aux2.getValor();
	}

	@Override
	public void restar(Object a, Object b) {
		Entero aux1 = (Entero)a;
		Entero aux2 = (Entero)b;
		
		this.valor = aux1.getValor() - aux2.getValor();
	}

	@Override
	public void multiplicar(Object a, Object b) {
		Entero aux1 = (Entero)a;
		Entero aux2 = (Entero)b;
		
		this.valor = aux1.getValor() * aux2.getValor();
	}

	@Override
	public void potencia(Object base, int exponente) {
		Entero aux1 = (Entero)base;
		
		this.valor = (int) Math.pow(aux1.getValor(), exponente);
	}

	@Override
	public boolean igualdad(Object otro) {
		Entero aux1 = (Entero)otro;
		
		if(aux1.getValor() == this.getValor()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void resto(Entero dividendo, Entero divisor) {
		if(divisor.getValor()!=0) {
			int b = Math.abs(divisor.getValor());
			int r = Math.abs(dividendo.getValor());
			
			while(r>=b) {
				r=r-b;
			}
			
			if(r!=0) {
				if(dividendo.getValor()<=0 && divisor.getValor()>0) {
					r=b-r;
				} else if(dividendo.getValor()<=0 && divisor.getValor()<0) {
					r=-b-r;
				}	
			}
			
			this.valor = r;
		}else {
			System.out.println("Error...");
		}
	}
	
	public void mcd(Entero a, Entero b) {
		int c = Math.abs(a.getValor());
		int d = Math.abs(b.getValor());
		
		if(c==0 && d==0) {
			System.out.println("Error...");
		}else {
			while(c!=d) {
				if(c>d) {
					c=c-d;
				}else {
					d=d-c;
				}
			}
			this.valor = c;
		}
	}
}
