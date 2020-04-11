package presentation;

import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.wasteless.business.GroceryItemService;
import com.wasteless.business.GroceryListService;
import com.wasteless.business.UserService;
import com.wasteless.data.entity.User;

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
