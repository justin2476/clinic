package com.clinic.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.main.model.Appointment;
import com.clinic.main.repository.AppointmentRepository;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentRepository appRepo;

	@PostMapping("createAppointment")
	public String createPerson(@RequestBody Appointment app) {
		Appointment ca = appRepo.insert(app);

		return "Student Created" + ca.getDoctor();

	}

	@GetMapping("getAllAppointment")
	public List<Appointment> getAppointment() {

		return appRepo.findAll();

	}

	@PutMapping("bookAppointment")
	public String bookAppointment(@RequestBody Appointment app) {
		Appointment ap = appRepo.findTopByDoctorAndStartDateAndIsBooked(app.getDoctor(), app.getStartDate(), false);
		if (ap != null) {
			ap.setBooked(true);
			ap.setPatientId(app.getPatientId());
			appRepo.save(ap);
			return "booked";
		} else
			return "not booked";
	}

}
