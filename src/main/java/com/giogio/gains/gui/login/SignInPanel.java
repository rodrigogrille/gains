package com.giogio.gains.gui.login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import com.giogio.gains.gui.custom.RoundedBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	public SignInPanel() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (count == 1) {
					SignInLoginButton.setForeground(Color.BLACK);
					SignInButton.setForeground(Color.BLACK);
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
		
		JLabel signInRepeatPasswordLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("signInRepeatPasswordLabel")); //$NON-NLS-1$ //$NON-NLS-2$
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
		SignInButton.setBorder(new RoundedBorder(10));
		SignInButton.setBounds(67, 521, 274, 29);
		SignInButton.setBackground(Color.GRAY);
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
				if (signInBornDateField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInBornDateField"))) {
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
				if (signInPasswordField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInPasswordField"))) {
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
				if (signInRepeatPasswordField.getText().equals(ResourceBundle.getBundle("i18n").getString("signInRepeatPasswordField"))) {
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
