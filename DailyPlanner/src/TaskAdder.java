import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskAdder extends JPanel implements ActionListener{
	JButton submitButton, generateButton;
	JLabel task, location, time, info;
	public static JTextField taskField, locationField, timeField, infoField;
	public static ArrayList<String> list = new ArrayList<>();
	
		
	
	
	
	public TaskAdder() {
		setBackground(Color.LIGHT_GRAY);
		super.setLayout(new BorderLayout());
		super.add(westSide(), BorderLayout.WEST);
		super.add(eastSide(), BorderLayout.EAST);
	}
	
	
	public JPanel westSide() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(4,2));
		task = new JLabel("   Task: ");
		task.setForeground(Color.WHITE);
		panel.add(task);
		taskField = new JTextField(18);
		taskField.setToolTipText("You must fill this field");
		panel.add(taskField);
		location = new JLabel("   Location: ");
		location.setForeground(Color.WHITE);
		panel.add(location);
		locationField = new JTextField();
		locationField.setToolTipText("You must fill this field");
		panel.add(locationField);
		time = new JLabel("   Time (minutes): ");
		time.setForeground(Color.WHITE);
		panel.add(time);
		timeField = new JTextField();
		timeField.setToolTipText("You must fill this field with a number");
		panel.add(timeField);
		info = new JLabel("   Additional Information: ");
		info.setForeground(Color.WHITE);
		panel.add(info);
		infoField = new JTextField();
		panel.add(infoField);
		return panel;
	}
	
	public JPanel eastSide() {
		JPanel panel = new JPanel();
		setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());
		submitButton = new JButton("Submit Task");
		submitButton.addActionListener(this);
		submitButton.setBackground(Color.blue);
		submitButton.setForeground(Color.WHITE);
		panel.add(submitButton, BorderLayout.EAST);
		return panel;
	}
	
	public static void appendTask(String appendage) {
		taskField.setText(appendage);
		//System.out.println(taskField.getText());
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Submit Task")) {
			list.add(taskField.getText());
			list.add(locationField.getText());
			list.add(timeField.getText());
			if (infoField.getText().equals("")) {
				list.add("   ");
			}
			else {
			list.add(infoField.getText());
			}
			taskField.setText("");
			locationField.setText("");
			timeField.setText("");
			infoField.setText("");
		}
		
	}


	
}
