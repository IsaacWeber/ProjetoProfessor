package source;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test extends JFrame implements KeyListener{

	public Test() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		
		
		JTextField t = new JTextField();
		t.addKeyListener(
			new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					System.out.println("pressed");
				}
					
			});
		add(t);
		
		//addKeyListener(this);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
