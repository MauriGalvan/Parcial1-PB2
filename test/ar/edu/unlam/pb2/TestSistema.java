package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSistema {

	// registro Clientes (Nombre, Codigo Postal,Telefono ,Mail)
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
	@Test
	public void queSePuedaRegistrarUnClienteConUnCorreoExistente()throws Exception  {
		
		Cliente cliente2 = new Cliente("Noelia", 2562, "1165372564", "noesol@gmail.com");
		RegistroCliente prueba= new RegistroCliente(cliente2);
		prueba.registrarClienteExixtente(cliente2);
			
		
	}
	
 	 // Gestion De Productos
	@Test
public void AgregarProductosAlCatalogoYQueEncuentrenProductosPorNombreEnCatalogo() {
		
		Producto producto1 = new Producto("nombre producto 1",10, 1,"Descripcion producto 1");
		Producto producto2 = new Producto("nombre producto 2",20, 2,"Descripcion producto 2");
		Producto producto3 = new Producto("nombre producto 3",30, 3,"Descripcion producto 3");
		Producto producto4 = new Producto("nombre producto 4",40, 4,"Descripcion producto 4");
		Catalogo catalogo1 = new Catalogo();
		
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto2);
		catalogo1.agregarProducto(producto3);
		catalogo1.agregarProducto(producto4);
		
		assertEquals(catalogo1.buscarProductosPorNombre(producto1.getNombre()),"nombre producto 1");
		assertEquals(catalogo1.buscarProductosPorNombre(producto2.getNombre()),"nombre producto 2");
		assertEquals(catalogo1.buscarProductosPorNombre(producto3.getNombre()),"nombre producto 3");
		assertEquals(catalogo1.buscarProductosPorNombre(producto4.getNombre()),"nombre producto 4");

	}
	@Test
	public void queSiNOEncuentraProductoPorNombreEnCatalogoYDeUnMensajeDeQueNoEncontro() {
		
		Producto producto1 = new Producto("",10, 5,"DescripcionProducto");
		Catalogo catalogo1 = new Catalogo();
		
		catalogo1.agregarProducto(producto1);
		
		assertNotEquals(catalogo1.buscarProductosPorNombre(producto1.getNombre()),"NotEquals");
		assertEquals(catalogo1.buscarProductosPorNombre(""),"No se encontraron productos con ese nombre.");
		assertEquals(catalogo1.buscarProductosPorNombre(null),"No se encontraron productos con ese nombre.");
		
	}
	@Test
	public void QueSeAgregenProductosAlCatalogoYConocerSuCantidad() {
		
		Producto producto1 = new Producto("producto1",10, 5,"DescripcionProducto");
		Producto producto2 = new Producto("producto2",10, 5,"DescripcionProducto");
		Producto producto3 = new Producto("producto3",10, 5,"DescripcionProducto");
		Producto producto4 = new Producto("producto4",10, 5,"DescripcionProducto");
		
		Catalogo catalogo1 = new Catalogo();
		
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto2);
		catalogo1.agregarProducto(producto3);
		catalogo1.agregarProducto(producto4);
		
		assertEquals(catalogo1.obtenerCantidadProductos(),4);
	}	
	@Test
	public void QueNOSePuedaAgregarProductosRepetidosAlCatalogo() {
		
		Producto producto1 = new Producto("producto1",10, 5,"DescripcionProducto");
		Catalogo catalogo1 = new Catalogo();
		
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto1);
		
		assertEquals(catalogo1.obtenerCantidadProductos(),1);
	}
	@Test
	public void QueSePuedaAgregarYELIMINARroductosdelCatalogo() {
		
		Producto producto1 = new Producto("producto1",10, 5,"DescripcionProducto");
		Producto producto2 = new Producto("producto2",10, 5,"DescripcionProducto");
		Producto producto3 = new Producto("producto3",10, 5,"DescripcionProducto");
		Producto producto4 = new Producto("producto4",10, 5,"DescripcionProducto");
		
		Catalogo catalogo1 = new Catalogo();
		
		catalogo1.agregarProducto(producto1);
		catalogo1.agregarProducto(producto2);
		catalogo1.agregarProducto(producto3);
		catalogo1.agregarProducto(producto4);
		
		assertEquals(catalogo1.obtenerCantidadProductos(),4);
		
		catalogo1.eliminarProducto(producto1);
		catalogo1.eliminarProducto(producto2);
		
		assertEquals(catalogo1.obtenerCantidadProductos(),2);
	}	
	
	
	 // Carrito
	@Test
	public void queSePuedaRealizarElPagoDeUnaCompra() {
		Cliente cliente2 = new Cliente("sofia", 3422, "11653756464", "sofi@gmail.com");
		
		CarritoDeCompras carrito =new CarritoDeCompras();
		
		Producto primerProducto= new Producto("Azucar",65.50,5,"Producto para endulzar");
		Producto segundoProducto= new Producto("leche",80.50,8,"Producto para tomar con cafe");
		Producto tercerProducto= new Producto("harina",74.50,10,"Producto para hacer pan");
		
		carrito.agregarProducto(primerProducto);
		carrito.agregarProducto(segundoProducto);
		carrito.agregarProducto(tercerProducto);
		
		CarritoDeCompras formaDePago = new CarritoDeCompras();
		boolean efectuarElPago = formaDePago.realizarPago(cliente2, carrito);
		assertTrue(efectuarElPago);
		
		
	}
	
	
	
	// Administracion de inventario
	@Test
	public void registrarQueSePuedeHacerUnaSalidaDeProducto() {
		Inventario inventario= new Inventario();
		
		Producto primerProducto= new Producto("yerba",350.30,8,"Producto para el mate");
		Producto segundoProducto= new Producto("leche",80.50,8,"Producto para tomar con cafe");
		Producto tercerProducto= new Producto("galletita",120.50,10,"Producto para la merienda");
		
		inventario.agregarProducto(primerProducto);
		inventario.agregarProducto(segundoProducto);
		inventario.agregarProducto(tercerProducto);
		
		Producto productoDeSalida = inventario.registrarSalida("yerba", 3);
		assertNotNull(productoDeSalida);
		assertEquals(5,productoDeSalida.getStock());
		
		
		
		
	} 

	
	
}
