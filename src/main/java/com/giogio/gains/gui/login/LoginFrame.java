package com.giogio.gains.gui.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;
import java.awt.CardLayout;
/**
 * 
 * @author Rodrigo
 *
 */
// Frame del login utilizado por el panel del login
// El flujo del programa empieza aqui
public class LoginFrame extends JFrame {

	private static JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginFrame() {
		setBounds(new Rectangle(0, 0, 409, 599));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 429, 686);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 409, 599));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		LoginPanel loginPanel = new LoginPanel(this);
		setContentPane(loginPanel);
		
	}

}
