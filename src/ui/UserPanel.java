package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.Application;

public class UserPanel extends JPanel {
	
	// constructor
	public UserPanel() {
		
	}
	
	public UserPanel(Application app) {
		this.app = app;
		setLayout(new FlowLayout());
		initialize();
	}
	
	// variables
	private Application app;
	private JTextField txtId;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblLoggedInUser;
    private JButton btnLogout;
	
	// methods
	private void initialize() {
		if (app.isLoggedIn()) {
			displayLoggedInPanel();
		} else {
			displayLoginPanel();
		}
	}
	
	private void displayLoginPanel() {
		this.removeAll();
		
		txtId = new JTextField(10);
		txtPassword = new JPasswordField(10);
		btnLogin = new JButton("Log in");
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String password = new String(txtPassword.getPassword());
				
				if (app.login(id, password)) {
					displayLoggedInPanel();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid id or password.");
				}
			}
		});
		
		this.add(new JLabel("ID:"));
		this.add(txtId);
		this.add(new JLabel("Password:"));
		this.add(txtPassword);
		this.add(btnLogin);
		
		this.revalidate();
		this.repaint();
	}
	
	private void displayLoggedInPanel() {
		this.removeAll();
		
		lblLoggedInUser = new JLabel("Logged in as: " + app.getLoggedInUser());
		btnLogout = new JButton("Log out");
		
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				app.logout();
				displayLoginPanel();
			}
		});
		
		this.add(lblLoggedInUser);
		this.add(btnLogout);
		
		this.revalidate();
		this.repaint();
	}
	
}
