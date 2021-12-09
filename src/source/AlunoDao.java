package source;

import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AlunoDao implements Dao<Aluno> {
	private List<Aluno> alunos  = new ArrayList<>();
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	@Override
	public Aluno get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Aluno t, String[] tData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Aluno t) {
		// TODO Auto-generated method stub
		
	}

	
	
}
