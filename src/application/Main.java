package application;

import ui.SwingMainFrame;

public class Main {
	public static void main(String[] args) {
		Application app = new Application();
		app.init();
		
		SwingMainFrame swingUI = new SwingMainFrame(app);
		swingUI.display();
	}

}
