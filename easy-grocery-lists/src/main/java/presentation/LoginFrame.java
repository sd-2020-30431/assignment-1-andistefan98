package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {

	private JFrame frmLogin;
	private JTextField userText;
	private JTextField passwordText;

	static UserService userServ ;
	static GroceryListService listServ ;
	static GroceryItemService itemServ;
	
	LoginController control = new LoginController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame(userServ,listServ,itemServ);
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame(UserService usr,	GroceryListService listServ, GroceryItemService itemServ2 ) {
		initialize();
	    this.userServ = usr;
		this.listServ =listServ ;
		this.itemServ = itemServ2;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 577, 428);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(null);
		//frmLogin.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 559, 381);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(156, 119, 101, 43);
		panel.add(lblUsername);
		
		userText = new JTextField();
		userText.setBounds(285, 130, 116, 22);
		panel.add(userText);
		userText.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(156, 156, 82, 38);
		panel.add(lblPassword);
		
		JLabel label = new JLabel("");
		label.setBounds(401, 16, 0, 0);
		panel.add(label);
		
		JLabel lblEr = new JLabel("");
		lblEr.setBounds(166, 307, 213, 16);
		panel.add(lblEr);
		
		passwordText = new JTextField();
		passwordText.setBounds(285, 165, 116, 22);
		panel.add(passwordText);
		passwordText.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				control.login(frmLogin,userServ,userText.getText(),passwordText.getText(),lblEr,listServ,itemServ);
				
				/*if(userText.getText().equals("admin") && passwordText.getText().contentEquals("admin"));
				{
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
				frmLogin.dispose();
			
				}*/
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(207, 231, 123, 25);
		panel.add(btnLogin);
		
		
	}

	public void setVisible(boolean b) {
		frmLogin.setVisible(b);
		
	}
}
