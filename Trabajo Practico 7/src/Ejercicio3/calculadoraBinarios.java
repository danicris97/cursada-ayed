package Ejercicio3;

public class CalculadoraBinarios {
	protected NumeroBinario a;
	protected NumeroBinario b;
	protected NumeroBinario resultado;
	
	public CalculadoraBinarios() {
		this.a=new NumeroBinario();
		this.b=new NumeroBinario();
		this.resultado=new NumeroBinario();
	}
	
	public void suma(String a, String b) {
		this.a.cargar(a);
		this.b.cargar(b);
		
		int tamA = this.a.tamanio()-1;
		int tamB = this.b.tamanio()-1;
		char aux='0';
		
		while(tamA!=0 && tamB!=0) {
			char operadorA = (char)this.a.devolver(tamA);
			char operadorB = (char)this.b.devolver(tamB);
			
			if(operadorA==operadorB) {
				this.resultado.insertar(aux, 0);
				if(operadorA=='1') {
					aux='1';
				}else {
					aux='0';
				}
			}else {
				if(aux=='0') {
					this.resultado.insertar('1', 0);
				}else {
					aux='0';
					this.resultado.insertar(aux, 0);
				}
			}
			
			tamA--;
			tamB--;
		}
		
		if(tamA==0) {
			while(tamB!=0) {
				this.resultado.insertar(this.b.devolver(tamB), 0);
				tamB--;
			}
		}else {
			while(tamA!=0) {
				this.resultado.insertar(this.a.devolver(tamA), 0);
				tamB--;
			}
		}
	}
	
	public String getResultado() {
		return resultado.getNumero();
	}
	
	public String getA() {
		return a.getNumero();
	}
	
	public String getB() {
		return b.getNumero();
	}
}
