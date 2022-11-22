package io.kadev.services;

import io.kadev.models.Role;
import io.kadev.models.User;

import java.util.List;

public interface UserService {
	User addUser(User user);
	Role addRole(Role role);
	User getUser(String username);
	User getUser(Long userId);
	void deleteUser(Long userId);
	Role getRole(String name);
	List<User> getAllUsers();
	void addRoleToUser(String username,String name);
}
