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
import java.util.ArrayList;
import java.util.ResourceBundle;
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

import com.giogio.gains.classes.Exercice;
import com.giogio.gains.dao.ExerciceDao;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JList list;
	private JButton btnNewButton_1;
	private JPanel panel_5;
	private JLabel nameLabel;
	private JLabel nameRequest;
	private JLabel descriptionLabel;
	private JTextArea descriptionRequest;
	private JLabel videoRequest;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private JList list_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBounds(new Rectangle(0, 0, 1082, 677));
		setLayout(new BorderLayout(0, 0));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		
		menuLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("mainTitle"));
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
		
		btnNewButton = new JButton(ResourceBundle.getBundle("i18n").getString("exerciceTitle"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeExercice();
				menuLabel.setText(ResourceBundle.getBundle("i18n").getString("exerciceTitle"));
				nameRequest.setText("");
				descriptionRequest.setText("");
				ArrayList<Exercice> array = ExerciceDao.read();
				Exercice[] wA = new Exercice[array.size()];
				int count = 0;
				for (Exercice workout : array) {
					wA[count] = workout;
					count++;
				}
				list.setListData(wA);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 0, 270, 627);
		panel_1.add(btnNewButton);
		
		panel_2 = new JPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(null);
		
		btnTablas = new JButton(ResourceBundle.getBundle("i18n").getString("tableTitle"));
		btnTablas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeTable();
				menuLabel.setText(ResourceBundle.getBundle("i18n").getString("tableTitle"));
			}
		});
		btnTablas.setContentAreaFilled(false);
		btnTablas.setBounds(0, 0, 270, 627);
		panel_2.add(btnTablas);
		
		panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(null);
		
		btnEntreno = new JButton(ResourceBundle.getBundle("i18n").getString("workoutTitle"));
		btnEntreno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeWorkout();
				menuLabel.setText(ResourceBundle.getBundle("i18n").getString("workoutTitle"));
			}
		});
		btnEntreno.setContentAreaFilled(false);
		btnEntreno.setBounds(0, 0, 270, 627);
		panel_3.add(btnEntreno);
		
		panel_4 = new JPanel();
		mainPanel.add(panel_4);
		panel_4.setLayout(null);
		
		btnEstadisticas = new JButton(ResourceBundle.getBundle("i18n").getString("statisticsTitle"));
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeStatistics();
				menuLabel.setText(ResourceBundle.getBundle("i18n").getString("statisticsTitle"));
			}
		});
		btnEstadisticas.setContentAreaFilled(false);
		btnEstadisticas.setBounds(0, 0, 270, 627);
		panel_4.add(btnEstadisticas);
		
		exercicePanel = new JPanel();
		layeredPane.add(exercicePanel, "name_610788982175000");
		exercicePanel.setLayout(null);
		
		list = new JList();
		list.setToolTipText("");
		list.setBounds(10, 30, 329, 548);
		exercicePanel.add(list);
		
		btnNewButton_1 = new JButton(ResourceBundle.getBundle("i18n").getString("showButton"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("exerciceInfoSelected"));
				} else {
					Exercice workout = (Exercice) list.getSelectedValue();
					nameRequest.setText(ResourceBundle.getBundle("i18n").getString(workout.getName()));
					descriptionRequest.setText(ResourceBundle.getBundle("i18n").getString(workout.getDescription()));
				}
			}
		});
		btnNewButton_1.setBounds(10, 589, 329, 33);
		exercicePanel.add(btnNewButton_1);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBounds(349, 30, 693, 592);
		exercicePanel.add(panel_5);
		panel_5.setLayout(null);
		
		nameLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("nameLabel"));
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		nameLabel.setBounds(47, 11, 95, 35);
		panel_5.add(nameLabel);
		
		nameRequest = new JLabel("");
		nameRequest.setFont(new Font("Tahoma", Font.BOLD, 20));
		nameRequest.setBounds(152, 11, 500, 35);
		panel_5.add(nameRequest);
		
		descriptionLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("descriptionLabel"));
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		descriptionLabel.setBounds(47, 57, 225, 35);
		panel_5.add(descriptionLabel);
		
		descriptionRequest = new JTextArea();
		descriptionRequest.setEditable(false);
		descriptionRequest.setBounds(47, 103, 602, 92);
		panel_5.add(descriptionRequest);
		
		videoRequest = new JLabel(ResourceBundle.getBundle("i18n").getString("videoLabel"));
		videoRequest.setFont(new Font("Tahoma", Font.BOLD, 20));
		videoRequest.setBounds(47, 206, 225, 35);
		panel_5.add(videoRequest);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBounds(47, 252, 602, 329);
		panel_5.add(panel_6);
		
		lblNewLabel = new JLabel("La sección video está actualmente en desarrollo");
		panel_6.add(lblNewLabel);
		
		tablePanel = new JPanel();
		layeredPane.add(tablePanel, "name_610791228577600");
		tablePanel.setLayout(null);
		
		list_1 = new JList();
		list_1.setToolTipText("");
		list_1.setBounds(10, 30, 329, 548);
		tablePanel.add(list_1);
		
		btnNewButton_2 = new JButton(ResourceBundle.getBundle("i18n").getString("newButton")); 
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(10, 589, 165, 33);
		tablePanel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton(ResourceBundle.getBundle("i18n").getString("showButton"));
		btnNewButton_3.setBounds(174, 589, 165, 33);
		tablePanel.add(btnNewButton_3);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane_1.setBounds(349, 30, 693, 592);
		tablePanel.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		JPanel blankPanel = new JPanel();
		layeredPane_1.add(blankPanel, "name_695991436920600");
		
		JLabel lblNewLabel_5 = new JLabel("blank panel");
		blankPanel.add(lblNewLabel_5);
		
		JPanel newTablePanel = new JPanel();
		layeredPane_1.add(newTablePanel, "name_695993978379300");
		
		JLabel lblNewLabel_1 = new JLabel("new panel");
		newTablePanel.add(lblNewLabel_1);
		
		JPanel showTable = new JPanel();
		layeredPane_1.add(showTable, "name_695997676193000");
		showTable.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 669, 566);
		showTable.add(table);
		
		workoutPanel = new JPanel();
		layeredPane.add(workoutPanel, "name_610793239884300");
		
		lblNewLabel_2 = new JLabel("panel de entreno");
		workoutPanel.add(lblNewLabel_2);
		
		statisticsPanel = new JPanel();
		layeredPane.add(statisticsPanel, "name_610795343312600");
		
		lblNewLabel_3 = new JLabel("Este panel esta actualmente en desarrollo");
		statisticsPanel.add(lblNewLabel_3);
		ArrayList<Exercice> array = ExerciceDao.read();
		Exercice[] wA = new Exercice[array.size()];
		int count = 0;
		for (Exercice workout : array) {
			wA[count] = workout;
			count++;
		}
		list.setListData(wA);

	}
	
	public void chargeTable() {
		layeredPane.removeAll();
		layeredPane.add(tablePanel);
		menuLabel.setText(ResourceBundle.getBundle("i18n").getString("tableTitle"));
	}

	public void chargeWorkout() {
		layeredPane.removeAll();
		layeredPane.add(workoutPanel);
		menuLabel.setText(ResourceBundle.getBundle("i18n").getString("workoutTitle"));
	}
	
	public void chargeExercice() {
		layeredPane.removeAll();
		layeredPane.add(exercicePanel);
		menuLabel.setText(ResourceBundle.getBundle("i18n").getString("exerciceTitle"));
	}
	
	public void chargeStatistics() {
		layeredPane.removeAll();
		layeredPane.add(statisticsPanel);
		menuLabel.setText(ResourceBundle.getBundle("i18n").getString("statisticsTitle"));
	}
	
	public void chargeMain() {
		layeredPane.removeAll();
		layeredPane.add(mainPanel);
		menuLabel.setText(ResourceBundle.getBundle("i18n").getString("mainTitle"));
		nameRequest.setText("");
		descriptionRequest.setText("");
		list.removeAll();
	}
}
