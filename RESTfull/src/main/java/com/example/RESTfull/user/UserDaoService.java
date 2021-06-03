package com.example.RESTfull.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserDaoService {
	
	private static List<User> users= new ArrayList();
	private static int userCount = 3;
	
	
	static {
		users.add(new User(1,"hyunil",new Date()));
		users.add(new User(2,"bri",new Date()));
		users.add(new User(3,"saki",new Date()));
		users.add(new User(4,"hee",new Date()));

	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id) {
		
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		
		return null;
		
	}
	
	public User save(User user) {
		if(user.getId() ==null) {
			user.setId(++userCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User DeleteById(int id) {
		Iterator<User> itr=  users.iterator();
		
		while(itr.hasNext()) {
			
			User user = itr.next();
			
			if(user.getId()==id) {
				itr.remove();
				return user;

			}
		}
		
		return null;


	}
	
	public User updateUser(User updatedUser) {
		
		User user = findOne(updatedUser.getId());
		
		if(user == null) {
			return null;
		}
		
		user.setName(updatedUser.getName());
		
		return user;

			
			
		
	}
	
}
