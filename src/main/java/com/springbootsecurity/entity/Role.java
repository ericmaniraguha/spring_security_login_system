// Import necessary classes and interfaces
package com.springbootsecurity.entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Declare the entity as a JPA entity
@Entity
// Specify the table name for this entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

	// Define the primary key field for the entity
	@Id
	// Specify the strategy for generating the primary key value
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Map this field to the 'role_id' column in the database table
	@Column(name = "role_id")
	private Integer roleId;
	
	// Define a field to store the authority of the role
	private String authority;
	
	// Default constructor
	public Role() {
		super();
	}
	
	// Constructor with authority parameter
	public Role(String authority) {
		this.authority = authority;
	}
	
	// Constructor with roleId and authority parameters
	public Role(Integer roleId, String authority) {
		this.roleId = roleId;
		this.authority = authority;
	}
	
	// Implement the method from the GrantedAuthority interface
	@Override
	public String getAuthority() {
		// Return the authority of the role
		return this.authority;
	}
	
	// Setter method for authority
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	// Getter method for roleId
	public Integer getRoleId() {
		return roleId;
	}
	
	// Setter method for roleId
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
