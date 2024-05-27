package ui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import application.Application;
import domain.Project;
import domain.Issue;

public class BodyPanel extends JPanel{
	
	// constructor
	public BodyPanel() {
		
	}
	
	public BodyPanel(Application app) {
		this.app = app;
		setLayout(new GridLayout(0, 1, 0, 10));
		initialize();
	}
	
	// variables
	private Application app;
	
	// methods
	private void initialize() {
        showProjects();
	}
	
	private void showProjects() {
        removeAll();
        List<Project> projects = app.getProjectService().getAllProjects();
        
        JPanel projectContainer = new JPanel();
        
        projectContainer.setLayout(new BoxLayout(projectContainer, BoxLayout.Y_AXIS));
        projectContainer.add(new ProjectPanel("category"));
        projectContainer.add(Box.createVerticalStrut(20));
        
        for (Project project : projects) {
        	projectContainer.add(new ProjectPanel(project));
            projectContainer.add(Box.createVerticalStrut(10));
        }
        
        add(projectContainer);
        add(Box.createVerticalGlue());
        revalidate();
        repaint();
    }
    
    private void showIssues() {
        removeAll();
        List<Issue> issues = app.getIssueService().getAllIssues();
        for (Issue issue : issues) {
            add(new IssuePanel(issue));
        }
        revalidate();
        repaint();
    }

}
