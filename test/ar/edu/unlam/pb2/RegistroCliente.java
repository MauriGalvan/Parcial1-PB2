package ar.edu.unlam.pb2;

import java.util.HashSet;

public class RegistroCliente {
private HashSet<Cliente>Clientes;
 
	public RegistroCliente() {
		this.Clientes = new HashSet<Cliente>();
	}

	public boolean ClienteRegistrado(Cliente clienteRegistrado) {
		if(clienteRegistrado.getTelefono().isEmpty() || clienteRegistrado.getNombre().isEmpty() || clienteRegistrado.getMail().isEmpty() || clienteRegistrado.getCodigoPostal() == 0) {			
			return false; // busca si algun campo esta vacio retorne falso
}
		for(Cliente c : Clientes) {
			if(c.getTelefono().equals(clienteRegistrado.getTelefono()) || c.getMail().equals(clienteRegistrado.getMail())) {
				return false; //recorre la coleccion de clientes para que no halla ningun telefono o mail iguales
			}
		}
				return Clientes.add(clienteRegistrado);
	}
	

	public void registrarCliente(Cliente NuevoCliente) {
		Clientes.add(NuevoCliente);
		
	}
	 public Cliente ObtenerCliente(String telefono) {
		 for(Cliente nuevoCliente : Clientes) {
			 if(nuevoCliente.getTelefono().equals(telefono)) {
				 return nuevoCliente;
			 }
		 }
		 return null;
	 }
	  public void registrarClienteExixtente(Cliente cliente) throws Exception {
	        for (Cliente c : Clientes) {
	            if (c.getMail().equals(cliente.getMail())) {
	                throw new Exception("El correo electrónico ya está registrado");
	            }
	        }
	        Clientes.add(cliente);
	    }
}
