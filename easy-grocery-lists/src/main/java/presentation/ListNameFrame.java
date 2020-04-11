package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JTextField;

import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

import javax.swing.JButton;

public class ListNameFrame {

	private JFrame frmListName;
	private JTextField textField;
	static Optional<User> user;
	static UserService service;
	static GroceryListService listServ;
	static GroceryItemService itemServ;
	static List<GroceryItem> intermList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListNameFrame window = new ListNameFrame(user,service,listServ,itemServ,intermList);
					window.frmListName.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param intermList 
	 * @param itemServ 
	 * @param listServ 
	 * @param service 
	 * @param user 
	 */
	public ListNameFrame(Optional<User> user, UserService service, GroceryListService listServ, GroceryItemService itemServ, List<GroceryItem> intermList) {
		initialize();
		this.user =user;
		this.service = service;
		this.listServ =listServ;
		this.itemServ = itemServ;
		this.intermList =intermList;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListName = new JFrame();
		frmListName.setTitle("List Name");
		frmListName.setBounds(100, 100, 450, 300);
		frmListName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListName.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 253);
		frmListName.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNameOfThe = new JLabel("Name of the list :");
		lblNameOfThe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNameOfThe.setBounds(32, 97, 142, 45);
		panel.add(lblNameOfThe);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(205, 97, 177, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.setBounds(142, 187, 97, 25);
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GroceryList newList = new GroceryList(textField.getText(),user.get());
				
				
				listServ.addList(newList);
				NewListFrame frm = new NewListFrame(user,service,newList,listServ,itemServ,intermList);
				frm.setVisible(true);
				frmListName.dispose();
			}
		});
		panel.add(continueBtn);
	}

	public void setVisible(boolean b) {
		frmListName.setVisible(b);
		
	}
}
