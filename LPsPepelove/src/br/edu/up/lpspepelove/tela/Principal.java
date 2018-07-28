package br.edu.up.lpspepelove.tela;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		System.out.println("-------------------Bem Vindo ao LPS PEPELOVE!------------------");
	
	Scanner sc = new Scanner(System.in);
	while(true) {
	
	System.out.println("Pressione 1 para acessar tela de usuario");
	System.out.println("Pressione 2 para acessar tela de produto");
	System.out.println("Pressione 3 para acessar tela de categoria");
	System.out.println("digite 9 para sair");
	int opcao = sc.nextInt();
	
	if (opcao == 1 ) {
		TelaUsuario telausuario = new TelaUsuario();
		telausuario.mostrarTelaUsuario();
	} else if (opcao == 2){
		TelaProduto telaproduto = new TelaProduto();
		telaproduto.mostrarTelaProduto();
	} else if (opcao == 3){
		TelaCategoria telacategoria = new TelaCategoria();
		telacategoria.mostrarTelaCategoria();
	}else if (opcao == 9)  {
		break;
		
	} else {
		System.out.println("Opção invalida!!");
	}
	
	}
		
	
	}
}
