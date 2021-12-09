package source;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	private Professor professorAtual;
	private Materia materiaAtual;
	private Turma turmaAtual;
	private EtapaDao eDao;
	private JFrame cadFrame;
	
	public EtapaTela(Professor prof, Materia mat, Turma tur) {
		this.professorAtual = prof;
		this.materiaAtual = mat;
		this.turmaAtual = tur;
		this.eDao = new EtapaDao();
		
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
		tabelaModelo = new DefaultTableModel(new Object[] {"N�", "Etapa", "Alunos"}, 0);
		tabelaEtapa = new JTable(tabelaModelo);
		tabelaEtapa.getTableHeader().setFont(DesignApp.fonteMedia);
		tabelaEtapa.setFont(DesignApp.fonteMedia);
		List<Etapa> ets = eDao.getAllByPMT(professorAtual.getId(),
				materiaAtual.getId(), turmaAtual.getId());
		for(int i = 0; i < ets.size(); ++i) {
			tabelaModelo.addRow(new Object[] {i+1, ets.get(i)});
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
		salvarBtn.addActionListener( //salva todas as turmas
				new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					List<Etapa> ets = eDao.getAllByPMT(
						professorAtual.getId(), materiaAtual.getId(), turmaAtual.getId());
					Validador validador = new Validador();
					boolean semProblema = true;
					
					String tNome = "";
					for(int i = 0; i < tabelaModelo.getRowCount(); ++i) {
						tNome = String.valueOf(tabelaModelo.getValueAt(i, 1)).trim(); //recupera nome com pontas aparadas
						
						if(!tNome.equals("") && validador.nomeValido(tNome)) { //se nome valido
							ets.get(i).setNome(validador.formatarNome(tNome)); //formata nome
							eDao.update(ets.get(i),
									new String[] {String.valueOf(ets.get(i))} ); //atualiza nome da materia
							tabelaModelo.setValueAt(ets.get(i), i, 1); //atualiza nome formatado na tabela
						}else {
							semProblema = false; //teve problema
							JOptionPane.showMessageDialog(null, 
									String.format("Nome inv�lido na linha %d\nO nome n�o pode conter espa�os ou estar em branco!\n", (i + 1)),
									"Corrija o nome da linha" + (i + 1), JOptionPane.ERROR_MESSAGE);
						}
						
					}//fim for
					
					if(semProblema) { //se n tiver nenhum problema
						JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", 
								"Dados salvos", JOptionPane.INFORMATION_MESSAGE); 
					}
				}
			});
		
		acessarBtn = new JButton("Acessar");
		acessarBtn.setFont(DesignApp.fonteMedia);
		cadastrarBtn = new JButton("Cadastrar");
		cadastrarBtn.setFont(DesignApp.fonteMedia);
		cadastrarBtn.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(cadFrame == null) { //se o frame nao estiver instanciado
							cadFrame = new CadastrarEtapaFrame();
							
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
	
	class CadastrarEtapaFrame extends JFrame {
		
		private JLabel tituloLbl;
		private JLabel nomeLbl; 
		private JTextField nomeTxt;
		private JLabel errLblNome;
		private JButton cadastrarEtp;
		private Box boxElementos;
		private Box boxTitulo;
		private Box boxNome;
		private Box boxBotao;
		private JFrame myInstance;
		
		public CadastrarEtapaFrame() {
			myInstance = this;
			getContentPane().setBackground(DesignApp.corFundo);
			
			setTitle("Gerenciador Escolar - Nova Etapa");
			setSize(600, 300);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			
			configPaineis();
			
			setVisible(true);
		}
		
		private void configPaineis() {
			tituloLbl = new JLabel("Nova Etapa");
			tituloLbl.setFont(DesignApp.fonteSecTitulo);
			
			nomeLbl = new JLabel("Nome:");
			nomeLbl.setFont(DesignApp.fonteGrande);
			
			nomeTxt = new JTextField();
			nomeTxt.addKeyListener( //evento para facilitar o uso
				new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER) {
							cadastrarEtp.doClick();
						}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
							myInstance.dispose();
						}
					}
							
			});	
			nomeTxt.setFont(DesignApp.fonteGrande);
			
			errLblNome = new JLabel();
			errLblNome.setFont(DesignApp.fonteMedia);
			errLblNome.setForeground(Color.RED);
			
			cadastrarEtp = new JButton("Cadastrar");
			cadastrarEtp.setFont(DesignApp.fonteGrande);
			cadastrarEtp.addActionListener( //classe anonima para cadastrar etapa
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							String nome = nomeTxt.getText();
							boolean nomeVal = false; //deixei uma variavel para poder extender futuramente
							Validador validador = new Validador();
							
							if(nome.trim().isEmpty()) {
								errLblNome.setText("O nome n�o pode estar vazio!");
								Thread labelTr = new Thread(
									new LabelTimeThread(errLblNome)); //thread para limpar o lbl errNome
								labelTr.start();
							}else {
								if(validador.nomeValido(nome)) {
									nomeVal = true; //nome valido
								}else {
									errLblNome.setText("O nome n�o pode ter espa�os em branco!");
									Thread labelTr = new Thread(
											new LabelTimeThread(errLblNome));
									labelTr.start();
								}
							}
						
						
						if(nomeVal) { //se nome eh valido
							
							nome = validador.formatarNome(nome);
							int resp = JOptionPane.showOptionDialog(
										null, 
										String.format("Deseja realmente cadastrar a etapa:\n\'%s'", nome), 
										"Cadastrar Etapa?", 
										JOptionPane.YES_NO_OPTION,  
										JOptionPane.QUESTION_MESSAGE, 
										null,
										new String[]{"Sim", "N�o"}, 
										"Sim");
							
							if(resp == JOptionPane.YES_OPTION) { //se resp sim, cadastra Etapa
								Etapa etp = new Etapa(eDao.getAll().size() + 1, nome,
									professorAtual.getId(), materiaAtual.getId(), turmaAtual.getId());
								
								eDao.save(etp);
								
								tabelaModelo.addRow(new Object[] {
									tabelaModelo.getRowCount() + 1, etp});
								
								JOptionPane.showMessageDialog(
									null, String.format("Etapa \'%s\' cadastrada com sucesso!\nE agora acess�vel na tabela de etapas.", nome),
									"Cadastro conclu�do", JOptionPane.INFORMATION_MESSAGE);
								
								nomeTxt.setText("");
							}
						
						}
						
						
					} //act performed end
			});
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

			boxBotao = Box.createHorizontalBox();
			boxBotao.add(cadastrarEtp);
			boxElementos.add(Box.createVerticalStrut(50));
			boxElementos.add(boxBotao);
			boxElementos.add(Box.createVerticalStrut(80));
			
			add(boxElementos);
			
		}//fim inner class
		
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
		}//fim inner thread
	
	
	} //fim inner class
	

}
