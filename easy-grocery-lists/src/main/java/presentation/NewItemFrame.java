package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JTextField;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.ItemValidator;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

import javax.swing.JButton;
import datechooser.beans.DateChooserCombo;

public class NewItemFrame {

	private JFrame frmNewItem;
	private JTextField nameText;
	private JTextField caloriesText;
	private JTextField pur1;
	private JTextField exp1;
	private JTextField con1;
	private JTextField pur2;
	private JTextField exp2;
	private JTextField con2;
	private JLabel lblTheDatesMust;
	private JLabel lblQunatity;
	private JTextField quantText;
	
	static Optional<User> user ;
    static UserService service;
	
	static GroceryList list ;
	static GroceryListService listServ ;
	static GroceryItemService itemServ;
	
	static List<GroceryItem> intermList;
	//JDateChooser datechoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewItemFrame window = new NewItemFrame(user,service,list,listServ,itemServ,intermList);
					window.frmNewItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param intermList 
	 */
	public NewItemFrame(Optional<User> user , UserService service,GroceryList list,	GroceryListService listServ , GroceryItemService itemServ, List<GroceryItem> intermList) {
		initialize();
		this.user =user;
		this.service = service;
		this.list = list ;
		this.listServ =listServ ;
		this.itemServ = itemServ;
		this.intermList = intermList;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewItem = new JFrame();
		frmNewItem.setTitle("New Item");
		frmNewItem.setBounds(100, 100, 421, 519);
		frmNewItem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewItem.getContentPane().setLayout(null);
		frmNewItem.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 411, 472);
		frmNewItem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblProductName.setBounds(51, 35, 112, 36);
		panel.add(lblProductName);
		
		JLabel lblCaloricValue = new JLabel("Caloric value");
		lblCaloricValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCaloricValue.setBounds(51, 133, 112, 36);
		panel.add(lblCaloricValue);
		
		JLabel lblPurchaseDate = new JLabel("Purchase date");
		lblPurchaseDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPurchaseDate.setBounds(51, 182, 112, 36);
		panel.add(lblPurchaseDate);
		
		JLabel lblExpirationDate = new JLabel("Expiration date");
		lblExpirationDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExpirationDate.setBounds(51, 231, 112, 36);
		panel.add(lblExpirationDate);
		
	
		nameText = new JTextField();
		nameText.setBounds(192, 40, 135, 28);
		panel.add(nameText);
		nameText.setColumns(10);
		
		caloriesText = new JTextField();
		caloriesText.setBounds(192, 138, 135, 28);
		panel.add(caloriesText);
		caloriesText.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(139, 321, 120, 42);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				String name = nameText.getText();
				Float caloricValue = Float.parseFloat(caloriesText.getText());
			 	int quantity = Integer.parseInt(quantText.getText());
			 	//  Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
			
			 	Date purchase = new Date();
			 	Date expiration = new Date();
			 	Date consumption = new Date();
				try {
					purchase = new SimpleDateFormat("dd/MM/yyyy").parse(pur1.getText());
					expiration = new SimpleDateFormat("dd/MM/yyyy").parse(exp1.getText());
					//consumption = new SimpleDateFormat("dd/MM/yyyy").parse(con1.getText());
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				if(ItemValidator.checkItemValidity(name,quantity,caloricValue , purchase, expiration, consumption,list) == true)
				{
					
					GroceryItem newItm = new GroceryItem(name,quantity,caloricValue , purchase, expiration,list);
					intermList.add(newItm);
					AddItemController.addItem(frmNewItem , user ,service, list,	listServ , itemServ , newItm , intermList);
				}
				else {
					System.out.println("NOT GOOOD");
				}
				
				
			}
		});
		panel.add(btnAddItem);
		
		
		
		pur1 = new JTextField();
		pur1.setBounds(192, 187, 135, 28);
		panel.add(pur1);
		pur1.setColumns(10);
		
		exp1 = new JTextField();
		exp1.setBounds(192, 236, 135, 28);
		panel.add(exp1);
		exp1.setColumns(10);
		
		
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(137, 376, 122, 42);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				NewListFrame frm = new NewListFrame(user,service,list,listServ,itemServ,intermList);
				frm.setVisible(true);
				frmNewItem.dispose();
			}
		});
		panel.add(btnReturn);
		
		lblTheDatesMust = new JLabel("The dates must be written in the format dd/mm/yyyy ");
		lblTheDatesMust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTheDatesMust.setBounds(12, 431, 376, 28);
		panel.add(lblTheDatesMust);
		
		lblQunatity = new JLabel("Quantity");
		lblQunatity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQunatity.setBounds(51, 104, 112, 16);
		panel.add(lblQunatity);
		
		quantText = new JTextField();
		quantText.setBounds(192, 96, 135, 28);
		panel.add(quantText);
		quantText.setColumns(10);
		
	
		
		
	}

	public void setVisible(boolean b) {
		frmNewItem.setVisible(b);
		
	}
}
