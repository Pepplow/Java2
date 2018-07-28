package br.edu.up.lpspepelove.tela;

import java.util.Scanner;

public class TelaCategoria {

	Scanner sc = new Scanner(System.in);
	public void mostrarTelaCategoria() {
		System.out.println("Cadastro de Categoria");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Alterar");
		System.out.println("3 - Excluir");
		System.out.println("4 - Listar");
		int opcao = sc.nextInt();
		if(opcao == 1) {
			cadastrarCategoria();
		} else if(opcao == 2) {
			alterarCategoria();
		} else if(opcao == 3) {
			excluirCategoria();
		} else if(opcao == 4) {
			listarCategoria();
		} else {
			System.out.println("Comando invalido");
		}

		
	}
	public void cadastrarCategoria() {
		System.out.println("Digite o Genero: ");
		String genero = sc.next();
		System.out.println("Digite o SubGenero: ");
		String subgenero = sc.next();
		
		System.out.println("=======Categoria Cadastrada=======");
		System.out.println("Genero: " + genero);
		System.out.println("Subgênero :"+ subgenero);
	}
	public void alterarCategoria() {
		System.out.println("Insira o Codigo da Categoria");
	}
	public void excluirCategoria() {
		System.out.println("Insira o Codigo da Categoria");
	}
	public void listarCategoria() {
		System.out.println("Categorias cadastrados");
	}
}
