package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtapaDao implements Dao<Etapa>{
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	List<Etapa> etapas = new ArrayList<>();
	
	@Override
	public Etapa get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Etapa> getAllByPMT(long profId, long matId, long turId) { //GET ALL BY PROF, MAT E TURMA
		etapas.clear();
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `etapa` WHERE `professor` = ? "
					+ "AND `materia` = ? AND `turma` = ?");
			stmt.setLong(1, profId);
			stmt.setLong(2, matId);
			stmt.setLong(3, turId);
			rs = stmt.executeQuery();
			
			while(rs.next()) { //coloca etapas 
				etapas.add(new Etapa(rs.getLong(1), rs.getString(2),
					rs.getLong(3), rs.getLong(4), rs.getLong(5)));
				
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return etapas;
	}
	@Override
	public List<Etapa> getAll() {
		etapas.clear();
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `etapa`");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				etapas.add(new Etapa(rs.getLong(1), rs.getString(2),
					rs.getLong(3), rs.getLong(4), rs.getLong(5)));
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return etapas;
	}

	@Override
	public void save(Etapa etp) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("INSERT INTO `etapa` VALUES(?, ?, ?, ?, ?)");
			stmt.setLong(1, etp.getId());
			stmt.setString(2, etp.getNome());
			stmt.setLong(3, etp.getProfId());
			stmt.setLong(4, etp.getMateriaId());
			stmt.setLong(5, etp.getTurmaId());
			stmt.executeUpdate();

			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
	}

	@Override
	public void update(Etapa t, String[] tData) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("UPDATE `etapa` SET `nome` = ? WHERE `idetapa` = ?");
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
	public void delete(Etapa t) {
		// TODO Auto-generated method stub
		
	}

}
