package com.clinic.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clinic.main.model.Doctor;
import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, Long> {
	Doctor findTopByOrderByIdDesc();
	List<Doctor> findByName(String name);
}
