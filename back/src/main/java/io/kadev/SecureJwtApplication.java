package io.kadev;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.kadev.models.Role;
import io.kadev.models.User;
import io.kadev.services.UserServiceImpl;

@SpringBootApplication
public class SecureJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureJwtApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start(UserServiceImpl userService) {
		return args -> {
			userService.addRole(new Role(null,"UTILISATEUR"));
			userService.addRole(new Role(null,"ADMINISTRATEUR"));
			
			userService.addUser(new User(null,"hamzakadimi1999@gmail.com","USER",29,"Homme","1949",new ArrayList<Role>()));
			userService.addUser(new User(null,"hamza.kadimi@uit.ac.ma","ADMIN",32,"Homme","1949",new ArrayList<Role>()));

			userService.addRoleToUser("ADMIN", "ADMINISTRATEUR");
			userService.addRoleToUser("USER", "UTILISATEUR");
			userService.addRoleToUser("ADMIN", "UTILISATEUR");
		};
	}
	
}
