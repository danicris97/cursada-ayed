
public class test {

	public static void main(String[] args) {
		Division d = new Division(55,4);
		d.cociente();
		d.resto();
		
		DivisionEntera divi = new DivisionEntera(-45,23);
		divi.calcular();
		
		Numero n = new Numero(53);
		System.out.println(n.sosPrimo());

		/*int[] lista = new int[n.getValor()];
		lista=n.criba();
		
		String cadena="{";
		for(int i=0;i<=n.getValor();i++) {
			cadena+=lista[i] + ",";
		}
		cadena+="}";
		
		System.out.println("Listado: " + cadena);*/
		
		Criba c = new Criba(4,55);
		c.criba();
		System.out.println(c.listaCompleta());
		System.out.println(c.listaDepurada());
	}

}
