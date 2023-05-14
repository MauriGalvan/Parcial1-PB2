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

	// CATALOGO // CATALOGO // CATALOGO // CATALOGO // CATALOGO // CATALOGO
	
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
	
	
	
	// PRODUCTOS // PRODUCTOS // PRODUCTOS // PRODUCTOS // PRODUCTOS // PRODUCTOS 
	
	@Test
	public void queSePuedaModificarLaInfoDeProductos() {
	Producto producto1 = new Producto("producto1",5, 5,"descripcion producto");
	producto1.ModificarInformacionProducto("nombre modificado",10, 10, "descripcion modificada");
	
	assertEquals(producto1.getNombre(),"nombre modificado");
	assertEquals(producto1.getPrecio(),10, 0.1);
	assertEquals(producto1.getStock(),10);
	assertEquals(producto1.getDescripcion(),"descripcion modificada");
	
	}
	
	
	
	@Test
	public void queSeSumeElStockCuandoSeaElMismoProductoRepetido() {
	
	Producto producto1 = new Producto("producto1",1000, 1,"descripcion producto");
	Catalogo catalogo1 = new Catalogo();
	
	catalogo1.agregarProducto(producto1);
	catalogo1.agregarProducto(producto1);
	catalogo1.agregarProducto(producto1); 
	catalogo1.agregarProducto(producto1);
	catalogo1.agregarProducto(producto1);
	
	assertEquals(producto1.getStock(),5, 0.1);	
	
	}
	
	
	@Test
	public void queSeSUMEyRESTEelStockCuandoSeaElMismoProductoRepetido() {
	
	Producto producto1 = new Producto("producto1",1000, 1,"descripcion producto");
	Catalogo catalogo1 = new Catalogo();
	CarritoDeCompras carritodecompra1 = new CarritoDeCompras();
			
	catalogo1.agregarProducto(producto1);
	catalogo1.agregarProducto(producto1);  // sumo el stock en 4
	catalogo1.agregarProducto(producto1);
	catalogo1.agregarProducto(producto1);
	
	assertEquals(producto1.getStock(),4, 0.1);
	
	carritodecompra1.agregarProducto(producto1);
	carritodecompra1.agregarProducto(producto1);  // agrego 3 al carrito de compra entonces queda 1 en stock
	carritodecompra1.agregarProducto(producto1);
	
	assertEquals(producto1.getStock(),1, 0.1);

	}
	
	
	
	// CARRITO DE COMPRA // CARRITO DE COMPRA // CARRITO DE COMPRA 
	
	
	@Test
	public void queSePuedaPagarExitosamenteYDeUnMensajeExitoso() {
	
	Producto producto1 = new Producto("producto1",10, 5,"descripcion producto");
	CarritoDeCompras carritodecompra = new CarritoDeCompras();
	Cliente cliente1 = new Cliente("cliente1",0 ,"0","mail");
	
	carritodecompra.agregarProducto(producto1);
	cliente1.setSaldo(9999);
	
	assertEquals(cliente1.getSaldo(),9999, 0.1);
	
	carritodecompra.setCliente(cliente1);
	carritodecompra.realizarPago();
	
	assertTrue(carritodecompra.realizarPago());	
	
	}
	
	@Test
	public void queNOSeRealizeElPagoPorSaldoInsuficienteYdeUnMensajeDeNoHaySuficienteSaldo() {
	
	Producto producto1 = new Producto("producto1",9999, 5,"descripcion producto");
	CarritoDeCompras carritodecompra = new CarritoDeCompras();
	Cliente cliente1 = new Cliente("cliente1",0 ,"0","mail");
	
	carritodecompra.agregarProducto(producto1);
	cliente1.setSaldo(1);
	carritodecompra.setCliente(cliente1);
	carritodecompra.realizarPago();
	
	assertFalse(carritodecompra.realizarPago());
	
	}
	
	@Test
	public void queSeConoscaElPrecioTotalDeLosProductosAgregandoYQuitandoVariosDelCarrito() {
	
	Producto producto1 = new Producto("producto1",10, 5,"descripcion producto");
	Producto producto2 = new Producto("producto2",20, 5,"descripcion producto");
	Producto producto3 = new Producto("producto3",30, 5,"descripcion producto");
	Producto producto4 = new Producto("producto4",40, 5,"descripcion producto");

	CarritoDeCompras carritodecompra = new CarritoDeCompras();
		
	carritodecompra.agregarProducto(producto1);
	carritodecompra.agregarProducto(producto2);
	carritodecompra.agregarProducto(producto3);
	carritodecompra.agregarProducto(producto4);
	
	assertEquals(carritodecompra.getPrecioTotal(),100,0.1);
	
	carritodecompra.elminarProducto(producto1);
	
	assertEquals(carritodecompra.getPrecioTotal(),90,0.1);
	
	}
		
}

	
	
	
	
	
	
}
