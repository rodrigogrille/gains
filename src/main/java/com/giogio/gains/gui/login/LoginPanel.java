package com.giogio.gains.gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.giogio.gains.classes.CompareStrings;
import com.giogio.gains.classes.Parser;
import com.giogio.gains.classes.User;
import com.giogio.gains.dao.UserDao;
import com.giogio.gains.gui.custom.RoundedBorder;
import com.giogio.gains.gui.main.MainFrame;
import com.giogio.gains.gui.main.MainFrameAdmin;
import com.giogio.gains.gui.main.MainPanel;
/**
 * 
 * @author Rodrigo
 *
 */
// Panel del Login
public class LoginPanel extends LoginFather {
	private JTextField loginUserField;
	private JButton loginForgotButton;
	private JButton loginSignInButton;
	private JPasswordField loginPasswordField;
	private int count;
	// Los eventos focus gained y mouse moved sirver para que cuando se pasa el raton por encima de los
	// JButton que no tienen decoracion que se vean como si fuera un Link de HTML que cambien de color
	// A gris
	public LoginPanel(final LoginFrame frame) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (count == 1) {
					loginForgotButton.setForeground(Color.BLACK);
					loginSignInButton.setForeground(Color.BLACK);
				}
			}
		});
		setBounds(new Rectangle(0, 0, 409, 599));
		setLayout(null);

		JLabel loginLabel = new JLabel();
		loginLabel.setText(ResourceBundle.getBundle("i18n").getString("loginLabel"));
		loginLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
		loginLabel.setBounds(67, 34, 274, 38);
		add(loginLabel);

		loginUserField = new JTextField();
		loginUserField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (loginUserField.getText().equals(ResourceBundle.getBundle("i18n").getString("loginUserField"))) {
					loginUserField.setForeground(new Color(0, 0, 0));
					loginUserField.setText("");
				}
			}
		});
		loginUserField.setForeground(Color.GRAY);
		loginUserField.setText(ResourceBundle.getBundle("i18n").getString("loginUserField")); //$NON-NLS-1$ //$NON-NLS-2$
		loginUserField.setBounds(67, 185, 274, 29);
		add(loginUserField);
		loginUserField.setColumns(10);

		JButton loginButton = new JButton(ResourceBundle.getBundle("i18n").getString("loginButton"));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Comprueba si se ecribio algo en los campos o si estan vacios
				if (loginUserField.getText().equals(ResourceBundle.getBundle("i18n").getString("loginUserField"))
						|| loginPasswordField.getText()
								.equals(ResourceBundle.getBundle("i18n").getString("loginPasswordField"))
						|| loginUserField.getText().equals("") || loginPasswordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							ResourceBundle.getBundle("i18n").getString("logInInfoMessageDefault"));
				} else {
					// Busca si existe el usuario en caso de que no existe devuelve un mensaje
					try {
						User user = UserDao.readUserById(loginUserField.getText());
						// Comprueba si tanto el usuario como la contraseña coinciden
						if (CompareStrings.compareUserPass(user, Parser.getPass(loginPasswordField.getPassword()))) {
							User currentUser = new User(user.getId(), user.getName(), user.getEmail(),
									user.getBorn_date(), user.getRole_id());
							// Comprueba el rol del usuario en caso de ser admin abre la ventana de admin si no abre la de usuario
							if (user.getRole_id() == 1) {
								MainFrameAdmin mainFrame = new MainFrameAdmin(currentUser);
								frame.setVisible(false);
								mainFrame.setVisible(true);
							} else {
								MainFrame mainFrame = new MainFrame(currentUser);
								frame.setVisible(false);
								mainFrame.setVisible(true);
							}
							

						} else {
							JOptionPane.showMessageDialog(null,
									ResourceBundle.getBundle("i18n").getString("logInInfoMessageLogin"));
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
								ResourceBundle.getBundle("i18n").getString("logInInfoMessageLogin"));
					}
				}
				loginUserField.setText("");
				loginPasswordField.setText("");
			}
		});
		loginButton.setBounds(67, 412, 274, 29);
		loginButton.setBorder(new RoundedBorder(10));
		add(loginButton);

		loginForgotButton = new JButton(ResourceBundle.getBundle("i18n").getString("loginForgotButton"));
		loginForgotButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				loginForgotButton.setForeground(Color.GRAY);
				count = 1;
			}
		});
		loginForgotButton.setContentAreaFilled(false);
		loginForgotButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		loginForgotButton.setHorizontalAlignment(SwingConstants.RIGHT);
		loginForgotButton.setOpaque(false);
		loginForgotButton.setBorderPainted(false);
		loginForgotButton.setBounds(163, 320, 192, 23);
		add(loginForgotButton);

		JLabel loginPasswordLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("loginPasswordLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		loginPasswordLabel.setBounds(67, 255, 84, 14);
		add(loginPasswordLabel);

		JLabel loginUserLabel = new JLabel(ResourceBundle.getBundle("i18n").getString("loginUserLabel")); //$NON-NLS-1$ //$NON-NLS-2$
		loginUserLabel.setBounds(67, 160, 84, 14);
		add(loginUserLabel);

		loginSignInButton = new JButton(ResourceBundle.getBundle("i18n").getString("loginSignInButton")); //$NON-NLS-1$ //$NON-NLS-2$
		loginSignInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Carga el Panel SignIn
				SignInPanel signInPanel = new SignInPanel(frame);
				frame.setContentPane(signInPanel);
			}
		});
		loginSignInButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				loginSignInButton.setForeground(Color.GRAY);
				count = 1;
			}
		});
		loginSignInButton.setHorizontalTextPosition(SwingConstants.LEFT);
		loginSignInButton.setHorizontalAlignment(SwingConstants.LEFT);
		loginSignInButton.setContentAreaFilled(false);
		loginSignInButton.setBorderPainted(false);
		loginSignInButton.setBounds(0, 555, 409, 23);
		add(loginSignInButton);

		loginPasswordField = new JPasswordField();
		loginPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (loginPasswordField.getText()
						.equals(ResourceBundle.getBundle("i18n").getString("loginPasswordField"))) {
					loginPasswordField.setForeground(Color.BLACK);
					loginPasswordField.setText("");
				}
			}
		});
		loginPasswordField.setText(ResourceBundle.getBundle("i18n").getString("loginPasswordField")); //$NON-NLS-1$ //$NON-NLS-2$
		loginPasswordField.setBounds(67, 280, 274, 29);
		add(loginPasswordField);

	}

}
