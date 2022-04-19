package Emprestimo;
import java.time.LocalDate;

public class Emprestimo {
	private final int idAmigo;
	private final int idLivro;
	private final LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	// para a equipe PENSAR nesta repetição de informação, pois pode-se obter os objetos pelo IDs
	// caso mantenha a base do ArrayList organizada fisicamente, pode usar o Id como chave de acesso
	// caso contrário, ou como opção extra para acesso, pode manter a referência ao objeto
	// private Livro livro;
	// private Amigo amigo;

	public Emprestimo(int idAmigo, int idLivro, LocalDate dataEmprestimo) {
		this.idAmigo = idAmigo;
		this.idLivro = idLivro;
		this.dataEmprestimo = dataEmprestimo;
	}

	public Emprestimo(int idAmigo, int idLivro) {
		this(idAmigo, idLivro, LocalDate.now());
	}

	public int getIdLivro() {
		return this.idLivro;
	}

	public int getIdAmigo() {
		return idAmigo;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public boolean hasBeenReturned() {
		return this.dataDevolucao != null;
	}

	public void returnLivro() {
		this.dataDevolucao = LocalDate.now();
	}
}
