package source;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import source.EtapaTela.CadastrarEtapaFrame;


public class AlunoPainel extends JPanel {
	
	private JLabel tituloLabel;
	private Box boxGeral, 
		boxTitulo, 
		boxConteudo,
		boxTblTitulo,
		boxBotao;
	private JLabel tabelaTitulo;
	private JTable tabelaAluno;
	private DefaultTableModel tabelaModelo;
	private JScrollPane tabelaRolagem;
	private JButton cadastrarBtn, salvarBtn, acessarBtn, encerrarBtn;
	private Professor professorAtual;
	private Materia materiaAtual;
	private Turma turmaAtual;
	private Etapa etapaAtual;
	private AlunoDao aDao;
	private JFrame cadFrame;
	
	public AlunoPainel(Professor prof, Materia mat, Turma tur, Etapa etp) {
		this.professorAtual = prof;
		this.materiaAtual = mat;
		this.turmaAtual = tur;
		this.etapaAtual = etp;
		this.aDao = new AlunoDao();
//		this.getContentPane().setBackground(DesignApp.corFundo);
//		this.setTitle("Gerenciador Escolar - Alunos");
//		this.setSize(800, 600);
//		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		this.setLocationRelativeTo(null);
//		this.setExtendedState(MAXIMIZED_BOTH);
		setLayout(new BorderLayout());
		setBackground(DesignApp.corFundo);
		configPaineis();
//		
//		this.setVisible(true);
	}
	
	
	private void configPaineis() {
		boxGeral = Box.createVerticalBox();	
		
		boxTitulo = Box.createHorizontalBox();
		tituloLabel = new JLabel("Gerenciador Escolar  ");//espacos colocados porque cortam a ultima letra
		tituloLabel.setFont(
			new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 60));
		boxTitulo.add(tituloLabel);
		
		boxConteudo = Box.createVerticalBox();
		boxTblTitulo = Box.createHorizontalBox();
		tabelaTitulo = new JLabel("Alunos");
		tabelaTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		tabelaModelo = new DefaultTableModel(new Object[] {"N°", "Matrícula", "Aluno", "Nota", "Faltas"}, 0);
		tabelaAluno = new JTable(tabelaModelo);
		tabelaAluno.getTableHeader().setFont(DesignApp.fonteMedia);
		tabelaAluno.setFont(DesignApp.fonteMedia);

		List<Aluno> ets = aDao.getAllByEtapa(professorAtual.getId(),
				materiaAtual.getId(), turmaAtual.getId(), etapaAtual.getId());
		for(int i = 0; i < ets.size(); ++i) {
			tabelaModelo.addRow(new Object[] {i+1, ets.get(i).getMatricula(), 
				ets.get(i), ets.get(i).getNota(),ets.get(i).getFaltas()});
		}
		
		tabelaAluno.setRowHeight(30); 
		TableColumnModel tcm = tabelaAluno.getColumnModel();
		tcm.getColumn(1).setPreferredWidth(10);
		
		tabelaRolagem = new JScrollPane(tabelaAluno,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		boxConteudo.add(Box.createVerticalStrut(50));
		boxTblTitulo.add(tabelaTitulo); //adiciona titulo da tabela
		boxConteudo.add(boxTblTitulo);
		boxConteudo.add(Box.createVerticalStrut(20));  
		boxConteudo.add(tabelaRolagem);
		
		boxBotao = Box.createHorizontalBox();
		cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.setFont(DesignApp.fonteMedia);
		cadastrarBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(cadFrame == null) { //se o frame nao estiver instanciado
							cadFrame = null;//put frame here...
							
							cadFrame.addWindowListener(
								new WindowAdapter() {
								
								@Override
								public void windowClosed(WindowEvent e) {
									cadFrame = null; 
								}

							});
							
						}else { //se esta instanciada
							cadFrame.requestFocus(); //foca na tela se tiver aberto
							cadFrame.setExtendedState(JFrame.NORMAL); //coloca no tamanho normal se tiver minimizado
						}
					}
				}
			);
		
		salvarBtn = new JButton("Salvar");
		salvarBtn.setFont(DesignApp.fonteMedia);
		acessarBtn = new JButton("Acessar");
		acessarBtn.setFont(DesignApp.fonteMedia);
		encerrarBtn = new JButton("Encerrar Aulas");
		encerrarBtn.setFont(DesignApp.fonteMedia);
		
		boxBotao.add(Box.createHorizontalGlue());
		boxBotao.add(cadastrarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(salvarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(acessarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(encerrarBtn);
		boxBotao.add(Box.createHorizontalStrut(50));
		
		boxConteudo.add(Box.createHorizontalStrut(50));
		boxConteudo.add(boxBotao);
		
		boxGeral.add(boxTitulo);
		boxGeral.add(boxConteudo);

		this.add(boxGeral);
	}
	

}
