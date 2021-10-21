package source;
	
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Materia extends JFrame {
	
	private JLabel tituloLabel;
	private Box boxGeral, 
		boxTitulo, 
		boxConteudo,
		boxTblTitulo,
		boxBotao;
	private JLabel tabelaTitulo;
	private JTable tabelaMateria;
	private DefaultTableModel tabelaModelo;
	private JScrollPane tabelaRolagem;
	private JButton salvarBtn, acessarBtn;
	
	
	public Materia() {
		this.setTitle("Gerenciador Escolar");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		//this.getContentPane().setBackground(Color.BLUE);
		
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
		tabelaTitulo = new JLabel("Matérias");
		tabelaTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		tabelaModelo = new DefaultTableModel(new Object[] {"N°", "matéria", "Alunos"}, 10);
		tabelaMateria = new JTable(tabelaModelo);
		tabelaRolagem = new JScrollPane(tabelaMateria);
		
		boxConteudo.add(Box.createVerticalStrut(50));
		boxTblTitulo.add(tabelaTitulo); //adiciona titulo da tabela
		boxConteudo.add(boxTblTitulo);
		boxConteudo.add(Box.createVerticalStrut(20));
		boxConteudo.add(tabelaRolagem);
		
		boxBotao = Box.createHorizontalBox();
		salvarBtn = new JButton("Salvar");
		acessarBtn = new JButton("Acessar");
		
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
