import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(600,850);
		frame.setTitle("Daily Planner");
		
		Color hotPink = new Color(184, 22, 162, 255);
		JPanel alphaPanel = new JPanel();
		alphaPanel.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(hotPink, 8);
		alphaPanel.setBorder(border);
		TaskAdder t = new TaskAdder();
		alphaPanel.add(t, BorderLayout.NORTH);
		MiddleButtons m = new MiddleButtons();
		alphaPanel.add(m, BorderLayout.CENTER);
		Bottom b = new Bottom();
		alphaPanel.add(b, BorderLayout.SOUTH);
		
		frame.add(alphaPanel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Hello Git!");
	}

}
