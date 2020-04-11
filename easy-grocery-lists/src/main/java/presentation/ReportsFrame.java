package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.ReportAbstractFactory;
import com.example.easygrocerylists.business.ReportFactory;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.ReportType.reportTypes;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

public class ReportsFrame {

	private JFrame frmReports;
	static Optional<User> user; 
	static UserService service;
	static GroceryListService listServ;
	static GroceryItemService itemServ;
	static JTextPane textPane = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsFrame window = new ReportsFrame(user,service,listServ,itemServ);
					window.frmReports.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param itemServ 
	 * @param listServ 
	 * @param service 
	 * @param user 
	 */
	public ReportsFrame(Optional<User> user, UserService service, GroceryListService listServ, GroceryItemService itemServ) {
		
		this.user= user;
		this.service = service;
		this.listServ = listServ;
		this.itemServ = itemServ;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReports = new JFrame();
		frmReports.setTitle("Reports");
		frmReports.setBounds(100, 100, 483, 415);
		frmReports.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReports.getContentPane().setLayout(null);
		frmReports.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 465, 368);
		frmReports.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton WeeklyBtn = new JButton("Weekly");
		WeeklyBtn.setBounds(64, 40, 135, 37);
		WeeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<GroceryList> usersLists = listServ.getAllByUserId(user.get());
				
				
				List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
				
			 for(GroceryList lst : usersLists) {
				 
				 List<GroceryItem> itemsFromList = itemServ.findByList(lst);

				 for(GroceryItem itm: itemsFromList) {
					itemsOfUser.add(itm);
				 }
				}
		
			ReportFactory fct = new ReportFactory(reportTypes.Weekly , itemsOfUser); 
	
				
			}
		});
		panel.add(WeeklyBtn);
		
		JButton monthlyBtn = new JButton("Monthly");
		monthlyBtn.setBounds(246, 40, 135, 37);
		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<GroceryList> usersLists = listServ.getAllByUserId(user.get());
				
				
				List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
				
			 for(GroceryList lst : usersLists) {
				 
				 List<GroceryItem> itemsFromList = itemServ.findByList(lst);

				 for(GroceryItem itm: itemsFromList) {
					itemsOfUser.add(itm);
				 }
				}
		
			ReportFactory fct = new ReportFactory(reportTypes.Monthly , itemsOfUser); 
	
				
			}
		});
		panel.add(monthlyBtn);
		
	
		textPane.setBounds(64, 123, 317, 197);
		panel.add(textPane);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(174, 333, 97, 25);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frm = new MainFrame(user,service,listServ,itemServ);
				frm.setVisible(true);
				frmReports.dispose();
			}
		});
		panel.add(backBtn);
	}

	public void setVisible(boolean b) {
		frmReports.setVisible(b);
		
	}
	
	public static JTextPane forReportDisplay() {
		return textPane;
	}
}
