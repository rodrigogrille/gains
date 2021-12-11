package com.giogio.gains.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.giogio.gains.classes.User;

public class MainFrameAdmin extends JFrame {

	private JPanel contentPane;
	private MainPanelAdmin mainPanel;
	private User currentUser;

	/**
	 * Create the frame.
	 */
	public MainFrameAdmin(User user) {
		currentUser = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(400, 200, 1112, 750));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		mainPanel = new MainPanelAdmin();
		chargePanel(mainPanel);
	}

	public void chargePanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
	}
}
