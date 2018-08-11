package br.edu.up.lpspepelove.Dao;

import java.util.ArrayList;

import br.edu.up.lpspepelove.entidade.Produto;

public class ProdutoDao implements Dao<Produto> {
	static ArrayList<Produto> produtos = new ArrayList<Produto>();
	static int id = 1;

	public void cadastrar(Produto p) throws DaoException {
		if (p.getAlbum() == null || p.getAlbum().equals("")) {
			throw new DaoException("O album precisa de um nome!!");
		}
		p.setId(id++);
		produtos.add(p);
	}

	public void alterar(Produto p) {

	}

	public void excluir(Produto p) {
		produtos.remove(p);
	}

	public ArrayList<Produto> listar() {
		return produtos;
	}

	@Override
	public Produto buscarporId(Integer id) {
		for (Produto p : produtos) {
			if (id == p.getId()) {
				return p;
			}
		}
		return null;

	}

}