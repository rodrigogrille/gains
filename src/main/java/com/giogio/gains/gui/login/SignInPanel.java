package com.giogio.gains.gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Date;
import java.util.Arrays;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.giogio.gains.classes.CompareStrings;
import com.giogio.gains.classes.Parser;
import com.giogio.gains.classes.PasswordEncrypt;
import com.giogio.gains.classes.User;
import com.giogio.gains.dao.UserDao;
import com.giogio.gains.gui.custom.RoundedBorder;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SignInPanel extends LoginFather {
	private JTextField signInUserField;
	private JTextField signInEmailField;
	private JTextField signInNameField;
	private JTextField signInBornDateField;
	private JPasswordField signInPasswordField;
	private JPasswordField signInRepeatPasswordField;
	private JButton SignInLoginButton;
	private JButton SignInButton;
	private int count;

	/**
	 * Create the panel.
	 */
	public SignInPanel(final JPanel panel) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (count == 1) {
					SignInLoginButton.setForeground(Color.BLACK);
				}
			}
		});

		JLabel signInLabel = new JLabel();
		signInLabel.setText(ResourceBundle.getBundle("i18n").getString("signInLabel"));
		signInLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		signInLabel.setBounds(67, 34, 274, 38);
		add(signInLabel);

		JLabel signInUserLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInUserLabel"));
		signInUserLabel.setBounds(67, 112, 274, 14);
		add(signInUserLabel);

		signInUserField = new JTextField();
		signInUserField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInUserField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInUserField"))) {
					signInUserField.setForeground(new Color(0, 0, 0));
					signInUserField.setText("");
				}
			}
		});
		signInUserField.setText(ResourceBundle.getBundle("i18n").getString("signInUserField"));
		signInUserField.setForeground(Color.GRAY);
		signInUserField.setColumns(10);
		signInUserField.setBounds(67, 137, 274, 29);
		add(signInUserField);

		JLabel signInPasswordLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInPasswordLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		signInPasswordLabel.setBounds(67, 307, 274, 14);
		add(signInPasswordLabel);

		JLabel signInRepeatPasswordLabel = new JLabel(
				ResourceBundle.getBundle("i18n").getString("signInRepeatPasswordLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		signInRepeatPasswordLabel.setBounds(67, 372, 274, 14);
		add(signInRepeatPasswordLabel);

		JLabel signInEmailLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInEmailLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		signInEmailLabel.setBounds(67, 437, 274, 14);
		add(signInEmailLabel);

		signInEmailField = new JTextField();
		signInEmailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInEmailField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInEmailField"))) {
					signInEmailField.setForeground(new Color(0, 0, 0));
					signInEmailField.setText("");
				}
			}
		});
		signInEmailField.setText(ResourceBundle.getBundle("i18n").getString("signInEmailField")); //$NON-NLS-1$ //$NON-NLS-2$
		signInEmailField.setForeground(Color.GRAY);
		signInEmailField.setColumns(10);
		signInEmailField.setBounds(67, 462, 274, 29);
		add(signInEmailField);

		SignInButton = new JButton((String) null);
		SignInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (signInNameField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInNameField"))
						|| signInUserField.getText()
								.equals(ResourceBundle.getBundle("i18n").getString("SignInLoginButton"))
						|| signInPasswordField.getText()
								.equals(ResourceBundle.getBundle("i18n").getString("signInPasswordField"))
						|| signInEmailField.getText()
								.equals(ResourceBundle.getBundle("i18n").getString("signInEmailField"))
						|| signInBornDateField.getText()
								.equals(ResourceBundle.getBundle("i18n").getString("signInBornDateField"))
						|| signInNameField.getText().equals("") || signInUserField.getText().equals("")
						|| signInPasswordField.getText().equals("") || signInEmailField.getText().equals("")
						|| signInBornDateField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("signInInfoMessageDefault"));
				} else {
					if (CompareStrings.dateValidation(signInBornDateField.getText())) {
						if (CompareStrings.comparePasswordSignIn(signInPasswordField.getPassword(),
								signInRepeatPasswordField.getPassword())) {
							String value = Parser.getPass(signInPasswordField.getPassword());
							if (!CompareStrings.compareUserName(UserDao.read(), signInUserField.getText())) {
								User user = new User(signInUserField.getText(), signInNameField.getText(),
										PasswordEncrypt.encryptPassword(value).toString(), signInEmailField.getText(),
										Parser.getDate(signInBornDateField.getText()), 2);
								UserDao.create(user);
								JOptionPane.showMessageDialog(null,
										ResourceBundle.getBundle("i18n").getString("signInInfoMessageRegister"));
								LoginPanel loginPanel = new LoginPanel(panel);
								panel.removeAll();
								panel.add(loginPanel);
								loginPanel.setBounds(225, 5, 439, 605);
								loginPanel.setAlignmentX(CENTER_ALIGNMENT);
								loginPanel.setAlignmentY(CENTER_ALIGNMENT);

							} else {
								JOptionPane.showMessageDialog(null,
										ResourceBundle.getBundle("i18n").getString("signInInfoMessageUser"));
								log.info("The User Already Exists");
							}

						} else {
							JOptionPane.showMessageDialog(null,
									ResourceBundle.getBundle("i18n").getString("signInInfoMessagePass"));
							log.info("Both password field have to be the same");
						}
					} else {
						JOptionPane.showMessageDialog(null, ResourceBundle.getBundle("i18n").getString("signInInfoMessageDate"));
						log.info("The date format is incorrect");
					}

				}

			}
		});
		SignInButton.setBorder(new RoundedBorder(10));
		SignInButton.setBounds(67, 521, 274, 29);
		SignInButton.setText(ResourceBundle.getBundle("i18n").getString("SignInButton"));
		add(SignInButton);

		signInNameField = new JTextField();
		signInNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInNameField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInNameField"))) {
					signInNameField.setForeground(new Color(0, 0, 0));
					signInNameField.setText("");
				}
			}
		});
		signInNameField.setText(ResourceBundle.getBundle("i18n").getString("signInNameField")); //$NON-NLS-1$ //$NON-NLS-2$
		signInNameField.setForeground(Color.GRAY);
		signInNameField.setColumns(10);
		signInNameField.setBounds(67, 202, 274, 29);
		add(signInNameField);

		JLabel signInNameLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInNameLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		signInNameLabel.setBounds(67, 177, 274, 14);
		add(signInNameLabel);

		signInBornDateField = new JTextField();
		signInBornDateField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInBornDateField.getText()
						.equals(ResourceBundle.getBundle("i18n").getString("signInBornDateField"))) {
					signInBornDateField.setForeground(new Color(0, 0, 0));
					signInBornDateField.setText("");
				}
			}
		});
		signInBornDateField.setText(ResourceBundle.getBundle("i18n").getString("signInBornDateField")); //$NON-NLS-1$ //$NON-NLS-2$
		signInBornDateField.setForeground(Color.GRAY);
		signInBornDateField.setColumns(10);
		signInBornDateField.setBounds(67, 267, 274, 29);
		add(signInBornDateField);

		JLabel signInBornDateLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInBornDateLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		signInBornDateLabel.setBounds(67, 242, 274, 14);
		add(signInBornDateLabel);

		SignInLoginButton = new JButton(ResourceBundle.getBundle("i18n").getString("SignInLoginButton")); //$NON-NLS-1$ //$NON-NLS-2$
		SignInLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPanel loginPanel = new LoginPanel(panel);
				panel.removeAll();
				panel.add(loginPanel);
				loginPanel.setBounds(225, 5, 439, 605);
				loginPanel.setAlignmentX(CENTER_ALIGNMENT);
				loginPanel.setAlignmentY(CENTER_ALIGNMENT);
			}
		});
		SignInLoginButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				SignInLoginButton.setForeground(Color.GRAY);
				count = 1;
			}
		});
		SignInLoginButton.setHorizontalTextPosition(SwingConstants.LEFT);
		SignInLoginButton.setHorizontalAlignment(SwingConstants.LEFT);
		SignInLoginButton.setContentAreaFilled(false);
		SignInLoginButton.setBorderPainted(false);
		SignInLoginButton.setBounds(0, 565, 409, 23);
		SignInLoginButton.setBackground(Color.GRAY);
		add(SignInLoginButton);

		signInPasswordField = new JPasswordField();
		signInPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInPasswordField.getText()
						.equals(ResourceBundle.getBundle("i18n").getString("signInPasswordField"))) {
					signInPasswordField.setForeground(new Color(0, 0, 0));
					signInPasswordField.setText("");
				}
			}
		});
		signInPasswordField.setText(ResourceBundle.getBundle("i18n").getString("signInPasswordField")); //$NON-NLS-1$ //$NON-NLS-2$
		signInPasswordField.setBounds(67, 332, 274, 29);
		add(signInPasswordField);

		signInRepeatPasswordField = new JPasswordField();
		signInRepeatPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (signInRepeatPasswordField.getText()
						.equals(ResourceBundle.getBundle("i18n").getString("signInRepeatPasswordField"))) {
					signInRepeatPasswordField.setForeground(new Color(0, 0, 0));
					signInRepeatPasswordField.setText("");
				}
			}
		});
		signInRepeatPasswordField.setText(ResourceBundle.getBundle("i18n").getString("signInRepeatPasswordField")); //$NON-NLS-1$ //$NON-NLS-2$
		signInRepeatPasswordField.setBounds(67, 397, 274, 29);
		add(signInRepeatPasswordField);

	}
}
