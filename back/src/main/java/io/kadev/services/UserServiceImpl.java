package io.kadev.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.kadev.models.Role;
import io.kadev.models.User;
import io.kadev.repositories.RoleRepository;
import io.kadev.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Service @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException,RuntimeException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			log.error("Username not found !");
			throw new UsernameNotFoundException("User not found in the database !");
		}
		if(!user.isMembre()) {
			log.error("L'utilisateur n'a pas joigner l'equipe encore !");
			throw new RuntimeException("User not allowed to login !");
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(
			user.getUsername(),user.getMot_de_passe(),authorities
		);
	}
	
	@Override
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public Role getRole(String name) {
		return roleRepository.findByName(name);
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void addRoleToUser(String username, String name) {
		log.info("Adding role {} to the user {}",name,username);
		User user = getUser(username);
		Role role = getRole(name);
		user.getRoles().add(role);
	}

	@Override
	public User addUser(User user) {
		log.info("Adding new user");
		user.setMot_de_passe(passwordEncoder.encode(user.getMot_de_passe()));
		return userRepository.save(user);
	}

	@Override
	public Role addRole(Role role) {
		log.info("Adding new role");
		return roleRepository.save(role);
	}
}
