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

public class MainPanel extends JPanel {
	private JPanel WorkoutPanel;
	private JPanel TrainPanel;
	private JPanel GraphicPanel;
	private JPanel TablePanel;
	/**
	 * Create the panel.
	 */
	public MainPanel(final MainFrame frame) {
		setBounds(new Rectangle(0, 0, 869, 605));
		setLayout(null);
		
		WorkoutPanel = new JPanel();
		WorkoutPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
//				WorkoutPanel.setBackground(Color.LIGHT_GRAY);
//				TrainPanel.setBackground(new Color(240,240,240));
//				GraphicPanel.setBackground(new Color(240,240,240));
//				TablePanel.setBackground(new Color(240,240,240));
			}
		});
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(WorkoutPanel);
		WorkoutPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Ejercicios");
		WorkoutPanel.add(btnNewButton_1);
		
		TablePanel = new JPanel();
		add(TablePanel);
		TablePanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Tablas");
		TablePanel.add(btnNewButton);
		
		TrainPanel = new JPanel();
		add(TrainPanel);
		TrainPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_2 = new JButton("Entreno");
		TrainPanel.add(btnNewButton_2, BorderLayout.CENTER);
		
		GraphicPanel = new JPanel();
		add(GraphicPanel);
		GraphicPanel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_3 = new JButton("Estadísticas");
		GraphicPanel.add(btnNewButton_3, BorderLayout.CENTER);

	}
}
