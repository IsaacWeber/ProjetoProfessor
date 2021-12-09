package source;

public class Etapa {

	private long id;
	private String nome;
	private long profId;
	private long materiaId;
	private long turmaId;
	
	public Etapa(long id, String nome, long prof, long mat, long tur) {
		this.id = id;
		this.nome = nome;
		this.profId = prof;
		this.materiaId = mat;
		this.turmaId = tur;
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

	public long getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(long turmaId) {
		this.turmaId = turmaId;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}
