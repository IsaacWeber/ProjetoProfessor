package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BD {

	public static final String URL = 
		"jdbc:mysql://localhost/escola?useTimezone=true&serverTimezone=UTC";
	public static final String USUARIO = "root";
	public static final String SENHA = "scientist";
	
//	private Connection conexao;
//	
//	public BD() {
//		try {
//			conexao = DriverManager.getConnection(url, usuario, senha);
//			System.out.println("connected");
//			Statement stmt = conexao.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM `professor`");
//			
//			System.out.println("Professores\n");
//			while(rs.next()) {
//				System.out.printf("%s %s %s\n",
//					String.valueOf(rs.getObject(1)),
//					String.valueOf(rs.getObject(2)),
//					String.valueOf(rs.getObject(3)));
//			}
//			
//			rs.close();
//			stmt.close();
//		}catch(Exception e) {
//			System.err.println("ERROR: \n" + e);
//		}
//	
//	}
//	
}
