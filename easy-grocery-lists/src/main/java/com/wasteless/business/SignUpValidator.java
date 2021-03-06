package com.wasteless.business;

import java.util.ArrayList;
import java.util.List;

import com.wasteless.data.entity.User;
import com.wasteless.data.repository.UserRepository;

public class SignUpValidator {
	
	UserService userServ ;
	
	public boolean checkIfUserValid(User user) {
		//UserRepository userRepo = new UserRepository() ;
		
         if(user.getUsername().length() < 4)
        	 return false;
         if(user.getPassword().length()<4)
        	 return false;
         
         if(userServ.getAllUsers().size()>0) {
         if(userServ.getUserByUsername(user.getUsername())!= null)
        	 return false;    //don't want two users with the same username
         }
         
         return true;
         
	}

}
