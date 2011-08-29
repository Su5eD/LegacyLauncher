package org.spoutcraft.launcher;

import java.io.File;
import java.util.Arrays;

import javax.swing.UIManager;

import org.spoutcraft.launcher.GUI.LoginForm;
import org.spoutcraft.launcher.Logging.SystemConsoleListener;

public class Main {
	
	public Main() throws Exception {
		main(new String[0]);
	}
	
    public static void main(String[] args) throws Exception {  	
        
    	if (Arrays.asList(args).contains("--portable") || new File("spoutcraft-portable").exists()) {
            PlatformUtils.setPortable(true);
        }
        
		PlatformUtils.getWorkingDirectory().mkdir();
		new File(PlatformUtils.getWorkingDirectory(), "spoutcraft").mkdir();
		
		if (!PlatformUtils.getWorkingDirectory().exists()) {
    		PlatformUtils.getWorkingDirectory().mkdirs();
    	}
    	SystemConsoleListener listener = new SystemConsoleListener();
    	listener.initialize();
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("[WARNING] Can't get system LnF: " + e);
        }
		
		LoginForm login = new LoginForm();
		login.setVisible(true);
	}
	
}
