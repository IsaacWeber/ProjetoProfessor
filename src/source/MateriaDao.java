package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MateriaDao implements Dao<Materia> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	
	@Override
	public Materia get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void save(Materia t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Materia t, String[] tData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Materia t) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Materia> getByProfessorId(int id) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("insert into");//continue aqui
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return null;
	}
}
