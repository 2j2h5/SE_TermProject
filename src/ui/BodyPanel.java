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
import domain.Account;
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
    					showDetails(issue);
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
    					showDetails(issue);
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
					showDetails(issue);
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
    	JPanel fourthRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	fourthRow.setLayout(new FlowLayout());
    	
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
    	
    	firstRow.add(lblInvolvedProject);
    	firstRow.add(txtInvolvedProject);
    	firstRow.add(lblId);
    	firstRow.add(txtId);
    	firstRow.add(lblTitle);
    	firstRow.add(txtTitle);
    	firstRow.add(Box.createVerticalStrut(100));
    	
    	secondRow.add(lblPriority);
    	secondRow.add(txtPriority);
    	secondRow.add(lblState);
    	secondRow.add(txtState);
    	secondRow.add(Box.createVerticalStrut(100));
    	
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
    	
    	fourthRow.add(btnSearch);
    	fourthRow.add(Box.createVerticalStrut(100));
    	
    	searchContainer.add(firstRow);
    	searchContainer.add(secondRow);
    	searchContainer.add(thirdRow);
    	searchContainer.add(fourthRow);
    	
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
    	JPanel fourthRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	fourthRow.setLayout(new FlowLayout());
    	
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
    	
    	firstRow.add(lblTitle);
    	firstRow.add(txtTitle);
    	firstRow.add(Box.createVerticalStrut(100));
    	
    	secondRow.add(lblDescription);
    	secondRow.add(scrollDescription);
    	secondRow.add(Box.createVerticalStrut(100));
    	
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
					} else {
						JOptionPane.showMessageDialog(null, "Invalid value");
					}
				} else {
					JOptionPane.showMessageDialog(null, "You can report issue after log in");
				}
			}
		});
    	
    	fourthRow.add(btnReport);
    	fourthRow.add(Box.createVerticalStrut(100));
    	
    	reportContainer.add(firstRow);
    	reportContainer.add(secondRow);
    	reportContainer.add(thirdRow);
    	reportContainer.add(fourthRow);
    	
    	add(reportContainer);
    	add(Box.createVerticalGlue());
    	revalidate();
        repaint();
    }
    
    public void showReport(Issue issue) {
		removeAll();
		
		List<Project> projects = app.getProjectService().getAllProjects();
		List<Account> accounts = app.getAccountService().getAllAccount();
    	
    	JPanel reportContainer = new JPanel();
    	
    	reportContainer.setLayout(new BoxLayout(reportContainer, BoxLayout.Y_AXIS));
    	
    	JPanel firstRow = new JPanel();
    	JPanel secondRow = new JPanel();
    	JPanel thirdRow = new JPanel();
    	JPanel fourthRow = new JPanel();
    	JPanel fifthRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	fourthRow.setLayout(new FlowLayout());
    	
    	JLabel lblTitle = new JLabel("Title:");
    	JLabel lblDescription = new JLabel("Description:");
    	JLabel lblInvolvedProject = new JLabel("Project:");
    	JLabel lblPriority = new JLabel("Priority:");
    	JLabel lblState = new JLabel("State:");
    	JLabel lblAssignee = new JLabel("Assignee:");
    	
    	JTextField txtTitle = new JTextField(issue.getTitle(), 30);
    	JTextArea txtDescription = new JTextArea(issue.getDescription(), 20, 40);
    	JScrollPane scrollDescription = new JScrollPane(txtDescription);
    	JComboBox<Project> cbxInvolvedProject = new JComboBox<>();
    	for (Project project : projects) {
    		cbxInvolvedProject.addItem(project);
    		if (project.getId() == issue.getId()) {
    			Project involvedProject = project;  
    			cbxInvolvedProject.setSelectedItem(involvedProject);
    		}
    	}
    	String[] priorities = {"blocker", "critical", "major", "minor", "trivial"};
    	JComboBox cbxPriority = new JComboBox(priorities);
    	cbxPriority.setSelectedItem(issue.getProject());
    	String[] states = {"assigned", "fixed", "resolved", "closed", "reopended"};
    	JLabel lblStateText = new JLabel(issue.getState());
    	JComboBox cbxState = new JComboBox(states);
    	if (issue.getState() != "new") {
    		cbxState.setSelectedItem(issue.getState());
    	}
    	JComboBox<Account> cbxAssignee = new JComboBox<>();
    	cbxAssignee.addItem(null);
    	for (Account account : accounts) {
    		cbxAssignee.addItem(account);
    		if (account.getId().equals(issue.getAssignee())) {
    			Account assignee = account;
    			cbxAssignee.setSelectedItem(assignee);
    		}
    	}
    	
    	firstRow.add(lblTitle);
    	firstRow.add(txtTitle);
    	firstRow.add(Box.createVerticalStrut(100));
    	
    	secondRow.add(lblDescription);
    	secondRow.add(scrollDescription);
    	secondRow.add(Box.createVerticalStrut(100));
    	
    	thirdRow.add(lblInvolvedProject);
    	thirdRow.add(cbxInvolvedProject);
    	thirdRow.add(lblPriority);
    	thirdRow.add(cbxPriority);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	fourthRow.add(lblState);
    	if (issue.getState().equals("new")) {
    		fourthRow.add(lblStateText);
    	} else {
    		fourthRow.add(cbxState);
    	}
    	fourthRow.add(lblAssignee);
    	fourthRow.add(cbxAssignee);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	JButton btnEdit = new JButton("Edit");
    	
    	btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn()) {
					String title = txtTitle.getText();
					String description = txtDescription.getText();
					int involvedProject = ((Project) cbxInvolvedProject.getSelectedItem()).getId();
					String priority = (String) cbxPriority.getSelectedItem();
					String state;
					if (issue.getState().equals("new")) {
						state = "new";
					} else {
						state = (String) cbxState.getSelectedItem();
					}
					String assignee;
					if ((Account) cbxAssignee.getSelectedItem() != null) {
						assignee = ((Account) cbxAssignee.getSelectedItem()).getId();
					} else {
						assignee = "";
					}
					
					
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
					
					if (state.equals("")) {
						app.getIssueService().enterInfo("state", null);
					} else {
						app.getIssueService().enterInfo("state", state);
					}
					
					if (assignee.equals("")) {
						app.getIssueService().enterInfo("assignee", null);
					} else {
						app.getIssueService().enterInfo("assignee", assignee);
					}
					
					if (app.getIssueService().checkValidation()) {
						try {
							app.getIssueService().requestEdit(issue.getId());
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
    	
    	fifthRow.add(btnEdit);
    	fifthRow.add(Box.createVerticalStrut(100));
    	
    	reportContainer.add(firstRow);
    	reportContainer.add(secondRow);
    	reportContainer.add(thirdRow);
    	reportContainer.add(fourthRow);
    	reportContainer.add(fifthRow);
    	
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
    	
    	firstRow.add(lblId);
    	firstRow.add(txtId);
    	firstRow.add(Box.createVerticalStrut(100));
    	
    	secondRow.add(lblPassword);
    	secondRow.add(txtPassword);
    	secondRow.add(lblPasswordConfirm);
    	secondRow.add(txtPasswordConfirm);
    	secondRow.add(Box.createVerticalStrut(100));
    	
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

	public void showDetails(Issue issue) {
		removeAll();
		
		List<Project> projects = app.getProjectService().getAllProjects();
    	
    	JPanel detailsContainer = new JPanel();
    	
    	detailsContainer.setLayout(new BoxLayout(detailsContainer, BoxLayout.Y_AXIS));
    	
    	JPanel firstRow = new JPanel();
    	JPanel secondRow = new JPanel();
    	JPanel thirdRow = new JPanel();
    	JPanel fourthRow = new JPanel();
    	JPanel fifthRow = new JPanel();
    	
    	firstRow.setLayout(new FlowLayout());
    	secondRow.setLayout(new FlowLayout());
    	thirdRow.setLayout(new FlowLayout());
    	fourthRow.setLayout(new FlowLayout());
    	fifthRow.setLayout(new FlowLayout());
    	
    	JLabel lblId = new JLabel("Id:");
    	JLabel lblTitle = new JLabel("Title:");
    	JLabel lblDescription = new JLabel("Description:");
    	JLabel lblInvolvedProject = new JLabel("Project:");
    	JLabel lblPriority = new JLabel("Priority:");
    	JLabel lblReporter = new JLabel("Reporter:");
    	JLabel lblReportedDate = new JLabel("Reported Date:");
    	JLabel lblState = new JLabel("State:");
    	JLabel lblAssignee = new JLabel("Assignee:");
    	JLabel lblFixer = new JLabel("Fixer:");
    	
    	JLabel lblIdText = new JLabel(Integer.toString(issue.getId()));
    	JLabel lblTitleText = new JLabel(issue.getTitle());
    	JLabel lblDescriptionText = new JLabel(issue.getDescription());
    	JLabel lblInvolvedProjectText = new JLabel();
    	for (Project project : projects) {
    		if (project.getId() == issue.getProject()) {
    			lblInvolvedProjectText = new JLabel(Integer.toString(issue.getProject()));
    		}
    	}
    	JLabel lblPriorityText = new JLabel(issue.getPriority());
    	JLabel lblReporterText = new JLabel(issue.getReporter());
    	JLabel lblReportedDateText = new JLabel(issue.getReportedDate());
    	JLabel lblStateText = new JLabel(issue.getState());
    	JLabel lblAssigneeText = new JLabel(issue.getAssignee());
    	JLabel lblFixerText = new JLabel(issue.getFixer());
    	
    	firstRow.add(lblId);
    	firstRow.add(lblIdText);
    	firstRow.add(lblTitle);
    	firstRow.add(lblTitleText);
    	firstRow.add(Box.createVerticalStrut(100));
    	
    	secondRow.add(lblDescription);
    	secondRow.add(lblDescriptionText);
    	secondRow.add(Box.createVerticalStrut(100));
    	
    	thirdRow.add(lblInvolvedProject);
    	thirdRow.add(lblInvolvedProjectText);
    	thirdRow.add(lblPriority);
    	thirdRow.add(lblPriorityText);
    	thirdRow.add(Box.createVerticalStrut(100));
    	
    	fourthRow.add(lblReporter);
    	fourthRow.add(lblReporterText);
    	fourthRow.add(lblReportedDate);
    	fourthRow.add(lblReportedDateText);
    	fourthRow.add(Box.createVerticalStrut(100));
    	
    	fifthRow.add(lblState);
    	fifthRow.add(lblStateText);
    	fifthRow.add(lblAssignee);
    	fifthRow.add(lblAssigneeText);
    	fifthRow.add(lblFixer);
    	fifthRow.add(lblFixerText);
    	fifthRow.add(Box.createVerticalStrut(100));
    	
    	JButton btnEdit = new JButton("Edit");
    	
    	btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (app.isLoggedIn()) {
					showReport(issue);
				} else {
					JOptionPane.showMessageDialog(null, "You can edit issue after log in.");
				}
			}
		});
    	
    	detailsContainer.add(firstRow);
    	detailsContainer.add(secondRow);
    	detailsContainer.add(thirdRow);
    	detailsContainer.add(fourthRow);
    	detailsContainer.add(fifthRow);
    	detailsContainer.add(btnEdit);
    	
    	add(detailsContainer);
    	add(Box.createVerticalGlue());
    	revalidate();
        repaint();
	}
	
	public String getState() {
		return state;
	}

}
