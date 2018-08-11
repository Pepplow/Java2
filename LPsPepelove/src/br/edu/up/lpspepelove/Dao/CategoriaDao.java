package br.edu.up.lpspepelove.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.edu.up.lpspepelove.entidade.Categoria;


public class CategoriaDao implements Dao<Categoria> {
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();

	public void cadastrar(Categoria c) {
		//c.setId(id++);
		//categorias.add(c);
		Connection conn = new Conexao().conectar();
		String insert = "insert into categoria"
				+ " (genero, subgenero)"
				+ "values" + "(?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, c.getGenero());
			ps.setString(2, c.getSubgenero());
			ps.execute();			
		} catch (Exception ex ){
			ex.printStackTrace();
		}
	}

	public void alterar(Categoria c) {
		Connection conn = new Conexao().conectar();
		String update = "update categoria set genero = ?,subgenero = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, c.getGenero());
			ps.setString(2, c.getSubgenero());
			ps.setInt(3, c.getId());
			ps.execute();
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
	}

	public void excluir(Categoria c) {
		Connection conn = new Conexao().conectar();
		String delete = "delete from categoria where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setInt(1, c.getId());
			ps.execute();		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Categoria> listar() {
		try {
			Connection conn = new Conexao().conectar();
			String querry = "select id,genero,subgenero from categoria";
			ResultSet c = conn.prepareStatement(querry).executeQuery();
			while (c.next()) {
				Categoria ca = new Categoria();
				ca.setId(c.getInt(1));
				ca.setGenero(c.getString(2));
				ca.setSubgenero(c.getString(3));
				
				categorias.add(ca);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		return categorias;
	}

	@Override
	public Categoria buscarporId(Integer id) {
		try {
			Connection conn = new Conexao().conectar();
			String query = "select id,genero,subgenero from categoria where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet c = ps.executeQuery();
			while (c.next()) {
				Categoria ca = new Categoria();
				ca.setId(c.getInt(1));
				ca.setGenero(c.getString(2));
				ca.setSubgenero(c.getString(3));
				return ca;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}		return null;
	}

}