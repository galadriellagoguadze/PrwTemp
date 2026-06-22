package prwtemp;

import java.util.Objects;

public class Cliente {
	private String nome;
	private String email;
	private String pratoFav;
	private double gasto;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	public void comprarPrato() {
		this.gasto += 89.90;
	}
	
	public double getGasto() {
		return gasto;
	}
	public void mudarPratoFav(String novoPrato) {
		this.pratoFav = novoPrato;
	}
	
	public String getPratoFav() {
		return pratoFav;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(email, other.email);
	}
	@Override
	public String toString() {
		return nome;
	}
	
	
}
