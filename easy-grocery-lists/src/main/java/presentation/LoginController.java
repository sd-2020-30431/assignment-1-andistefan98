package presentation;

import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;
import com.example.easygrocerylists.data.entity.User;

public class LoginController {
	
	
	public void login(JFrame frmLogin,UserService srv,String username, String pass, JLabel lbl,GroceryListService lsrv,GroceryItemService itemServ) {
		
		Optional<User> user =srv.getUserByUsername(username);
		if(user.isPresent() == true) {
		if(user.get()!=null) {
			if(user.get().getPassword().contentEquals(pass)) {
				MainFrame frm = new MainFrame(user,srv,lsrv,itemServ);
				frm.setVisible(true);
				frmLogin.dispose();
				
			}
		  }
		}
		else {
			lbl.setText("Username or/and password incorrect");
		}
		
		
		
	}

}
