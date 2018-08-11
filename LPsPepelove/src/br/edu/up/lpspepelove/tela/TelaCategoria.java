package br.edu.up.lpspepelove.tela;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.lpspepelove.Dao.CategoriaDao;
import br.edu.up.lpspepelove.entidade.Categoria;

public class TelaCategoria {

	Scanner sc = new Scanner(System.in);

	// criação vetor
	static Categoria[] categorias = new Categoria[100];
	static long posicao = 0;

	public void mostrarTelaCategoria() {
		System.out.println("===============================");
		System.out.println("      Cadastro de Categoria");
		System.out.println("===============================");
		while (true) {
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Alterar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Listar");
			System.out.println("0 - Voltar ao Menu Principal");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				cadastrarCategoria();
			} else if (opcao == 2) {
				alterarCategoria();
			} else if (opcao == 3) {
				excluirCategoria();
			} else if (opcao == 4) {
				listarCategoria();
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("Comando Invalido!");
			}
		}

	}

	public void cadastrarCategoria() {
		Categoria c = new Categoria();

		System.out.println("=====Cadastro de Categorias=====");

		System.out.println("Digite o Genero: ");
		c.setGenero(sc.next());
		System.out.println("Digite o SubGenero: ");
		c.setSubgenero(sc.next());

		new CategoriaDao().cadastrar(c);

	}

	public void alterarCategoria() {
		System.out.println("Insira o Codigo da Categoria : ");
		int id = sc.nextInt();
		Categoria categoria = new CategoriaDao().buscarporId(id);


		if (categoria == null) {
			System.out.println("Categoria nao encontrada!");
		} else {

			System.out.println("Digite o Genero: ");
			categoria.setGenero(sc.next());
			System.out.println("Digite o SubGenero: ");
			categoria.setSubgenero(sc.next());
			new CategoriaDao().alterar(categoria);

		}
	}

	public void excluirCategoria() {
		System.out.println("Insira o Codigo da Categoria");
		int id = sc.nextInt();
		Categoria categoria = new CategoriaDao().buscarporId(id);

		
		if (categoria == null) {

			System.out.println("Categoria nao encontrada!");
			
		} else {
			new CategoriaDao().excluir(categoria);
			System.out.println("Categoria Deletada com Sucesso!");
		}
	}

	

	public void listarCategoria() {
		ArrayList<Categoria> categorias = new CategoriaDao().listar();
		
		System.out.println("=======Categorias Cadastradas=======");
		for (Categoria c : categorias) {
			
			System.out.println("ID: " + c.getId());
			System.out.println("Genero: " + c.getGenero());
			System.out.println("SubGenero: " + c.getSubgenero());
			System.out.println("=============================");

		}

	}
}
