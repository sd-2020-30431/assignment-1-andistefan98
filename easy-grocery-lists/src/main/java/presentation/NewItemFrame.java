package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
	
	//JDateChooser datechoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewItemFrame window = new NewItemFrame(user,service,list,listServ,itemServ);
					window.frmNewItem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewItemFrame(Optional<User> user , UserService service,GroceryList list,	GroceryListService listServ , GroceryItemService itemServ) {
		initialize();
		this.user =user;
		this.service = service;
		this.list = list ;
		this.listServ =listServ ;
		this.itemServ = itemServ;
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
		
		JLabel lblConsumption = new JLabel("Consumption");
		lblConsumption.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsumption.setBounds(51, 272, 112, 36);
		panel.add(lblConsumption);
		
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
				Date purchase = ItemValidator.dateCreator(pur2.getText(),pur1.getText());
				Date expiration = ItemValidator.dateCreator(exp2.getText(),exp1.getText());
				Date consumption = ItemValidator.dateCreator(con2.getText(),con1.getText());
				
				GroceryItem newItm = new GroceryItem(name,quantity,caloricValue , purchase, expiration, consumption,list);
				
				if(ItemValidator.checkItemValidity(newItm) == true)
				{
					AddItemController.addItem(frmNewItem , user ,service, list,	listServ , itemServ , newItm);
				}
				else {
					System.out.println("NOT GOOOD");
				}
				
				
			}
		});
		panel.add(btnAddItem);
		
		
		
		pur1 = new JTextField();
		pur1.setBounds(192, 187, 59, 28);
		panel.add(pur1);
		pur1.setColumns(10);
		
		exp1 = new JTextField();
		exp1.setBounds(192, 236, 59, 28);
		panel.add(exp1);
		exp1.setColumns(10);
		
		con1 = new JTextField();
		con1.setBounds(192, 277, 59, 28);
		panel.add(con1);
		con1.setColumns(10);
		
		pur2 = new JTextField();
		pur2.setBounds(268, 187, 59, 28);
		panel.add(pur2);
		pur2.setColumns(10);
		
		exp2 = new JTextField();
		exp2.setBounds(263, 236, 64, 28);
		panel.add(exp2);
		exp2.setColumns(10);
		
		con2 = new JTextField();
		con2.setBounds(263, 277, 64, 28);
		panel.add(con2);
		con2.setColumns(10);
		
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(137, 376, 122, 42);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
				NewListFrame frm = new NewListFrame(user,service,list,listServ,itemServ);
				frm.setVisible(true);
				frmNewItem.dispose();
			}
		});
		panel.add(btnReturn);
		
		lblTheDatesMust = new JLabel("The dates must be written in the format month / day !!");
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
