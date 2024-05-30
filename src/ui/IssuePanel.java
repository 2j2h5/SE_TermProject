package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		initialize();
	}
	
	public IssuePanel(String category) {		
		initializeCategory();
	}
	
	// variables
	private Issue issue;
	private final int HEIGHT = 50;
	private final int LENGTH = 750;
	private final int LABEL_LENGTH = 100;
	private final LineBorder DEFAULT_BORDER = new LineBorder(Color.BLACK);
	private final LineBorder HOVER_BORDER = new LineBorder(Color.RED, 3);
	
	// methods
	private void initialize() {
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		setBorder(DEFAULT_BORDER);
		
		add(createLabel(String.valueOf(issue.getId())));
		add(createLabel(issue.getTitle()));
		add(createLabel(issue.getPriority()));
		add(createLabel(issue.getReporter()));
		add(createLabel(issue.getState()));
		
		addMouseListener(new HoverMouseListener());
	}
	
	private void initializeCategory() {
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		setBorder(DEFAULT_BORDER);
		
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
		label.setBorder(new LineBorder(Color.gray));
		
		return label;
	}
	
	private class HoverMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			setBorder(HOVER_BORDER);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setBorder(DEFAULT_BORDER);
		}
	}

}
