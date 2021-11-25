package com.giogio.gains.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.giogio.gains.gui.login.LoginPanel;
import com.giogio.gains.gui.login.SignInPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private LoginPanel loginPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setAutoRequestFocus(false);
		setResizable(false);
		getContentPane().setLayout(new CardLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 654);
		contentPane = new JPanel();
		contentPane.setRequestFocusEnabled(false);
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		loginPanel = new LoginPanel(contentPane);
		loginPanel.setBounds(225, 5, 439, 605);
		contentPane.add(loginPanel);
	}
}
