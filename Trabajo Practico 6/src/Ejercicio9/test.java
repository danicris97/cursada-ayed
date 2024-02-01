package Ejercicio9;

public class test {

	public static void main(String[] args) {
		PilaCaracteres p = new PilaCaracteres();
		
		p.meter(')');
		p.meter('e');
		p.meter('(');
		p.meter('(');
		p.meter(')');
		
		if(p.parentesisBalanceados()) {
			System.out.println("Esta balanceado");
		}else {
			System.out.println("Desbalanceado");
		}
	}

}
