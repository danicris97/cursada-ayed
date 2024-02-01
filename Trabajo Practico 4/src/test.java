import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		Numero n = new Numero(-333);
		
		System.out.println(n.potencia(-3));
		System.out.println(n.primo());
		System.out.println(n.cantidadDigitos());
		System.out.println(n.mcd(17));
		
		ParOrdenado st = new ParOrdenado();
		st=n.st(17);
		System.out.println(st.toString());
		ArrayList<Integer> lista = new ArrayList();
		lista = n.factoresPrimos();
		System.out.println(lista);
		System.out.println(n.factores());
	}

}
