package source;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TelaAbas extends JFrame {
	
	private JTabbedPane abas;
	private Professor professorAtual;
	private Materia materiaAtual;
	private Turma turmaAtual;
	private Etapa etapaAtual;
	
	public TelaAbas(Professor prof, Materia mat, Turma tur, Etapa etp) {
		this.abas = new JTabbedPane();
		this.professorAtual = prof;
		this.materiaAtual = mat;
		this.turmaAtual = tur;
		this.etapaAtual = etp;
		
		this.getContentPane().setBackground(DesignApp.corFundo);
		this.setTitle("Gerenciador Escolar - Aluno");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		this.configAbas();
		
		this.setVisible(true);
	}
	
	private void configAbas() {
		abas.addTab("Alunos", null, 
			new AlunoPainel(professorAtual, 
				materiaAtual, turmaAtual, etapaAtual),
			"Tela de Alunos");
		
		abas.addTab("Atividades", null, new JPanel(), "Tela de Atividades");
		
		this.add(abas);
		
	}
	
	
}
