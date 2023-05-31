package ar.edu.unlam.pb2;

public class Producto {
	    
		private String nombre;
	    private double precio;
	    private int stock;
	    private String descripcion;
		
	    //metodos
	    
	    public void ModificarInformacionProducto(String nuevoNombre, double nuevoPrecio, int nuevoStock, String nuevaDescripcion) {
	    	this.nombre = nuevoNombre;
	    	this.precio = nuevoPrecio;
	    	this.stock = nuevoStock;
	    	this.descripcion = nuevaDescripcion;    	
	    }
	    
	  
	    public int sumarStock() {
	    		return this.stock++;   
		   	   }
	   
	   	public int restarStock() {
	    		return this.stock--;   
		   	   }
	    
	    
		// Constructor			    
		public Producto(String nombre, double precio, int stock, String descripcion) {
			this.nombre = nombre;
			this.precio = precio;
			this.stock = stock;
			this.descripcion = descripcion;
		}
		
				
		//Getters y setters		
		public String getNombre() {
			return nombre;							
		}
		
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	    
	    
	    
	
	
}
