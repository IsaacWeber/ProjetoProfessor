package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao implements Dao<Materia> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private List<Materia> materias = new ArrayList<>();
	
	@Override
	public Materia get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> getAll() {
		materias.clear(); //limpa valores anteriores
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `materia`");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				materias.add(new Materia(
					rs.getLong(1), rs.getString(2), rs.getLong(3)));
			}
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return materias;
	}
	
	public List<Materia> getAllByProfId(long profId) {
		materias.clear(); //limpa valores anteriores
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `materia` as m WHERE m.professor = ?");
			stmt.setLong(1,profId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				materias.add(new Materia(
					rs.getLong(1), rs.getString(2), rs.getLong(3)));
			}
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return materias;
	}
	
	@Override
	public void save(Materia mat) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("INSERT INTO `materia` VALUES(?, ?, ?)");
			stmt.setLong(1, mat.getId());
			stmt.setString(2, mat.getNome());
			stmt.setLong(3, mat.getProfId());
			
			stmt.executeUpdate();

			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
	}

	@Override
	public void update(Materia mat, String[] matData) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("UPDATE `materia` SET `nome` = ? WHERE `idmateria` = ?");
			stmt.setString(1, matData[0]);
			stmt.setLong(2, mat.getId());
			
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
	}

	@Override
	public void delete(Materia t) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Materia> getByProfessorId(long id) {
		materias.clear();
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT *  FROM `materia` WHERE materia.professor = ?");//continue aqui
			stmt.setLong(1, id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				materias.add(new Materia(
					rs.getLong(1), rs.getString(2), rs.getLong(3)));
				
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return materias;
		
	}
}
