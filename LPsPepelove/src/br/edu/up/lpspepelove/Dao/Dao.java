package br.edu.up.lpspepelove.Dao;

import java.util.ArrayList;

public interface Dao<T> {
	public void cadastrar(T t) throws DaoException;
	
	public void alterar(T t);
	
	public void excluir(T t);
	
	public ArrayList<T> listar();
	
	public T buscarporId(Integer id);
}
