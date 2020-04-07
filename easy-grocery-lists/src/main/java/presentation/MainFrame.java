package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {

	private JFrame frmMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainMenu = new JFrame();
		frmMainMenu.setTitle("Main Menu");
		frmMainMenu.setBounds(100, 100, 637, 467);
		frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainMenu.getContentPane().setLayout(null);
		frmMainMenu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 619, 420);
		frmMainMenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewList = new JButton("New grocery list");
		btnNewList.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnNewList.setBackground(Color.WHITE);
		btnNewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewListFrame frm = new NewListFrame();
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		btnNewList.setBounds(137, 13, 310, 67);
		panel.add(btnNewList);
		
		JButton btnSeeReports = new JButton("Show reports");
		btnSeeReports.setBackground(Color.WHITE);
		btnSeeReports.setForeground(Color.BLACK);
		btnSeeReports.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnSeeReports.setBounds(137, 104, 310, 67);
		panel.add(btnSeeReports);
		
		JButton btnDonate = new JButton("Donate to charity");
		btnDonate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new DonationFrame();
			}
		});
		btnDonate.setBackground(Color.WHITE);
		btnDonate.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationFrame frm = new DonationFrame();
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		btnDonate.setBounds(137, 203, 310, 67);
		panel.add(btnDonate);
		
		JButton btnGoal = new JButton("Update caloric goal");
		btnGoal.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnGoal.setBackground(Color.WHITE);
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoalFrame frm = new GoalFrame();
				frm.setVisible(true);
				frmMainMenu.dispose();
			}
		});
		btnGoal.setBounds(137, 301, 310, 67);
		panel.add(btnGoal);
	}

	public void setVisible(boolean b) {
		frmMainMenu.setVisible(b);
		
	}

}
