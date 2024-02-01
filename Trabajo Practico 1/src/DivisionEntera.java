//Ejercicio 11
public class DivisionEntera {
	private int cociente;
	private int resto;
	private int dividendo;
	private int divisor;
	
	
	public DivisionEntera(int dividendo, int divisor) {
		this.setDividendo(dividendo);
		this.setDivisor(divisor);
		this.setCociente(0);
		this.setResto(0);
	}
	
	//getters and setters
	public int getCociente() {
		return this.cociente;
	}
	
	public int getResto() {
		return this.resto;
	}
	
	public int getDividendo() {
		return this.dividendo;
	}
	
	public int getDivisor() {
		return this.divisor;
	}
	
	public void setCociente(int cociente) {
		this.cociente=cociente;
	}
	
	public void setResto(int resto) {
		this.resto=resto;
	}
	
	public void setDividendo(int dividendo) {
		this.dividendo=dividendo;
	}
	
	public void setDivisor(int divisor) {
		this.divisor=divisor;
	}
	
	//code
	public void calcular() {
		if(this.divisor!=0) {
			int r=Math.abs(this.getDividendo());
			int b=Math.abs(this.getDivisor());
			int c=0;
			while(r>=b) {
				c++;
				r=r-b;
			}
			if(this.dividendo>=0 && this.divisor<0) {
				this.cociente=-c;
				this.resto=r;
			}else if(this.dividendo<=0 && this.divisor>0) {
				if(r==0) {
					this.cociente=-c;
					this.resto=0;
				}else {
					this.cociente=(-c-1);
					this.resto=(b-r);
				}
			}else if(this.dividendo<=0 && this.divisor<0) {
				if(r==0) {
					this.cociente=c;
					this.resto=r;
				}else {
					this.cociente=(c+1);
					this.resto=(-b-r);
				}
			}
			System.out.println("Cociente: " + this.getCociente());
			System.out.println("Resto: " + this.getResto());
		}else {
			System.out.println("\nError. No se puede dividir por cero");
		}
	}

}