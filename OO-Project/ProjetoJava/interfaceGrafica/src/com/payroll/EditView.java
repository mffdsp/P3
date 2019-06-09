package com.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditView extends JFrame {

	private JPanel contentPane;
	private JTextField codeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//EditView frame = new EditView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditView(Funcionario[] func) {
		
		setTitle("Insira o Código de Acesso");
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 225, 145);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane.setLayout(null);
		
		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBackground(SystemColor.menu);
		codeField.setBounds(20, 22, 168, 37);
		contentPane.add(codeField);
		int code = 0;
		
		JButton btnIr = new JButton("IR");
		btnIr.setBounds(141, 66, 50, 34);
		contentPane.add(btnIr);
		
		btnIr.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				
				int code = Integer.parseInt(codeField.getText());
				if(func[code] == null)
				{
					JOptionPane.showMessageDialog(null ,
							"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
				}
				//JOptionPane.showMessageDialog(null, texto1.getText());
				else new realEdit(func[code]).setVisible(true);
			}
		});
	}
}
