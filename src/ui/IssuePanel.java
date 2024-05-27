package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import domain.Issue;
import domain.Project;

public class IssuePanel extends JPanel {
	
	// constructor
	public IssuePanel() {
		
	}
	
	public IssuePanel(Issue issue) {
		this.issue = issue;
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		setBorder(border);
		initialize();
	}
	
	public IssuePanel(String category) {
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		setBorder(border);
		initializeCategory();
	}
	
	// variables
	private Issue issue;
	private final int HEIGHT = 50;
	private final int LENGTH = 750;
	private final int LABEL_LENGTH = 100;
	private final LineBorder DEFAULT_BORDER = new LineBorder(Color.gray);
	
	// methods
	private void initialize() {
		add(createLabel(String.valueOf(issue.getId())));
		add(createLabel(issue.getTitle()));
		add(createLabel(issue.getPriority()));
		add(createLabel(issue.getReporter()));
		add(createLabel(issue.getState()));
	}
	
	private void initializeCategory() {
		add(createLabel("ID"));
		add(createLabel("TITLE"));
		add(createLabel("PRIORITY"));
		add(createLabel("REPORTER"));
		add(createLabel("STATE"));
	}
	
	private JLabel createLabel(String value) {
		JLabel label = new JLabel(value);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setPreferredSize(new Dimension(LABEL_LENGTH, HEIGHT));
		label.setBorder(DEFAULT_BORDER);
		
		return label;
	}

}
