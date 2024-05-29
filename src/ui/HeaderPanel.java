package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import application.Application;

public class HeaderPanel extends JPanel{
	
	// constructor
	public HeaderPanel() {
		
	}
	
	public HeaderPanel(Application app, BodyPanel body) {
		this.app = app;
		this.body = body;
		
		initialize();
	}
	
	// variables
	private Application app;
	private BodyPanel body;
	private NavPanel navPanel;
	private UserPanel userPanel;
	
	// methods
	public void initialize() {
		userPanel = new UserPanel(app);
		navPanel = new NavPanel(app, body);
		
		this.setLayout(new BorderLayout());;
		this.add(navPanel, BorderLayout.WEST);
		this.add(userPanel, BorderLayout.EAST);
	}

}
