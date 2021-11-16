package source;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class AlunoTela extends JFrame {
	
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
	
	public AlunoTela() {
		this.getContentPane().setBackground(DesignApp.corFundo);
		this.setTitle("Gerenciador Escolar - Alunos");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		configPaineis();
		
		this.setVisible(true);
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
		tabelaModelo = new DefaultTableModel(new Object[] {"N°", "Matrícula", "Aluno", "Faltas", "Situação"}, 2);
		tabelaAluno = new JTable(tabelaModelo);
		tabelaAluno.getTableHeader().setFont(DesignApp.fonteMedia);
		tabelaAluno.setFont(DesignApp.fonteMedia);
		String[][] alunos = {
				{"0001", "Isaac Weber", "10", "2.7", "Em Andamento"},
				{"0002", "Nícolas Kaleb", "11", "5.8", "Em Andamento"}};
		
		for(int i = 0; i < alunos.length; i++) {
			tabelaAluno.setValueAt(i + 1, i, 0); //número do aluno
			tabelaAluno.setValueAt(alunos[i][0], i, 1); //matrícula
			tabelaAluno.setValueAt(alunos[i][1], i, 2);
			tabelaAluno.setValueAt(alunos[i][2], i, 3);
			tabelaAluno.setValueAt(alunos[i][3], i, 4);

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
