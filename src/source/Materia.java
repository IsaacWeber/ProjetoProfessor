package source;

public class Materia {
	
	private long id;
	private String nome;
	private long profId;
	
	public Materia(long id, String nome, long profId) {
		this.id = id;
		this.nome = nome;
		this.profId = profId;
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
	
	public long getProfId() {
		return profId;
	}

	public void setProfId(long profId) {
		this.profId = profId;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	

}
