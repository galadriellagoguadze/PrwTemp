package prwtemp;

import java.util.HashMap;

public class Sistema {

    private HashMap<String, Restaurante> restaurantes;
    private HashMap<String, Cliente> clientes;

    public Sistema() {
        this.restaurantes = new HashMap<>();
        this.clientes = new HashMap<>();
    }

    public boolean adicionarRestaurante(String nome, String prato) {
    	if(restaurantes.get(nome) == null) {
    		Restaurante r = new Restaurante(nome, prato);
    		restaurantes.put(nome, r);
    		return true;
    	}
        return false;
    }

    public boolean adicionarCliente(String nome, String email) {
    	if(clientes.get(email) == null) {
    		Cliente c = new Cliente(nome, email);
    		clientes.put(nome, c);
    		return true;
    	}
        return false;
    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	Cliente c = clientes.get(emailCliente);

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {

    }

    public double obtemGastoCliente(String emailCliente) {
        return 0;
    }

    public String[] listarClientesRestaurante(String nomeRestaurante) {
        return new String[0];
    }

    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
        return "";
    }

    public String melhorPrato() {
        return "";
    }

    public String[] listarLivroVisitas(String nomeRestaurante) {
        return new String[0];
    }

    public String[] listarLivroVisitas(String nomeRestaurante, int numRecentes) {
        return new String[0];
    }

}
