package presentation;

import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.GroceryItem;
import com.wasteless.data.entity.GroceryList;
import com.wasteless.data.entity.User;

public class AddItemController {

	
	
	public static void  addItem(JFrame frmNewItem,Optional<User> user , UserService service,GroceryList list,	GroceryListService listServ , GroceryItemService itemServ ,GroceryItem newItm, List<GroceryItem> intermList) {
		
		itemServ.addItem(newItm);
  
		NewListFrame frm = new NewListFrame(user,service,list,listServ,itemServ, intermList);
		frm.setVisible(true);
		frmNewItem.dispose();
		
	}
	
}
