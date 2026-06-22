package prwtemp;


import java.util.HashMap;


public class Sistema {

    private HashMap<String, Restaurante> restaurantes;
    private HashMap<String, Cliente> clientes;

    public Sistema() {
        this.restaurantes = new HashMap<>();
        this.clientes = new HashMap<>();
    }
    
    

    public HashMap<String, Restaurante> getRestaurantes() {
		return restaurantes;
	}



	public HashMap<String, Cliente> getClientes() {
		return clientes;
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
    		clientes.put(email, c);
    		return true;
    	}
        return false;
    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	Cliente c = clientes.get(emailCliente);
    	
    	Visita v = new Visita(c);
    	r.registrarVisita(v);
    	r.adicionarCliente(c);

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	Cliente c = clientes.get(emailCliente);
    	
    	Visita v = new Visita(c, comentario);
    	r.registrarVisita(v);
    	r.adicionarCliente(c);
    }

    public double obtemGastoCliente(String emailCliente) {
    	Cliente c = clientes.get(emailCliente);
    	
        return c.getGasto();
    }

    public String[] listarClientesRestaurante(String nomeRestaurante) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	
        return r.listarClientes();
    }

    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	Cliente c = clientes.get(emailCliente);
    	
    	if(r.clienteVisitou(c)) {
    		r.receberVoto();
    		return "Voto registrado com sucesso!";
    	}
        return "Voto não registrado";
    }

    public String melhorPrato() {
    	Restaurante melhorRestaurante = null; 
    	for(Restaurante r : restaurantes.values()) {
    		if(melhorRestaurante == null || r.getVotos() > melhorRestaurante.getVotos()) {
    			melhorRestaurante = r;
    		}
    	}
        return "Melhor prato: " + melhorRestaurante.getPrato() + " Restaurante: " + melhorRestaurante.getNome();
    }

    public String[] listarLivroVisitas(String nomeRestaurante) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
    	
        return r.listarVisitas();
    }

    public String[] listarLivroVisitas(String nomeRestaurante, int numRecentes) {
    	Restaurante r = restaurantes.get(nomeRestaurante);
        return r.listarUltimasNVisitas(numRecentes);
    }



	public Restaurante getRestaurante(String string) {
		return restaurantes.get(string);
	}
	
	public Cliente getCliente(String string) {
		return clientes.get(string);
	}

}
