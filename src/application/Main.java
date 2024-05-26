package application;

import domain.Account;
import exceptions.ValidationException;
import ui.SwingMainFrame;

public class Main {
	public static void main(String[] args) {
		Application app = new Application();
		app.init();
		
		app.getAccountService().enterInfo("id", "PL1");
		app.getAccountService().enterInfo("password", "PL1");
		try {
			app.getAccountService().requestMake();
			System.out.println("requestMake success!");
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		
		Account admin = app.getAccountService().getAccount("PL1");
		if(admin != null) {
			System.out.println(admin.getPassword());
		}
		
		app.shutdown();
		
		//SwingMainFrame swingUI = new SwingMainFrame(app);
		//swingUI.display();
	}

}
