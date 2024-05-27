package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		setBorder(border);
		initialize();
	}
	
	public ProjectPanel(String category) {
		setLayout(new GridLayout(1, 0, 0, 10));
		setPreferredSize(new Dimension(LENGTH, HEIGHT));
		Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
		setBorder(border);
		initializeCategory();
	}
	
	// variables
	private Project project;
	private final int HEIGHT = 50;
	private final int LENGTH = 750;
	private final int ID_LENGTH = 100;
	private final int NAME_LENGTH = 100;
	private final int RESPONSIBLEPL_LENGTH = 100;
	private final LineBorder LINE_BORDER = new LineBorder(Color.gray);
	
	// methods
	private void initialize() {
		JLabel lblId = new JLabel(String.valueOf(project.getId()));
		JLabel lblName = new JLabel(project.getName());
		JLabel lblResponsiblePL = new JLabel(project.getResponsiblePL());
		
		lblId.setVerticalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.CENTER);
		lblResponsiblePL.setVerticalAlignment(SwingConstants.CENTER);
		
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsiblePL.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblId.setPreferredSize(new Dimension(ID_LENGTH, HEIGHT));
		lblName.setPreferredSize(new Dimension(NAME_LENGTH, HEIGHT));
		lblResponsiblePL.setPreferredSize(new Dimension(RESPONSIBLEPL_LENGTH, HEIGHT));
		
		lblId.setBorder(LINE_BORDER);
		lblName.setBorder(LINE_BORDER);
		lblResponsiblePL.setBorder(LINE_BORDER);
		
		add(lblId);
		add(lblName);
		add(lblResponsiblePL);
	}
	
	private void initializeCategory() {
		JLabel lblId = new JLabel("ID");
		JLabel lblName = new JLabel("NAME");
		JLabel lblResponsiblePL = new JLabel("RESPONSIBLE PL");
		
		lblId.setVerticalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.CENTER);
		lblResponsiblePL.setVerticalAlignment(SwingConstants.CENTER);
		
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsiblePL.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblId.setPreferredSize(new Dimension(ID_LENGTH, HEIGHT));
		lblName.setPreferredSize(new Dimension(NAME_LENGTH, HEIGHT));
		lblResponsiblePL.setPreferredSize(new Dimension(RESPONSIBLEPL_LENGTH, HEIGHT));
		
		lblId.setBorder(LINE_BORDER);
		lblName.setBorder(LINE_BORDER);
		lblResponsiblePL.setBorder(LINE_BORDER);
		
		add(lblId);
		add(lblName);
		add(lblResponsiblePL);
	}

}
