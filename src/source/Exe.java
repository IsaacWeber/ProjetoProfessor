package source;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Exe {
	
	public static void main(String[] args) {
		
		new Exe().configLKF("Nimbus");
		Materia materia = new Materia();
		//Entrada entrada = new Entrada(); asdfa
		
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
