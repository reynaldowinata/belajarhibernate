package com.tog.test;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tog.config.AppConfig;
import com.tog.entity.MstUser;
import com.tog.service.MstUserSvc;

public class TestMstUser {
	
	public static void main(String[]args){
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		MstUserSvc mstUserSvc = context.getBean(MstUserSvc.class);
		
		MstUser mstUser = new MstUser();
		mstUser.setPassword("Haqi");
		mstUser.setUsername("Haqi");
		mstUser.setCreatedDate(LocalDateTime.now());
		mstUser.setCreatedUser("ADMIN");
		mstUser.setDeleted(false);
		
//		mstUserSvc.save(mstUser);
		List<MstUser> list = mstUserSvc.findByUsernameAndPassword("Haqi", "Haqi");
		
		if(!list.isEmpty() || list != null || list.size() > 0){
			for(MstUser user : list){
				System.out.println("Username: " + user.getUsername() 
									+"Password: " + user.getPassword());
			}
		}
		else{
			System.out.println("No data");
		}
		
	}

}
