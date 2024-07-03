package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;

import jakarta.validation.Valid;
@Service
public class DoctorService implements IDoctorService{
	//for getting log in console
	private final Logger logger = LoggerFactory.getLogger(DoctorService.class);
	
	@Autowired
	DoctorRepository productRepo;
	
	@Override
	public List<Doctor> getDoctorsFromDatabase() {
		logger.info("Fetching all records from Database...");
		return productRepo.findAll();
	}
	
	@Override
	public Optional<Doctor> getDoctorById(int id) {
		
		return productRepo.findById(id);
	}

	@Override
	public void deleteDoctorById(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}

	@Override
	public Doctor createDoctor(@Valid Doctor newDoctor) {
		// TODO Auto-generated method stub
		return productRepo.save(newDoctor);
	}

	@Override
	public ResponseEntity<Doctor> updateDoctor(Integer doctorId, @Valid Doctor newDoctor) {
		Optional<Doctor> existingProduct = productRepo.findById(doctorId);
		existingProduct.get().setDocName(newDoctor.getDocName());
		existingProduct.get().setAddress(newDoctor.getAddress());
		productRepo.save(existingProduct.get());
		return ResponseEntity.ok(existingProduct.get());
	}
	
	
	
	
	

}
