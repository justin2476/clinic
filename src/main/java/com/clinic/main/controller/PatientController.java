package com.clinic.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.main.model.Patient;
import com.clinic.main.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	private PatientRepository patientRepo;

	@PostMapping("createPatient")
	public String createPerson(@RequestBody Patient p) {
		Patient lastPatient = patientRepo.findTopByOrderByIdDesc();
		if (lastPatient != null) {
			long lastId = lastPatient.getId();
			++lastId;
			p.setId(lastId);
		} else {
			p.setId(1000);
		}
		Patient cp = patientRepo.insert(p);

		return "Student Created" + cp.getName();

	}

	@GetMapping("getAllPatient")
	public List<Patient> getPerson() {
		return patientRepo.findAll();
	}

}
