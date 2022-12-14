package io.kadev;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.kadev.models.Event;
import io.kadev.models.EventDate;
import io.kadev.models.Role;
import io.kadev.models.User;
import io.kadev.services.EmailNotifierServiceImpl;
import io.kadev.services.EventDateServiceImpl;
import io.kadev.services.EventService;
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
	CommandLineRunner start(UserServiceImpl userService, EventService eventService, EventDateServiceImpl eventdateService, EmailNotifierServiceImpl emailNotifierService) {
		return args -> {
			userService.addRole(new Role(null,"UTILISATEUR"));
			userService.addRole(new Role(null,"ADMINISTRATEUR"));

			userService.addUser(new User(null,"hamza.kadimi@uit.ac.ma","ADMIN",32,"Homme",true,"1949",new ArrayList<Role>()));

			userService.addRoleToUser("ADMIN", "ADMINISTRATEUR");
			userService.addRoleToUser("ADMIN", "UTILISATEUR");
			
			
			EventDate ed1 = new EventDate(null,new Date());
			EventDate ed2 = new EventDate(null,new Date());
			Event e1 = new Event("Title 1", "Address 1", "Description 1 ....");
			Event e2 = new Event("Title 2", "Address 2", "Description 2 ....");
			e1.getEventDates().add(ed1);
			e2.getEventDates().add(ed2);
			eventService.addEvent(e1);
			eventService.addEvent(e2);
			
			

			
//			eventService.addEvent(new Event(null, "Title 3", "Address 3", "Description 3 ...."));
//			eventService.addEvent(new Event(null, "Title 4", "Address 4", "Description 4 ...."));

		};
	}
	
}
