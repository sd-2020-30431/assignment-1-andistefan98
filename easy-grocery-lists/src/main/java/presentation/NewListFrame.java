package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class NewListFrame {

	private JFrame frmGroceryList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewListFrame window = new NewListFrame();
					window.frmGroceryList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewListFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGroceryList = new JFrame();
		frmGroceryList.setTitle("Grocery List");
		frmGroceryList.setBounds(100, 100, 645, 446);
		frmGroceryList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroceryList.getContentPane().setLayout(null);
		frmGroceryList.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 627, 399);
		frmGroceryList.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollBar itemsScrollBar = new JScrollBar();
		itemsScrollBar.setBounds(72, 32, 220, 271);
		panel.add(itemsScrollBar);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(Color.ORANGE);
		btnAddItem.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnAddItem.setBounds(384, 139, 185, 66);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewItemFrame frm = new NewItemFrame();
				frm.setVisible(true);
				frmGroceryList.dispose();
			}
		});
		panel.add(btnAddItem);
		
		JButton btnSaveList = new JButton("Save list");
		btnSaveList.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnSaveList.setBounds(235, 341, 127, 45);
		btnSaveList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
				frmGroceryList.dispose();
			}
		});
		panel.add(btnSaveList);
	}

	public void setVisible(boolean b) {
		frmGroceryList.setVisible(b);
		
	}

}
