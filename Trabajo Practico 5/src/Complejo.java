
public class Complejo implements Operaciones{
	private double real;
	private double imaginario;
	
	public Complejo(double real, double imaginario) {
		this.setReal(real);
		this.setImaginario(imaginario);
	}
	
	public Complejo() {
		this.setReal(0);
		this.setImaginario(0);
	}

	public double getImaginario() {
		return this.imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	public double getReal() {
		return this.real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	@Override
	public void sumar(Object a, Object b) {
		Complejo aux1=(Complejo)a;
		Complejo aux2=(Complejo)b;
		
		this.setReal(aux1.getReal() + aux2.getReal());
		this.setImaginario(aux1.getImaginario() + aux2.getImaginario());
	}

	@Override
	public void restar(Object a, Object b) {
		Complejo aux1=(Complejo)a;
		Complejo aux2=(Complejo)b;
		
		this.setReal(aux1.getReal() - aux2.getReal());
		this.setImaginario(aux1.getImaginario() - aux2.getImaginario());
	}

	@Override
	public void multiplicar(Object a, Object b) {
		Complejo aux1=(Complejo)a;
		Complejo aux2=(Complejo)b;
		
		this.setReal(aux1.getReal()*aux2.getReal()-aux1.getImaginario()*aux2.getImaginario());
		this.setImaginario(aux1.getReal()*aux2.getImaginario() - aux1.getImaginario()*aux2.getReal());
	}

	@Override
	public void potencia(Object base, int exponente) {
		Complejo aux=(Complejo)base;
		
		this.setReal(Math.pow(aux.getReal(), exponente));
		this.setImaginario(Math.pow(aux.getImaginario(), exponente));
	}

	@Override
	public boolean igualdad(Object otro) {
		Complejo aux = (Complejo)otro;
		if(this.getReal()==aux.getReal() && this.getImaginario()==aux.getImaginario()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void productoEscalar(Complejo a, int escalar) {
		this.setReal(a.getReal()*escalar);
		this.setImaginario(a.getImaginario()*escalar);
	}
	
	public void conjugado(Complejo a) {
		this.setReal(a.getReal());
		this.setImaginario(a.getImaginario()*-1);
	}
	
	public double modulo() {
		return Math.sqrt(Math.pow(this.getReal(), 2) + Math.pow(this.getImaginario(), 2));
	}
	
	public String toString() {
		return "(" + this.getReal() + "," + this.getImaginario() + "i)";
	}
}
