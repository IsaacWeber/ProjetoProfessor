package source;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class DesignApp { //classe para fazer o design geral do app
	
	public final static Color corFundo = new Color(237, 237, 237);
	public final static Font fonteGrande = new Font(Font.SANS_SERIF, Font.PLAIN, 25); 
	public final static Font fonteMedia = new Font(Font.SANS_SERIF, Font.PLAIN, 18); 
	
	public DesignApp(String lkfTipo) {
		configLKF(lkfTipo);
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
