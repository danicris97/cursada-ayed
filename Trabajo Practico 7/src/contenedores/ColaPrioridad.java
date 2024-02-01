package contenedores;

import recursos.Nodo;

public abstract class ColaPrioridad extends ColaSLinkedList{
	
	public abstract boolean iguales(Object elemento1, Object elemento2);
	public abstract boolean esMenor(Object elemento1, Object elemento2);
	public abstract boolean esMayor(Object elemento1, Object elemento2);
	
	public void meter(Object elemento) {
		Nodo nodo;
		nodo = new Nodo(elemento);
		if(this.estaVacia()) {
			this.frenteC=this.finalC=nodo;
		}else {
			if(esMenor(elemento, this.frenteC.getNodoInfo())) {
				//inserccion al frente
				nodo.setNextNodo(this.frenteC);
				this.frenteC=nodo;
			}else {
				if(esMayor(elemento,this.finalC.getNodoInfo()) || iguales(elemento,this.finalC.getNodoInfo())) {
					//inserta al final
					this.finalC.setNextNodo(nodo);
					this.finalC=nodo;
				}else {
					//inserta al medio
					Nodo temp = this.frenteC;
					boolean flag=false;
					while (/*temp.getNextNodo()!=null && */!flag){
						if (esMayor(elemento,temp.getNextNodo().getNodoInfo()) || iguales(elemento,temp.getNextNodo().getNodoInfo())){
							temp=temp.getNextNodo();
						}else{
							flag=true;
						}
					}

					nodo.setNextNodo(temp.getNextNodo());
					temp.setNextNodo(nodo);	
				}
			}
		}
	}
}
