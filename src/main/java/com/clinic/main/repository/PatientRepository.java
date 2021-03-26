package com.clinic.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinic.main.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Long>{
	 Patient findTopByOrderByIdDesc();
}
