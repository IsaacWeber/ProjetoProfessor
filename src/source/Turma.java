package source;

public class Turma {
	private long id;
	private String nome;
	private long profId;
	private long materiaId;
	
	public Turma(long id, String nome, long prof, long mat) {
		this.id = id;
		this.nome = nome;
		this.profId = prof;
		this.materiaId = mat;
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

	public long getMateriaId() {
		return materiaId;
	}

	public void setMateriaId(long materiaId) {
		this.materiaId = materiaId;
	}

	@Override
	public String toString() {
		return nome;
	}

}
