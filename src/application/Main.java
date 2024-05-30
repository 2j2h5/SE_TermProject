package application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import exceptions.ValidationException;
import ui.MainFrame;

public class Main {
	public static void main(String[] args) {
		Application app = new Application();
		app.init();
		
		app.getAccountService().enterInfo("id", "admin");
		app.getAccountService().enterInfo("password", "admin");
		try {
			app.getAccountService().requestMake();
		} catch (ValidationException e) {
			System.out.println("Admin account already exists");
		}
		
		
		MainFrame swingUI = new MainFrame(app);
		swingUI.display();
	}

}
