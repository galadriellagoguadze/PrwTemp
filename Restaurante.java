package prwtemp;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Restaurante {
	private String nome;
	private String prato;
	private int votos;
	private LinkedHashSet<Cliente> clientes;
	private ArrayList<Visita> visitas;
	
	public Restaurante(String nome, String prato) {
		this.nome = nome;
		this.prato = prato;
		this.clientes = new LinkedHashSet<>();
		this.visitas = new ArrayList<>();
	}
	
	public void receberVoto() {
		this.votos++;
	}
	public String[] listarClientes() {
		String[] lista = new String[clientes.size()];
		int i = 0;
		for(Cliente c : clientes) {
			lista[i] = c.toString();
			i++;
		}
		return lista;
	}
	public void adicionarCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	public void registrarVisita(Visita v) {
		this.visitas.add(v);
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Restaurante [nome=" + nome + ", prato=" + prato + ", votos=" + votos + ", clientes=" + clientes
				+ ", visitas=" + visitas + "]";
	}
	
	
	
	
}
