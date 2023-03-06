package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Sports extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
	@Column(name = "sports_name",length = 6)
	private SportsType sports;
	
	@Column(name = "no_of_ground",nullable = false)
	private Long noOfGrounds;
	
	@ManyToOne
	@JoinColumn(name ="academy_id")
	private Academy academy;
	
	@OneToMany(mappedBy = "sports",cascade = CascadeType.ALL)
	private List<Ground> groundList = new ArrayList<>();



	
	 public static Sports fromString(String sport) {
	        for (Sports s : Sports.values()) {
	            if (s.toString().equalsIgnoreCase(sport)) {
	                return s;
	            }
	        }
	        throw new IllegalArgumentException("Invalid sport: " + sport);
	    }

	 public static Sports[] values() {
	        return Sports.values();
	    }



	

}
