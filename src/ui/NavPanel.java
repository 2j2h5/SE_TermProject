package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import application.Application;

public class NavPanel extends JPanel{
	
	// constructor
	public NavPanel() {
		
	}
	
	public NavPanel(Application app) {
		this.app = app;
		initialize();
	}
	
	// variables
	private Application app;
	private UserPanel userPanel;
	
	// methods
	public void initialize() {
		userPanel = new UserPanel(app);
		
		this.setLayout(new BorderLayout());;
		this.add(userPanel, BorderLayout.EAST);
	}

}
