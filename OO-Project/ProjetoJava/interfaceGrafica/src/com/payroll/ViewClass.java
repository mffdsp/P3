package com.payroll;

import java.awt.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ViewClass extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel texto;
	private JLabel texto2;
	private JLabel texto3;
	private JButton btnNewButton;
	private JLabel BackG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Nimbus set
	    try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (ClassNotFoundException ex) {
	       System.err.println(ex);
	    } catch (InstantiationException ex1) {
	    	System.err.println(ex1);
	    } catch (IllegalAccessException ex2) {
	    	System.err.println(ex2);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex3) {
	    	System.err.println(ex3);
	    }
	    //Nimbus set
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClass frame = new ViewClass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	public void loadList() {
//		try {
//			String query = "select * from info";
//			PreparedStatement pst = .preparaStatement(query);
//			
//		}
//	}
	private double xOffset = 0;
    private double yOffset = 0;
    

    public void start(Stage stage) throws Exception {
        
    }

	/**
	 * Create the frame.
	 */
	
	public ViewClass() {
		
	
		//ArrayList<Funcionario> teste = new ArrayList();
		Funcionario[] teste = new Horista[300];
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 521);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new CompoundBorder());
		setContentPane(contentPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(663, 414);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		



		contentPane.setLayout(null);
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		background.setBounds(0,0,0,0);
		background.setBackground(new Color(0,0,0,80));
		getContentPane().add(background);
		
//		JLabel background;
//		ImageIcon img = new ImageIcon("src/imgs/bgteste.jpg");
//		background = new JLabel("", img, JLabel.CENTER);
//		background.setBounds(0,0,height/2,width/2);
//		add(background);
		
//		Background background = new Background("src/imgs/teste.jpg");
//        background.setSize(500, 500);
//        getContentPane().add(background);
//        
		//setIcon
		
		
		
		JButton AddBt = new JButton("");
		AddBt.setIcon(new ImageIcon("C:\\Users\\Mateus\\eclipse-workspace\\interfaceGrafica\\src\\icons\\addF.png"));
		AddBt.setSelectedIcon(new ImageIcon("C:\\Users\\Mateus\\eclipse-workspace\\interfaceGrafica\\src\\icons\\addF.png"));
		
		
		AddBt.setToolTipText("Adicionar Funcion\u00E1rio");
		AddBt.setBackground(Color.WHITE);
		AddBt.setForeground(Color.WHITE);
		
		AddBt.setBounds(44, 255, 81, 81);
		AddBt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		AddBt.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, texto1.getText());
				new SignUP(teste[0]).setVisible(true);
			}
		});
		contentPane.add(AddBt);
		
		texto = new JLabel("New label");
		texto.setBounds(336, 29, 46, 14);
		contentPane.add(texto);
		
		texto2 = new JLabel("New label");
		texto2.setBounds(158, 55, 46, 14);
		contentPane.add(texto2);
		
		texto3 = new JLabel("Adicionar Funcion\u00E1rio");
		texto3.setForeground(SystemColor.textText);
		texto3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		texto3.setBounds(22, 342, 147, 25);
		contentPane.add(texto3);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(204, 103, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null ,
						"Dados:\n\n"
						+ "Nome: " + teste[0].getName() + "\n" 
						+ "Endereço: " + teste[0].getAdress() + "\n" 
						+ "Salário: " + teste[0].getSalary() + "RS\n");
				
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(189, 435, 0, 0);
		contentPane.add(lblNewLabel);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Mateus\\eclipse-workspace\\interfaceGrafica\\src\\icons\\removeF.png"));
		button_1.setToolTipText("Adicionar Funcion\u00E1rio");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(204, 255, 81, 81);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Mateus\\eclipse-workspace\\interfaceGrafica\\src\\icons\\editF.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setToolTipText("Adicionar Funcion\u00E1rio");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(368, 255, 81, 81);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\Mateus\\eclipse-workspace\\interfaceGrafica\\src\\icons\\ListH.png"));
		button_3.setToolTipText("Adicionar Funcion\u00E1rio");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(523, 255, 81, 81);
		contentPane.add(button_3);
		
		JLabel lblRemoverFuncionrio = new JLabel("Remover Funcion\u00E1rio");
		lblRemoverFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemoverFuncionrio.setBounds(179, 342, 147, 25);
		contentPane.add(lblRemoverFuncionrio);
		
		JLabel lblAlterarDados = new JLabel("Alterar Dados");
		lblAlterarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAlterarDados.setBounds(365, 342, 147, 25);
		contentPane.add(lblAlterarDados);
		
		JLabel lblListarEmpregados = new JLabel("Listar Empregados");
		lblListarEmpregados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListarEmpregados.setBounds(510, 342, 147, 25);
		contentPane.add(lblListarEmpregados);

	}
}
