package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class TurmaDao implements Dao<Turma> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private List<Turma> turmas = new ArrayList<>();
	
	@Override
	public Turma get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Turma> getAll() {
		turmas.clear();
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `turma`");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				turmas.add(new Turma(rs.getLong(1), rs.getString(2),
					rs.getLong(3), rs.getLong(4)));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return turmas;
	}
	
	public List<Turma> getAllByProfMat(long profId, long matId) {
		turmas.clear();
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `turma` WHERE `professor` = ? and `materia` = ?");
			stmt.setLong(1, profId);
			stmt.setLong(2, matId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				turmas.add(new Turma(rs.getLong(1), rs.getString(2),
					rs.getLong(3), rs.getLong(4)));
				
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return turmas;
	}
	
	@Override
	public void save(Turma t) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("INSERT INTO `turma` VALUES(?, ?, ?, ?)");
			stmt.setLong(1, t.getId());
			stmt.setString(2, t.getNome());
			stmt.setLong(3, t.getProfId());
			stmt.setLong(4, t.getMateriaId());
			
			stmt.executeUpdate();

			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
	}

	@Override
	public void update(Turma t, String[] tData) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("UPDATE `turma` SET `nome` = ? WHERE `idturma` = ?");
			stmt.setString(1, tData[0]);
			stmt.setLong(2, t.getId());
			
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
	}

	@Override
	public void delete(Turma t) {
		// TODO Auto-generated method stub
		
	}

	
	
}
