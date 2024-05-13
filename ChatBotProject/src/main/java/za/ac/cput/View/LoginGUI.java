package za.ac.cput.View;
import za.ac.cput.service.AuthService;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class LoginGUI {
    private AuthService authService;
    private JFrame frame;

    public LoginGUI() {
        authService = new AuthService();
        setupGUI();
    }

    private ImageIcon getScaledIcon(String imagePath, int width, int height) {
        // Load the image and scale it
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private void setupGUI() {
        frame = new JFrame("CPUT Chatbot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 650); // Larger frame size
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        Color bgColor = new Color(173, 216, 230);
        Color textColor = new Color(0, 51, 102);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout());

        // Picture or Logo on the left side
        ImageIcon scaledIcon = getScaledIcon("cput_logo.png", 250, 200);
        JLabel logo = new JLabel(scaledIcon);
        panel.add(logo, BorderLayout.WEST);

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(6, 2, 10, 10)); // Grid layout with gaps
        loginPanel.setBackground(bgColor);

        loginPanel.add(new JLabel("Username:", SwingConstants.RIGHT));
        JTextField loginUsernameField = new JTextField();
        loginPanel.add(loginUsernameField);

        loginPanel.add(new JLabel("Password:", SwingConstants.RIGHT));
        JPasswordField loginPasswordField = new JPasswordField();
        loginPanel.add(loginPasswordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginUsernameField.getText();
                String password = new String(loginPasswordField.getPassword());

                if (authService.login(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful! Welcome to CPUT Chatbot.", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Reset login text fields after successful login
                    loginUsernameField.setText("");
                    loginPasswordField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed. Check your credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginPanel.add(loginButton);

        // Exit Button for Login Panel
        JButton exitButtonLogin = new JButton("Exit");
        exitButtonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
        loginPanel.add(exitButtonLogin);

        // Registration Panel with additional fields
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(7, 2, 10, 10)); // 7 rows for additional fields
        registerPanel.setBackground(bgColor);

        registerPanel.add(new JLabel("New Username:", SwingConstants.RIGHT));
        JTextField registerUsernameField = new JTextField();
        registerPanel.add(registerUsernameField);

        registerPanel.add(new JLabel("New Password:", SwingConstants.RIGHT));
        JPasswordField registerPasswordField = new JPasswordField();
        registerPanel.add(registerPasswordField);

        registerPanel.add(new JLabel("Student Number:", SwingConstants.RIGHT));
        JTextField studentIDField = new JTextField();
        registerPanel.add(studentIDField);

        registerPanel.add(new JLabel("Email:", SwingConstants.RIGHT));
        JTextField emailField = new JTextField();
        registerPanel.add(emailField);

        // Register Button
        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = registerUsernameField.getText();
                String password = new String(registerPasswordField.getPassword());
                String studentID = studentIDField.getText();
                String email = emailField.getText();
                if (authService.register(username, password, studentID, email)) {
                    JOptionPane.showMessageDialog(frame, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Reset text fields
                    registerUsernameField.setText("");
                    registerPasswordField.setText("");
                    studentIDField.setText("");
                    emailField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration Failed. Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        registerPanel.add(registerButton);

        // Exit Button for Register Panel
        JButton exitButtonRegister = new JButton("Exit");
        exitButtonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
        registerPanel.add(exitButtonRegister);

        // Add Panels to Frame
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Register", registerPanel);

        panel.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String []args){
        new LoginGUI();
    }
}
