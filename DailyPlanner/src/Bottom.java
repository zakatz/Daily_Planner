import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Bottom extends JPanel implements ActionListener {
	JComboBox<String> timeWake, timeSleep;
	JLabel outBed, inBed, motivation;
	JTextArea motivationField;
	String[] wakeUpTimes, sleepTimes;
	static String wakeTransfer, sleepTransfer, motivationText;
	
	
	
	public void setWakeTransfer(String wakeTransfer) {
		this.wakeTransfer = wakeTransfer;
	}
	
	public static String getWakeTransfer() {
		//System.out.println(this.wakeTransfer);
		return wakeTransfer;
	}
	
	public void setSleepTransfer(String sleepTransfer) {
		this.sleepTransfer = sleepTransfer;
	}
	
	public static String getSleepTransfer() {
		return sleepTransfer;
	}
	
	public Bottom() {
		wakeUpTimes = new String[13];
		wakeUpTimes[0] = "5:00 A.M.";
		wakeUpTimes[1] = "5:30 A.M.";
		wakeUpTimes[2] = "6:00 A.M.";
		wakeUpTimes[3] = "6:30 A.M.";
		wakeUpTimes[4] = "7:00 A.M.";
		wakeUpTimes[5] = "7:30 A.M.";
		wakeUpTimes[6] = "8:00 A.M.";
		wakeUpTimes[7] = "8:30 A.M.";
		wakeUpTimes[8] = "9:00 A.M.";
		wakeUpTimes[9] = "9:30 A.M.";
		wakeUpTimes[10] = "10:00 A.M.";
		wakeUpTimes[11] = "10:30 A.M.";
		wakeUpTimes[12] = "11:00 A.M.";
		Vector vector = new Vector();
		for (int i = 0; i<wakeUpTimes.length; i++) {
			vector.addElement(wakeUpTimes[i]);
		}
		timeWake = new JComboBox(vector);
		timeWake.addActionListener(this);
		
		sleepTimes = new String[8];
		sleepTimes[0] = "9:00 P.M.";
		sleepTimes[1] = "9:30 P.M.";
		sleepTimes[2] = "10:00 P.M.";
		sleepTimes[3] = "10:30 P.M.";
		sleepTimes[4] = "11:00 P.M.";
		sleepTimes[5] = "11:30 P.M.";
		sleepTimes[6] = "12:00 A.M.";
		sleepTimes[7] = "12:30 A.M.";
		Vector vect2 = new Vector();
		for (int x = 0; x<sleepTimes.length; x++) {
			vect2.addElement(sleepTimes[x]);
		}
		timeSleep = new JComboBox(vect2);
		timeSleep.addActionListener(this);
		
		
		super.setLayout(new GridLayout(4,2));
		
		outBed = new JLabel("   (Morning) Out of bed: ");
		outBed.setForeground(Color.WHITE);
		inBed = new JLabel("   (Night) In bed: ");
		inBed.setForeground(Color.WHITE);
		motivation = new JLabel("   Motivation: ");
		motivation.setForeground(Color.WHITE);
		motivationField = new JTextArea(1, 1);
		motivationField.setLineWrap(true);
		motivationField.setFont(new Font("Serif", Font.PLAIN, 11));
		
		JLabel copyright = new JLabel(" © Zach Katz 2020");
		
		copyright.setFont(new Font("Verdana", Font.BOLD, 9));
		
		
		setBackground(Color.BLACK);
		super.add(outBed);
		super.add(timeWake);
		super.add(inBed);
		super.add(timeSleep);
		super.add(motivation);
		super.add(motivationField);
		super.add(copyright);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedWake = timeWake.getSelectedItem().toString();
		wakeTransfer = selectedWake;
		String selectedSleep = timeSleep.getSelectedItem().toString();
		sleepTransfer = selectedSleep;
		String moti = "";
		Scanner scan = new Scanner(motivationField.getText());
		while (scan.hasNext()) {
			moti = moti + scan.next() + " ";
		}
		scan.close();
		motivationText = moti;		
		
	}
}
