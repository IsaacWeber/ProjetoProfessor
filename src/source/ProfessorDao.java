package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfessorDao implements Dao<Professor> {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private List<Professor> professores = new ArrayList<>();
	
	//methods
	@Override
	public Optional<Professor> get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> getAll() {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("SELECT * FROM `professor`");
			rs = stmt.executeQuery();
			
			while(rs.next()) { //percorre o result set
				professores.add(
					new Professor(
						rs.getLong(1), 
						rs.getString(2), 
						rs.getString(3))); //adiciona o professor do BD
				
			}
			
			rs.close(); //fechando conexoes
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
		
		return professores;
	}
	
	@Override
	public void save(Professor p) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement("INSERT INTO `professor` VALUES(?, ?, ?)");
			
			stmt.setLong(1, p.getId());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getSobreNome());
			stmt.executeUpdate();
			
			stmt.close();
			con.close();
		}catch(SQLException e) {
			System.err.println("ERROR:\n" + e);
		}
	}

	@Override
	public void update(Professor p, String[] tData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Professor p) {
		// TODO Auto-generated method stub
		
	}

}
