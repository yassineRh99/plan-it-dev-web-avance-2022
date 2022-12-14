package io.kadev.models;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor	
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String username;
	private int age;
	private String gender;
	private boolean membre;
	@JsonIgnore
	private String mot_de_passe;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = Arrays.asList();
	
}
