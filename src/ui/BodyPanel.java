package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import application.Application;
import domain.Project;
import exceptions.ValidationException;
import domain.Issue;

public class BodyPanel extends JPanel{
	
	// constructor
	public BodyPanel() {
		
	}
	
	public BodyPanel(Application app) {
		this.app = app;
		
		initialize();
	}
	
	// variables
	private Application app;
	private String state;
	
	// methods
	private void initialize() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
        showProjects();
	}
	
	public void showProjects() {
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
        
        state = "project";
    }
	
	public void showProjects(String keyword) {
        removeAll();
        List<Project> projects = app.getProjectService().getAllProjects();
        
        JPanel projectContainer = new JPanel();
        
        projectContainer.setLayout(new BoxLayout(projectContainer, BoxLayout.Y_AXIS));
        projectContainer.add(new ProjectPanel("category"));
        projectContainer.add(Box.createVerticalStrut(20));
        
        for (Project project : projects) {
        	if (keyword.equals(Integer.toString(project.getId())) || keyword.equals(project.getName())) {
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
        }
        
        add(projectContainer);
        add(Box.createVerticalGlue());
        revalidate();
        repaint();
        
        state = "project";
    }
    
    public void showIssues(Project project) {
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
        
        state = "issue";
    }
    
    public void showIssues(String keyword) {
    	removeAll();
        List<Issue> issues = app.getIssueService().getAllIssues();
        
        JPanel issueContainer = new JPanel();
        
        issueContainer.setLayout(new BoxLayout(issueContainer, BoxLayout.Y_AXIS));
        issueContainer.add(new IssuePanel("category"));
        issueContainer.add(Box.createVerticalStrut(20));
        
        for (Issue issue : issues) {
        	if (keyword.equals(Integer.toString(issue.getProject())) || keyword.equals(issue.getTitle())) {
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
        
        state = "issue";
    }
    
    public void showIssues(List<Issue> issues) {
    	removeAll();
        
        JPanel issueContainer = new JPanel();
        
        issueContainer.setLayout(new BoxLayout(issueContainer, BoxLayout.Y_AXIS));
        issueContainer.add(new IssuePanel("category"));
        issueContainer.add(Box.createVerticalStrut(20));
        
        for (Issue issue : issues) {
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
        add(issueContainer);
        add(Box.createVerticalGlue());
        revalidate();
        repaint();
        
        state = "issue";
    }
    
    public void showSearch() {
    	removeAll();
    	
    	JPanel searchContainer = new JPanel();
    	
    	searchContainer.setLayout(new BoxLayout(searchContainer, BoxLayout.Y_AXIS));
    	
    	JPanel firstRow = new JPanel();
    	JPanel secondRow = new JPanel();
    	JPanel thirdRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	
    	JLabel lblInvolvedProject = new JLabel("Project:");
    	JLabel lblId = new JLabel("Id:");
    	JLabel lblTitle = new JLabel("Title:");
    	JLabel lblPriority = new JLabel("Priority:");
    	JLabel lblState = new JLabel("State:");
    	JLabel lblAssignee = new JLabel("Assignee");
    	JLabel lblReporter = new JLabel("Reporter");
    	JLabel lblFixer = new JLabel("Fixer");
    	
    	JTextField txtInvolvedProject = new JTextField(10);
    	JTextField txtId = new JTextField(10);
    	JTextField txtTitle = new JTextField(10);
    	JTextField txtPriority = new JTextField(10);
    	JTextField txtState = new JTextField(10);
    	JTextField txtAssignee = new JTextField(10);
    	JTextField txtReporter = new JTextField(10);
    	JTextField txtFixer = new JTextField(10);
    	
    	firstRow.add(Box.createVerticalStrut(100));
    	firstRow.add(lblInvolvedProject);
    	firstRow.add(txtInvolvedProject);
    	firstRow.add(lblId);
    	firstRow.add(txtId);
    	firstRow.add(lblTitle);
    	firstRow.add(txtTitle);
    	
    	secondRow.add(lblPriority);
    	secondRow.add(txtPriority);
    	secondRow.add(lblState);
    	secondRow.add(txtState);
    	
    	thirdRow.add(lblAssignee);
    	thirdRow.add(txtAssignee);
    	thirdRow.add(lblReporter);
    	thirdRow.add(txtReporter);
    	thirdRow.add(lblFixer);
    	thirdRow.add(txtFixer);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	JButton btnSearch = new JButton("Search");
    	
    	btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String searchedInvolvedProject = txtInvolvedProject.getText();
				String searchedId = txtId.getText();
				String searchedTitle = txtTitle.getText();
				String searchedPriority = txtPriority.getText();
				String searchedState = txtState.getText();
				String searchedAssignee = txtAssignee.getText();
				String searchedReporter = txtReporter.getText();
				String searchedFixer = txtFixer.getText();
				
				List<Issue> matchingIssues = new ArrayList<>() ;
				
				try {
					if (searchedInvolvedProject.equals("")) {
						app.getIssueService().enterInfo("involvedProject", 0);
					} else {
						app.getIssueService().enterInfo("involvedProject", Integer.parseInt(searchedInvolvedProject));
					}
					
					if (searchedId.equals("")) {
						app.getIssueService().enterInfo("id", 0);
					} else {
						app.getIssueService().enterInfo("id", Integer.parseInt(searchedId));
					}
					
					if (searchedTitle.equals("")) {
						app.getIssueService().enterInfo("title", null);
					} else {
						app.getIssueService().enterInfo("title", searchedTitle);
					}
					
					if (searchedPriority.equals("")) {
						app.getIssueService().enterInfo("priority", null);
					} else {
						app.getIssueService().enterInfo("priority", searchedPriority);
					}
					
					if (searchedState.equals("")) {
						app.getIssueService().enterInfo("state", null);
					} else {
						app.getIssueService().enterInfo("state", searchedState);
					}
					
					if (searchedAssignee.equals("")) {
						app.getIssueService().enterInfo("assignee", null);
					} else {
						app.getIssueService().enterInfo("assignee", searchedAssignee);
					}
					
					if (searchedReporter.equals("")) {
						app.getIssueService().enterInfo("reporter", null);
					} else {
						app.getIssueService().enterInfo("reporter", searchedReporter);
					}
					
					if (searchedFixer.equals("")) {
						app.getIssueService().enterInfo("fixer", null);
					} else {
						app.getIssueService().enterInfo("fixer", searchedFixer);
					}
					
					matchingIssues = app.getIssueService().requestBrowse();
					showIssues(matchingIssues);
				} catch (ClassCastException | NullPointerException | NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid value");
				}
			}
		});
    	
    	searchContainer.add(firstRow);
    	searchContainer.add(secondRow);
    	searchContainer.add(thirdRow);
    	searchContainer.add(btnSearch);
    	
    	add(searchContainer);
    	add(Box.createVerticalGlue());
    	revalidate();
        repaint();
    }
    
    public void showReport() {
		removeAll();
		
		List<Project> projects = app.getProjectService().getAllProjects();
    	
    	JPanel reportContainer = new JPanel();
    	
    	reportContainer.setLayout(new BoxLayout(reportContainer, BoxLayout.Y_AXIS));
    	
    	JPanel firstRow = new JPanel();
    	JPanel secondRow = new JPanel();
    	JPanel thirdRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	
    	JLabel lblInvolvedProject = new JLabel("Project:");
    	JLabel lblTitle = new JLabel("Title:");
    	JLabel lblDescription = new JLabel("Description:");
    	JLabel lblPriority = new JLabel("Priority:");
    	
    	JComboBox<Project> cbxInvolvedProject = new JComboBox<>();
    	for (Project project : projects) {
    		cbxInvolvedProject.addItem(project);
    	}
    	
    	JTextField txtTitle = new JTextField(30);
    	
    	JTextArea txtDescription = new JTextArea(20, 40);
    	JScrollPane scrollDescription = new JScrollPane(txtDescription);
    	
    	String[] priorities = {"blocker", "critical", "major", "minor", "trivial"};
    	JComboBox cbxPriority = new JComboBox(priorities);
    	cbxPriority.setSelectedIndex(2);
    	
    	firstRow.add(Box.createVerticalStrut(100));
    	firstRow.add(lblTitle);
    	firstRow.add(txtTitle);
    	
    	secondRow.add(lblDescription);
    	secondRow.add(scrollDescription);
    	
    	thirdRow.add(lblInvolvedProject);
    	thirdRow.add(cbxInvolvedProject);
    	thirdRow.add(lblPriority);
    	thirdRow.add(cbxPriority);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	JButton btnReport = new JButton("Report");
    	
    	btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn()) {
					String title = txtTitle.getText();
					String description = txtDescription.getText();
					int involvedProject = ((Project) cbxInvolvedProject.getSelectedItem()).getId();
					String priority = (String) cbxPriority.getSelectedItem();
					
					if (involvedProject == 0) {
						app.getIssueService().enterInfo("involvedProject", 0);
					} else {
						app.getIssueService().enterInfo("involvedProject", involvedProject);
					}
					
					if (title.equals("")) {
						app.getIssueService().enterInfo("title", null);
					} else {
						app.getIssueService().enterInfo("title", title);
					}
					
					if (description.equals("")) {
						app.getIssueService().enterInfo("description", null);
					} else {
						app.getIssueService().enterInfo("description", description);
					}
					
					if (priority.equals("")) {
						app.getIssueService().enterInfo("priority", null);
					} else {
						app.getIssueService().enterInfo("priority", priority);
					}
					
					if (app.getIssueService().checkValidation()) {
						try {
							app.getIssueService().requestMake();
							showProjects();
						} catch (ValidationException e1) {
							e1.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "You can report issue after log in.");
				}
			}
		});
    	
    	reportContainer.add(firstRow);
    	reportContainer.add(secondRow);
    	reportContainer.add(thirdRow);
    	reportContainer.add(btnReport);
    	
    	add(reportContainer);
    	add(Box.createVerticalGlue());
    	revalidate();
        repaint();
    }
    
    public void showNewAccount() {
    	removeAll();
    	
    	JPanel newAccountContainer = new JPanel();
    	
    	newAccountContainer.setLayout(new BoxLayout(newAccountContainer, BoxLayout.Y_AXIS));
    	
    	JPanel firstRow = new JPanel();
    	JPanel secondRow = new JPanel();
    	JPanel thirdRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	
    	JLabel lblId = new JLabel("Id:");
    	JLabel lblPassword = new JLabel("Password:");
    	JLabel lblPasswordConfirm = new JLabel("Confirm PassWord:");
    	
    	JTextField txtId = new JTextField(10);
    	JPasswordField txtPassword = new JPasswordField(10);
    	JPasswordField txtPasswordConfirm = new JPasswordField(10);
    	
    	firstRow.add(Box.createVerticalStrut(100));
    	firstRow.add(lblId);
    	firstRow.add(txtId);
    	
    	secondRow.add(lblPassword);
    	secondRow.add(txtPassword);
    	
    	secondRow.add(lblPasswordConfirm);
    	secondRow.add(txtPasswordConfirm);
    	
    	JButton btnNewAccount = new JButton("New Account");
    	
    	btnNewAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String password = new String(txtPassword.getPassword());
				String passwordConfirm = new String(txtPasswordConfirm.getPassword());
				
				if (password.equals(passwordConfirm)) {
					app.getAccountService().enterInfo("id", id);
					app.getAccountService().enterInfo("password", password);
					try {
						app.getAccountService().requestMake();
						showProjects();
					} catch (ValidationException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "ID is not available");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Password do not match");
				}
			}
		});
    	
    	thirdRow.add(btnNewAccount);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	newAccountContainer.add(firstRow);
    	newAccountContainer.add(secondRow);
    	newAccountContainer.add(thirdRow);
    	//newAccountContainer.add(btnNewAccount);
    	
    	add(newAccountContainer);
    	add(Box.createVerticalGlue());
    	revalidate();
        repaint();
    }

	public void showComments(Issue issue) {
		
	}
	
	public String getState() {
		return state;
	}

}
