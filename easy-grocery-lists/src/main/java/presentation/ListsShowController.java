package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.ListModel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.GroceryItem;
import com.example.easygrocerylists.data.entity.GroceryList;
import com.example.easygrocerylists.data.entity.User;

public class ListsShowController {
	
	static void showAll(JScrollBar scroll,Optional<User> user, UserService userS, GroceryItemService itemS, GroceryListService listS) {
		
		
		List<GroceryList> usersLists = listS.getAllByUserId(user.get().getUserId());
		
		List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
		
		for(GroceryList lst : usersLists) {
			itemsOfUser.addAll(itemS.findByList(lst));
		}
		
		
		JList lsst = new JList(itemsOfUser.toArray());
		scroll.add(lsst);
	}

}
