package source;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Entrada extends JFrame {
	
	private Box boxGeral;
	private Box boxTitulo;
	private JLabel tituloLabel;
	private Box boxConteudo;
	private Box bc1, bc2, bc3;
	private JPanel bc2Panel, bc3Panel;
	private JLabel professorLabel;
	private JComboBox<String> professorCombo;
	private JButton professorEntrar;
	private JButton professorCadastrar;
	private Font fonteGeral;
	private Color bgCor;
	private JPanel painelGrafico;
	private JLabel graficoLabel;
	
	public Entrada() {
		configLKF("Nimbus");
		
		this.setTitle("Gerenciador Escolar");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		//this.getContentPane().setBackground(Color.BLUE);
		configPaineis();
		
		//this.getContentPane().setBackground(Color.PINK);
		
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
		bc1 = Box.createHorizontalBox();
		bc2 = Box.createHorizontalBox();
		bc3 = Box.createHorizontalBox();
		
		fonteGeral = new Font(Font.SANS_SERIF, Font.PLAIN, 25); 
		professorLabel = new JLabel("Professor(a):");
		professorLabel.setFont(fonteGeral);
		bc1.add(Box.createHorizontalStrut(50));
		bc1.add(professorLabel);
		bc1.add(Box.createHorizontalStrut(135));
		bc1.add(Box.createHorizontalGlue());
		
		String[] professores = {"Lidinete Guedes", "Oswaldo"};
		professorCombo = new JComboBox<String>(professores);
		professorCombo.setFont(fonteGeral);
		professorEntrar = new JButton("Entrar");
		professorEntrar.setFont(fonteGeral);
		JPanel bc2Panel = new JPanel(
			new FlowLayout(FlowLayout.LEFT, 50, 0));
		
		bc2Panel.add(professorCombo);
		bc2Panel.add(professorEntrar);
		
		bgCor = new Color(237, 237, 237);
		bc2Panel.setBackground(bgCor);
		
		bc2.add(bc2Panel);
		
		professorCadastrar = new JButton("Cadastrar");
		professorCadastrar.setFont(fonteGeral);
		bc3Panel = new JPanel(
			new FlowLayout(FlowLayout.RIGHT));
		bc3Panel.setBackground(bgCor);
		bc3Panel.add(professorCadastrar);
		bc3.add(bc3Panel);	
		
		boxGeral.add(boxTitulo);
		//boxGeral.add(Box.createVerticalStrut(80)); 
		boxGeral.add(Box.createVerticalGlue()); 
		boxConteudo.add(bc1);
		boxConteudo.add(Box.createVerticalStrut(-20));
		boxConteudo.add(bc2);
		boxConteudo.add(Box.createVerticalStrut(200));
		boxConteudo.add(bc3);
		boxConteudo.add(Box.createVerticalStrut(-60));
		boxGeral.add(boxConteudo);
		
		configPainelGrafico(this);
		
		
		this.add(boxGeral);
	}
	
	private void configPainelGrafico(JFrame meuFrame) { //cria grafico sobre os alunos de tal professor
		
		painelGrafico = new JPanel(null) {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
			
				g.setColor(Color.GREEN);
				g.fillRect(0, 50, 500, 50);
				
				g.setColor(Color.GRAY);
				g.fillRect(0, 150, 300, 50);
				
				g.setColor(Color.RED);
				g.fillRect(0, 250, 100, 50);
				
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 714, 3);
				g.fillRect(0, 0, 3, 370);
				
				g.setColor(Color.GREEN);
				g.fillRect(560, 300, 40, 10);
				
				g.setColor(Color.GRAY);
				g.fillRect(560, 320, 40, 10);
				
				g.setColor(Color.RED);
				g.fillRect(560, 340, 40, 10);
				
				g.setColor(Color.BLACK);
				g.drawString("Aprovado", 610, 310);
				g.drawString("Em espera", 610, 328);
				g.drawString("Reprovado", 610, 346);
				
				g.drawString("60%", 510, 78 );
				g.drawString("30%", 310, 178);
				g.drawString("10%", 110, 278 );
			}
			
		};
		
		painelGrafico.setBackground(Color.WHITE);
		painelGrafico.setBounds(this.getWidth()/2 + 100,
				this.getHeight()/4 + 50, 714, 370);
		
		graficoLabel = new JLabel("Situação Alunos");
		graficoLabel.setFont(fonteGeral);
		graficoLabel.setLayout(null);
		graficoLabel.setBounds(this.getWidth()/2 + 100 + 250,
				this.getHeight()/4 -150, 185, 370);
		
		this.add(graficoLabel);
		this.add(painelGrafico);
	}
	
	
	private void configLKF(String lkfNome) { //colocando look and feel
		LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
		
		try {
			
			for(LookAndFeelInfo info: plafs) {
				if(info.getName().equalsIgnoreCase(lkfNome)) {
					UIManager.setLookAndFeel(info.getClassName());
				}
			}
			
		}catch(Exception e) {
			System.err.println("Look and Feel Error\n\n" + e);
		}
		
	}
	
	
	
}
