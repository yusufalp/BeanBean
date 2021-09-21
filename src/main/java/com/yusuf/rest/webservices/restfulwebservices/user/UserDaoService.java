package com.yusuf.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	// initialize an ArrayList with the name users
	private static List<User> users = new ArrayList<>();
	
	// initialize the count of users in the default ArrayList
	private static int usersCount = 3;
	
	// initialize a few random values to users ArrayList
	static {
		users.add(new User(1, "Yusuf", new Date()));
		users.add(new User(2, "Sevde", new Date()));
		users.add(new User(3, "Zeyneb", new Date()));
	}
	
	//methods
	
	// findAll() - return all users
	public List<User> findAll(){
		return users;
	}
	
	// save(User user) - save a new user
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	// findOne(int id) - find a user by id
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
}
