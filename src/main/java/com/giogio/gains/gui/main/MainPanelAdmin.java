package com.giogio.gains.gui.main;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

import com.giogio.gains.classes.CompareStrings;
import com.giogio.gains.classes.Exercice;
import com.giogio.gains.classes.Parser;
import com.giogio.gains.classes.PasswordEncrypt;
import com.giogio.gains.classes.User;
import com.giogio.gains.dao.ExerciceDao;
import com.giogio.gains.dao.UserDao;
import com.giogio.gains.gui.login.LoginPanel;

import lombok.extern.log4j.Log4j2;

import javax.swing.JTextField;

@Log4j2
public class MainPanelAdmin extends JPanel {

	private JLayeredPane layeredPane;
	private JLabel lblMenu;
	private JPanel userPanel;
	private JList userList;
	private JTextField idField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField bornField;
	private JTextField roleField;
	private JButton dontShowButton;
	private JButton showButton;
	private JButton createButton;
	private JButton modifyButton;
	private JButton deleteButton;
	private JPanel mainPanel;
	private JTextField idFieldExercice;
	private JTextField nameFieldExercice;
	private JTextField descriptionFieldExercice;
	private JTextField videoFieldExercice;
	private JButton showButton_1;
	private JButton dontShowButton_1;
	private JButton createButton_1;
	private JButton modifyButton_1;
	private JButton deleteButton_1;
	private JList exerciceList;
	private JPanel exercicePanel;

	/**
	 * Create the panel.
	 */
	public MainPanelAdmin() {
		setBounds(new Rectangle(0, 0, 1082, 677));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblMenu);

		Component verticalStrut = Box.createVerticalStrut(40);
		panel.add(verticalStrut);

