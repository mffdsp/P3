package com.payroll;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.awt.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ViewClass extends JFrame{
	
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
	
	public static int findIndex(Funcionario[] func) {
		for(int i = 0; i < 30; i++)
		{
			if(func[i] == null || !func[i].isSaved())
			{
				return i;
			}
		}
		return -1;
		
	}
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
					System.out.println("ERRO AO EXECUTAR");
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

	/**
	 * Create the frame.
	 * @throws Exception 
	 */

	public ViewClass() {
				
		//VISUAL
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.UTILITY);
		setTitle("FolhaDePagamento");
		setResizable(false);
		setForeground(UIManager.getColor("textHighlight"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/com/payroll/addF.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 521);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBackground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		texto = new JLabel("Sistema de Folha de pagamento vers\u00E3o 3.0");
		texto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		texto.setBounds(610, 11, 256, 14);
		

		JButton button_2 = new JButton("");
		button_2.setBounds(432, 86, 81, 81);
		button_2.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/editF.png")));
		
		JButton button_1 = new JButton("");
		button_1.setBounds(265, 86, 81, 81);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(589, 86, 81, 81);
		
		JButton AddBt = new JButton("");
		AddBt.setBounds(104, 86, 81, 81);
		AddBt.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/addF.png")));
		AddBt.setSelectedIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/addF.png")));
		AddBt.setToolTipText("Adicionar Funcion\u00E1rio");
		AddBt.setBackground(Color.WHITE);
		AddBt.setForeground(Color.WHITE);
		AddBt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		
		texto3 = new JLabel("Adicionar Funcion\u00E1rio");
		texto3.setBounds(82, 165, 147, 25);
		texto3.setForeground(SystemColor.textText);
		texto3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/ListH.png")));
		button_3.setToolTipText("Listar Funcion\u00E1rios");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_3.setBackground(Color.WHITE);
		
		JLabel lblRemoverFuncionrio = new JLabel("Remover Funcion\u00E1rio");
		lblRemoverFuncionrio.setBounds(239, 165, 147, 25);
		lblRemoverFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAlterarDados = new JLabel("Alterar Dados");
		lblAlterarDados.setBounds(432, 165, 147, 25);
		lblAlterarDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblListarEmpregados = new JLabel("Listar Empregados");
		lblListarEmpregados.setBounds(571, 165, 147, 25);
		lblListarEmpregados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		
		contentPane.setLayout(null);
		//contentPane.add(background);
		contentPane.add(AddBt);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(texto3);
		contentPane.add(lblRemoverFuncionrio);
		contentPane.add(lblListarEmpregados);
		contentPane.add(lblAlterarDados);
		contentPane.add(texto);
		
		
		
		//Screen Config
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(793, 564);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		background.setBounds(11, 1, 0, 0);
		background.setBackground(new Color(0,0,0,80));
		
		
		//Data
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat hora = DateFormat.getTimeInstance();
		DateFormat formataData = DateFormat.getDateInstance();
		JLabel lblNewLabel = new JLabel("aaa");
		JLabel label = new JLabel("aaa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(21, 490, 103, 25);
		contentPane.add(lblNewLabel);
		label.setBounds(21, 474, 103, 25);
		contentPane.add(label);
		lblNewLabel.setText(formataData.format(data)); 
		label.setText(hora.format(data)); 
		
		
		//ArrayList<Funcionario> teste = new ArrayList();
		//AddFuncionario();
		Funcionario[] teste = new Funcionario[50];	
		
		AddBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = findIndex(teste);
				try {
					teste[index] = new Assalariado();
					new SignUP(teste[index], index).setVisible(true);
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					
					System.out.println("Indice fora dos limites definidos");
				}
			}
		});
		
		
		//RmvFuncionario();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText(formataData.format(data)); 
				label.setText(hora.format(data)); 
				new EditView(teste, "remover").setVisible(true);
			}
		});
		
		
		button_1.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/removeF.png")));
		button_1.setToolTipText("Remover Funcion\u00E1rio");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_1.setBackground(Color.WHITE);
		
		
		//editFuncionario();
	
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(teste, "editar").setVisible(true);
			}
		});
		button_2.setToolTipText("Alterar Dados");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_2.setBackground(Color.WHITE);
		
		
		//listarFuncionario();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < 30; i++)
				{
					if(teste[i] != null)
					{
						teste[i].listarFuncionarios();
					}

				}
				//new Lista(teste).setVisible(true);
			}
		});
		
	
		JButton btnAtualizarTempo = new JButton("Atualizar Tempo");
		btnAtualizarTempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Calendar ca = Calendar.getInstance();
				Date ndate = ca.getTime();
				lblNewLabel.setText(formataData.format(ndate)); 
				label.setText(hora.format(ndate)); 
			}
		});
		btnAtualizarTempo.setBounds(116, 493, 147, 23);
		contentPane.add(btnAtualizarTempo);
		
		JButton UndoBTN = new JButton("");
		UndoBTN.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/iconfinder_reload-refresh-repeat-arrow_2937372.png")));
		UndoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		UndoBTN.setBounds(654, 474, 43, 41);
		contentPane.add(UndoBTN);
		
		JButton RedoBTN = new JButton("");
		RedoBTN.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/iconfinder_reload-refresh-arrow-repeat_2937371 (2).png")));
		RedoBTN.setBounds(707, 474, 43, 41);
		contentPane.add(RedoBTN);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/icons8-inserir-cart\u00E3o-64.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setToolTipText("Adicionar Funcion\u00E1rio");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button.setBackground(Color.WHITE);
		button.setBounds(104, 211, 81, 81);
		contentPane.add(button);
		
		JLabel lblLanarCarto = new JLabel("Cart\u00E3o de Ponto");
		lblLanarCarto.setForeground(Color.BLACK);
		lblLanarCarto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLanarCarto.setBounds(93, 290, 147, 25);
		contentPane.add(lblLanarCarto);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/icons8-restitui\u00E7\u00E3o-2-64.png")));
		button_4.setToolTipText("Remover Funcion\u00E1rio");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(265, 211, 81, 81);
		contentPane.add(button_4);
		
		JLabel lblLanarTaxa = new JLabel(" Lan\u00E7ar Taxa");
		lblLanarTaxa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLanarTaxa.setBounds(265, 290, 147, 25);
		contentPane.add(lblLanarTaxa);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/icons8-vender-64.png")));
		button_5.setToolTipText("Alterar Dados");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(431, 211, 81, 81);
		contentPane.add(button_5);
		
		JLabel lblCriarAgendaDe = new JLabel("Criar Agenda ");
		lblCriarAgendaDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCriarAgendaDe.setBounds(589, 290, 147, 25);
		contentPane.add(lblCriarAgendaDe);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/icons8-adicionar-a-lista-64.png")));
		button_6.setToolTipText("Listar Funcion\u00E1rios");
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(589, 211, 81, 81);
		contentPane.add(button_6);
		
		JButton btnRodarFolhaDe = new JButton("");
		btnRodarFolhaDe.setIcon(new ImageIcon(ViewClass.class.getResource("/com/payroll/icons8-transfer\u00EAncia-de-dinheiro-64.png")));
		btnRodarFolhaDe.setToolTipText("Listar Funcion\u00E1rios");
		btnRodarFolhaDe.setForeground(Color.BLACK);
		btnRodarFolhaDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnRodarFolhaDe.setBackground(Color.WHITE);
		btnRodarFolhaDe.setBounds(563, 448, 81, 81);
		contentPane.add(btnRodarFolhaDe);
		
		JLabel lblRodarFolha = new JLabel(" Rodar Folha");
		lblRodarFolha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRodarFolha.setBounds(563, 426, 89, 25);
		contentPane.add(lblRodarFolha);
		
		JLabel lblUndo = new JLabel("   Undo");
		lblUndo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUndo.setBounds(654, 448, 43, 25);
		contentPane.add(lblUndo);
		
		JLabel lblRedo = new JLabel("   Redo");
		lblRedo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRedo.setBounds(707, 448, 43, 25);
		contentPane.add(lblRedo);
		
		JLabel lblLanarVenda = new JLabel("  Lan\u00E7ar Venda");
		lblLanarVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLanarVenda.setBounds(422, 290, 147, 25);
		contentPane.add(lblLanarVenda);
		
//		Timeline oneMinuteTimeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> {
//			
//		}));
//		oneMinuteTimeline.setCycleCount(Timeline.INDEFINITE); // Executar indefinidamente.
//		oneMinuteTimeline.play();
//		repaint();
		
}
}
