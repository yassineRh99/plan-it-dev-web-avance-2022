package io.kadev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Dto.UserDto;
import io.kadev.models.Role;
import io.kadev.models.User;
import io.kadev.services.UserService;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

//	@GetMapping("/users")
//	public List<User> getAllUsers(){
//		return userService.getAllUsers();
//	}
	
	@PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setAge(userDto.getAge());
		user.setMembre(false);
		user.setMot_de_passe(userDto.getPassword());
		user.setSexe(userDto.getSexe());
		return ResponseEntity.ok().body(userService.addUser(user));
	}
	
	@PutMapping("confirm")
	public ResponseEntity<User> confirmAdherence(@RequestParam Long userId){
		User user = userService.getUser(userId);
		user.setMembre(true);
		Role role = userService.getRole("UTILISATEUR");
		user.getRoles().add(role);
		return ResponseEntity.ok().body(userService.addUser(user));
	}
	
}
