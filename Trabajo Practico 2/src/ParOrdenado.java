public class ParOrdenado{
    private int x;
    private int y;
    
    public ParOrdenado(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    public ParOrdenado() {
    	this.setX(0);
    	this.setY(0);
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int  getY(){
        return this.y;
    }
    
    public String toString() {
    	String cadena="(" + this.getX() + "," + this.getY() + ")";
    	
    	return cadena;
    }
}