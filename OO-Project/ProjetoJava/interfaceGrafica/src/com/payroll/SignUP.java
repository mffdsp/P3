package com.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DropMode;

public class SignUP extends JFrame {
	private static double DBsalary = -1;
	private static int actions = 0;
	private static boolean invalidenumber = true;

	private JPanel contentPane;
	private JTextField AdressField;
	private JTextField NameField;
	private JTextField SalaryField;
	private JLabel errotext;

	/**
	 * Launch the application.
	 */
	public Funcionario retornarValor(Horista func) {
		return func;
	}
	public void POPUP(Funcionario func) {
		//JOptionPane.showMessageDialog(null, texto1.getText());
		

		func.setName(NameField.getText());
		func.setAdress(AdressField.getText());
		
		System.out.println(invalidenumber);
		
		if(func.getName().equals("") || func.getAdress().equals("") || invalidenumber ) {
			JOptionPane.showMessageDialog(null ,
					"Preencha todos os campos corretamente!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		DBsalary = Double.parseDouble(SalaryField.getText());
		func.setSalary(DBsalary);
		JOptionPane.showMessageDialog(null ,
				"Dados:\n\n"
				+ "Nome: " + func.getName() + "\n" 
				+ "Endereço: " + func.getAdress() + "\n" 
				+ "Salário: " + func.getSalary() + "RS\n", "Funcionário adicionado!", JOptionPane.INFORMATION_MESSAGE);
		actions = 0;
		setVisible(false);
						
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					return;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUP(Funcionario func) {
		
		func = new Horista();
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Funcionário ao Sistema");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(300, height/2);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setForeground(Color.BLACK);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblTipo = new JLabel("Sal\u00E1rio:");
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		AdressField = new JTextField();
		AdressField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func);
	               
	            }
	        }
		});
		AdressField.setBackground(SystemColor.menu);
		AdressField.setColumns(10);
		
		NameField = new JTextField();
		NameField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func);
	               
	            }
	        }
		});
		NameField.setBackground(SystemColor.menu);
		NameField.setForeground(SystemColor.desktop);
		NameField.setColumns(10);
		
		SalaryField = new JTextField();
		SalaryField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func);
	            }
	        }
		});
		SalaryField.setBackground(SystemColor.menu);
		
		
		
		SalaryField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try {
					DBsalary = Double.parseDouble(SalaryField.getText());
					errotext.setText("");
					invalidenumber = false;
					
				} catch(NumberFormatException e) {
					
					invalidenumber = true;
					errotext.setText("invalid number");
				}
			}
		});
		SalaryField.setColumns(10);
		errotext = new JLabel("");
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				POPUP(func);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEndereo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(91))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(errotext)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(AdressField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(SalaryField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
							.addGap(14))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(AdressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(SalaryField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(errotext)
					.addGap(28)
					.addComponent(btnSalvar)
					.addContainerGap(283, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
