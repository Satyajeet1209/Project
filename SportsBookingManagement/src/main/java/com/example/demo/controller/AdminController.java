package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.AcademyOwner;
import com.example.demo.service.AcademyOwnerService;

@RestController
@RequestMapping("/owner")
@CrossOrigin
public class AdminController {

	@Autowired
	AcademyOwnerService academyOwnerService;
	
	@GetMapping("/ownerlist")
	public List<AcademyOwner> getallOwners(){ ;
		return academyOwnerService.findallOwners();
	}


	@PostMapping("/addowner")
	public String addOwner(@RequestBody AcademyOwner owner) {
		
		return academyOwnerService.addowner(owner);
	}
	
	@GetMapping("/findowner/{id}")
	public AcademyOwner findowner(@PathVariable Long id) {
		AcademyOwner owner = academyOwnerService.findOwner(id);
		return owner;
	}
	
	@PutMapping("/updateowner/{id}")
	public String updateOwner(@RequestBody AcademyOwner owner ,@PathVariable Long id ) {
		String mesg = academyOwnerService.UpdateOwner(id, owner);
		return mesg;
	}

	@DeleteMapping("/deleteowner/{id}")
	public String DeleteOwner(@PathVariable Long id) {
		String message = academyOwnerService.DeleteOwner(id);
		return message;
	}
	
}
