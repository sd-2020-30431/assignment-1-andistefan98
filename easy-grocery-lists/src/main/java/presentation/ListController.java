package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

public class ListController {

	
	static void saveList(JFrame frmGroceryList, Optional<User> user, UserService service, GroceryListService listServ,GroceryList items,GroceryItemService itemServ) {
		
		/*if(items.getItems().size()>0) {
			 listServ.addList(items);
			}
		*/
	
		
		MainFrame frm = new MainFrame(user,service,listServ,itemServ);
		frm.setVisible(true);
		frmGroceryList.dispose();
	}
	
	static void addNewItem(JFrame frmGroceryList,Optional<User> user, UserService service, GroceryListService listServ,GroceryList items , GroceryItemService itemServ, List<GroceryItem> intermList) {
		NewItemFrame frm = new NewItemFrame(user,service,items,listServ,itemServ,intermList);
		frm.setVisible(true);
		frmGroceryList.dispose();
	}
	
}
