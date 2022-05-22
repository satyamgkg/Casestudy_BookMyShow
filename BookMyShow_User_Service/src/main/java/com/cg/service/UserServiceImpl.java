package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Users;
import com.cg.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	private UserRepository MovieRepo;
	@Autowired
	public UserServiceImpl(UserRepository MovieRepo) {
		super();
		this.MovieRepo = MovieRepo;
	    }
	@Override
	public List<Users> getAllUser() {
		
		return (List<Users>) MovieRepo.findAll();
		
	}
	@Override
	public Users addUser(Users ad) {
		// TODO Auto-generated method stub
		Users  savedDept = MovieRepo.save(ad);
		 return  savedDept;
	}

}
