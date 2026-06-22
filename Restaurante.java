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
	
	public int getVotos() {
		return votos;
	}

	public String[] listarClientes() {
		String[] lista = new String[clientes.size()];
		int i = 0;
		for(Cliente c : clientes) {
			if(c.getPratoFav().equals(prato)) {
				lista[i] = "Cliente: " + c.toString() + ", Prato preferido da casa";
			}
			else{
				lista[i] = "Cliente: " + c.toString();
			}
			i++;
		}
		return lista;
	}
	
	public String[] listarVisitas() {
		String[] lista = new String[visitas.size()];
		int i = 0;
		for(Visita v : visitas) {
			lista[i] = v.toString();
			i++;
		}
		return lista;
	}
	public String[] listarUltimasNVisitas(int n) {
    	int tamanho = visitas.size();
    	String[] lista = new String[n];
    	int indiceArray = 0;
        for (int i = tamanho - 1; i >= tamanho - n; i--) {
            lista[indiceArray] = visitas.get(i).toString();
            indiceArray++; 
        }
    	return lista;
	}
	

	public boolean clienteVisitou(Cliente c) {
		if(clientes.contains(c)) {
			return true;
		}else {
			return false;
		}
	}
	public void adicionarCliente(Cliente c) {
		if(clienteVisitou(c)) {
			return;
		}
		clientes.add(c);
	}
	
	public String getNome() {
		return nome;
	}

	public String getPrato() {
		return prato;
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
	public int quantidadeClientes() {
	    return clientes.size();
	}

	public int quantidadeVisitas() {
	    return visitas.size();
	}
	@Override
	public String toString() {
		return "Restaurante [nome=" + nome + ", prato=" + prato + ", votos=" + votos + ", clientes=" + clientes
				+ ", visitas=" + visitas + "]";
	}
	
	
	
	
}
