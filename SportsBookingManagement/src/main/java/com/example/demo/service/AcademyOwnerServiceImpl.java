package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.pojo.AcademyOwner;
import com.example.demo.repo.AcademyOwnerRepo;

@Service
@Transactional
public class AcademyOwnerServiceImpl implements AcademyOwnerService {

	@Autowired
	AcademyOwnerRepo academyOwnerRepo;
	
	@Override
	public List<AcademyOwner> findallOwners() {
		return academyOwnerRepo.findAll();
	}

	@Override
	public String addowner(AcademyOwner owner) {
		try {
			academyOwnerRepo.save(owner);
			return "Owner added successfully";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public AcademyOwner findOwner(Long id) {
		return academyOwnerRepo.findById(id).orElseThrow(()->new RuntimeException("AcademyOwner not found"));
	}

	@Override
	public String UpdateOwner(Long id, AcademyOwner newOwner) {
		AcademyOwner oldOwner=academyOwnerRepo.findById(id).orElseThrow(()->new RuntimeException("AcademyOwner not found"));
		oldOwner=newOwner;
		academyOwnerRepo.save(oldOwner);
		return "Owner updated successfully";
	}

	@Override
	public String DeleteOwner(Long id) {
		try {
			academyOwnerRepo.deleteById(id);
			return "Owner data deleted successfully";
		}catch (Exception e) {
			return "something went wrong";
		}
	}

}
