package recursos;

//operaciones comunes a dos tipo de lista
public interface OperacionesCL2 {
	public int buscar(Object elemento);
	public Object devolver(int posicion);
	public void eliminar(int posicion);
	public void limpiar();
	public boolean estaVacia();		
	public int tamanio();
}



