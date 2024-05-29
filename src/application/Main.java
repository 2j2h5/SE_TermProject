package application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import exceptions.ValidationException;
import ui.MainFrame;

public class Main {
	public static void main(String[] args) {
		Application app = new Application();
		app.init();
		
		MainFrame swingUI = new MainFrame(app);
		swingUI.display();
	}

}
