package Principal;

import java.util.Locale;
import java.util.Scanner;

import Amigo.*;
import Emprestimo.*;
import Biblioteca.*;


enum LibraryList { ALPHABETICALLY, INDEX }

public class Principal {
	private static final Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static final ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static final ListaAmigos amigos = new ListaAmigos();
	private static final Scanner scanner = new Scanner(System.in);

	public static void printChoiceErrorMessage(int choice) {
		System.out.println("Ops! Não tem nenhuma opção " + choice + "!");
	}

	public static void populate() {
		int harryPoty1 = bib.addLivro("Harry Poty", "RR", 200);
		bib.addLivro("Java para Iniciantes", "Café", 150);
		bib.addLivro("Harry Poty 2", "RR", 200);
		int javaIt = bib.addLivro("Java para Interessados", "Café", 110.50f);
		int harryPoty4 = bib.addLivro("Harry Poty 4", "RR", 200);
		int javaA = bib.addLivro("Java Avançado", "Café", 235);
		int harryPoty5 = bib.addLivro("Harry Poty 5", "RR", 200);
		int harryPoty3 = bib.addLivro("Harry Poty 3", "RR", 200);

		amigos.addAmigo("Jão", "9999999");
		amigos.addAmigo("Joanina", "9999999");
		amigos.addAmigo("Creber", "9999999");
		amigos.addAmigo("Cassiuldes", "9999999");
		amigos.addAmigo("Cassildes", "9999999");
		amigos.addAmigo("Kassildes", "9999999");
		amigos.addAmigo("Predo", "9999999");
		amigos.addAmigo("Marilane", "9999999");
		amigos.addAmigo("Juquinha", "9999999");
		amigos.addAmigo("Zé", "9999999");

		// Joanina
		emprestimos.addEmprestimo(2, harryPoty3);
		bib.getLivro(harryPoty3).setEmprestado();
		// Zé
		emprestimos.addEmprestimo(10, javaA);
		bib.getLivro(javaA).setEmprestado();
		// Predo
		emprestimos.addEmprestimo(7, javaIt);
		bib.getLivro(javaIt).setEmprestado();
		// Creber
		emprestimos.addEmprestimo(3, harryPoty1);
		bib.getLivro(harryPoty1).setEmprestado();
		// Joanina
		emprestimos.addEmprestimo(2, harryPoty4);
		bib.getLivro(harryPoty4).setEmprestado();

		emprestimos.getEmprestimo(0).returnLivro();
		bib.getLivro(harryPoty3).setDisponivel();

		// Cassildes
		emprestimos.addEmprestimo(5, harryPoty3);
		bib.getLivro(harryPoty3).setEmprestado();

		emprestimos.getEmprestimo(5).returnLivro();
		bib.getLivro(harryPoty3).setDisponivel();

		bib.getLivro(harryPoty3).setDanificado();
		bib.getLivro(harryPoty5).setConsultaLocal();
		bib.getLivro(javaA).setExtraviado();
	}

