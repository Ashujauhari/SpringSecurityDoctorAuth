package com.example.demo.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Patient;

import feign.Headers;

@Headers("Content-Type: application/json")

@FeignClient(name = "patient-service", url = "${PRODUCT_SERVICE:http://localhost:9193}")

public interface PatientFeignClient {

	@GetMapping("/api/patient/doctor/{doctorId}")
	List<Patient> getPatientByDoctorId(@PathVariable("doctorId") int doctorId);
}
