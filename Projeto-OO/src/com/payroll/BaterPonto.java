package com.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BaterPonto extends JFrame {

	private JPanel contentPane;
	public BaterPonto(Funcionario func) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 263, 208);
		setTitle("Lançar Cartão de Ponto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb1 = new JLabel("Bem vindo, " + func.getName());
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setBounds(10, 11, 156, 22);
		contentPane.add(lb1);
	
		JButton btnENTRADA = new JButton("Registrar Entrada");
		btnENTRADA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null ,
						"Entrada registrada com sucesso! as " + CalendarMT.Ahora + ":"+  CalendarMT.Aminuto, "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
				func.setTimeIN(CalendarMT.Ahora);
				setVisible(false);
			}
		});
		btnENTRADA.setBounds(0, 75, 247, 48);
		contentPane.add(btnENTRADA);
		
		JButton btnSAIDA = new JButton("Registrar Saída");
		btnSAIDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				func.setTimeOUT(CalendarMT.Ahora);
				int value = func.getTimeOUT() - func.getTimeIN();
				func.setWH(value);
				JOptionPane.showMessageDialog(null ,
						"Saída registrada com sucesso! as " + CalendarMT.Ahora  + ":" + CalendarMT.Aminuto + 
						"\n Horas trabalhadas hoje: " + value + "Hrs", "Sucesso!", 	JOptionPane.INFORMATION_MESSAGE);
				if(func instanceof Horista) {
					((Horista) func).addSalary(value);
				}
				setVisible(false);
			}
		});
		btnSAIDA.setBounds(0, 122, 247, 48);
		contentPane.add(btnSAIDA);
		
		JLabel lb2 = new JLabel("Selecione uma opção:");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setBounds(10, 34, 156, 30);
		contentPane.add(lb2);
	}
}
