package presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JLabel;
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
	
	static JList showAll(Optional<User> user, UserService userS, GroceryItemService itemS, GroceryListService listS) {
		
	   System.out.println(user.get().getUserId());
		List<GroceryList> usersLists = listS.getAllByUserId(user.get());
		
		
		List<GroceryItem> itemsOfUser = new ArrayList<GroceryItem>();
		
	 for(GroceryList lst : usersLists) {
		 System.out.println("list :  " + lst.getId() + "\n");
		 
		 List<GroceryItem> itemsFromList = itemS.findByList(lst);
		 //System.out.println("size : " + itemsFromList.size() + "\n");
		 for(GroceryItem itm: itemsFromList) {
			itemsOfUser.add(itm);
		 }
		}
		
	 System.out.println("list final size :  " + itemsOfUser.size() + "\n");
		
		JList lsst = new JList(itemsOfUser.toArray());
		return lsst;
		
	}

	public static void userShow(JLabel lblUser, Optional<User> user) {
		
		String userText = user.get().getUsername();
		lblUser.setText(userText);
		
	}

}
