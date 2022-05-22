package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.model.Users;
import com.cg.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserService liserv;
    @Autowired
	public UserController(UserService liserv) {
		this.liserv=liserv;
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Users>> getAllUser(){
    return new ResponseEntity<List<Users>>((List<Users>)liserv.getAllUser(),HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Users>addUser(@RequestBody Users ad) {
		Users  savedDept = liserv.addUser(ad);
		 return new ResponseEntity<>(savedDept, HttpStatus.CREATED);
	}
}
