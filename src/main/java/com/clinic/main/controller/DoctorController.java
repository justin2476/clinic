package com.clinic.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.main.model.Doctor;
import com.clinic.main.repository.DoctorRepository;

@RestController
public class DoctorController {

	@Autowired
	private DoctorRepository docRepo;

	@PostMapping("createDoctor")
	public String createPerson(@RequestBody Doctor doc) {
		Doctor lastDoc = docRepo.findTopByOrderByIdDesc();
		if (lastDoc != null) {
			long lastId = lastDoc.getId();
			++lastId;
			doc.setId(lastId);
		} else {
			doc.setId(1000);
		}
		Doctor cd = docRepo.insert(doc);

		return "Student Created" + cd.getName();

	}
	@GetMapping("getAllDoctor")
	public List<Doctor> getDoctor() {
		
		return docRepo.findAll();
	
	}
	
	@GetMapping("getDoctorByName")
	public List<Doctor> getDoctorByName(@RequestParam String name) {
	return docRepo.findByName(name);
	}
}
