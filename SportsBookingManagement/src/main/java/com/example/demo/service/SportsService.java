package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GroundDto;
import com.example.demo.dto.SportsDto;
import com.example.demo.pojo.Ground;
import com.example.demo.pojo.Sports;

public interface SportsService {
	SportsDto getSportsById(Long id);
    List<SportsDto> getAllSports();
    List<GroundDto> getGroundsBySports(Long sportsId);
    SportsDto getSportsByIdAndAcademyId(Long id, Long academyId);
    List<SportsDto> getSportsByAcademyId(Long academyId);
	SportsDto createSports(SportsDto sportsDto);
	SportsDto updateSports(Long id, SportsDto sportsDto);
	void deleteSports(Long id);

}
