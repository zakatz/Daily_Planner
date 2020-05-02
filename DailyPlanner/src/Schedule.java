import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Schedule {
	
	public Schedule(String wakeUp, String goSleep) {
		JFrame schedule = new JFrame();
		schedule.setResizable(true);
		schedule.setVisible(true);
		schedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		schedule.setSize(600,900);
		schedule.setTitle("Your Daily Schedule");
		
		ArrayList<String> times = new ArrayList<>();
		
		JPanel alphaPanel = new JPanel(new GridLayout(1,4));
		
		Color grayWhite = new Color(222,222,222);
		Color easyRed = new Color(255, 100, 100);
		JPanel timePanel = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.BLACK, 4);
		timePanel.setBorder(border);
		timePanel.setBackground(easyRed);
		int panelNumber = TaskAdder.list.size()/4+2;
		timePanel.setLayout(new GridLayout(panelNumber+1, 1));
		JLabel macrotimes = new JLabel("      Time: ");
		macrotimes.setForeground(grayWhite);
		macrotimes.setFont(new Font("Verdana", Font.BOLD, 17));
		timePanel.add(macrotimes);
		String wakeTime = wakeUp;
		times.add(wakeTime);
		JLabel wake = new JLabel("              " + wakeTime);
		wake.setForeground(grayWhite);
		timePanel.add(wake);
		String timeInNumsStr = "";
			if (wakeTime.charAt(5) == 'A') {
				 timeInNumsStr = wakeTime.substring(0,1) + wakeTime.substring(2,4);
			}
			else if (wakeTime.charAt(6) == 'A') {
				timeInNumsStr = wakeTime.substring(0,2) + wakeTime.substring(3,5);
			}
		int currentTime = Integer.parseInt(timeInNumsStr);
		int[] timeArray = new int[panelNumber-2];
		int i = 0;
		//timeArray[i] = currentTime;
		
	
		int lessThanListLength = 2;
		while ( i < timeArray.length) {
			String taskLengthString = TaskAdder.list.get(lessThanListLength);
			lessThanListLength = lessThanListLength + 4;
			int timeItemToInt = Integer.parseInt(taskLengthString);
			currentTime = currentTime + timeItemToInt;
			if (currentTime % 100 >= 60) {
				currentTime = currentTime + 40;
			}
			timeArray[i] = currentTime;
			i++;
		}
		
		String sleepTime = goSleep;
//		String sleepInNumsStr = "";
//		if (sleepTime.charAt(5) == 'P') {
//			sleepInNumsStr = sleepTime.substring(0,1) + sleepTime.substring(2,4);
//		}
//		else if (sleepTime.charAt(6) == 'P') {
//			sleepInNumsStr = sleepTime.substring(0,2) + sleepTime.substring(3,5);
//		}
//		
//		currentTime = Integer.parseInt(sleepInNumsStr);
//		timeArray[i] = currentTime;
		
		
		for (int x = 0; x < timeArray.length; x++) {
			String AMPM = " A.M.";
			int clockTime = timeArray[x];
			if (clockTime >= 1200) {
				 AMPM = " P.M.";
			}
			if (clockTime >= 1300) {
				clockTime = clockTime - 1200;
			}
			int last_digits = clockTime%100;
			String last_digits_str = "";
			if (last_digits < 10) {
				last_digits_str = "0" + last_digits;
			}
			else
				last_digits_str += last_digits;
			String clockLabel = "   " + ((clockTime - (clockTime%100))/100) + ":" + (last_digits_str) + AMPM;
			times.add(clockLabel);
			//JLabel clock = new JLabel(clockLabel);
			//time.add(clock);
		}
		
		for (int g = 1; g < times.size(); g++) {
			String clockSpan = times.get(g-1) + " -" + times.get(g);
			JLabel clock = new JLabel("   " + clockSpan);
			clock.setForeground(grayWhite);
			timePanel.add(clock);
		}
		JLabel sleep = new JLabel("              " + sleepTime);
		sleep.setForeground(grayWhite);
		timePanel.add(sleep);
		
		
		
		JPanel taskPanel = new JPanel();
		Color blueGreen = new Color(3, 168, 94);
		taskPanel.setBackground(blueGreen);
		taskPanel.setLayout(new GridLayout(panelNumber+1, 1));
		JLabel task = new JLabel("          Task");
		task.setFont(new Font("Verdana", Font.ITALIC, 15));
		taskPanel.add(task);
		JLabel wakeywakey = new JLabel("   WAKE UP");
		taskPanel.add(wakeywakey);
		
		int z = 0;
		while (z < TaskAdder.list.size()) {
			String microtask = "   " + TaskAdder.list.get(z);
			JLabel taskLabel = new JLabel(microtask);
			taskPanel.add(taskLabel);
			z = z + 4;
//			String location = "@  " + TaskAdder.list.get(z);
//			JLabel locationLabel = new JLabel(location);
//			tasks.add(locationLabel);
//			z++;
//			z++;
//			String addInfo = "|  " + TaskAdder.list.get(z);
//			JLabel addInfoLabel = new JLabel(addInfo);
//			tasks.add(addInfoLabel);
//			z++;
		}
		String nowSleep = "   SLEEP";
		JLabel sleepington = new JLabel(nowSleep);
		taskPanel.add(sleepington);
		Color realGreen = new Color(75, 168, 3);
		JPanel locationPanel = new JPanel();
		locationPanel.setBackground(realGreen);
		locationPanel.setLayout(new GridLayout(panelNumber+1,1));
		JLabel location = new JLabel("   @    Location");
		location.setFont(new Font("Verdana", Font.ITALIC, 15));
		locationPanel.add(location);
		JTextArea motivation = new JTextArea();
		motivation.setLineWrap(true);
		motivation.append("\n \n \nDAILY MOTIVATION: \nI am the captain of my ship, I seal my fate");
		if (!(Bottom.motivationText.equals(""))) {
			motivation.setText("DAILY MOTIVATION:\n" + Bottom.motivationText);
		}
		//motivation.setEditable(true);
		motivation.setBackground(realGreen);
		motivation.setFont(new Font("Serif", Font.PLAIN, 12));
		locationPanel.add(motivation);
		int y = 1;
		while (y < TaskAdder.list.size()) {
			String microlocation = TaskAdder.list.get(y);
			JLabel locationLabel = new JLabel("   " + microlocation);
			locationPanel.add(locationLabel);
			y = y + 4;
		}
		Color yellowGreen = new Color(123, 199, 10);
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(yellowGreen);
		infoPanel.setLayout(new GridLayout(panelNumber+1, 1));
		JLabel additionalInfo = new JLabel("    Additional Info");
		JLabel getAfterIt = new JLabel("");
		additionalInfo.setFont(new Font("Verdana", Font.ITALIC, 15));
		infoPanel.add(additionalInfo);
		infoPanel.add(getAfterIt);
		int w = 3;
		while (w < TaskAdder.list.size()) {
			String addInfo = TaskAdder.list.get(w);
			JLabel infoLabel = new JLabel("   " + addInfo);
			infoPanel.add(infoLabel);
			w = w + 4;
		}

		
		alphaPanel.add(timePanel);
		alphaPanel.add(taskPanel);
		alphaPanel.add(locationPanel);
		alphaPanel.add(infoPanel);
		schedule.add(alphaPanel);
	}
	
	
	
	
//	public static void main(String[] args) {
//		Schedule s = new Schedule();
//		JFrame schedule = new JFrame();
//		schedule.add(s);
//		schedule.setVisible(true);
//		schedule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		schedule.setSize(700,1000);
//		schedule.setTitle("Your Daily Schedule");
//	}

}
