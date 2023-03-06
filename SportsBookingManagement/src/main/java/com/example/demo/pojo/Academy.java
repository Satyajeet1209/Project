package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Academy extends BaseEntity{
	
	@Column(length = 500,nullable = false)
	private String description;
	
	@Column(length = 30,nullable = false)
	private String location;
	
	@Column(length = 30,nullable = false,unique = true,columnDefinition="CHAR(10)")
	private String contactDetails;
	
	@Column(length = 50,nullable = false)
	private String academyName;
	
	@Column(length = 100,nullable = false)
	private String address;
	
	@Column(length = 100,nullable = false)
	private String city;
	
	@Column(name = "no_of_sports",nullable =false)
	private Integer noOfSports;
	
	@OneToOne
	@JoinColumn(name = "owner_id")
	private AcademyOwner owner;
	
	@OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
	private List<AcademyPhotos> photoList = new ArrayList<>();
	
	@OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
	private List<Sports> sportList = new ArrayList<>();
	
	@OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
	private List<Ground> groundList = new ArrayList<>();
	
	@OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
	private List<Booking> bookingList = new ArrayList<>();
	
	@OneToMany(mappedBy = "academy")
	private List<Reviews> reviewList = new ArrayList<Reviews>();

}
