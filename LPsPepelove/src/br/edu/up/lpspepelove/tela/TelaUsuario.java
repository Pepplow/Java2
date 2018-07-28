package br.edu.up.lpspepelove.tela;

import java.io.Console;
import java.util.Scanner;

public class TelaUsuario {
	Scanner sc = new Scanner(System.in);
	
	public void mostrarTelaUsuario() {
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Alterar");
		System.out.println("3 - excluir");
		System.out.println("4 - Listar");
		int opcao = sc.nextInt();
		if (opcao == 1) {
			cadastrarUsuario();
		} else if (opcao == 2) {
			alterarUsuario();
		} else if (opcao == 3) {
			excluirUsuario();
		} else if (opcao == 4) {
			listarUsuario();
		} else {
			System.out.println("comando invalido");
		}
		
	}
	
	public void cadastrarUsuario() {
		System.out.println("Cadastro de Usuários\n");
		
		System.out.println("Digite o nome: ");
		final String nome = sc.next();
		System.out.println("Digite o CPF: ");
		long cpf = sc.nextLong();
		System.out.println("Digite a Idade: ");
		int idade = sc.nextInt();
		System.out.println("Digite o Sexo: ");
		String sexo = sc.next();
		
		System.out.println("\n=========Usuários Cadastrados======");
		System.out.println("Nome: "+nome);
		System.out.println("CPF: "+cpf);
		System.out.println("idade: "+idade);
		System.out.println("Sexo: "+sexo);
	}
	
	public void alterarUsuario() {
		System.out.println("Insira o codigo do usuario ara alterar");
	}
	
	public void excluirUsuario() {
		System.out.println("Insira o codigo do usuario que deseja excluir");
	}
	
	public void listarUsuario() {
		System.out.println("usuarios cadastrados");	
	}

}
