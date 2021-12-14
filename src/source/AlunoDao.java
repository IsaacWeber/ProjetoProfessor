package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class AlunoDao implements Dao<Aluno> {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private List<Aluno> alunos  = new ArrayList<>();
	
	@Override
	public Aluno get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Aluno> getAllByEtapa(long profId, long matId, 
			long turId, long etpId) {
		try {
			con = DriverManager.getConnection(BD.URL, BD.USUARIO, BD.SENHA);
			stmt = con.prepareStatement(
				"SELECT  al.idaluno, am.matricula, al.nome, al.sobrenome, ae.nota, ae.faltas FROM aluno as al"
				+ " INNER JOIN aluno_etapa as ae ON ae.idaluno = al.idaluno AND ae.idetapa = ?"
				+ " INNER JOIN aluno_materia as am ON am.idaluno = al.idaluno AND am.idmateria = ?"); //pega alunos da etapa ? e da materia ?
			stmt.setLong(1, etpId);
			stmt.setLong(2, matId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				alunos.add(new Aluno(rs.getLong(1), rs.getLong(2), rs.getString(3), 
					rs.getString(4), rs.getDouble(5), rs.getLong(6),
					profId, matId, turId, etpId));
			}
			
		}catch(SQLException e) {
			System.err.println(e);
		}
		
		return alunos;
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
