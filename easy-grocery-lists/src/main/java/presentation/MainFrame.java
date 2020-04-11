package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wasteless.business.BurnDownRateCalculator;
import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JLabel;

public class MainFrame {

	private JFrame frmMainMenu;
	static GroceryItemService itemServ;
    static Optional<User> user ;
    static UserService service;
	static GroceryListService listServ ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame(user,service,listServ,itemServ);
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param srv 
	 * @param user 
	 * @param lsrv 
	 * @param itemServ 
	 */
	public MainFrame(Optional<User> user, UserService srv, GroceryListService lsrv, GroceryItemService itemServ) {
		initialize();
		this.user= user;
		this.service = srv;
		this.listServ = lsrv;
		this.itemServ= itemServ;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 597, 561);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 579, 514);
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewList = new JButton("New grocery list");
		btnNewList.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnNewList.setBackground(Color.WHITE);
		btnNewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				List<GroceryItem> intermList = new ArrayList<GroceryItem>();
				
				ListNameFrame lstName = new ListNameFrame(user,service,listServ,itemServ,intermList);
				lstName.setVisible(true);
				frmMainMenu.dispose();
			
			}
		});
		btnNewList.setBounds(137, 13, 310, 67);
		panel.add(btnNewList);
		
		JButton btnSeeReports = new JButton("Show reports");
		btnSeeReports.setBackground(Color.WHITE);
		btnSeeReports.setForeground(Color.BLACK);
		btnSeeReports.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnSeeReports.setBounds(137, 103, 310, 67);
		btnSeeReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportsFrame frm = new ReportsFrame(user,service,listServ,itemServ);
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		panel.add(btnSeeReports);
		
		
		JButton btnGoal = new JButton("Update caloric goal");
		btnGoal.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnGoal.setBackground(Color.WHITE);
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoalFrame frm = new GoalFrame(user,service,listServ,itemServ);
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		btnGoal.setBounds(137, 288, 310, 67);
		panel.add(btnGoal);
		
		JButton showAllBtn = new JButton("See all lists");
		showAllBtn.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		showAllBtn.setBackground(Color.WHITE);
		showAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
						SeeAllListsFrame lstName = new SeeAllListsFrame(user,service,listServ,itemServ);
						lstName.setVisible(true);
						frmMainMenu.dispose();
					
			}
		});
		showAllBtn.setBounds(137, 196, 310, 67);
		panel.add(showAllBtn);
		
		JButton btnDonate = new JButton("Donate to local charities");
		btnDonate.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnDonate.setBounds(137, 383, 310, 67);
		btnDonate.setBackground(Color.WHITE);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationFrame frm = new DonationFrame(user,service,listServ,itemServ);
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		panel.add(btnDonate);
		
		
	}

	public void setVisible(boolean b) {
		frmMainMenu.setVisible(b);
		
	}

}
