package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;
import com.example.easygrocerylists.business.BurnDownRateCalculator;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;

public class DonationFrame {

	

	private JFrame frmDonate;
	static Optional<User> user ;
    static UserService service;
	static GroceryListService listServ ;
	static GroceryItemService itemServ;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationFrame window = new DonationFrame(user,service, listServ, itemServ);
					window.frmDonate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DonationFrame(Optional<User> user , UserService service,GroceryListService listServ,GroceryItemService itemServ) {
		
		this.user=user;
		this.service = service;
		this.listServ = listServ;
		this.itemServ = itemServ;
		initialize();
	}


	private void initialize() {
		frmDonate = new JFrame();
		frmDonate.setTitle("Donate");
		frmDonate.setBounds(100, 100, 685, 562);
		frmDonate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDonate.getContentPane().setLayout(null);
		frmDonate.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 667, 515);
		frmDonate.getContentPane().add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		list.setBounds(72, 297, 163, -226);
		panel.add(list);
		
		
		
		  List<GroceryList> usersLists = listServ.getAllByUserId(user.get());
			
			
			List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
			
		 for(GroceryList lst : usersLists) {
			 System.out.println("list :  " + lst.getId() + "\n");
			 
			 List<GroceryItem> itemsFromList = itemServ.findByList(lst);

			 for(GroceryItem itm: itemsFromList) {
				itemsOfUser.add(itm);
			 }
			}
			JScrollPane scrollPane_1 = new JScrollPane();
		    scrollPane_1.setBounds(46, 198, 280, 243);

		
			

			JList lsst = new JList(itemsOfUser.toArray());
			scrollPane_1.setViewportView(lsst);
			lsst.setVisibleRowCount(20);
			lsst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			panel.add(scrollPane_1);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setBackground(Color.ORANGE);
		btnDonate.setBounds(392, 286, 153, 47);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GroceryItem selectedItem= (GroceryItem) lsst.getSelectedValue();
				System.out.println(selectedItem.getName() + "    id :   " + selectedItem.getId());
				
				itemServ.deleteItem(selectedItem.getId());
				switchFrames();
				
				
			}
		});
		panel.add(btnDonate);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(274, 463, 153, 39);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user,service,listServ,itemServ);
				frm.setVisible(true);
				frmDonate.dispose();
			}
		});
		panel.add(btnBack);
		
		JLabel lblItemsThatWill = new JLabel("Items that will soon expire:");
		lblItemsThatWill.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblItemsThatWill.setBounds(102, 84, 224, 39);
		panel.add(lblItemsThatWill);

		
		
		List<GroceryItem> expiresSoon = new ArrayList<GroceryItem>();
		for(GroceryItem itmm : itemsOfUser) {
			 LocalDate expirationLocal = BurnDownRateCalculator.convertToLocalDateViaInstant(itmm.getExpirationDate());
			 Calendar calendar = Calendar.getInstance();
		       int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
		       if(expirationLocal.getDayOfYear() - dayOfYear <= 3) {
		    	   expiresSoon.add(itmm);
		       }
		}
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(368, 49, 251, 119);
		
		JList dueToExpireList = new JList(expiresSoon.toArray());
		dueToExpireList.setBounds(368, 49, 251, 119);
		scrollPane_2.setViewportView(dueToExpireList);
		dueToExpireList.setVisibleRowCount(7);
		dueToExpireList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel.add(scrollPane_2);
		
		JLabel lblNewLabel = new JLabel("(next 2 days)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(159, 120, 95, 16);
		panel.add(lblNewLabel);
	}
 
	public void setVisible(boolean b) {
		frmDonate.setVisible(b);
		
	 }  
	
	public void switchFrames() {
		
		frmDonate.setVisible(false);
		MainFrame frmDonate2 = new MainFrame(user,service, listServ, itemServ);
		frmDonate2.setVisible(true);
	}
}
