package ar.edu.unlam.pb2;

public class Cliente {
	private String nombre;
	private Integer codigoPostal;
	protected String telefono;
	private String mail;
	 private double saldo;
	

	public Cliente(String nombre, Integer codigoPostal, String telefono, String mail) {
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.mail = mail;
		this.telefono = telefono;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
