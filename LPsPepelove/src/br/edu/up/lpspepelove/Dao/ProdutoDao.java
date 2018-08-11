package br.edu.up.lpspepelove.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.edu.up.lpspepelove.entidade.Produto;

public class ProdutoDao implements Dao<Produto> {

	ArrayList<Produto> produtos = new ArrayList<Produto>();


	public void cadastrar(Produto p) throws DaoException {
		if (p.getAlbum() == null || p.getAlbum().equals("")) {
			throw new DaoException("O album precisa de um nome!!");
		}

		// p.setId(id++);
		// produtos.add(p);
		Connection conn = new Conexao().conectar();
		String insert = "insert into produto" 
		+ "(descricao,ano,album,autor,cantor)"
		+ "values" + "(?,?,?,?,?,)";

		try {

			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, p.getDescricao());
			ps.setInt(2, p.getAno());
			ps.setString(3, p.getAlbum());
			ps.setString(4, p.getAutor());
			ps.setString(5, p.getCantor());
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void alterar(Produto p) {
		Connection conn = new Conexao().conectar();
		String update = "update produto set descricao = ?,ano = ?,album = ?,autor = ?,cantor =? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, p.getDescricao());
			ps.setInt(2, p.getAno());
			ps.setString(3, p.getAlbum());
			ps.setString(4, p.getAutor());
			ps.setString(5, p.getCantor());
			ps.setInt(6, p.getId());
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			
		}
	

	public void excluir(Produto p) {
		Connection conn = new Conexao().conectar();
		String delete = "delete from produto where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setInt(1, p.getId());
			ps.execute();		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Produto> listar() {
		try {
			Connection conn = new Conexao().conectar();
			String query = "select id, descricao, ano, album, autor, cantor from produto";
			ResultSet c = conn.prepareStatement(query).executeQuery();
			while (c.next()) {
				Produto p = new Produto();
				p.setId(c.getInt(1));
				p.setDescricao(c.getString(2));
				p.setAno(c.getInt(3));
				p.setAlbum(c.getString(4));
				p.setAutor(c.getString(5));
				p.setCantor(c.getString(6));

				produtos.add(p);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return produtos;
	}

	@Override
	public Produto buscarporId(Integer id) {
		try {
			Connection conn = new Conexao().conectar();
			String querry = "select id,descricao,ano,album,autor,cantor from produto where id = ?";
			PreparedStatement ps = conn.prepareStatement(querry);
			ps.setInt(1, id);
			ResultSet c = ps.executeQuery();
			while (c.next()) {
				Produto p = new Produto();
				p.setId(c.getInt(1));
				p.setDescricao(c.getString(2));
				p.setAno(c.getInt(3));
				p.setAlbum(c.getString(4));
				p.setAutor(c.getString(5));
				p.setCantor(c.getString(6));
				return p;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}		return null;

	}

}