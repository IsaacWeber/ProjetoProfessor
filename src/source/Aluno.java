package source;

public class Aluno {
	
	private long id;
	private String nome;
	private String sobreNome;
	private double nota;
	private long faltas;
	private long matricula;
	private long profId;
	private long materiaId;
	private long turmaId;
	private long etapaId;
	
	public Aluno(long id, long matr, String nome, String sobreNome, 
			double n, long f, long prof, long mat, long tur, long etp) { //para instanciar na entrada da tela
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.nota = n;
		this.faltas = f;
		this.matricula = matr;
		this.profId = prof;
		this.materiaId = mat;
		this.turmaId = tur;
		this.etapaId = etp;
	}
	
//	public Aluno(long id, String nome, String sobreNome, 
//			double n, long f) { //para instancioar no DAO
//		this.id = id;
//		this.nome = nome;
//		this.sobreNome = sobreNome;
//		this.nota = n;
//		this.faltas = f;
//	}
	
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

	public long getEtapaId() {
		return etapaId;
	}

	public void setEtapaId(long etapaId) {
		this.etapaId = etapaId;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public long getFaltas() {
		return faltas;
	}

	public void setFaltas(long faltas) {
		this.faltas = faltas;
	}
	
	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return nome + " " + sobreNome;
	}
	
}
