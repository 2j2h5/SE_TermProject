package ui;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import domain.Issue;
import domain.Project;

public class IssuePanel extends JPanel {
	
	// constructor
	public IssuePanel() {
		
	}
	
	public IssuePanel(Issue issue) {
		this.issue = issue;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		setBorder(border);
		initialize();
	}
	
	// variables
	private Issue issue;
	
	// methods
	private void initialize() {
		add(new JLabel(String.valueOf(issue.getId())));
		add(new JLabel(issue.getTitle()));
	}

}
