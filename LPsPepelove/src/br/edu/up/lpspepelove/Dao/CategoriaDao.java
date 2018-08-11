package br.edu.up.lpspepelove.Dao;

import java.util.ArrayList;

import br.edu.up.lpspepelove.entidade.Categoria;;

public class CategoriaDao implements Dao<Categoria>{
	static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	static int id = 1;
	public void cadastrar(Categoria c) {
		c.setId(id++);
		categorias.add(c);
	}
	public void alterar(Categoria c) {
		
	}
	public void excluir(Categoria c) {
		categorias.remove(c);
	}
	public ArrayList<Categoria> listar(){
		return categorias;
	}
	@Override
	public Categoria buscarporId(Integer id) {
		for (Categoria c : categorias) {
		if (id == c.getId())
		return c;
		}
		return null;
	}
	 
}