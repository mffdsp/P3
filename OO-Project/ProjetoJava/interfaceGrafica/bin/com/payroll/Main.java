package com.payroll;


import javax.swing.*;
import java.awt.*;

public class Main {
	 
	public static void main() {
	
    
    JFrame frame = new JFrame("MATEUS TESTANDO");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JLabel label = new JLabel("clica ai");
	frame.getContentPane().add(label);
	frame.pack();
	frame.setVisible(true);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int height = screenSize.height;
	int width = screenSize.width;
	frame.setSize(width/2, height/2);
	frame.setLocation(width/2-frame.getSize().width/2, height/2-frame.getSize().height/2);
	
	
	}
	//Nimbus set
    //</editor-fold>
	
	
	
}
