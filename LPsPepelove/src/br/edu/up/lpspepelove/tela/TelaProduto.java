package br.edu.up.lpspepelove.tela;

import java.util.Scanner;

public class TelaProduto {
	Scanner sc = new Scanner(System.in);
	
	public void mostrarTelaProduto() {
	System.out.println("----Cadastro de Produtos----");
	
	System.out.println("1 - Cadastrar");
	System.out.println("2 - Alterar");
	System.out.println("3 - excluir");
	System.out.println("4 - Listar");
	int opcao = sc.nextInt();
	if (opcao == 1) {
		cadastrarProduto();
	} else if (opcao == 2) {
		alterarProduto();
	} else if (opcao == 3) {
		excluirProduto();
	} else if (opcao == 4) {
		listarProduto();
	} else {
		System.out.println("comando invalido");
	}
	}

	public void cadastrarProduto() {
	
        System.out.println("Digite a Descrição: ");
		String descricao = sc.next();
		System.out.println("Digite o Ano :");
		int ano = sc.nextInt();
		System.out.println("Digite o Album: ");
		String album = sc.next();
		System.out.println("Digite o Ca2ntor: ");
		String cantor = sc.next();
		System.out.println("Digite o Autor: ");
		String autor = sc.next();
		
		System.out.println("====Produtos Cadastrados====");
		System.out.println("Descrição: "+descricao);
		System.out.println("Ano : "+ano);
		System.out.println("Album: "+album);
		System.out.println("Cantor : "+cantor);
		System.out.println("Autor : "+autor);
	}
	public void alterarProduto() {
		System.out.println("Insira o ID do produto para alterar");
	}
	public void excluirProduto() {
		System.out.println("insira um ID para excluir");
	}
	public void listarProduto() {
		System.out.println("1123213");
	}
		
		
		
	}

