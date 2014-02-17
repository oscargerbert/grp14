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
 * Main GUI window showing all the control buttons and other UI elements.
 * @author dustin
 *
 */
public class MainWindow {
	// TODO: clean up... and maybe redesign
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	static private Controller controller = null;

	private CalendarPanel calendarPanel;

	public MainWindow(Controller c) {
		controller = c;
		calendarPanel = new CalendarPanel(controller);

	}

	public void addComponentsToPane(final Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton btnNewTask;
		final JButton btnTaskView;
		JButton btnAll, btnHigh;
		final JButton btnCalendar = new JButton("Calendar");
		JLabel label_UpComingTask;
		pane.setLayout(new GridBagLayout());
		final GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
			// natural height, maximum width
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		btnTaskView = new JButton("TaskView");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(btnTaskView, c);

		final ListPanel tasklist = new ListPanel(controller);
		btnTaskView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnTaskView.getText() == "TaskView") {
					btnTaskView.setText("Calendar");
					c.fill = GridBagConstraints.BOTH;
					// c.ipady = 400; //make this component tall
					c.weightx = 0.5;
					c.weighty = 0.5;
					c.gridwidth = 4;
					// c.gridheight=2;
					c.gridx = 0;
					c.gridy = 1;
					pane.remove(calendarPanel);
					pane.add(tasklist.getPanel(), c);
				} else {
					btnTaskView.setText("TaskView");
					c.fill = GridBagConstraints.BOTH;
					// c.ipady = 400; //make this component tall
					c.weightx = 0.5;
					c.weighty = 0.5;
					c.gridwidth = 4;
					// c.gridheight=2;
					c.gridx = 0;
					c.gridy = 1;
					pane.remove(tasklist.getPanel());
					pane.add(calendarPanel, c);
				}
			}
		});

		btnAll = new JButton("All");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(btnAll, c);

		btnHigh = new JButton("High");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(btnHigh, c);

		btnNewTask = new JButton("NewTask");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 0;
		pane.add(btnNewTask, c);

		// NewTask button Listener
		btnNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContentFrame contentframe = new ContentFrame();
				contentframe.createAndShowGUI();
			}
		});
		// add calendar
		c.fill = GridBagConstraints.BOTH;
		// c.ipady = 400; //make this component tall
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = 4;
		// c.gridheight=2;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(calendarPanel, c);

		// button = new JButton("5");
		label_UpComingTask = new JLabel("Upcoming Tasks: "+controller.getEventModel().getRowCount());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 0.05; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 2; // third row
		pane.add(label_UpComingTask, c);
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TimeManager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 800) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 600) / 2;
		frame.setLocation(w, h);
		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Display the window.
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}

}
