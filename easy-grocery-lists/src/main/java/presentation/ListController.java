package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

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
