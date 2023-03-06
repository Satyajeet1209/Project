package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users extends BaseEntity {
	@Column(length = 20,nullable = false)
	private String password;
	
	@Column(length = 50,unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type",length = 6)
	private Role role;

	public Users(String password, Role role) {
		super();
		this.password = password;
		this.role = role;
	}

}
