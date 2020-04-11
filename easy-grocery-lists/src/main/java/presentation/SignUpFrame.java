package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;

import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.SignUpValidator;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.User;
import com.wasteless.data.repository.UserRepository;

import javax.swing.JButton;

public class SignUpFrame {

	private JFrame frmSignUp;
	private JTextField userText;
	private JTextField passText;
	
	//UserRepository userRepo ;
	
	static GroceryListService listServ ;
	static GroceryItemService itemServ;

	
	private static UserService userSrvice;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame window = new SignUpFrame(userSrvice,listServ,itemServ);
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpFrame(UserService userv,GroceryListService listServ,GroceryItemService itemServ2 ) {
		initialize();
		this.userSrvice = userv;
		this.listServ = listServ ;
		this.itemServ = itemServ2;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setBounds(100, 100, 514, 388);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignUp.setLocationRelativeTo(null);
		frmSignUp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 496, 341);
		frmSignUp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWhatUsernameWould = new JLabel("What username would you like?");
		lblWhatUsernameWould.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWhatUsernameWould.setBounds(81, 33, 278, 34);
		panel.add(lblWhatUsernameWould);
		
		userText = new JTextField();
		userText.setBounds(136, 81, 129, 22);
		panel.add(userText);
		userText.setColumns(10);
		
		JLabel lblYourPassword = new JLabel("Your password?");
		lblYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYourPassword.setBounds(136, 126, 223, 34);
		panel.add(lblYourPassword);
		
		passText = new JTextField();
		passText.setBounds(136, 173, 129, 22);
		panel.add(passText);
		passText.setColumns(10);
		
		JLabel lblChr = new JLabel("");
		lblChr.setBounds(46, 274, 412, 16);
		panel.add(lblChr);
		
		JLabel userLabel = new JLabel("");
		userLabel.setBounds(136, 312, 307, 16);
		panel.add(userLabel);
		
		JButton signUpBtn = new JButton("Sign Me Up");
		signUpBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		signUpBtn.setBounds(146, 219, 108, 34);
		signUpBtn.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				SignUpValidator validator = new SignUpValidator();
				User newUser = new User(userText.getText(),passText.getText());
				
         		//if(validator.checkIfUserValid(newUser)==false) {
				//	lblChr.setText("Make sure your username & password have at least 4 characters");
				//	userLabel.setText("Username already taken.");
				//}
				
				//else {
				
				userSrvice.addUser(newUser);
				StartFrame frm = new StartFrame(userSrvice,	listServ ,itemServ);
				frm.setVisible(true);
				frmSignUp.dispose();
				//}
			}
		});
		panel.add(signUpBtn);
		
		
		
		
	}

	public void setVisible(boolean b) {
		frmSignUp.setVisible(b);
		
	}
}
