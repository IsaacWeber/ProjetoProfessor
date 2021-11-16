package source;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
	static DefaultComboBoxModel<String> profComboModel;
	private JButton professorEntrar;
	private JButton professorCadastrar;
	private JPanel painelGrafico;
	private JLabel graficoLabel;
	
	public Entrada() {
		configLKF("Nimbus");
		this.getContentPane().setBackground(DesignApp.corFundo);
		
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
		bc1 = Box.createHorizontalBox();
		bc2 = Box.createHorizontalBox();
		bc3 = Box.createHorizontalBox();
		
		
		professorLabel = new JLabel("Professor(a):");
		professorLabel.setFont(DesignApp.fonteGrande);
		bc1.add(Box.createHorizontalStrut(50));
		bc1.add(professorLabel);
		bc1.add(Box.createHorizontalStrut(135));
		bc1.add(Box.createHorizontalGlue());
		
		//String[] professores = {"Lidinete Guedes", "Oswaldo"};
		profComboModel = new DefaultComboBoxModel<String>();
		this.addNomeProfs(); //adiciona nome dos professores
		professorCombo = new JComboBox<String>(profComboModel);
		professorCombo.setFont(DesignApp.fonteGrande);
		professorEntrar = new JButton("Entrar");
		professorEntrar.setFont(DesignApp.fonteGrande);
		JPanel bc2Panel = new JPanel(
			new FlowLayout(FlowLayout.LEFT, 50, 0));
		
		bc2Panel.add(professorCombo);
		bc2Panel.add(professorEntrar);
		
		bc2Panel.setBackground(this.getContentPane().getBackground());
		
		bc2.add(bc2Panel);
		
		professorCadastrar = new JButton("Cadastrar");
		professorCadastrar.setFont(DesignApp.fonteGrande);
		professorCadastrar.addActionListener(new CadastrarProfessorHandler());
		bc3Panel = new JPanel(
			new FlowLayout(FlowLayout.RIGHT));
		bc3Panel.setBackground(this.getContentPane().getBackground());
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
		graficoLabel.setFont(DesignApp.fonteGrande);
		graficoLabel.setLayout(null);
		graficoLabel.setBounds(this.getWidth()/2 + 100 + 250,
				this.getHeight()/4 -150, 185, 370);
		
		this.add(graficoLabel);
		this.add(painelGrafico);
	}
	
	private void addNomeProfs() {
		ProfessorDao pDao = new ProfessorDao();
		List<Professor> profs = pDao.getAll();
		
		for(Professor prof: profs) {
			profComboModel.addElement(
				String.format("%s %s", 
					prof.getNome(), prof.getSobreNome()));
		}
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



class CadastrarProfessorFrame extends JFrame {
	
	private JLabel tituloLbl,
		nomeLbl, 
		sbNomeLbl;
	private JLabel errLblNome, errLblSbNome;
	private JTextField nomeTxt,
			sbNomeTxt;
	private JButton cadastrarPf;
	private Box boxElementos,
		boxTitulo,
		boxNome,
		boxSbNome,
		boxBotao;
	
	public CadastrarProfessorFrame() {
		getContentPane().setBackground(DesignApp.corFundo);
		
		setTitle("Gerenciador Escolar - Novo Professor");
		setSize(600, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		configPaineis();
		
		setVisible(true);
	}
	
	
	private void configPaineis() {
		tituloLbl = new JLabel("Novo Professor");
		tituloLbl.setFont(DesignApp.fonteSecTitulo);
		
		nomeLbl = new JLabel("Nome:");
		nomeLbl.setFont(DesignApp.fonteGrande);
		
		sbNomeLbl = new JLabel("Sobrenome:");
		sbNomeLbl.setFont(DesignApp.fonteGrande);
		
		nomeTxt = new JTextField();
		nomeTxt.setFont(DesignApp.fonteGrande);
		
		sbNomeTxt = new JTextField();
		sbNomeTxt.setFont(DesignApp.fonteGrande);
		
		errLblNome = new JLabel();
		errLblNome.setFont(DesignApp.fonteMedia);
		errLblNome.setForeground(Color.RED);
		
		errLblSbNome = new JLabel();
		errLblSbNome.setFont(DesignApp.fonteMedia);
		errLblSbNome.setForeground(Color.RED);
		
		cadastrarPf = new JButton("Cadastrar");
		cadastrarPf.setFont(DesignApp.fonteGrande);
		cadastrarPf.addActionListener( //classe anonima
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String nome = nomeTxt.getText();
					String sbNome = sbNomeTxt.getText();
					boolean nomeVal = false, 
							sbNomeVal = false; //validadores
					Validador validador = new Validador();
					
					if(nome.trim().isEmpty()) {
						errLblNome.setText("O nome não pode estar vazio!");
						Thread labelTr = new Thread(
							new LabelTimeThread(errLblNome)); //thread para limpar o lbl errNome
						labelTr.start();
					}else {
						if(validador.nomeValido(nome)) {
							nomeVal = true; //nome valido
						}else {
							errLblNome.setText("O nome não pode ter espaços em branco!");
							Thread labelTr = new Thread(
									new LabelTimeThread(errLblNome));
							labelTr.start();
						}
					}
					
					if(sbNome.trim().isEmpty()) {
						errLblSbNome.setText("O sobrenome não pode estar vazio!");
						Thread labelTr = new Thread(
							new LabelTimeThread(errLblSbNome)); //thread para limpar o errSbNome
						labelTr.start();
					}else {
						if(validador.nomeValido(sbNome)) {
							sbNomeVal = true; 
						}else {
							errLblSbNome.setText("O sobrenome não pode ter espaços em branco!");
							Thread labelTr = new Thread(
									new LabelTimeThread(errLblSbNome));
							labelTr.start();
						}
					}
					
				
					if(nomeVal && sbNomeVal) { //se ambos sao validos ( cadastra )
						
						nome = validador.formatarNome(nome);
						sbNome = validador.formatarNome(sbNome);
						int answer = JOptionPane.showOptionDialog(
									null, 
									String.format("Deseja realmente cadastrar professor(a):\n\'%s %s\'", nome, sbNome), 
									"Cadastrar usuário?", 
									JOptionPane.YES_NO_OPTION,  
									JOptionPane.QUESTION_MESSAGE, 
									null,
									new String[]{"Sim", "Não"}, 
									new String[]{"Sim", "Não"}[0]);
						
						
						if(answer == JOptionPane.YES_OPTION) {
							ProfessorDao pDao = new ProfessorDao();
							Professor prf = new Professor(
								pDao.getAll().size() + 1, nome, sbNome);
							pDao.save(prf);
							Entrada.profComboModel.addElement(
								prf.getNome() + " " + prf.getSobreNome());
							
							JOptionPane.showMessageDialog(
								null, String.format("Professor(a) \'%s %s\' cadastrado(a) com sucesso!\n e acessível na lista de professores.", nome, sbNome),
								"Cadastro concluído", JOptionPane.INFORMATION_MESSAGE);
							
							nomeTxt.setText("");
							sbNomeTxt.setText("");
						}
					
					}
					
					
				} //act performed end
			}
		);
		
		boxElementos = Box.createVerticalBox();
		boxTitulo = Box.createHorizontalBox();
		boxTitulo.add(tituloLbl);
		boxElementos.add(boxTitulo);
		boxElementos.add(Box.createVerticalStrut(50));
		
		boxNome = Box.createHorizontalBox();
		boxNome.add(Box.createHorizontalStrut(60));
		boxNome.add(nomeLbl);
		boxNome.add(Box.createHorizontalStrut(80));
		boxNome.add(nomeTxt);
		boxNome.add(Box.createHorizontalStrut(150));
		boxElementos.add(boxNome);
		boxElementos.add(errLblNome);
		//boxElementos.add(Box.createVerticalStrut(20));
		
		boxSbNome = Box.createHorizontalBox();
		boxSbNome.add(Box.createHorizontalStrut(60));
		boxSbNome.add(sbNomeLbl);
		boxSbNome.add(Box.createHorizontalStrut(20));
		boxSbNome.add(sbNomeTxt);
		boxSbNome.add(Box.createHorizontalStrut(150));
		boxElementos.add(Box.createVerticalStrut(30));
		boxElementos.add(boxSbNome);
		boxElementos.add(errLblSbNome);
		
		boxBotao = Box.createHorizontalBox();
		boxBotao.add(cadastrarPf);
		boxElementos.add(Box.createVerticalStrut(50));
		boxElementos.add(boxBotao);
		boxElementos.add(Box.createVerticalStrut(80));
		
		add(boxElementos);
		
	}
	
	//THREADS inner
	class LabelTimeThread implements Runnable {

		private JLabel lbl;
		
		public LabelTimeThread(JLabel l) {
			lbl = l;
		}	
		@Override
		public void run() {
			try {
				Thread.sleep(3 * 1000); //espera 2 segundos
				lbl.setText(""); //limpa o respectivo label
			}catch(InterruptedException e) {
				System.err.println("ERROR:\n" + e);
			}
		}
	}
	
}

//HANDLERS *****

class CadastrarProfessorHandler 
	implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new CadastrarProfessorFrame();
	}
	
}




