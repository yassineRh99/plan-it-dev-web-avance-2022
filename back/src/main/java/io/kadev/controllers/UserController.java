package io.kadev.controllers;

import java.util.List;

import io.kadev.services.EmailNotifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Dto.UserDto;
import io.kadev.models.Role;
import io.kadev.models.User;
import io.kadev.services.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	EmailNotifierService emailNotifierService;
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	@PostMapping("register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto){
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setAge(userDto.getAge());
		user.setMembre(false);
		user.setMot_de_passe(userDto.getPassword());
		user.setGender(userDto.getGender());
		emailNotifierService.notify(userService.getUser("ADMIN").getEmail(),"NEW USER HAS BEEN REGISTRED", "CHECK YOUR ACCOUNT ,YOU HAVE SOME NEW USERS WAITING YOUR CONFIRMATION");
		return ResponseEntity.ok().body(userService.addUser(user));
	}
	
	@PutMapping("confirm")
	public ResponseEntity<User> confirmAdherence(@RequestParam Long userId){
		User user = userService.getUser(userId);
		user.setMembre(true);
		Role role = userService.getRole("UTILISATEUR");
		user.getRoles().add(role);
		emailNotifierService.notify(user.getEmail(),"CONFIRMATION ACCOUNT PLANit", "You have been accepted by the administrator of PlanIt, you are able now to participate in events proposed by the captains, ENJOY !");
		return ResponseEntity.ok().body(userService.addUser(user));
	}
	
	@DeleteMapping("remove_user")
	public ResponseEntity<?> removeUser(@RequestParam Long userId){
		userService.deleteUser(userId);
		emailNotifierService.notify(userService.getUser(userId).getEmail(),"YOUR ACCOUNT IS DELETED", "Your account have been deleted, the administrator didn't accep your request for registration. Contact Us for more information");
		return ResponseEntity.ok().body(null);
	}
	
}
