package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;

import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.User;

import javax.swing.JButton;
import java.awt.Color;

public class DonationFrame {
/*
	private JFrame frmDonate;
	static Optional<User> user ;
    static UserService service;
	static GroceryListService listServ ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationFrame window = new DonationFrame(user,service);
					window.frmDonate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DonationFrame(Optional<User> user , UserService service) {
		initialize();
		this.user=user;
		this.service = service;
	}


	private void initialize() {
		frmDonate = new JFrame();
		frmDonate.setTitle("Donate");
		frmDonate.setBounds(100, 100, 634, 434);
		frmDonate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDonate.getContentPane().setLayout(null);
		frmDonate.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 616, 387);
		frmDonate.getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(72, 297, 163, -226);
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(60, 34, 195, 278);
		panel.add(scrollBar);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setBackground(Color.ORANGE);
		btnDonate.setBounds(369, 145, 153, 47);
		panel.add(btnDonate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(217, 335, 153, 39);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user,service);
				frm.setVisible(true);
				frmDonate.dispose();
			}
		});
		panel.add(btnBack);
	}
 
	public void setVisible(boolean b) {
		frmDonate.setVisible(b);
		
	 }  
	 */ 
}
