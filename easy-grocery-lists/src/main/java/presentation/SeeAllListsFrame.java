package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;

public class SeeAllListsFrame {

	private JFrame frmGroceryLists;
	static Optional<User> user;
	static UserService service;
	static GroceryListService listServ;
	static GroceryItemService itemServ;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeeAllListsFrame window = new SeeAllListsFrame(user,service,listServ,itemServ );
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
	public SeeAllListsFrame(Optional<User> user, UserService service, GroceryListService listServ, GroceryItemService itemServ) {
	
		this.user = user;
		System.out.println(user.get().getUsername() + " asta ");
		this.service = service;
		this.listServ = listServ;
		this.itemServ = itemServ;
		initialize();

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
		

	List<GroceryList> usersLists = listServ.getAllByUserId(user.get());
		
		
		List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
		
	 for(GroceryList lst : usersLists) {
		 System.out.println("list :  " + lst.getId() + "\n");
		 
		 List<GroceryItem> itemsFromList = itemServ.findByList(lst);

		 for(GroceryItem itm: itemsFromList) {
			itemsOfUser.add(itm);
		 }
		}
		

		JList lsst = new JList(itemsOfUser.toArray());
	
		lsst.setBounds(100, 69, 320, 263);
		lsst.setVisibleRowCount(20);
		lsst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane_1 = new JScrollPane(lsst);
	    scrollPane_1.setBounds(100, 69, 280, 243);

		panel.add(scrollPane_1);
		

		
		JLabel lblAllItemsFor = new JLabel("All items for user : ");
		lblAllItemsFor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAllItemsFor.setBounds(111, 13, 141, 43);
		panel.add(lblAllItemsFor);
		
		JLabel lblUser = new JLabel("New label");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
	
		lblUser.setBounds(293, 13, 141, 43);
		
		ListsShowController.userShow(lblUser,user);
		
		
		lblUser.setText(user.get().getUsername());
		
		
		
		panel.add(lblUser);
		
		JButton backBtn = new JButton("Back");
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backBtn.setBounds(174, 353, 97, 25);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						MainFrame lstName = new MainFrame(user,service,listServ,itemServ);
						lstName.setVisible(true);
						frmGroceryLists.dispose();
					
			}
		});
		panel.add(backBtn);

	}

	public void setVisible(boolean b) {
		frmGroceryLists.setVisible(b);
		
	}
}
