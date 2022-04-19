package Biblioteca;
import java.util.ArrayList;
import java.util.Collections;

public class Biblioteca {
	private final String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;

	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}

	private Biblioteca(String nome, ArrayList<Livro> alLivros, float  investimento) {
		this(nome);
		this.alLivros = alLivros;
		this.investimento = investimento;
	}

	public String getNome() {
		return nome;
	}

	public float getInvestimento() {
		return investimento;
	}

	public int getSize() {
		return this.alLivros.size();
	}

	public int addLivro(String titulo, String autor, float preco) {
		int idLivro = this.alLivros.size() + 1;

		Livro livro = new Livro(idLivro, titulo, autor, preco);

		this.investimento += preco;
		this.alLivros.add(livro);

		return idLivro;
	}

	public Livro getLivro(int id) {
		return alLivros.get(id - 1);
	}

	public Biblioteca getTitleOrderedBib() {
		ArrayList<Livro> livros = (ArrayList<Livro>) this.alLivros.clone();
		Collections.sort(livros);
		return new Biblioteca(this.nome, livros, this.investimento);
	}
}
