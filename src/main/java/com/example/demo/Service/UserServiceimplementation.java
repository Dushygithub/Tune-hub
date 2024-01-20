package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceimplementation implements UserService
{
	@Autowired
	UserRepository urepo;

	@Override
	public String addUser(User user) {
		urepo.save(user);
		return "user added succesfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
		return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		User user=urepo.findByEmail(email);
		String dbpass=user.getPassword();
		if(password.equals(dbpass))
		{
			return true;
		}
		else
		{
		
		return false;
		}
		
	}

	@Override
	public String getRole(String email) {
		User user=urepo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {
		
		return urepo.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		urepo.save(user);
		
	}

	
	
	

}
