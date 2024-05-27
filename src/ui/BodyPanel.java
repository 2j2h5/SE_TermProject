package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
        	JPanel projectPanel = new ProjectPanel(project);
        	projectContainer.add(projectPanel);
            projectContainer.add(Box.createVerticalStrut(10));
            projectPanel.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e) {
					showIssues(project);
				}
				public void mousePressed(MouseEvent e) {
				}
				public void mouseReleased(MouseEvent e) {
				}
				public void mouseEntered(MouseEvent e) {
				}
				public void mouseExited(MouseEvent e) {
				}
			});
        }
        
        add(projectContainer);
        add(Box.createVerticalGlue());
        revalidate();
        repaint();
    }
    
    private void showIssues(Project project) {
        removeAll();
        List<Issue> issues = app.getIssueService().getAllIssues();
        
        JPanel issueContainer = new JPanel();
        
        issueContainer.setLayout(new BoxLayout(issueContainer, BoxLayout.Y_AXIS));
        issueContainer.add(new IssuePanel("category"));
        issueContainer.add(Box.createVerticalStrut(20));
        
        for (Issue issue : issues) {
        	if (project.getId() == issue.getProject()) {
        		JPanel issuePanel = new IssuePanel(issue);
            	issueContainer.add(issuePanel);
                issueContainer.add(Box.createVerticalStrut(10));
                issuePanel.addMouseListener(new MouseListener() {
    				public void mouseClicked(MouseEvent e) {
    					showComments(issue);
    				}
    				public void mousePressed(MouseEvent e) {
    				}
    				public void mouseReleased(MouseEvent e) {
    				}
    				public void mouseEntered(MouseEvent e) {
    				}
    				public void mouseExited(MouseEvent e) {
    				}
    			});
        	}
        }
        add(issueContainer);
        add(Box.createVerticalGlue());
        revalidate();
        repaint();
    }

	private void showComments(Issue issue) {
		
	}

}
