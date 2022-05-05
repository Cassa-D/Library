package Emprestimo;
import java.util.ArrayList;

public class ListaEmprestimos {

	private final ArrayList<Emprestimo> alEmprestimos;

	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}
	
	public void addEmprestimo(int idAmigo, int idLivro) {
		Emprestimo emprestimo = new Emprestimo(idAmigo, idLivro);

		alEmprestimos.add(emprestimo);
	}

	public int getSize() {
		return alEmprestimos.size();
	}

	public Emprestimo getEmprestimo(int i) {
		return alEmprestimos.get(i);
	}
}
