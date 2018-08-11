package br.edu.up.lpspepelove.Dao;

import java.util.ArrayList;

import br.edu.up.lpspepelove.entidade.Usuario;

public class UsuarioDao implements Dao<Usuario> {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static int id = 1;

	public void cadastrar(Usuario u) {
		u.setId(id++);
		usuarios.add(u);
	}

	public void alterar(Usuario u) {

	}

	public void excluir(Usuario u) {
		usuarios.remove(u);
	}

	public ArrayList<Usuario> listar() {
		return usuarios;
	}

	@Override
	public Usuario buscarporId(Integer id) {
		for (Usuario u : usuarios) {
			if (id == u.getId()) {
				return u;
			}
		}
		return null;
	}
}
