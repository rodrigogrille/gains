package com.giogio.gains.gui.main;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBounds(new Rectangle(0, 0, 869, 605));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel WorkoutPanel = new JPanel();
		WorkoutPanel.setLayout(null);
		GridBagConstraints gbc_WorkoutPanel = new GridBagConstraints();
		gbc_WorkoutPanel.insets = new Insets(0, 0, 5, 0);
		gbc_WorkoutPanel.fill = GridBagConstraints.BOTH;
		gbc_WorkoutPanel.gridx = 0;
		gbc_WorkoutPanel.gridy = 0;
		add(WorkoutPanel, gbc_WorkoutPanel);
		
		JLabel lblNewLabel = new JLabel("Ejercicios");
		lblNewLabel.setBounds(411, 66, 46, 14);
		WorkoutPanel.add(lblNewLabel);
		
		JPanel TablePanel = new JPanel();
		TablePanel.setLayout(null);
		GridBagConstraints gbc_TablePanel = new GridBagConstraints();
		gbc_TablePanel.insets = new Insets(0, 0, 5, 0);
		gbc_TablePanel.fill = GridBagConstraints.BOTH;
		gbc_TablePanel.gridx = 0;
		gbc_TablePanel.gridy = 1;
		add(TablePanel, gbc_TablePanel);
		
		JLabel lblNewLabel_1 = new JLabel("Tablas");
		lblNewLabel_1.setBounds(411, 66, 46, 14);
		TablePanel.add(lblNewLabel_1);
		
		JPanel TrainPanel = new JPanel();
		TrainPanel.setLayout(null);
		GridBagConstraints gbc_TrainPanel = new GridBagConstraints();
		gbc_TrainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_TrainPanel.fill = GridBagConstraints.BOTH;
		gbc_TrainPanel.gridx = 0;
		gbc_TrainPanel.gridy = 2;
		add(TrainPanel, gbc_TrainPanel);
		
		JLabel lblNewLabel_2 = new JLabel("Entreno");
		lblNewLabel_2.setBounds(411, 66, 46, 14);
		TrainPanel.add(lblNewLabel_2);
		
		JPanel GraphicPanel = new JPanel();
		GraphicPanel.setLayout(null);
		GridBagConstraints gbc_GraphicPanel = new GridBagConstraints();
		gbc_GraphicPanel.fill = GridBagConstraints.BOTH;
		gbc_GraphicPanel.gridx = 0;
		gbc_GraphicPanel.gridy = 3;
		add(GraphicPanel, gbc_GraphicPanel);
		
		JLabel lblNewLabel_3 = new JLabel("Estadísticas");
		lblNewLabel_3.setBounds(404, 66, 61, 14);
		GraphicPanel.add(lblNewLabel_3);

	}
}
