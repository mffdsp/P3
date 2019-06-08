package com.payroll;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
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

public class ViewClass extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texto1;
	private JLabel texto;
	private JLabel texto2;
	private JLabel texto3;
	private JButton btnNewButton;

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

	/**
	 * Create the frame.
	 */
	public ViewClass() {
		
		
		Funcionario teste = new Horista();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width/2, height/2);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JButton AddBt = new JButton("Adicionar novo funcionario\r\n");
		AddBt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		AddBt.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, texto1.getText());
				new SignUP(teste).setVisible(true);
			}
		});
		
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, AddBt, 75, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, AddBt, -298, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, AddBt, -566, SpringLayout.EAST, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(AddBt);
		
		texto1 = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, texto1, 76, SpringLayout.SOUTH, AddBt);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, texto1, -167, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, AddBt, 0, SpringLayout.WEST, texto1);
		sl_contentPane.putConstraint(SpringLayout.WEST, texto1, 73, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, texto1, -70, SpringLayout.EAST, contentPane);
		contentPane.add(texto1);
		texto1.setColumns(10);
		
		texto = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, texto, 88, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, texto, 231, SpringLayout.EAST, AddBt);
		contentPane.add(texto);
		
		texto2 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.NORTH, texto2, 28, SpringLayout.SOUTH, texto);
		sl_contentPane.putConstraint(SpringLayout.EAST, texto2, 0, SpringLayout.EAST, texto);
		contentPane.add(texto2);
		
		texto3 = new JLabel("New label");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, texto3, 0, SpringLayout.SOUTH, AddBt);
		sl_contentPane.putConstraint(SpringLayout.EAST, texto3, 0, SpringLayout.EAST, texto);
		contentPane.add(texto3);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null ,
						"Dados:\n\n"
						+ "Nome: " + teste.getName() + "\n" 
						+ "Endereço: " + teste.getAdress() + "\n" 
						+ "Salário: " + teste.getSalary() + "RS\n");
				
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 64, SpringLayout.EAST, AddBt);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, texto2);
		contentPane.add(btnNewButton);
	}
}
