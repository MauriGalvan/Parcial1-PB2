package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Inventario {

	private ArrayList<Producto> productos;
	
	
public Inventario() {
	
	this.productos = new ArrayList<>();
}

public void agregarProducto(Producto producto) {
	productos.add(producto);
}
public Producto buscarProducto (String nombre) {
	for(Producto producto: productos) {
		if(producto.getNombre().equals(nombre)) {
			return producto;
		}
	}
	return null;
	
}
public Producto registrarSalida(String nombre,int cantidad) {
	Producto producto = buscarProducto(nombre);
	if(producto!= null && producto.getStock()>=cantidad) {
		producto.restarStock(cantidad);
		return producto;
	}return null;
	
}

}
