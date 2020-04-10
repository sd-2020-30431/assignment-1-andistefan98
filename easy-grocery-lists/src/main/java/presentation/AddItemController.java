package presentation;

import java.util.List;
import java.util.Optional;

import javax.swing.JFrame;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

public class AddItemController {

	
	
	public static void  addItem(JFrame frmNewItem,Optional<User> user , UserService service,GroceryList list,	GroceryListService listServ , GroceryItemService itemServ ,GroceryItem newItm, List<GroceryItem> intermList) {
		
		itemServ.addItem(newItm);
        //list.getItems().add(newItm);
		
		NewListFrame frm = new NewListFrame(user,service,list,listServ,itemServ, intermList);
		frm.setVisible(true);
		frmNewItem.dispose();
	}
	
}
