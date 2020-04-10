package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;

import javax.swing.JButton;

public class StartFrame {

	private JFrame frmStart;

	/**
	 * Launch the application.
	 */
	
	static UserService userS ; 
	static GroceryListService listServ ;
	static GroceryItemService itemServ;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame window = new StartFrame(userS,listServ,itemServ);
					window.frmStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param listServ 
	 * @param itemServ 
	 */
	public StartFrame(UserService usr, GroceryListService listServ, GroceryItemService itemServ) {
		initialize();
		this.userS = usr;
		this.listServ = listServ;
		this.itemServ = itemServ;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStart = new JFrame();
		frmStart.setTitle("Start");
		frmStart.setBounds(100, 100, 465, 333);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStart.setLocationRelativeTo(null);
		frmStart.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 455, 293);
		frmStart.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(39, 106, 150, 75);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame frm = new LoginFrame(userS,listServ,itemServ);
				frm.setVisible(true);
				frmStart.dispose();
			}
		});
		panel.add(loginBtn);
		
		JButton signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(242, 106, 150, 75);
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpFrame frm = new SignUpFrame(userS,listServ,itemServ);
				frm.setVisible(true);
				frmStart.dispose();
			}
		});
		panel.add(signUpBtn);
	}

	public void setVisible(boolean b) {
		frmStart.setVisible(b);
		
	}
}
