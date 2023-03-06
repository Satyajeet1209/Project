package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.AcademyOwner;

public interface AcademyOwnerService {
	public List<AcademyOwner> findallOwners();
	public String addowner(AcademyOwner owner);
	public AcademyOwner findOwner(Long id);
	public String UpdateOwner(Long id , AcademyOwner newowner);
	public String DeleteOwner(Long id);
}
