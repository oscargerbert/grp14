package main;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The dialog for editing and adding a new item. 
 * TODO: better name?
 * @author 
 *
 */
public class ContentFrame {
	private boolean shouldFill = true;
	private boolean shouldWeightX = true;
	private boolean RIGHT_TO_LEFT = false;
	
	// from
	private JTextField fromField_Day;
	private JTextField fromField_Year;
	private JTextField fromField_Month;
	
	// to
	private JTextField toField_Day;
	private JTextField toField_Year;
	private JTextField toField_Month;
	
	private JTextField titleField;

	public void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		JButton okButton;
		JCheckBox checkBox;
		JLabel fromLabel;
		JLabel toLabel;
		GridBagLayout gr = new GridBagLayout();
		pane.setLayout(gr);
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		// 1st row : write title, complete button
		JLabel titleLabel = new JLabel("Title");
		if (shouldWeightX) {
			c.weightx = 0.3;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(titleLabel, c);

		titleField = new JTextField(20);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(titleField, c);

		okButton = new JButton("OK");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.2;
		c.gridx = 2;
		c.gridy = 0;

		

		pane.add(okButton, c);

		// 2nd row : all day checkbox, get current date
		checkBox = new JCheckBox("All day (Current Date)");
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(checkBox, c);

		// 3rd row : from(date and time)
		fromLabel = new JLabel("FROM:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 10;
		pane.add(fromLabel, c);

		fromField_Year = new JTextField(4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 25;
		pane.add(fromField_Year, c);

		JLabel yearLabel = new JLabel("Year");
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 10;
		pane.add(yearLabel, c);
		c.gridy = 3;
		yearLabel = new JLabel("Year");
		pane.add(yearLabel, c);

		fromField_Month = new JTextField(2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 2;
		c.weightx = 25;
		pane.add(fromField_Month, c);

		JLabel monthLabel = new JLabel("Month");
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 4;
		c.gridy = 2;
		c.weightx = 10;
		c.gridwidth = 1;
		pane.add(monthLabel, c);
		c.gridy = 3;
		monthLabel = new JLabel("Month");
		pane.add(monthLabel, c);

		fromField_Day = new JTextField(2);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 5;
		c.gridy = 2;
		c.weightx = 25;
		pane.add(fromField_Day, c);

		JLabel dayLabel = new JLabel("Day");
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 6;
		c.gridy = 2;
		c.weightx = 10;
		c.gridwidth = 1;
		pane.add(dayLabel, c);
		c.gridy = 3;
		dayLabel = new JLabel("Day");
		pane.add(dayLabel, c);

		// 4th row : to(date and time)
		toLabel = new JLabel("TO:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 0;
		c.gridy = 3;
		pane.add(toLabel, c);

		toField_Year = new JTextField(4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		pane.add(toField_Year, c);

		toField_Month = new JTextField(4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 3;
		pane.add(toField_Month, c);

		toField_Day = new JTextField(4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 5;
		c.gridy = 3;
		pane.add(toField_Day, c);

		// 5th row : repeat checkbox
		checkBox = new JCheckBox("Repeat");
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 4;
		pane.add(checkBox, c);

		// 6th row: category, priority buttons
		button = new JButton("Category");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 5;
		pane.add(button, c);

		button = new JButton("Priority");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 5;
		pane.add(button, c);

		// button = new JButton("5");
		checkBox = new JCheckBox("Back up");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 0.05; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.gridx = 0; // aligned with button 2
		c.gridwidth = 4; // 2 columns wide
		c.gridy = 6; // third row
		pane.add(checkBox, c);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get values from input fields
				int startDay = Integer.parseInt(fromField_Day.getText());
				int startMonth = Integer.parseInt(fromField_Month.getText());
				int startYear = Integer.parseInt(fromField_Year.getText());				
				
				int endDay = Integer.parseInt(toField_Day.getText());
				int endMonth = Integer.parseInt(toField_Month.getText());
				int endtYear = Integer.parseInt(toField_Year.getText());
				
				String title = titleField.getText();
				

				// call controller addNewEvent
				Main.controller.addNewEvent(startDay, startMonth, startYear, endDay, endMonth, endtYear, title, "");
				Main.controller.updateViews();

			}
		});
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("New Task");
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 600) / 2;
		frame.setLocation(w, h);
		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(400, 600);
		frame.setVisible(true);
	}

}
