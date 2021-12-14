package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class Test extends JFrame {
	
	private JButton addImage;
	private JFrame myInstance;
	public Test() {
		super("Test jfile chooser");
		setLayout(null);
		myInstance = this;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);

		
		Icon btnImage = new ImageIcon(
				getClass().getResource("../images/add-image.png"));
		addImage = new JButton(btnImage);
		addImage.setBounds(10, 10, 150, 180);
		addImage.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
					fileChooser.showOpenDialog(myInstance);
					
				}
			});
		
		add(addImage);
		
		setVisible(true);
		
	}

}
