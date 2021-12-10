package com.giogio.gains.gui.main;

import javax.swing.JPanel;

import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPanel extends JPanel {
	private JPanel panel;
	private Component verticalStrut;
	private JLayeredPane layeredPane;
	private JPanel mainPanel;
	private JPanel exercicePanel;
	private JPanel tablePanel;
	private JPanel workoutPanel;
	private JPanel statisticsPanel;
	private JLabel menuLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JButton btnTablas;
	private JButton btnEntreno;
	private JButton btnEstadisticas;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	/**
	 * Create the panel.
	 */
	public MainPanel(final MainFrame frame) {
		setBounds(new Rectangle(0, 0, 1082, 677));
		setLayout(new BorderLayout(0, 0));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		menuLabel = new JLabel("Menú");
		menuLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(menuLabel);
		
		verticalStrut = Box.createVerticalStrut(40);
		panel.add(verticalStrut);
		
		layeredPane = new JLayeredPane();
		add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		mainPanel = new JPanel();
		layeredPane.add(mainPanel, "name_610787174912100");
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		panel_1 = new JPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Ejercicios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeExercice();
				menuLabel.setText("Ejercicios");
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 0, 270, 627);
		panel_1.add(btnNewButton);
		
		panel_2 = new JPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(null);
		
		btnTablas = new JButton("Tablas");
		btnTablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeTable();
				menuLabel.setText("Tablas");
			}
		});
		btnTablas.setContentAreaFilled(false);
		btnTablas.setBounds(0, 0, 270, 627);
		panel_2.add(btnTablas);
		
		panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(null);
		
		btnEntreno = new JButton("Entreno");
		btnEntreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeWorkout();
				menuLabel.setText("Entreno");
			}
		});
		btnEntreno.setContentAreaFilled(false);
		btnEntreno.setBounds(0, 0, 270, 627);
		panel_3.add(btnEntreno);
		
		panel_4 = new JPanel();
		mainPanel.add(panel_4);
		panel_4.setLayout(null);
		
		btnEstadisticas = new JButton("Estadísticas");
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeStatistics();
				menuLabel.setText("Estadísticas");
			}
		});
		btnEstadisticas.setContentAreaFilled(false);
		btnEstadisticas.setBounds(0, 0, 270, 627);
		panel_4.add(btnEstadisticas);
		
		exercicePanel = new JPanel();
		layeredPane.add(exercicePanel, "name_610788982175000");
		
		lblNewLabel = new JLabel("Panel de ejercicio");
		exercicePanel.add(lblNewLabel);
		
		tablePanel = new JPanel();
		layeredPane.add(tablePanel, "name_610791228577600");
		
		lblNewLabel_1 = new JLabel("panel de tablas");
		tablePanel.add(lblNewLabel_1);
		
		workoutPanel = new JPanel();
		layeredPane.add(workoutPanel, "name_610793239884300");
		
		lblNewLabel_2 = new JLabel("panel de entreno");
		workoutPanel.add(lblNewLabel_2);
		
		statisticsPanel = new JPanel();
		layeredPane.add(statisticsPanel, "name_610795343312600");
		
		lblNewLabel_3 = new JLabel("panel de estadisticas");
		statisticsPanel.add(lblNewLabel_3);

	}
	
	public void chargeTable() {
		layeredPane.removeAll();
		layeredPane.add(tablePanel);
		menuLabel.setText("Tablas");
	}

	public void chargeWorkout() {
		layeredPane.removeAll();
		layeredPane.add(workoutPanel);
		menuLabel.setText("Entreno");
	}
	
	public void chargeExercice() {
		layeredPane.removeAll();
		layeredPane.add(exercicePanel);
		menuLabel.setText("Ejercicios");
	}
	
	public void chargeStatistics() {
		layeredPane.removeAll();
		layeredPane.add(statisticsPanel);
		menuLabel.setText("Estadísticas");
	}
	
	public void chargeMain() {
		layeredPane.removeAll();
		layeredPane.add(mainPanel);
		menuLabel.setText("Main");
	}
}
