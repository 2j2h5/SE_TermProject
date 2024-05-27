package ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import application.Application;

public class MainFrame extends JFrame{

	// constructor
	public MainFrame() {
		
	}
	
	public MainFrame(Application app) {
		this.app = app;
	}
	
	// variables
	private Application app;
	private NavPanel nav;
	private BodyPanel body;
	
	// methods
	public void display() {
		nav = new NavPanel(app);
		body = new BodyPanel(app);
		
		setLayout(new BorderLayout());
		add(nav, BorderLayout.NORTH);
		
		JScrollPane jspScrolledSection= new JScrollPane(body);
		add(jspScrolledSection, BorderLayout.CENTER);
		
		pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setVisible(true);
	}

}
