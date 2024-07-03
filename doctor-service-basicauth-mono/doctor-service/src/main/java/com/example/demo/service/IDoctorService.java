package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Doctor;

import jakarta.validation.Valid;

public interface IDoctorService {
	
	List<Doctor> getDoctorsFromDatabase();
	public Optional<Doctor> getDoctorById(int id);
	void deleteDoctorById(int id);
	Doctor createDoctor(@Valid Doctor newDoctor);
	//ResponseEntity<Doctor> updateProduct(Integer productId);
	ResponseEntity<Doctor> updateDoctor(Integer productId, @Valid Doctor newDoctor);
	

}
