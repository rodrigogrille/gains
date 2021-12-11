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

		JPanel mainPanel = new JPanel();
		layeredPane.add(mainPanel, "name_716880805494200");
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeUser();
				chargeUserList();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(0, 0, 216, 627);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		mainPanel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnRoles = new JButton("Roles");
		btnRoles.setContentAreaFilled(false);
		btnRoles.setBounds(0, 0, 216, 627);
		panel_2.add(btnRoles);

		JPanel panel_3 = new JPanel();
		mainPanel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnPermisos = new JButton("Permisos");
		btnPermisos.setContentAreaFilled(false);
		btnPermisos.setBounds(0, 0, 216, 627);
		panel_3.add(btnPermisos);

		JPanel panel_4 = new JPanel();
		mainPanel.add(panel_4);
		panel_4.setLayout(null);

		JButton btnRolPermiso = new JButton("Rol permiso");
		btnRolPermiso.setContentAreaFilled(false);
		btnRolPermiso.setBounds(0, 0, 216, 627);
		panel_4.add(btnRolPermiso);

		JPanel panel_5 = new JPanel();
		mainPanel.add(panel_5);
		panel_5.setLayout(null);

		JButton btnEjercicios = new JButton("Ejercicios");
		btnEjercicios.setContentAreaFilled(false);
		btnEjercicios.setBounds(0, 0, 216, 627);
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
							JOptionPane.showMessageDialog(null,"Usuario modificado con exito");
							idField.setText("");
							nameField.setText("");
							emailField.setText("");
							bornField.setText("");
							roleField.setText("");
							dontShowButton.doClick();
						} else {
							JOptionPane.showMessageDialog(null,"El usuario no existe");
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
							JOptionPane.showMessageDialog(null,"Borrado con exito");
							dontShowButton.doClick();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null,"Error en borrado");
						}
						
					} else {
						JOptionPane.showMessageDialog(null,"El usuario no existe");
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

	}

	public void chargeUser() {
		layeredPane.removeAll();
		layeredPane.add(userPanel);
		lblMenu.setText("Usuarios");
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
}
