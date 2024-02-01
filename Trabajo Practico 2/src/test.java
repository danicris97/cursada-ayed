
public class test {

	public static void main(String[] args) {
		Numero n = new Numero(40);
		ParOrdenado p = new ParOrdenado();
		
		p=n.st(n.getValor(), 5);
		
		System.out.println(p.toString());
		
		
		Numero a = new Numero(48);
		System.out.println(a.factores().toString());
	}

}
