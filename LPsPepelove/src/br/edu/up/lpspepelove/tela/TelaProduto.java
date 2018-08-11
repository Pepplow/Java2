package br.edu.up.lpspepelove.tela;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.lpspepelove.Dao.DaoException;
import br.edu.up.lpspepelove.Dao.ProdutoDao;
import br.edu.up.lpspepelove.entidade.Produto;
import br.edu.up.lpspepelove.entidade.Usuario;

public class TelaProduto {
	Scanner sc = new Scanner(System.in);

	static Produto[] produtos = new Produto[100];
	static long posicao = 0;

	public void mostrarTelaProduto() {

		System.out.println("===============================");
		System.out.println("     Cadastro de Produtos");
		System.out.println("===============================");
		while (true) {
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Alterar");
			System.out.println("3 - excluir");
			System.out.println("4 - Listar");
			System.out.println("0 - Voltar ao Menu Principal");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				cadastrarProduto();
			} else if (opcao == 2) {
				alterarProduto();
			} else if (opcao == 3) {
				excluirProduto();
			} else if (opcao == 4) {
				listarProduto();
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("Comando Invalido!");
			}

		}
	}

	public void cadastrarProduto() {

		Produto p = new Produto();

		System.out.println("=====Cadastro de Produtos=====");

		System.out.println("Digite a Descrição: ");
		p.setDescricao(sc.next());
		System.out.println("Digite o Ano:");
		p.setAno(sc.nextInt());
		System.out.println("Digite o Album: ");
		p.setAlbum(sc.next());
		System.out.println("Digite o Cantor: ");
		p.setCantor(sc.next());
		System.out.println("Digite o Autor: ");
		p.setAutor(sc.next());

		try {
			new ProdutoDao().cadastrar(p);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Erro " + e.getMessage());
		}

	}

	public void alterarProduto() {
		System.out.println("Insira o ID do produto para alterar : ");
		int id = sc.nextInt();

		Produto produto = new ProdutoDao().buscarporId(id);

		if (produto == null) {
			System.out.println("Produto não Encontrado!");
		} else {
			System.out.println("Digite a Descrição: ");
			produto.setDescricao(sc.next());
			System.out.println("Digite o Ano :");
			produto.setAno(sc.nextInt());
			System.out.println("Digite o Album: ");
			produto.setAlbum(sc.next());
			System.out.println("Digite o Cantor: ");
			produto.setCantor(sc.next());
			System.out.println("Digite o Autor: ");
			produto.setAutor(sc.next());
			new ProdutoDao().alterar(produto);
		}
	}

	public void excluirProduto() {
		System.out.println("insira um ID para excluir");
		int id = sc.nextInt();

		Produto produto = new ProdutoDao().buscarporId(id);

		if (produto == null) {
			System.out.println("Produto não encontrado!");
		} else {
			new ProdutoDao().excluir(produto);
			System.out.println("Produto Excluido com Sucesso!");
		}

	}

	public void listarProduto() {
		ArrayList<Produto> produtos = new ProdutoDao().listar();

		System.out.println("=====Produtos Cadastrados=====");
		for (Produto p : produtos) {
			System.out.println("ID: " + p.getId());
			System.out.println("Descrição : " + p.getDescricao());
			System.out.println("Ano : " + p.getAno());
			System.out.println("Album : " + p.getAlbum());
			System.out.println("Cantor : " + p.getCantor());
			System.out.println("Autor: " + p.getAutor());
			System.out.println("===========================");
		}

	}

}
