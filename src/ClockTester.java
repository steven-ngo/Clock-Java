import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class ClockTester {
	//main class
	public static void main(String[] args) {
		// Delay for 1 second
		final int DELAY = 1000;
		
		JFrame f = new JFrame("Clock by Steven Ngo");
		ClockIcon clockIcon = new ClockIcon(350);
		JLabel label = new JLabel(clockIcon);
		
		f.setLayout(new FlowLayout());
		f.add(label);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed( ActionEvent event){
				label.repaint();
			}
		};
		
		javax.swing.Timer t = new javax.swing.Timer(DELAY, listener);
		t.start();
		
	}

}
