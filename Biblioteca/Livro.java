package Biblioteca;

public class Livro implements Comparable<Livro> {
	private int idLivro;
	private String titulo;
	private String autor;
	private float preco;
	private Disponibilidade dispLivro;

	public Livro(int idLivro, String titulo, String autor, float preco, Disponibilidade dispLivro) {
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.dispLivro = dispLivro;
	}

	public Livro(int idLivro, String titulo, String autor, float preco) {
		this(idLivro, titulo, autor, preco, Disponibilidade.DISPONIVEL);
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Disponibilidade getDispLivro() {
		return dispLivro;
	}

	public void setDisponivel() {
		this.dispLivro = Disponibilidade.DISPONIVEL;
	}

	public void setConsultaLocal() {
		this.dispLivro = Disponibilidade.CONSULTALOCAL;
	}

	public void setEmprestado() {
		this.dispLivro = Disponibilidade.EMPRESTADO;
	}

	public void setDanificado() {
		this.dispLivro = Disponibilidade.DANIFICADO;
	}

	public void setExtraviado() {
		this.dispLivro = Disponibilidade.EXTRAVIADO;
	}

	@Override
	public int compareTo(Livro o) {
		return this.titulo.compareToIgnoreCase(o.getTitulo());
	}
}