	public static void main(String[] args) {
		boolean stop = false;

		populate();

		while (!stop) {
			// Menu
			System.out.println("Menu");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar...");
			System.out.println("2 - Emprestar livro");
			System.out.println("3 - Devolver livro");
			System.out.println("4 - Listar...");
			System.out.println("5 - Alterar estado do livro");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 0 -> {
					System.out.println("-- Saindo...");
					stop = true;
				}
				case 1 -> {
					System.out.println("-- Cadastrar");
					System.out.println("0 - Cancelar");
					System.out.println("1 - Livro");
					System.out.println("2 - Amigo");

					choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 0 -> {} // Mesma coisa que "continue;"
						case 1 -> {
							System.out.println("-- -- Registrar livro");
							registerBook();
						}
						case 2 -> {
							System.out.println("-- -- Registrar amigo");
							registerFriend();
						}
						default -> printChoiceErrorMessage(choice);
					}
				}
				case 2 -> {
					System.out.println("-- Emprestar livro");
					borrowBook();
				}
				case 3 -> {
					System.out.println("-- Devolver livro");
					returnBook();
				}
				case 4 -> {
					System.out.println("-- Listar");
					System.out.println("0 - Cancelar");
					System.out.println("1 - Emprestimos atuais");
					System.out.println("2 - História de emprestimos");
					System.out.println("3 - Toda a biblioteca");

					choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 0 -> {} // Mesma coisa que "continue;"
						case 1 -> {
							System.out.println("-- -- Listar empréstimos");
							listLoans();
						}
						case 2 -> {
							System.out.println("-- -- Listar história de empréstimos");
							listLoanHistory();
						}
						case 3 -> {
							System.out.println("-- -- Listar biblioteca");
							System.out.println("0 - Cancelar");
							System.out.println("1 - Alfabeticamente");
							System.out.println("2 - Por index");

							choice = scanner.nextInt();
							scanner.nextLine();

							switch (choice) {
								case 0 -> {} // Mesma coisa que "continue;"
								case 1 -> {
									System.out.println("-- -- -- Listar biblioteca alfabeticamente");
									listLibrary(LibraryList.ALPHABETICALLY);
								}
								case 2 -> {
									System.out.println("-- -- -- Listar biblioteca por index");
									listLibrary(LibraryList.INDEX);
								}
								default -> printChoiceErrorMessage(choice);
							}
						}
						default -> printChoiceErrorMessage(choice);
					}
				}
				case 5 -> {
					System.out.println("-- Alterar estado");
					changeBookState();
				}
				default -> printChoiceErrorMessage(choice);
			}
			System.out.println("#------------------------------------------");
		}
	}

	public static Livro requestBook() {
		System.out.println("Informe o código identificador do livro:");

		int idLivro = scanner.nextInt();
		scanner.nextLine();

		return bib.getLivro(idLivro);
	}

	public static void registerBook() {
		System.out.println("Favor insira os dados corretamente");

		System.out.println("* Titulo:");
		String titulo = scanner.nextLine();

		System.out.println("* Autor:");
		String autor = scanner.nextLine();

		System.out.println("* Preço:");
		float preco = scanner.nextFloat();
		scanner.nextLine();

		int idLivro = bib.addLivro(titulo, autor, preco);

		System.out.println("Livro com id " + idLivro + " cadastrado corretamente!");
	}

	public static void registerFriend() {
		System.out.println("Favor insira os dados corretamente");

		System.out.println("* Nome:");
		String nome = scanner.nextLine();

		System.out.println("* Telefone:");
		String celular = scanner.nextLine();

		int idAmigo = amigos.addAmigo(nome, celular);

		System.out.println("Amigo " + nome + " com id " + idAmigo + " cadastrado corretamente!");
	}

	public static void borrowBook() {
		Livro livro = requestBook();

		// TODO - verificar se o livro é disponível

		System.out.println("Informe o nome do amigo:");
		String nome = scanner.nextLine();
		
		Amigo amigoFound = null;

		for (int i = 1; i <= amigos.getListaAmigosSize(); i++) {
			Amigo amigo = amigos.getAmigo(i);
			if (amigo.getNome().toUpperCase().contains(nome.toUpperCase())) {
				System.out.println("Amigo com nome " + amigo.getNome() + " encontrado!");
				System.out.println("É o amigo correto? <S/N>");

				char choice = scanner.nextLine().toUpperCase().charAt(0);

				if (choice == 'S') {
					amigoFound = amigo;
					break;
				} else if (choice != 'N') {
					System.out.println("Opa algo deu errado!");
					i--;
				}
			}
		}

		if (amigoFound == null) {
			System.out.println("Não foi encontrado nenhum amigo com o nome " + nome + "!");
			return;
		}

		int idAmigo = amigoFound.getIdAmigo();

		emprestimos.addEmprestimo(idAmigo, livro.getIdLivro());
		livro.setEmprestado();

		System.out.println("Emprestimo criado!");
	}

	public static void returnBook() {
		Livro livro = requestBook();

		// TODO - verificar se não encontrar empréstimo

		for (int i = 0; i < emprestimos.getSize(); i++) {
			Emprestimo emprestimo = emprestimos.getEmprestimo(i);

			if (
				emprestimo.getIdLivro() == livro.getIdLivro() &&
				!emprestimo.hasBeenReturned() &&
				livro.getDispLivro() == Disponibilidade.EMPRESTADO
			) {
				emprestimo.returnLivro();
				livro.setDisponivel();
				break;
			}
		}

		System.out.println("Livro " + livro.getTitulo() + " devolvido!");
	}

	public static void listLoans() {
		System.out.println("Lista de emprestimos:");
		int quantEmprestimos = 0;

		for (int i = 0; i < emprestimos.getSize(); i++) {
			Emprestimo emprestimo = emprestimos.getEmprestimo(i);
			Livro livro = bib.getLivro(emprestimo.getIdLivro());
			Amigo amigo = amigos.getAmigo(emprestimo.getIdAmigo());

			if (!emprestimo.hasBeenReturned() && livro.getDispLivro() == Disponibilidade.EMPRESTADO) {
				quantEmprestimos++;

				System.out.println("#------------------------------------------");
				System.out.println("** Livro " + livro.getTitulo());
				System.out.println("Emprestado para: " + amigo.getNome());
				System.out.println("Na data: " + emprestimo.getDataEmprestimo());
			}
		}

		if (quantEmprestimos == 0) {
			System.out.println("Opa! Não foi encontrado nenhum emprestimo.");
		}
	}

	public static void listLoanHistory() {
		Livro livro = requestBook();

		// TODO - verificar se não encontrar empréstimo

		System.out.println("** Livro " + livro.getTitulo());

		Amigo amigoAtual = null;
		Emprestimo emprestimoAtual = null;

		for (int i = 0; i < emprestimos.getSize(); i++) {
			Emprestimo emprestimo = emprestimos.getEmprestimo(i);

			if (emprestimo.getIdLivro() == livro.getIdLivro()) {
				Amigo amigo = amigos.getAmigo(emprestimo.getIdAmigo());

				System.out.println("#------------------------------------------");
				if (emprestimo.hasBeenReturned()) {
					System.out.println("Foi emprestado para: " + amigo.getNome());
					System.out.println("Na data: " + emprestimo.getDataEmprestimo());
					System.out.println("Devolvido na data: " + emprestimo.getDataDevolucao());
				} else if (livro.getDispLivro() == Disponibilidade.EMPRESTADO || livro.getDispLivro() == Disponibilidade.EXTRAVIADO) {
					amigoAtual = amigo;
					emprestimoAtual = emprestimo;
				}
			}
		}

		if (amigoAtual != null) {
			System.out.println("Atualmente emprestado para: " + amigoAtual.getNome());
			System.out.println("Na data: " + emprestimoAtual.getDataEmprestimo());
		}

		if (livro.getDispLivro() == Disponibilidade.EXTRAVIADO) {
			System.out.println("Livro foi extraviado!");
		}
	}

	public static void listLibrary(LibraryList lList) {
		Biblioteca orderedBib = bib;
		if (lList == LibraryList.ALPHABETICALLY) {
			orderedBib = bib.getTitleOrderedBib();
		}

		System.out.println("Lista de livros na biblioteca:");

		System.out.println("#------------------------------------------");

		for (int i = 1; i <= orderedBib.getSize(); i++) {
			Livro livro = orderedBib.getLivro(i);

			System.out.println("** Livro " + livro.getTitulo());
			System.out.println("Disponibilidade: " + livro.getDispLivro());
			System.out.println("Preço pago: R$" + livro.getPreco());

			System.out.println("#------------------------------------------");
		}

		System.out.println("-- Quantidade de livros: " + orderedBib.getSize());
		System.out.println("-- Total investido: R$" + orderedBib.getInvestimento());
	}

	public static void changeBookState() {
		Livro livro = requestBook();

		// TODO - adicionar print do título do livro
		// TODO - adicionar lógica para remover "Consulta local" da lista de possibilidades

		System.out.println("Estado do livro: " + livro.getDispLivro());
		System.out.println("Mandar para que estado?");
		System.out.println("0 - Cancelar");
		System.out.println("1 - Consulta local");
		System.out.println("2 - Danificado");
		System.out.println("3 - Extraviado");

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
			case 1:
				if (livro.getDispLivro() == Disponibilidade.EMPRESTADO) {
					System.out.println("Opa! Não é possível mandar para consulta local um livro que foi emprestado!");
					return;
				}
				livro.setConsultaLocal();
				break;
			case 2:
				livro.setDanificado();
				break;
			case 3:
				livro.setExtraviado();
				break;
			case 0:
			default:
				return;
		}

		System.out.println("Troca de estado concluido!");
	}
}
