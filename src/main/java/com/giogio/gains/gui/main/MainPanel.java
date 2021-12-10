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

public class MainPanel extends JPanel {
	private JPanel panel;
	private Component verticalStrut;
	private JPanel panel_1;
	private JPanel exercicePanel;
	private JPanel tablePanel;
	private JPanel workoutPanel;
	private JPanel statisticsPanel;
	private JLabel lblNewLabel;
	private JLabel lblTablas;
	private JLabel lblEntreno;
	private JLabel lblEstadisticas;
	/**
	 * Create the panel.
	 */
	public MainPanel(final MainFrame frame) {
		setBounds(new Rectangle(0, 0, 1082, 677));
		setLayout(new BorderLayout(0, 0));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		verticalStrut = Box.createVerticalStrut(60);
		panel.add(verticalStrut);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		exercicePanel = new JPanel();
		exercicePanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.DARK_GRAY));
		panel_1.add(exercicePanel);
		exercicePanel.setLayout(null);
		
		lblNewLabel = new JLabel("Ejercicios");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 294, 179, 14);
		exercicePanel.add(lblNewLabel);
		
		tablePanel = new JPanel();
		tablePanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.DARK_GRAY));
		panel_1.add(tablePanel);
		tablePanel.setLayout(null);
		
		lblTablas = new JLabel("Tablas");
		lblTablas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablas.setBounds(45, 294, 179, 14);
		tablePanel.add(lblTablas);
		
		workoutPanel = new JPanel();
		workoutPanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.DARK_GRAY));
		panel_1.add(workoutPanel);
		workoutPanel.setLayout(null);
		
		lblEntreno = new JLabel("Entreno");
		lblEntreno.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntreno.setBounds(45, 294, 179, 14);
		workoutPanel.add(lblEntreno);
		
		statisticsPanel = new JPanel();
		statisticsPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		panel_1.add(statisticsPanel);
		statisticsPanel.setLayout(null);
		
		lblEstadisticas = new JLabel("Estadisticas");
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setBounds(45, 294, 179, 14);
		statisticsPanel.add(lblEstadisticas);

	}
}
