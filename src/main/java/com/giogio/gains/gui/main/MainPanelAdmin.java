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
import com.giogio.gains.classes.Role;
import com.giogio.gains.classes.Table;
import com.giogio.gains.classes.User;
import com.giogio.gains.dao.ExerciceDao;
import com.giogio.gains.dao.RoleDao;
import com.giogio.gains.dao.TableDao;
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
	private JPanel tablePanel;
	private JList tableList;
	private JPanel panel_6_2;
	private JTextField idTableField;
	private JTextField nameTableField;
	private JTextField userIdTableField;
	private JLabel lblNewLabel_2;
	private JLabel lblNombre_2;
	private JLabel lblEmail_2;
	private JButton showButton_2;
	private JButton createButton_2;
	private JButton modifyButton_2;
	private JButton deleteButton_2;
	private JButton dontShowButton_2;
	private JPanel rolePanel;
	private JList roleList;
	private JPanel panel_6_3;
	private JTextField idRoleField;
	private JTextField nameRoleField;
	private JLabel lblNewLabel_3;
	private JLabel lblNombre_3;
	private JButton showButton_3;
	private JButton createButton_3;
	private JButton modifyButton_3;
	private JButton deleteButton_3;
	private JButton dontShowButton_3;

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
		btnRoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeRole();
			}
		});
		btnRoles.setContentAreaFilled(false);
		btnRoles.setBounds(0, 0, 270, 627);
		panel_2.add(btnRoles);

		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnPermisos = new JButton("Tablas");
		btnPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeTable();
			}
		});
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
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()),
								nameFieldExercice.getText(), descriptionFieldExercice.getText(),
								videoFieldExercice.getText());
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
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()),
								nameFieldExercice.getText(), descriptionFieldExercice.getText(),
								videoFieldExercice.getText());
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
						Exercice exercice = new Exercice(Integer.parseInt(idFieldExercice.getText()),
								nameFieldExercice.getText(), descriptionFieldExercice.getText(),
								videoFieldExercice.getText());
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

		tablePanel = new JPanel();
		tablePanel.setLayout(null);
		layeredPane.add(tablePanel, "name_787883963813500");

		tableList = new JList();
		tableList.setToolTipText("");
		tableList.setBounds(10, 30, 329, 548);
		tablePanel.add(tableList);

		panel_6_2 = new JPanel();
		panel_6_2.setLayout(null);
		panel_6_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6_2.setBounds(349, 30, 723, 548);
		tablePanel.add(panel_6_2);

		idTableField = new JTextField();
		idTableField.setColumns(10);
		idTableField.setBounds(247, 113, 466, 32);
		panel_6_2.add(idTableField);

		nameTableField = new JTextField();
		nameTableField.setColumns(10);
		nameTableField.setBounds(247, 258, 466, 32);
		panel_6_2.add(nameTableField);

		userIdTableField = new JTextField();
		userIdTableField.setColumns(10);
		userIdTableField.setBounds(247, 403, 466, 32);
		panel_6_2.add(userIdTableField);

		lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(33, 113, 204, 32);
		panel_6_2.add(lblNewLabel_2);

		lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setBounds(33, 258, 204, 32);
		panel_6_2.add(lblNombre_2);

		lblEmail_2 = new JLabel("Id Usuario");
		lblEmail_2.setBounds(33, 403, 204, 32);
		panel_6_2.add(lblEmail_2);

		showButton_2 = new JButton("Mostrar");
		showButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay nada selecionado");
				} else {
					Table table = (Table) tableList.getSelectedValue();
					idTableField.setText(Integer.toString(table.getId()));
					nameTableField.setText(table.getName());
					userIdTableField.setText(table.getUser_id());
					showButton_2.setEnabled(false);
					dontShowButton_2.setEnabled(true);
					modifyButton_2.setEnabled(true);
					deleteButton_2.setEnabled(true);
					createButton_2.setEnabled(false);
				}
			}
		});
		showButton_2.setBounds(10, 589, 165, 27);
		tablePanel.add(showButton_2);

		createButton_2 = new JButton("Crear");
		createButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTableField.getText().equals("") || nameTableField.getText().equals("")
						|| userIdTableField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Table table = new Table(Integer.parseInt(idTableField.getText()), nameTableField.getText(),
								userIdTableField.getText());
						TableDao.create(table);
						JOptionPane.showMessageDialog(null, "Tabla creada correctamente");
						showButton_2.setEnabled(true);
						dontShowButton_2.setEnabled(false);
						modifyButton_2.setEnabled(false);
						deleteButton_2.setEnabled(false);
						createButton_2.setEnabled(true);
						idTableField.setText("");
						nameTableField.setText("");
						userIdTableField.setText("");
						chargeTable();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		createButton_2.setBounds(349, 589, 241, 27);
		tablePanel.add(createButton_2);

		modifyButton_2 = new JButton("Modificar");
		modifyButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTableField.getText().equals("") || nameTableField.getText().equals("")
						|| userIdTableField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Table table = new Table(Integer.parseInt(idTableField.getText()), nameTableField.getText(),
								userIdTableField.getText());
						TableDao.update(table);
						JOptionPane.showMessageDialog(null, "Tabla modificada correctamente");
						showButton_2.setEnabled(true);
						dontShowButton_2.setEnabled(false);
						modifyButton_2.setEnabled(false);
						deleteButton_2.setEnabled(false);
						createButton_2.setEnabled(true);
						idTableField.setText("");
						nameTableField.setText("");
						userIdTableField.setText("");
						chargeTable();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		modifyButton_2.setEnabled(false);
		modifyButton_2.setBounds(590, 589, 241, 27);
		tablePanel.add(modifyButton_2);

		deleteButton_2 = new JButton("Borrar");
		deleteButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idTableField.getText().equals("") || nameTableField.getText().equals("")
						|| userIdTableField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Table table = new Table(Integer.parseInt(idTableField.getText()), nameTableField.getText(),
								userIdTableField.getText());
						TableDao.delete(table);
						JOptionPane.showMessageDialog(null, "Tabla borrada correctamente");
						showButton_2.setEnabled(true);
						dontShowButton_2.setEnabled(false);
						modifyButton_2.setEnabled(false);
						deleteButton_2.setEnabled(false);
						createButton_2.setEnabled(true);
						idTableField.setText("");
						nameTableField.setText("");
						userIdTableField.setText("");
						chargeTable();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		deleteButton_2.setEnabled(false);
		deleteButton_2.setBounds(831, 589, 241, 27);
		tablePanel.add(deleteButton_2);

		dontShowButton_2 = new JButton("No Mostrar");
		dontShowButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showButton_2.setEnabled(true);
				dontShowButton_2.setEnabled(false);
				modifyButton_2.setEnabled(false);
				deleteButton_2.setEnabled(false);
				createButton_2.setEnabled(true);
				idTableField.setText("");
				nameTableField.setText("");
				userIdTableField.setText("");
				chargeTable();
			}
		});
		dontShowButton_2.setEnabled(false);
		dontShowButton_2.setBounds(174, 589, 165, 27);
		tablePanel.add(dontShowButton_2);

		rolePanel = new JPanel();
		rolePanel.setLayout(null);
		layeredPane.add(rolePanel, "name_789191423454300");

		roleList = new JList();
		roleList.setToolTipText("");
		roleList.setBounds(10, 30, 329, 548);
		rolePanel.add(roleList);

		panel_6_3 = new JPanel();
		panel_6_3.setLayout(null);
		panel_6_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6_3.setBounds(349, 30, 723, 548);
		rolePanel.add(panel_6_3);

		idRoleField = new JTextField();
		idRoleField.setColumns(10);
		idRoleField.setBounds(247, 161, 466, 32);
		panel_6_3.add(idRoleField);

		nameRoleField = new JTextField();
		nameRoleField.setColumns(10);
		nameRoleField.setBounds(247, 354, 466, 32);
		panel_6_3.add(nameRoleField);

		lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(33, 161, 204, 32);
		panel_6_3.add(lblNewLabel_3);

		lblNombre_3 = new JLabel("Nombre");
		lblNombre_3.setBounds(33, 354, 204, 32);
		panel_6_3.add(lblNombre_3);

		showButton_3 = new JButton("Mostrar");
		showButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roleList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay nada selecionado");
				} else {
					Role role = (Role) roleList.getSelectedValue();
					idRoleField.setText(Integer.toString(role.getId()));
					nameRoleField.setText(role.getName());
					showButton_3.setEnabled(false);
					dontShowButton_3.setEnabled(true);
					modifyButton_3.setEnabled(true);
					deleteButton_3.setEnabled(true);
					createButton_3.setEnabled(false);
				}
			}
		});
		showButton_3.setBounds(10, 589, 165, 27);
		rolePanel.add(showButton_3);

		createButton_3 = new JButton("Crear");
		createButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idRoleField.getText().equals("") || nameRoleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Role role = new Role(Integer.parseInt(idRoleField.getText()), nameRoleField.getText());
						RoleDao.create(role);
						JOptionPane.showMessageDialog(null, "Rol creado correctamente");
						showButton_3.setEnabled(true);
						dontShowButton_3.setEnabled(false);
						modifyButton_3.setEnabled(false);
						deleteButton_3.setEnabled(false);
						createButton_3.setEnabled(true);
						idRoleField.setText("");
						nameRoleField.setText("");
						chargeRole();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		createButton_3.setBounds(349, 589, 241, 27);
		rolePanel.add(createButton_3);

		modifyButton_3 = new JButton("Modificar");
		modifyButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idRoleField.getText().equals("") || nameRoleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Role role = new Role(Integer.parseInt(idRoleField.getText()), nameRoleField.getText());
						RoleDao.update(role);
						JOptionPane.showMessageDialog(null, "Rol modificado correctamente");
						showButton_3.setEnabled(true);
						dontShowButton_3.setEnabled(false);
						modifyButton_3.setEnabled(false);
						deleteButton_3.setEnabled(false);
						createButton_3.setEnabled(true);
						idRoleField.setText("");
						nameRoleField.setText("");
						chargeRole();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		modifyButton_3.setEnabled(false);
		modifyButton_3.setBounds(590, 589, 241, 27);
		rolePanel.add(modifyButton_3);

		deleteButton_3 = new JButton("Borrar");
		deleteButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idRoleField.getText().equals("") || nameRoleField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					try {
						Role role = new Role(Integer.parseInt(idRoleField.getText()), nameRoleField.getText());
						RoleDao.delete(role);
						JOptionPane.showMessageDialog(null, "Rol borrado correctamente");
						showButton_3.setEnabled(true);
						dontShowButton_3.setEnabled(false);
						modifyButton_3.setEnabled(false);
						deleteButton_3.setEnabled(false);
						createButton_3.setEnabled(true);
						idRoleField.setText("");
						nameRoleField.setText("");
						chargeRole();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "El id tiene que ser de tipo Entero");
					}

				}
			}
		});
		deleteButton_3.setEnabled(false);
		deleteButton_3.setBounds(831, 589, 241, 27);
		rolePanel.add(deleteButton_3);

		dontShowButton_3 = new JButton("No Mostrar");
		dontShowButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showButton_3.setEnabled(true);
				dontShowButton_3.setEnabled(false);
				modifyButton_3.setEnabled(false);
				deleteButton_3.setEnabled(false);
				createButton_3.setEnabled(true);
				idRoleField.setText("");
				nameRoleField.setText("");
				chargeRole();
			}
		});
		dontShowButton_3.setEnabled(false);
		dontShowButton_3.setBounds(174, 589, 165, 27);
		rolePanel.add(dontShowButton_3);

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

	public void chargeTable() {
		layeredPane.removeAll();
		layeredPane.add(tablePanel);
		lblMenu.setText("Tablas");
		chargeTableList();
	}

	public void chargeRole() {
		layeredPane.removeAll();
		layeredPane.add(rolePanel);
		lblMenu.setText("Role");
		chargeRoleList();
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

	public void chargeTableList() {
		ArrayList<Table> array = TableDao.read();
		Table[] tableAr = new Table[array.size()];
		int count = 0;
		for (Table table : array) {
			tableAr[count] = table;
			count++;
		}
		tableList.setListData(tableAr);
	}

	public void chargeRoleList() {
		ArrayList<Role> array = RoleDao.read();
		Role[] roleAr = new Role[array.size()];
		int count = 0;
		for (Role role : array) {
			roleAr[count] = role;
			count++;
		}
		roleList.setListData(roleAr);
	}
}
