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
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewClass extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel texto;
	private JLabel texto3;
	private JLabel BackG;
	private static int index = 0;

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
	//private double xOffset = 0;
    //private double yOffset = 0;
    

    public void start(Stage stage) throws Exception {
        
    }

	/**
	 * Create the frame.
	 */
	
	public ViewClass() {
		
	
		//ArrayList<Funcionario> teste = new ArrayList();
		Funcionario[] teste = new Horista[50];
		
		
		
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
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		background.setBackground(new Color(0,0,0,80));
		
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
		AddBt.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/addF.png")));
		AddBt.setSelectedIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/addF.png")));
		
		
		AddBt.setToolTipText("Adicionar Funcion\u00E1rio");
		AddBt.setBackground(Color.WHITE);
		AddBt.setForeground(Color.WHITE);
		AddBt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		AddBt.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				teste[index] = new Horista();
				//JOptionPane.showMessageDialog(null, texto1.getText());
				new SignUP(teste[index]).setVisible(true);
				index += 1;
			}
		});
		
		texto = new JLabel("New label");
		
		texto3 = new JLabel("Adicionar Funcion\u00E1rio");
		texto3.setForeground(SystemColor.textText);
		texto3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//JLabel lblNewLabel = new JLabel("");
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/removeF.png")));
		button_1.setToolTipText("Adicionar Funcion\u00E1rio");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_1.setBackground(Color.WHITE);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/editF.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(teste).setVisible(true);
			}
		});
		button_2.setToolTipText("Adicionar Funcion\u00E1rio");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_2.setBackground(Color.WHITE);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < 30; i++) {
					if(teste[i] != null)
					{
						teste[i].listarFuncionarios();
					}
				}
			}
		});
		button_3.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/ListH.png")));
		button_3.setToolTipText("Adicionar Funcion\u00E1rio");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_3.setBackground(Color.WHITE);
		
		JLabel lblRemoverFuncionrio = new JLabel("Remover Funcion\u00E1rio");
		lblRemoverFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAlterarDados = new JLabel("Alterar Dados");
		lblAlterarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblListarEmpregados = new JLabel("Listar Empregados");
		lblListarEmpregados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(background)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(AddBt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(texto3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblRemoverFuncionrio, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(145)
							.addComponent(lblListarEmpregados, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAlterarDados, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(texto)
					.addGap(280))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(background)
					.addGap(138)
					.addComponent(texto)
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(AddBt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(texto3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRemoverFuncionrio, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblListarEmpregados, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlterarDados, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
