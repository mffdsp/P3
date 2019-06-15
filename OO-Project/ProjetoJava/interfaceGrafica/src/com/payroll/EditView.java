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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
					EditView frame = new EditView(null, "editar");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static int getIndex(String codigo){
        int i = 0;
        int index = 0;
        //2019265
        int pt = codigo.length() - 5;
        while(i < codigo.length() - 4 )
        {
            index += Math.pow(10, pt - i) * Character.getNumericValue(codigo.charAt(i + 4));
            i += 1;
        }
        return index;
	}

	/**
	 * Create the frame.
	 */
	public EditView(Funcionario[] func, String action) {
		
		
		
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
		btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(action.equals("editar"))
				{
					int indice = getIndex(codeField.getText());
					if(func[indice] == null || Integer.parseInt(codeField.getText()) < 20190)
					{
						JOptionPane.showMessageDialog(null ,
								"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else new realEdit(func[indice]).setVisible(true);
				}
				if(action.equals("remover"))
				{
					int indice = getIndex(codeField.getText());
					if(func[indice] == null || Integer.parseInt(codeField.getText()) < 20190)
					{
						JOptionPane.showMessageDialog(null ,
								"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						func[indice] = null;
						JOptionPane.showMessageDialog(null ,
						"Funcionário removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if(action.equals("TSindical"))
				{
					int indice = getIndex(codeField.getText());
					if(func[indice] == null || Integer.parseInt(codeField.getText()) < 20190)
					{
						JOptionPane.showMessageDialog(null ,
								"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						func[indice] = null;
						JOptionPane.showMessageDialog(null ,
						"Funcionário removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if(action.equals("Lvenda"))
				{
					int indice = getIndex(codeField.getText());
					if(func[indice] == null || Integer.parseInt(codeField.getText()) < 20190)
					{
						JOptionPane.showMessageDialog(null ,
								"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						func[indice] = null;
						JOptionPane.showMessageDialog(null ,
						"Funcionário removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				if(action.equals("BPonto"))
				{
					int indice = getIndex(codeField.getText());
					if(func[indice] == null || Integer.parseInt(codeField.getText()) < 20190)
					{
						JOptionPane.showMessageDialog(null ,
								"Código incorreto", "ERRO", JOptionPane.INFORMATION_MESSAGE);
					}
					//JOptionPane.showMessageDialog(null, texto1.getText());
					else {
						func[indice] = null;
						JOptionPane.showMessageDialog(null ,
						"Funcionário removido com sucesso", "Remover", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		});
		
		btnIr.setBounds(141, 66, 50, 34);
		contentPane.add(btnIr);
		
		
		
	}
}
