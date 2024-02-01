package contenedores;

public abstract class ColaPrioridadLO extends Lista2DLinkedL{
	
	public Object sacar() {
		Object elemento = null;
		
		if(this.estaVacia()) {
			System.out.println("Error al sacar. Cola de Prioridad vacia...");
		}else {
			elemento = devolver(0);
			eliminar(0);
		}
		
		return elemento;
	}
}
