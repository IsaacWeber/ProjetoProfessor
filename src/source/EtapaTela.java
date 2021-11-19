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

public class EtapaTela extends JFrame {
	
	
	private JLabel tituloLabel;
	private Box boxGeral, 
		boxTitulo, 
		boxConteudo,
		boxTblTitulo,
		boxBotao;
	private JLabel tabelaTitulo;
	private JTable tabelaEtapa;
	private DefaultTableModel tabelaModelo;
	private JScrollPane tabelaRolagem;
	private JButton salvarBtn, acessarBtn, cadastrarBtn;
	//private Professor professorAtual;
	
	public EtapaTela() {
		this.getContentPane().setBackground(DesignApp.corFundo);
		this.setTitle("Gerenciador Escolar - Etapas");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		tabelaTitulo = new JLabel("Etapas");
		tabelaTitulo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		tabelaModelo = new DefaultTableModel(new Object[] {"N°", "Etapa", "Alunos"}, 5);
		tabelaEtapa = new JTable(tabelaModelo);
		tabelaEtapa.getTableHeader().setFont(DesignApp.fonteMedia);
		tabelaEtapa.setFont(DesignApp.fonteMedia);
		String[] names = {"Primeiro Bimestre", "Segundo Bimestre", 
				"Terceiro Bimestre", "Quarto Bimestre", "Quinto Bimestre"};
		
		for(int i = 0; i < names.length; ++i) {
			tabelaEtapa.setValueAt(i, i, 0);
			tabelaEtapa.setValueAt(names[i], i, 1);
			tabelaEtapa.setValueAt(0, i, 2);
		}
		tabelaEtapa.setRowHeight(30); 
		TableColumnModel tcm = tabelaEtapa.getColumnModel();
		tcm.getColumn(1).setPreferredWidth(10);
		
		tabelaRolagem = new JScrollPane(tabelaEtapa,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
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
		cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.setFont(DesignApp.fonteMedia);
		
		boxBotao.add(Box.createHorizontalGlue());
		boxBotao.add(salvarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(acessarBtn);
		boxBotao.add(Box.createHorizontalStrut(20));
		boxBotao.add(cadastrarBtn);
		boxBotao.add(Box.createHorizontalStrut(50));
		
		boxConteudo.add(Box.createHorizontalStrut(50));
		boxConteudo.add(boxBotao);
		
		
		boxGeral.add(boxTitulo);
		boxGeral.add(boxConteudo);
		
		this.add(boxGeral);
	}
	

}
