package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.awt.Color;
import javax.swing.JLabel;

public class NewListFrame {

	private JFrame frmGroceryList;
	
	static Optional<User> user ;
    static UserService service;
    
    static GroceryList items ;
	static GroceryListService listServ ;
	static GroceryItemService itemServ;
	private JTextField nameTxt;
	
	static List<GroceryItem> intermList;
	
	//ListController control ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewListFrame window = new NewListFrame(user,service, items,listServ,itemServ,intermList);
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
	public NewListFrame(Optional<User> user , UserService service , GroceryList items, 	GroceryListService listServ, GroceryItemService itemServ,List<GroceryItem> intermList2 ) {
		initialize();
		this.user =user;
		this.service = service;
		this.items = items; 
		this.listServ = listServ;
		this.itemServ = itemServ;
		this.intermList = intermList2;
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
		JList itemsScrollBar = new JList();
		if(intermList!=null) {
		if(intermList.size()>0) {
		itemsScrollBar = new JList( intermList.toArray());
		itemsScrollBar.setBounds(82, 42, 220, 271);
		}
		}
		else {
			itemsScrollBar = new JList();
			itemsScrollBar.setBounds(72, 32, 220, 271);
		}
		panel.add(itemsScrollBar);
	
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(Color.ORANGE);
		btnAddItem.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		btnAddItem.setBounds(384, 139, 185, 66);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				ListController.addNewItem(frmGroceryList,user,service, listServ, items ,itemServ,intermList);
			}
		});
		panel.add(btnAddItem);
		
		JButton btnSaveList = new JButton("Save list");
		btnSaveList.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		btnSaveList.setBounds(235, 341, 127, 45);
		btnSaveList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			//System.out.println(nameTxt.getText());
			//items.setListName(nameTxt.getText());
			ListController.saveList(frmGroceryList,user,service, listServ,items, itemServ);
			
			}
		});
		panel.add(btnSaveList);
		

		
	}

	public void setVisible(boolean b) {
		frmGroceryList.setVisible(b);
		
	}
}
