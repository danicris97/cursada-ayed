//Ejercicio 10 Naturales
public class Division {
	private int cociente;
	private int resto;
	private int dividendo;
	private int divisor;
	
	
	public Division(int dividendo, int divisor) {
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
	public void cociente() {
		int a=this.getDividendo();
		int b=this.getDivisor();
		if(a>=0 && b>0) {
			while(a>=b) {
				this.cociente=this.cociente+1;
				a=a-b;
			}
			System.out.println("Cociente: " + this.getCociente());
		}else {
			System.out.println("\nError...");
		}
	}
	
	public void resto() {
		this.resto=this.getDividendo();
		int b=this.getDivisor();
		if(this.resto>=0 && b>0) {
			while(this.resto>=b) {
				this.resto=this.resto-b;
			}
			System.out.println("Resto: " + this.getResto());
		}else {
			System.out.print("Error...");
		}
	}
	
	public void calcular() {
		this.cociente();
		this.resto();
	}
}
