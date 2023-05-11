package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Iterator;

public class Catalogo {

	 private ArrayList<Producto> productos;
	 
	 //Constructor
	  public Catalogo() {
	        this.productos = new ArrayList<>();
	    }
	  	
	  	//metodos
	  
	  public int obtenerCantidadProductos() {
	        return this.productos.size();
	    }
	    
	  
	  
	  public String buscarProductosPorNombre(String nombreProducto) {
		    String resultado = "";
		    for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
		        Producto producto = (Producto) iterator.next();
		        if (producto.getNombre().equals(nombreProducto)) {
		            resultado += producto.getNombre();
		        }
		    }
		    if (resultado.equals("")) {
		        resultado = "No se encontraron productos con ese nombre.";
		        System.out.println("No se encontraron productos con ese nombre.");
		    }
		    return resultado;
		} 
	  
	  	
	    
	  	//add y remove
	  
	  
	  
	  
	  	public void agregarProducto(Producto producto) {
		    if (!this.productos.contains(producto)) {
		        this.productos.add(producto);
		        
		    } else {
		    	producto.sumarStock();
		    }
		}
	    public void eliminarProducto(Producto producto) {
	    	if (this.productos.contains(producto)) {
	    		 this.productos.remove(producto);
			}
	    	else {producto.restarStock();}
	    }

		public ArrayList<Producto> getProductos() {
			return productos;
		}

		public void setProductos(ArrayList<Producto> productos) {
			this.productos = productos;
		}
	  
}
