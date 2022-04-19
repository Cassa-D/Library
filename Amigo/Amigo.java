package Amigo;
public class Amigo {
	private int idAmigo;
	private String nome;
	private String celular;

	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}

	public String getCelular() {
		return celular;
	}

	public int getIdAmigo() {
		return idAmigo;
	}

	@Override
	public String toString() {
		return "Amigo [idAmigo =" + idAmigo + ", nome =" + nome + "]";
	}
}
