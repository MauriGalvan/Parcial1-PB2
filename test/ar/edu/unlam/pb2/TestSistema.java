package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSistema {

	// registro Clientes (Nombre, Codigo Postal,Telefono ,Mail,
	@Test
	public void queSeRegistroUnClienteConTodosLosCamposCompletos() {
		
		Cliente nuevoCliente;
		final String nombre = "mauri";
		final Integer codigoPostal = 1111;
		final String telefono = "1234567890";
		final String mail = "mau@gmail.com";
				
		nuevoCliente = new Cliente(nombre,codigoPostal,telefono,mail);	
		RegistroCliente registroCliente = new RegistroCliente(nuevoCliente);
		
		registroCliente.registrarCliente(nuevoCliente);	
	}
	@Test
	public void queSePuedaEncontrarUnClientePorElTelefono() {
		Cliente nuevoCliente;
		final String nombre = "mauri";
		final Integer codigoPostal = 1111;
		final String telefono = "1234567890";
		final String mail = "mau@gmail.com";
				
		nuevoCliente = new Cliente(nombre,codigoPostal,telefono,mail);	
		RegistroCliente registroCliente = new RegistroCliente(nuevoCliente);
		 
		registroCliente.registrarCliente(nuevoCliente);	
		assertEquals(nuevoCliente, registroCliente.ObtenerCliente("1234567890"));
	}
	
 	 // Gestion De Productos
	@Test
	public void queSeAgregueUnNuevoProductoAlCatalogo() {
		
	}
	
	 // Carrito
	@Test
	public void queSeAgregueUnProductoAlCarrito() {
	}
	
	 //Seguimiento de pedidos
	@Test
	public void quePuedaVerElEstadoDeUnPedidoEnProceso() {
	}
	
	// Administracion de inventario
	@Test
	public void quePuedaVerificarElStockActualDelProducto() {
	} 

	
	
}
