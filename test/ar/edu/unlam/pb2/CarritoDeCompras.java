package ar.edu.unlam.pb2;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    
    private ArrayList<Producto> productos;
    private double precioTotal;
    int cantidadProducto;
    
    Producto producto;
    Cliente cliente;
   
	public CarritoDeCompras() {
        productos = new ArrayList<>();
        precioTotal = 0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        precioTotal += producto.getPrecio();
        cantidadProducto++;
        producto.restarStock();
    }
    
    public void elminarProducto(Producto producto) {
    	productos.remove(producto);
    	precioTotal -= producto.getPrecio();
    	cantidadProducto--;
    	producto.sumarStock();
    }
    
    
    
    public boolean realizarPago() {
    	if (cliente.getSaldo() >= precioTotal) {
			System.out.println("Pago realizado con exito");
			return true;
		} else { System.out.println("No hay suficeinte saldo.");
		return false;
		}	   		
    }	
    
   
    
    
    
    //getters y setters
    
    public Cliente getCliente() {
		return cliente;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
    
  