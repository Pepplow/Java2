package br.edu.up.lpspepelove.tela;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.up.lpspepelove.Dao.UsuarioDao;
import br.edu.up.lpspepelove.entidade.Usuario;

public class TelaUsuario {
	Scanner sc = new Scanner(System.in);
	// vetor de usuario sedo criado
	static Usuario[] usuarios = new Usuario[100];
	static long posicao = 0;

	public void mostrarTelaUsuario() {
		while (true) {
			System.out.println("===============================");
			System.out.println("      Cadastro de Usuario");
			System.out.println("===============================");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Alterar");
			System.out.println("3 - excluir");
			System.out.println("4 - Listar");
			System.out.println("0 - Voltar ao Menu Principal");
			int opcao = sc.nextInt();
			if (opcao == 1) {
				cadastrarUsuario();
			} else if (opcao == 2) {
				alterarUsuario();
			} else if (opcao == 3) {
				excluirUsuario();
			} else if (opcao == 4) {
				listarUsuario();
			} else if (opcao == 0) {
				break;
			} else {
				System.out.println("Comando Invalido");
			}
		}
	}

	public void cadastrarUsuario() {
		Usuario u = new Usuario();

		System.out.println("Cadastro de Usuários\n");

		System.out.println("Digite o nome: ");
		u.setNome(sc.next());
		System.out.println("Digite o CPF: ");
		u.setCpf(sc.nextLong());
		System.out.println("Digite a Idade: ");
		u.setIdade(sc.nextInt());
		System.out.println("Digite o Sexo: ");
		u.setSexo(sc.next());

		new UsuarioDao().cadastrar(u);

	}

	public void alterarUsuario() {
		System.out.println("Insira o codigo do usuario ara alterar");
		int id = sc.nextInt();
		Usuario usuario = new UsuarioDao().buscarporId(id);

		if (usuario == null) {
			System.out.println("usuario nao encontrado!");
		} else {
			System.out.println("Digite o nome: ");
			usuario.setNome(sc.next());
			System.out.println("Digite o CPF: ");
			usuario.setCpf(sc.nextLong());
			System.out.println("Digite a Idade: ");
			usuario.setIdade(sc.nextInt());
			System.out.println("Digite o Sexo: ");
			usuario.setSexo(sc.next());
		}
	}

	public void excluirUsuario() {
		System.out.println("Insira o codigo do usuario que deseja excluir");
		int id = sc.nextInt();
		Usuario usuario = new UsuarioDao().buscarporId(id);

		if (usuario == null) {
			System.out.println("Usuario Não Encontrado!");

		} else {
			new UsuarioDao().excluir(usuario);
			System.out.println("Usuario Deletado!");
		}

	}

	public void listarUsuario() {
		ArrayList<Usuario> usuarios = new UsuarioDao().listar();
		
		System.out.println("=====Usuarios Cadastrados=====");
		for (Usuario u : usuarios) {
			System.out.println("ID: " + u.getId());
			System.out.println("Nome: " + u.getNome());
			System.out.println("CPF: " + u.getCpf());
			System.out.println("Idade: " + u.getIdade());
			System.out.println("Sexo: " + u.getSexo());
			System.out.println("===========================");
		}
	}

}
