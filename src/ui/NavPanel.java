package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.Application;

public class NavPanel extends JPanel {
	
	// constructor
	public NavPanel() {
		
	}
	
	public NavPanel(Application app, BodyPanel body) {
		this.app = app;
		this.body = body;
		
		initialize();
	}
	
	// variables
	private Application app;
	private BodyPanel body;
	private JButton btnHome;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JButton btnAdvancedSearch;
	private JButton btnReportIssue;
	private JButton btnNewAccount;
	private JButton btnNewProject;
	
	// methods
	
	private void initialize() {
		setLayout(new FlowLayout());
		
		btnHome = new JButton("Home");
		txtSearch = new JTextField(10);
		btnSearch = new JButton("Search");
		btnAdvancedSearch = new JButton("Advanced Search");
		btnReportIssue = new JButton("Report Issue");
		btnNewAccount = new JButton("New Account");
		btnNewProject = new JButton("New Project");
		
		btnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				body.showProjects();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String keyword = txtSearch.getText();
				if (body.getState().equals("project")) {
					body.showProjects(keyword);
				} else if (body.getState().equals("issue")) {
					body.showIssues(keyword);
				}
				txtSearch.setText("");
			}
		});
		
		btnAdvancedSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				body.showSearch();
			}
		});
		
		btnReportIssue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn()) {
					body.showReport();
				} else {
					JOptionPane.showMessageDialog(null, "You can report issue after log in.");
				}
			}
		});
		
		btnNewAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn() && app.getLoggedInUser().equals("admin")) {
					body.showNewAccount();
				} else {
					JOptionPane.showMessageDialog(null, "Only admin can create new account");
				}
			}
		});
		
		btnNewProject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn() && app.getLoggedInUser().equals("admin")) {
					body.showNewProject();
				} else {
					JOptionPane.showMessageDialog(null, "Only admin can create new account");
				}
			}
		});
		
		this.add(btnHome);
		this.add(txtSearch);
		this.add(btnSearch);
		this.add(btnAdvancedSearch);
		this.add(btnReportIssue);
		this.add(btnNewAccount);
		this.add(btnNewProject);
		
		this.revalidate();
		this.repaint();
	}

}
