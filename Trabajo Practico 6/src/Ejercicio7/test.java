package Ejercicio7;

public class test {

	public static void main(String[] args) {
		PilaArrS2 pila = new PilaArrS2();
		pila.meter('a');
		pila.meter('c');
		pila.meter('d');
		
		System.out.println("Tope pila: " + (char)pila.topePila());
		System.out.println("Tope pila: " + (char)pila.topePilaApp());
	}

}
