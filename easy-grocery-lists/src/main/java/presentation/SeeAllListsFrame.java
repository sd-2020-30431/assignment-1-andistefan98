package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.util.Optional;

public class SeeAllListsFrame {

	private JFrame frmGroceryLists;
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
					SeeAllListsFrame window = new SeeAllListsFrame(user,service,listServ,itemServ , intermList);
					window.frmGroceryLists.setVisible(true);
					
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
	public SeeAllListsFrame(Optional<User> user, UserService service, GroceryListService listServ, GroceryItemService itemServ, List<GroceryItem> intermList) {
		initialize();
		this.user = user;
		this.service = service;
		this.listServ = listServ;
		this.itemServ = itemServ;
		this.intermList = intermList;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGroceryLists = new JFrame();
		frmGroceryLists.setTitle("Grocery lists");
		frmGroceryLists.setBounds(100, 100, 511, 438);
		frmGroceryLists.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGroceryLists.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 493, 391);
		frmGroceryLists.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(212, 69, 21, 243);
		panel.add(scrollBar);
		
		ListsShowController.showAll(scrollBar,user,service,itemServ,listServ);
		
		JLabel lblAllItemsFor = new JLabel("All items for user : ");
		lblAllItemsFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAllItemsFor.setBounds(111, 13, 141, 43);
		panel.add(lblAllItemsFor);
		
		JLabel lblUser = new JLabel("New label");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(293, 13, 141, 43);
		{
			lblUser.setText(user.get().getUsername());
		}
		
		panel.add(lblUser);
	}

	public void setVisible(boolean b) {
		frmGroceryLists.setVisible(b);
		
	}
}
