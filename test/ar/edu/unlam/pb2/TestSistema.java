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
		RegistroCliente registroCliente = new RegistroCliente();
		
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
		RegistroCliente registroCliente = new RegistroCliente();
		 
		registroCliente.registrarCliente(nuevoCliente);	
		assertEquals(nuevoCliente, registroCliente.ObtenerCliente("1234567890"));
	}
	@Test
	public void queNoSePuedaRegistarUnClienteSinCompletarTodosLosCamposRequeridos() {
		Cliente ClienteCompleto;
		Cliente ClienteIncompleto;

		ClienteCompleto = new Cliente("mauri",1111,"1234567890","mau@gmail.com");
		ClienteIncompleto = new Cliente("mauricio",1111,"","");
		
		RegistroCliente registroClienteCompleto = new RegistroCliente();
		RegistroCliente registroClienteIncompleto = new RegistroCliente();
	
		
		assertTrue(registroClienteCompleto.ClienteRegistrado(ClienteCompleto));
		assertFalse(registroClienteIncompleto.ClienteRegistrado(ClienteIncompleto));
	}
	
	@Test
	public void queNoSePuedaRegistrarUnClienteConUnMailOTelefonoQueYaExista() {
		
		Cliente ClienteA = new Cliente("mauri",111,"12345","mau@gmail");
		Cliente ClienteB = new Cliente("ROBERTO",111,"12345","rober@gmail");
		Cliente ClienteC = new Cliente("juan",111,"1234531","mau@gmail");
		Cliente ClienteD = new Cliente("hola",111,"1234531","hola@gmail");
		
		RegistroCliente registroCliente = new RegistroCliente();
		
		
		assertTrue(registroCliente.ClienteRegistrado(ClienteA));
		assertFalse(registroCliente.ClienteRegistrado(ClienteB)); // tiene que dar false por que tiene el mismo telefono
		assertFalse(registroCliente.ClienteRegistrado(ClienteC)); // tiene que dar false por que tiene el mismo mail
		assertTrue(registroCliente.ClienteRegistrado(ClienteD)); // tiene que dar true por que usa distinto mail y telefono de los demas
		
		
		
	}
	@Test
	public void queSePuedaRegistrarUnClienteConUnCorreoExistente()throws Exception  {
				
		Cliente cliente2 = new Cliente("Noelia", 2562, "1165372564", "noesol@gmail.com");
		RegistroCliente prueba= new RegistroCliente();
		prueba.registrarClienteExixtente(cliente2);
					
				
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

