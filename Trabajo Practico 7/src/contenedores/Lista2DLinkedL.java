package contenedores;
import recursos.*;

// lista ordenada
public abstract class Lista2DLinkedL extends Lista0DLinkedL implements OperacionesCL4 {
	
	// insercion ordenada
	public void insertar(Object elemento) {
		NodoDoble nodo;

		if (estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(elemento);
		} else{
			if (esMenor(elemento, this.frenteL.getNodoInfo())) {		
				//insercion al frente
				this.frenteL = new NodoDoble(elemento, null, this.frenteL); // nuevo frente
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL); // vamos al 2do y conectamos con el 1ero
			}else{
				if (esMayor(elemento, this.finalL.getNodoInfo()) || iguales(elemento, this.finalL.getNodoInfo())) {
					//al final si es mayor o igual no puede ponerese antes
					this.finalL = new NodoDoble(elemento,this.finalL,null);
					this.finalL.getPrevNodo().setNextNodo(this.finalL);
				}else{				
					// al medio
					NodoDoble temp = this.frenteL;
					boolean flag = false;
					while (temp.getNextNodo() != null && !flag) {
						if (esMayor(elemento, temp.getNextNodo().getNodoInfo()) || iguales(elemento, temp.getNextNodo().getNodoInfo())) {
							temp = temp.getNextNodo();
						}else{
							flag = true;
						}
					}
					// insercion al medio. entre temp y temp.next				
					nodo = new NodoDoble(elemento, temp, temp.getNextNodo());
					temp.getNextNodo().setPrevNodo(nodo);
					temp.setNextNodo(nodo);	
				}
			}
		}
		this.ultimo++; // incrementamos "ultima posicion" de lista
	}	
	
	
	//metodos abstractos que dependeran del tipo del objecto y el cricterio de comparacion
	public abstract boolean iguales(Object elemento1, Object elemento2);
	public abstract boolean esMenor(Object elemento1, Object elemento2);
	public abstract boolean esMayor(Object elemento1, Object elemento2);
	
	// implementar alg�n metodo de b�squeda
	public int buscar(Object elemento){
		if(!this.estaVacia()) {
			if(this.ultimo==0) {
				if(iguales(elemento,this.frenteL.getNodoInfo())) {
					return 0;
				}else {
					return -1;
				}
			}else {
				if(iguales(elemento,this.frenteL.getNodoInfo())) {
					return 0;
				}else if(iguales(elemento,this.finalL.getNodoInfo())) {
					return this.ultimo;
				}else {
					NodoDoble nodo=null;
					int ini=0, fin=this.ultimo, med=(int)(ini+fin/2);
					//movimiento del nodo
					int i=0;
					while(i<=med) {
						nodo=nodo.getNextNodo();
						i++;
					}
					
					//busqueda binaria para listas ordenadas
					while(ini<fin && !iguales(elemento,nodo.getNodoInfo())) {
						if(esMayor(elemento,nodo.getNodoInfo())) {
							fin=med-1;
						}else{
							ini=med+1;
						}
						med=(int)(ini+fin)/2;
						if(i<med) {
							while(i<=med) {
								nodo=nodo.getNextNodo();
								i++;
							}
						}else if(i>med){
							while(i>=med) {
								nodo=nodo.getPrevNodo();
								i--;
							}
						}
					}
					if(iguales(elemento,nodo.getNodoInfo())) {
						return med;
					}else {
						System.out.println("El elemento no pertenece a la lista...");
						return -1;
					}
				}
			}
		}else {
			System.out.println("Lista vacia...");
			return -1;
		}
	}
}
