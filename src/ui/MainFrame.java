package ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private HeaderPanel header;
	private BodyPanel body;
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;
	
	// methods
	public void display() {
		body = new BodyPanel(app);
		header = new HeaderPanel(app, body);
		
		setLayout(new BorderLayout());
		add(header, BorderLayout.NORTH);
		
		JScrollPane jspScrolledSection= new JScrollPane(body);
		jspScrolledSection.getVerticalScrollBar().setUnitIncrement(25);
		add(jspScrolledSection, BorderLayout.CENTER);
		
		pack();
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				app.shutdown();
				System.exit(0);
			}
		});
	}
}
