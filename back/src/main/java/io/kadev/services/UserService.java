package io.kadev.services;

import io.kadev.models.Role;
import io.kadev.models.User;

public interface UserService {
	User addUser(User user);
	Role addRole(Role role);
	User getUser(String username);
	User getUser(Long userId);
	Role getRole(String name);
	void addRoleToUser(String username,String name);
}
