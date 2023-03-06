package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AcademyDto;
import com.example.demo.pojo.Academy;
import com.example.demo.pojo.SportsType;
import com.example.demo.service.AcademyService;

@RestController
@RequestMapping("/academy")
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @GetMapping("/{id}")
    public ResponseEntity<AcademyDto> findById(@PathVariable Long id) {
        Academy academy = academyService.findById(id);
        AcademyDto academyDto = convertToDto(academy);
        return ResponseEntity.ok(academyDto);
    }

    @GetMapping("/findBySports")
    public ResponseEntity<List<AcademyDto>> findBySports(@RequestParam SportsType sports) {
        List<Academy> academies = academyService.findBySports(sports);
        List<AcademyDto> academyDtos = convertToDtoList(academies);
        return ResponseEntity.ok(academyDtos);
    }

    @GetMapping("/findByAcademyName")
    public ResponseEntity<List<AcademyDto>> findByAcademyName(@RequestParam String academyName) {
        List<Academy> academies = academyService.findByAcademyName(academyName);
        List<AcademyDto> academyDtos = convertToDtoList(academies);
        return ResponseEntity.ok(academyDtos);
    }

    @GetMapping("/findByCity")
    public ResponseEntity<List<AcademyDto>> findByCity(@RequestParam String city) {
        List<Academy> academies = academyService.findByCity(city);
        List<AcademyDto> academyDtos = convertToDtoList(academies);
        return ResponseEntity.ok(academyDtos);
    }

    @GetMapping("/findByCityAndSports")
    public ResponseEntity<List<AcademyDto>> findByCityAndSports(@RequestParam String city, @RequestParam SportsType sports) {
        List<Academy> academies = academyService.findByCityAndSports(city, sports);
        List<AcademyDto> academyDtos = convertToDtoList(academies);
        return ResponseEntity.ok(academyDtos);
    }

    private AcademyDto convertToDto(Academy academy) {
        ModelMapper modelMapper = new ModelMapper();
        AcademyDto academyDto = modelMapper.map(academy, AcademyDto.class);
        return academyDto;
    }

    private List<AcademyDto> convertToDtoList(List<Academy> academies) {
        List<AcademyDto> academyDtos = new ArrayList<>();
        for (Academy academy : academies) {
            AcademyDto academyDto = convertToDto(academy);
            academyDtos.add(academyDto);
        }
        return academyDtos;
    }
}
