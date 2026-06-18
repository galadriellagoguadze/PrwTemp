package prwtemp;

public class Visita {
	private String data;
	private Cliente cliente;
	private String comentario;
	
	public Visita(Cliente cliente) {
		this.cliente = cliente;
	}
	 
	public Visita(Cliente cliente, String comentario) {
		this.cliente = cliente;
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Visita [data=" + data + ", cliente=" + cliente + ", comentario=" + comentario + "]";
	}
	
	
}
