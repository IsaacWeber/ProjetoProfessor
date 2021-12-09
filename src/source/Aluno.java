package source;

public class Aluno {
	
	private long id;
	private String nome;
	private String sobreNome;
	
	public Aluno(long id, String nome, String sobreNome) {
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
