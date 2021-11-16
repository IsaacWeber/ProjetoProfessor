package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Professor {
	
	private long id;
	private String nome;
	private String sobreNome;
	
	public Professor(long id, String nome, String sobreNome) {
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
}
