package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import data.EventList;

/**
 * This panel contains a simple JTable object displaying the
 * TimeManager events.
 * @author 
 *
 */
public class ListPanel implements View {

	private JPanel mainpanel;
	private int subPanelNumber = 1;
	private ArrayList MainList = new ArrayList();
	private JTable table;
	private Controller controller;

	public ListPanel(Controller c) {
		// register this view to the controller to keep track of changes to model
		controller = c;
		controller.registerView(this);
		
		mainpanel = new JPanel(new GridLayout(subPanelNumber, 0));
		//mainpanel = new JPanel(new FlowLayout());
		setMainPanel();
	}

	private void setMainPanel() {
		/*
		for (int i = 0; i < subPanelNumber; i++) {
			JPanel panel = new JPanel(new GridBagLayout());
			panel.setBorder(BorderFactory.createLineBorder(Color.gray));
			MainList.add(panel);
			mainpanel.add(panel);
		}
		*/
		
		table = new JTable(Main.controller.getEventModel());
		mainpanel.add(new JScrollPane(table));
		
		
	}

	public void updatePanel() {
		mainpanel.removeAll();
		setMainPanel();
	}

	public JPanel getPanel() {
		return mainpanel;
	}

	@Override
	public void updateView(EventList eventList) {
		//System.out.println("updateView "+eventList.getRowCount());
		//table.setModel(eventList);
		table.updateUI();
		
	}

}
