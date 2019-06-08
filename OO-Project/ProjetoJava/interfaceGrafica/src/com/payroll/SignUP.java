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

public class SignUP extends JFrame {
	private static double DBsalary = 0;

	private JPanel contentPane;
	private JTextField AdressField;
	private JTextField NameField;
	private JTextField SalaryField;
	private JLabel errotext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP frame = new SignUP();
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
	public SignUP() {
		
		Funcionario funcionarios = new Horista();
		
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Janela com JFrame");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(300, height/2);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		JLabel lblTipo = new JLabel("Sal\u00E1rio:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		AdressField = new JTextField();
		AdressField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setColumns(10);
		
		SalaryField = new JTextField();
		SalaryField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				try {
					DBsalary = Double.parseDouble(SalaryField.getText());
					errotext.setText("");
					
				} catch(NumberFormatException e) {
					errotext.setText("invalid number");
				}
			}
		});
		SalaryField.setColumns(10);
		
		errotext = new JLabel("");
		
		JButton btnSalvar = new JButton("Salvar");
		
		btnSalvar.addActionListener(new ActionListener() {
			//a��o
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, texto1.getText());
				funcionarios.setName(NameField.getText());
				funcionarios.setAdress(AdressField.getText());
				funcionarios.setSalary(DBsalary);
				
				JOptionPane.showMessageDialog(null ,
						"Dados:\n\n"
						+ "Nome: " + funcionarios.getName() + "\n" 
						+ "Endere�o: " + funcionarios.getAdress() + "\n" 
						+ "Sal�rio: " + funcionarios.getSalary() + "RS\n", "Funcion�rio adicionado!", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false);
								
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addGap(91))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(errotext)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
								.addComponent(AdressField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
								.addComponent(SalaryField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
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
