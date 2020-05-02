import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MiddleButtons extends JPanel implements ActionListener {
	JButton yoga, stretch, lift, swim, run, food, calisth, study, homework, meditate, classes, independent, rest, social, weed, flix, generate;
	JLabel phys, mental, leisure;
	// public int taskPanels;
	
	public MiddleButtons() {
		super.setLayout(new GridLayout(1,3));
		super.add(leftPanel());
		super.add(midPanel());
		super.add(rightPanel());
	}
	
	public JPanel leftPanel() {
		Color newGreen = new Color(55, 176, 21);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(10, 1));
		phys = new JLabel(" Physical Investments");
		phys.setForeground(Color.WHITE);
		phys.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JButton clear = new JButton("");
		clear.setVisible(false);
		panel.add(clear);
		panel.add(phys);
		yoga = new JButton("Yoga");
		yoga.addActionListener(this);
		yoga.setBackground(newGreen);
		stretch = new JButton("Stretch");
		stretch.addActionListener(this);
		stretch.setBackground(newGreen);
		swim = new JButton("Swim");
		swim.addActionListener(this);
		swim.setBackground(newGreen);
		run = new JButton("Run");
		run.addActionListener(this);
		run.setBackground(newGreen);
		food = new JButton("Food");
		food.addActionListener(this);
		food.setBackground(newGreen);
		calisth = new JButton("Calisthenics");
		calisth.addActionListener(this);
		calisth.setBackground(newGreen);
		lift = new JButton("Lift weights");
		lift.addActionListener(this);
		lift.setBackground(newGreen);
		panel.add(yoga);
		panel.add(stretch);
		panel.add(swim);
		panel.add(run);
		panel.add(food);
		panel.add(calisth);
		panel.add(lift);
		JButton clear3 = new JButton("");
		clear3.setVisible(false);
		panel.add(clear3);
		return panel;
		
	}
	
	public JPanel midPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(10, 1));
		mental = new JLabel("  Mental Investments");
		mental.setForeground(Color.WHITE);
		mental.setFont(new Font("Verdana", Font.BOLD, 15));
		JButton clear3 = new JButton("");
		clear3.setVisible(false);
		panel.add(clear3);
		
		Color borange = new Color(252, 157, 3, 255);
		panel.add(mental);
		study = new JButton("Study");
		study.addActionListener(this);
		study.setBackground(borange);
		homework = new JButton("Homework");
		homework.addActionListener(this);
		homework.setBackground(borange);
		meditate = new JButton("Meditate");
		meditate.addActionListener(this);
		meditate.setBackground(borange);
		classes = new JButton("Class");
		classes.addActionListener(this);
		classes.setBackground(borange);
		independent = new JButton("Independent studies");
		independent.addActionListener(this);
		independent.setBackground(borange);
		panel.add(classes);
		panel.add(study);
		panel.add(homework);
		panel.add(meditate);
		panel.add(independent);
		JButton clear2 = new JButton("");
		clear2.setVisible(false);
		
		panel.add(clear2);
		return panel;
	}
	
	public JPanel rightPanel() {
		Color purple = new Color(135, 12, 242, 255);
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(10, 1));
		JButton clear3 = new JButton("");
		clear3.setVisible(false);
		panel.add(clear3);
		leisure = new JLabel("           Leisure");
		leisure.setFont(new Font("Verdana", Font.BOLD, 15));
		leisure.setForeground(Color.WHITE);
		panel.add(leisure);
		rest = new JButton("Rest");
		rest.addActionListener(this);
		rest.setBackground(purple);
		social = new JButton("Socialize");
		social.addActionListener(this);
		social.setBackground(purple);
		weed = new JButton("Video games");
		weed.addActionListener(this);
		weed.setBackground(purple);
		flix = new JButton("YouTube/Netflix");
		flix.addActionListener(this);
		flix.setBackground(purple);
		panel.add(rest);
		panel.add(social);
		panel.add(weed);
		panel.add(flix);
		JButton clear = new JButton("");
		clear.setVisible(false);
		JButton clearAgain = new JButton("");
		clearAgain.setVisible(false);
		panel.add(clear);
		panel.add(clearAgain);
		generate = new JButton("Generate Schedule");
		generate.addActionListener(this);
		generate.setBackground(Color.blue);
		generate.setForeground(Color.white);
		panel.add(generate);
		return panel;
		
		
	}
	
//	public int getTaskPanels() {
//		return this.taskPanels;
//	}
	
//	public void setTaskPanels(int taskPanels) {
//		this.taskPanels = taskPanels;
//	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Generate Schedule")) {
//			PrintWriter pw = null;
//			try {
//				pw = new PrintWriter("dailyTasks.txt");
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			for (String s: TaskAdder.list) {
//				pw.println(s);
//			}
//			pw.close();
			//taskPanels = TaskAdder.list.size()/4 + 2;
			//setTaskPanels(tasks);
			//System.out.println(tasks);
//			for (String s : TaskAdder.list) {
//				System.out.println(s);
//			}
			
			String wake = "5:00 A.M.";
			String sleep = "9:00 P.M.";
			sleep = Bottom.getSleepTransfer();
			wake = Bottom.getWakeTransfer();
			Schedule s = new Schedule(wake, sleep);

		}
		else {
		String buttonText = event.getActionCommand();
		TaskAdder.appendTask(buttonText);
		}
	}
	
		
}
