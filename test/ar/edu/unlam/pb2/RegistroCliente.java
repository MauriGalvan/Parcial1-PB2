package ar.edu.unlam.pb2;

import java.util.HashSet;

public class RegistroCliente {
 private HashSet<Cliente>Clientes;
 
	public RegistroCliente(Cliente Cliente) {
		this.setCliente(new HashSet<Cliente>());
	}

	public HashSet<Cliente> getCliente() {
		return Clientes;
	}

	public void setCliente(HashSet<Cliente> Cliente) {
		this.Clientes = Cliente;
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
