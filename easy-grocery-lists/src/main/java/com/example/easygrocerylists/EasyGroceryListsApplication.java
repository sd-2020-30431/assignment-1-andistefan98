package com.example.easygrocerylists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.easygrocerylists.business.GroceryItemService;
import com.example.easygrocerylists.business.GroceryListService;
import com.example.easygrocerylists.business.UserService;

import presentation.StartFrame;



@SpringBootApplication
public class EasyGroceryListsApplication implements CommandLineRunner{

	@Autowired
	UserService userServ ;
	
	@Autowired
	GroceryListService listServ;
	
	@Autowired
	GroceryItemService itemServ;
	
	
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(EasyGroceryListsApplication.class);
    	builder.headless(false);
    	
    	
    	
    	ConfigurableApplicationContext context = builder.run(args);
    }
 
    public void run(String args) throws Exception 
    {       
    	
    }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("AICI");
		
		StartFrame frm = new StartFrame(userServ,listServ,itemServ);
		frm.setVisible(true);
		
	}

}
