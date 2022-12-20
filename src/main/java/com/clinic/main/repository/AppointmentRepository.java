package com.clinic.main.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinic.main.model.Appointment;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, Long> {
	Appointment findTopByDoctorAndStartDateAndIsBooked(String doc,Date start,boolean isbook);
	Appointment findTopByPatientIdAndStartDate(long pId,Date start);
}
