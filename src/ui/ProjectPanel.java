package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import domain.Project;

public class ProjectPanel extends JPanel {
	
	// constructor
	public ProjectPanel() {
		
	}
	
	public ProjectPanel(Project project) {
		this.project = project;
		
		initialize();
	}
	
	public ProjectPanel(String category) {
		initializeCategory();
	}
	
	// variables
	private Project project;
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
		
		add(createLabel(String.valueOf(project.getId())));
		add(createLabel(project.getName()));
		add(createLabel(project.getResponsiblePL()));
		
		addMouseListener(new HoverMouseListener());
	}
	
	private void initializeCategory() {
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		setBorder(DEFAULT_BORDER);
		
		add(createLabel("ID"));
		add(createLabel("NAME"));
		add(createLabel("RESPONSIBLE PL"));
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
