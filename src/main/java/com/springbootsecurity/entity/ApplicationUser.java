// Import necessary classes and interfaces
package com.springbootsecurity.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

// Declare the entity as a JPA entity
@Entity
// Specify the table name for this entity
@Table(name = "users")
public class ApplicationUser implements UserDetails {

	// Define the primary key field for the entity
	@Id
	// Specify the strategy for generating the primary key value
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Map this field to the 'user_id' column in the database table
	@Column(name = "user_id")
	private Integer userId;

	// Define fields to store username and password for the user
	private String username;
	private String password;

	// Define a relationship between ApplicationUser and Role entities
	// FetchType.EAGER ensures that roles are fetched eagerly (loaded immediately with the user)
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(
		// Specify the junction table name
		name = "user_role_juncyion",
		// Specify the join column for the user entity
		joinColumns = { @JoinColumn(name = "user_id") },
		// Specify the inverse join column for the Role entity
		inverseJoinColumns = { @JoinColumn(name = "role_id") }
	)
	private Set<Role> authorities;

	// Default constructor
	public ApplicationUser() {
		super();
		// Initialize authorities as an empty HashSet
		this.authorities = new HashSet<Role>();
	}

	// Constructor with all fields
	public ApplicationUser(Integer userId, String username, String password, Set<Role> authorities) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	// Getter and setter methods for userId
	public Integer getUserId() {
		return userId;
	}

	public void setUserID(Integer userId) {
		this.userId = userId;
	}

	// Implement the method from the UserDetails interface to retrieve the user's authorities (roles)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Return the user's authorities (roles)
		return this.authorities;
	}

	// Setter method for authorities (roles)
	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	// Implement the method from the UserDetails interface to retrieve the user's password
	@Override
	public String getPassword() {
		return this.password;
	}

	// Setter method for the password
	public void setPassword(String password) {
		this.password = password;
	}

	// Implement the method from the UserDetails interface to retrieve the user's username
	@Override
	public String getUsername() {
		return this.username;
	}

	// Setter method for the username
	public void setUsername(String username) {
		this.username = username;
	}

	// Methods from UserDetails interface to indicate if the user's account is non-expired, non-locked, non-expired, and enabled
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
