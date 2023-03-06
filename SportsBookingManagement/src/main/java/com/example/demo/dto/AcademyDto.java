package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademyDto {
	 private Long id;
	    private String description;
	    private String location;
	    private String contactDetails;
	    private String academyName;
	    private String address;
	    private String city;
	    private Integer noOfSports;


}