		layeredPane = new JLayeredPane();
		add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));

		mainPanel = new JPanel();
		layeredPane.add(mainPanel, "name_716880805494200");
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeUser();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 0, 270, 627);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnRoles = new JButton("Roles");
		btnRoles.setContentAreaFilled(false);
		btnRoles.setBounds(0, 0, 270, 627);
		panel_2.add(btnRoles);

		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnPermisos = new JButton("Tablas");
		btnPermisos.setContentAreaFilled(false);
		btnPermisos.setBounds(0, 0, 270, 627);
		panel_3.add(btnPermisos);

		JPanel panel_5 = new JPanel();
		mainPanel.add(panel_5);
		panel_5.setLayout(null);

		JButton btnEjercicios = new JButton("Ejercicios");
		btnEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeExercice();
			}
		});
		btnEjercicios.setContentAreaFilled(false);
		btnEjercicios.setBounds(0, 0, 270, 627);
		panel_5.add(btnEjercicios);

		userPanel = new JPanel();
		layeredPane.add(userPanel, "name_716884805593500");
		userPanel.setLayout(null);

		userList = new JList();
		userList.setToolTipText("");
		userList.setBounds(10, 30, 329, 548);
		userPanel.add(userList);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBounds(349, 30, 723, 548);
		userPanel.add(panel_6);
		panel_6.setLayout(null);

		idField = new JTextField();
		idField.setBounds(247, 64, 466, 32);
		panel_6.add(idField);
		idField.setColumns(10);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(247, 160, 466, 32);
		panel_6.add(nameField);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(247, 256, 466, 32);
		panel_6.add(emailField);

		bornField = new JTextField();
		bornField.setColumns(10);
		bornField.setBounds(247, 352, 466, 32);
		panel_6.add(bornField);

		roleField = new JTextField();
		roleField.setColumns(10);
		roleField.setBounds(247, 448, 466, 32);
		panel_6.add(roleField);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(33, 64, 204, 32);
		panel_6.add(lblNewLabel);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 160, 204, 32);
		panel_6.add(lblNombre);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(33, 256, 204, 32);
		panel_6.add(lblEmail);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(33, 352, 204, 32);
		panel_6.add(lblFechaNacimiento);

		JLabel lblRoleId = new JLabel("Rol ID");
		lblRoleId.setBounds(33, 448, 204, 32);
		panel_6.add(lblRoleId);

		showButton = new JButton("Mostrar");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay nada selecionado");
				} else {
					User user = (User) userList.getSelectedValue();
					idField.setText(user.getId());
					nameField.setText(user.getName());
					emailField.setText(user.getEmail());
					bornField.setText(user.getBorn_date().toString());
					roleField.setText(Integer.toString(user.getRole_id()));
					showButton.setEnabled(false);
					dontShowButton.setEnabled(true);
					modifyButton.setEnabled(true);
					deleteButton.setEnabled(true);
					createButton.setEnabled(false);
				}
			}
		});
		showButton.setBounds(10, 589, 165, 27);
		userPanel.add(showButton);

		createButton = new JButton("Crear");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().equals("") || nameField.getText().equals("") || emailField.getText().equals("")
						|| bornField.getText().equals("") || roleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					if (CompareStrings.dateValidation(bornField.getText())) {
						if (!CompareStrings.compareUserName(UserDao.read(), idField.getText())) {
							User user = new User(idField.getText(), nameField.getText(),
									PasswordEncrypt.encryptPassword("abc123.").toString(), emailField.getText(),
									Parser.getDate(bornField.getText()), Integer.parseInt(roleField.getText()));
							UserDao.create(user);
							JOptionPane.showMessageDialog(null,
									ResourceBundle.getBundle("i18n").getString("signInInfoMessageRegister"));
							idField.setText("");
							nameField.setText("");
							emailField.setText("");
							bornField.setText("");
							roleField.setText("");
							chargeUserList();
						} else {
							JOptionPane.showMessageDialog(null,
									ResourceBundle.getBundle("i18n").getString("signInInfoMessageUser"));
							log.info("The User Already Exists");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								ResourceBundle.getBundle("i18n").getString("signInInfoMessageDate"));
						log.info("The date format is incorrect");
					}
				}
			}
		});
		createButton.setBounds(349, 589, 241, 27);
		userPanel.add(createButton);

		modifyButton = new JButton("Modificar");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().equals("") || nameField.getText().equals("") || emailField.getText().equals("")
						|| bornField.getText().equals("") || roleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					if (CompareStrings.dateValidation(bornField.getText())) {
						if (CompareStrings.compareUserName(UserDao.read(), idField.getText())) {
							User user = new User(idField.getText(), nameField.getText(), emailField.getText(),
									Parser.getDate(bornField.getText()), Integer.parseInt(roleField.getText()));
							UserDao.update(user);
							JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
							idField.setText("");
							nameField.setText("");
							emailField.setText("");
							bornField.setText("");
							roleField.setText("");
							dontShowButton.doClick();
						} else {
							JOptionPane.showMessageDialog(null, "El usuario no existe");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								ResourceBundle.getBundle("i18n").getString("signInInfoMessageDate"));
						log.info("The date format is incorrect");
					}
				}
			}
		});
		modifyButton.setEnabled(false);
		modifyButton.setBounds(590, 589, 241, 27);
		userPanel.add(modifyButton);

		deleteButton = new JButton("Borrar");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					if (CompareStrings.compareUserName(UserDao.read(), idField.getText())) {
						User user = new User(idField.getText());
						try {
							UserDao.delete(user);
							JOptionPane.showMessageDialog(null, "Borrado con exito");
							dontShowButton.doClick();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Error en borrado");
						}

					} else {
						JOptionPane.showMessageDialog(null, "El usuario no existe");
					}
				}
			}
		});
		deleteButton.setEnabled(false);
		deleteButton.setBounds(831, 589, 241, 27);
		userPanel.add(deleteButton);

		dontShowButton = new JButton("No Mostrar");
		dontShowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showButton.setEnabled(true);
				dontShowButton.setEnabled(false);
				modifyButton.setEnabled(false);
				deleteButton.setEnabled(false);
				createButton.setEnabled(true);
				idField.setText("");
				nameField.setText("");
				emailField.setText("");
				bornField.setText("");
				roleField.setText("");
				chargeUserList();
			}
		});
		dontShowButton.setEnabled(false);
		dontShowButton.setBounds(174, 589, 165, 27);
		userPanel.add(dontShowButton);

		exercicePanel = new JPanel();
		exercicePanel.setLayout(null);
		layeredPane.add(exercicePanel, "name_785002518154300");

		exerciceList = new JList();
		exerciceList.setToolTipText("");
		exerciceList.setBounds(10, 30, 329, 548);
		exercicePanel.add(exerciceList);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6_1.setBounds(349, 30, 723, 548);
		exercicePanel.add(panel_6_1);

		idFieldExercice = new JTextField();
		idFieldExercice.setColumns(10);
		idFieldExercice.setBounds(247, 84, 466, 32);
		panel_6_1.add(idFieldExercice);

		nameFieldExercice = new JTextField();
		nameFieldExercice.setColumns(10);
		nameFieldExercice.setBounds(247, 200, 466, 32);
		panel_6_1.add(nameFieldExercice);

		descriptionFieldExercice = new JTextField();
		descriptionFieldExercice.setColumns(10);
		descriptionFieldExercice.setBounds(247, 316, 466, 32);
		panel_6_1.add(descriptionFieldExercice);

		videoFieldExercice = new JTextField();
		videoFieldExercice.setColumns(10);
		videoFieldExercice.setBounds(247, 432, 466, 32);
		panel_6_1.add(videoFieldExercice);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(33, 84, 204, 32);
		panel_6_1.add(lblNewLabel_1);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(33, 200, 204, 32);
		panel_6_1.add(lblNombre_1);

		JLabel lblEmail_1 = new JLabel("Description");
		lblEmail_1.setBounds(33, 316, 204, 32);
		panel_6_1.add(lblEmail_1);

		JLabel lblFechaNacimiento_1 = new JLabel("Video link");
		lblFechaNacimiento_1.setBounds(33, 432, 204, 32);
		panel_6_1.add(lblFechaNacimiento_1);

		showButton_1 = new JButton("Mostrar");
		showButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (exerciceList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay nada selecionado");
				} else {
					Exercice exercice = (Exercice) exerciceList.getSelectedValue();
					idFieldExercice.setText(Integer.toString(exercice.getId()));
					nameFieldExercice.setText(exercice.getName());
					descriptionFieldExercice.setText(exercice.getDescription());
					videoFieldExercice.setText(exercice.getVideo());
					showButton_1.setEnabled(false);
					dontShowButton_1.setEnabled(true);
					modifyButton_1.setEnabled(true);
					deleteButton_1.setEnabled(true);
					createButton_1.setEnabled(false);
				}

			}
		});
		showButton_1.setBounds(10, 589, 165, 27);
		exercicePanel.add(showButton_1);

		createButton_1 = new JButton("Crear");
		createButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idFieldExercice.getText().equals("") || nameFieldExercice.getText().equals("")
						|| descriptionFieldExercice.getText().equals("") || videoFieldExercice.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()), nameFieldExercice.getText(), descriptionFieldExercice.getText(), videoFieldExercice.getText());
						ExerciceDao.create(exercice);
						JOptionPane.showMessageDialog(null, "Ejercicio creado con exito");
						idFieldExercice.setText("");
						nameFieldExercice.setText("");
						descriptionFieldExercice.setText("");
						videoFieldExercice.setText("");
						chargeExerciceList();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}
					
				}
			}
		});
		createButton_1.setBounds(349, 589, 241, 27);
		exercicePanel.add(createButton_1);

		modifyButton_1 = new JButton("Modificar");
		modifyButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idFieldExercice.getText().equals("") || nameFieldExercice.getText().equals("")
						|| descriptionFieldExercice.getText().equals("") || videoFieldExercice.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()), nameFieldExercice.getText(), descriptionFieldExercice.getText(), videoFieldExercice.getText());
						ExerciceDao.update(exercice);
						JOptionPane.showMessageDialog(null, "Ejercicio modificado con exito");
						dontShowButton_1.doClick();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}
					
				}
			}
		});
		modifyButton_1.setEnabled(false);
		modifyButton_1.setBounds(590, 589, 241, 27);
		exercicePanel.add(modifyButton_1);

		deleteButton_1 = new JButton("Borrar");
		deleteButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idFieldExercice.getText().equals("") || nameFieldExercice.getText().equals("")
						|| descriptionFieldExercice.getText().equals("") || videoFieldExercice.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()), nameFieldExercice.getText(), descriptionFieldExercice.getText(), videoFieldExercice.getText());
						ExerciceDao.delete(exercice);
						JOptionPane.showMessageDialog(null, "Ejercicio borrado con exito");
						dontShowButton_1.doClick();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}
					
				}
			}
		});
		deleteButton_1.setEnabled(false);
		deleteButton_1.setBounds(831, 589, 241, 27);
		exercicePanel.add(deleteButton_1);

		dontShowButton_1 = new JButton("No Mostrar");
		dontShowButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showButton_1.setEnabled(true);
				dontShowButton_1.setEnabled(false);
				modifyButton_1.setEnabled(false);
				deleteButton_1.setEnabled(false);
				createButton_1.setEnabled(true);
				idFieldExercice.setText("");
				nameFieldExercice.setText("");
				descriptionFieldExercice.setText("");
				videoFieldExercice.setText("");
				chargeExerciceList();
			}
		});
		dontShowButton_1.setEnabled(false);
		dontShowButton_1.setBounds(174, 589, 165, 27);
		exercicePanel.add(dontShowButton_1);

	}

	public void chargeUser() {
		layeredPane.removeAll();
		layeredPane.add(userPanel);
		lblMenu.setText("Usuarios");
		chargeUserList();
	}

	public void chargeMain() {
		layeredPane.removeAll();
		layeredPane.add(mainPanel);
		lblMenu.setText("Menu");
	}

	public void chargeExercice() {
		layeredPane.removeAll();
		layeredPane.add(exercicePanel);
		lblMenu.setText("Ejercicios");
		chargeExerciceList();
	}

	public void chargeUserList() {
		ArrayList<User> array = UserDao.read();
		User[] userAr = new User[array.size()];
		int count = 0;
		for (User user : array) {
			userAr[count] = user;
			count++;
		}
		userList.setListData(userAr);
	}

	public void chargeExerciceList() {
		ArrayList<Exercice> array = ExerciceDao.read();
		Exercice[] exerciceAr = new Exercice[array.size()];
		int count = 0;
		for (Exercice exercice : array) {
			exerciceAr[count] = exercice;
			count++;
		}
		exerciceList.setListData(exerciceAr);
	}
}
