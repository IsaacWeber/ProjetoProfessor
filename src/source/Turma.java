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

public class Turma extends JFrame {
	
	private JLabel tituloLabel;
	private Box boxGeral, 
		boxTitulo, 
		boxConteudo,
		boxTblTitulo,
		boxBotao;
	private JLabel tabelaTitulo;
	private JTable tabelaTurma;
	private DefaultTableModel tabelaModelo;
	private JScrollPane tabelaRolagem;
	private JButton salvarBtn, acessarBtn;
	
	public Turma() {
		this.getContentPane().setBackground(DesignApp.corFundo);
		this.setTitle("Gerenciador Escolar - Turmas");
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
		tabelaTitulo = new JLabel("Turmas");
		tabelaTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		tabelaModelo = new DefaultTableModel(new Object[] {"N°", "Turma", "Alunos"}, 5);
		tabelaTurma = new JTable(tabelaModelo);
		tabelaTurma.getTableHeader().setFont(DesignApp.fonteMedia);
		tabelaTurma.setFont(DesignApp.fonteMedia);
		String[] names = {"A", "B", "C", "D", "E"};
		
		for(int i = 0; i < names.length; ++i) {
			tabelaTurma.setValueAt(i, i, 0);
			tabelaTurma.setValueAt(names[i], i, 1);
			tabelaTurma.setValueAt(0, i, 2);
		}
		tabelaTurma.setRowHeight(30); 
		TableColumnModel tcm = tabelaTurma.getColumnModel();
		tcm.getColumn(1).setPreferredWidth(10);
		
		tabelaRolagem = new JScrollPane(tabelaTurma);
		boxConteudo.add(Box.createVerticalStrut(50));
		boxTblTitulo.add(tabelaTitulo); //adiciona titulo da tabela
		boxConteudo.add(boxTblTitulo);
		boxConteudo.add(Box.createVerticalStrut(20));  
		boxConteudo.add(tabelaRolagem);

		boxBotao = Box.createHorizontalBox();
		salvarBtn = new JButton("Salvar");
		salvarBtn.setFont(DesignApp.fonteMedia);
		acessarBtn = new JButton("Acessar");
		acessarBtn.setFont(DesignApp.fonteMedia);
		
		boxBotao.add(Box.createHorizontalGlue());
		boxBotao.add(salvarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(acessarBtn);
		boxBotao.add(Box.createHorizontalStrut(50));
		
		boxConteudo.add(Box.createHorizontalStrut(50));
		boxConteudo.add(boxBotao);
		
		
		boxGeral.add(boxTitulo);
		boxGeral.add(boxConteudo);
		
		this.add(boxGeral);
	}
	
	
	
	
	

}
