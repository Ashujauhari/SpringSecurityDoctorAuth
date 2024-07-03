package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.feign.PatientFeignClient;
import com.example.demo.payload.LoginDto;
import com.example.demo.service.IDoctorService;

import jakarta.validation.Valid;

@RestController // http://localhost:9192/api/hello
@RequestMapping("/docapi/user")

public class DoctorController {

	// http://localhost:9193/swagger-ui/index.html
	
	@Autowired
	IDoctorService doctorService;
	
	@Autowired
	PatientFeignClient patientClient;
	//Testing
	@PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        ResponseEntity<String> response = doctorService.authenticateUser(loginDto);
       // return new ResponseEntity<>(response, HttpStatus.OK);
        return response;
    }

	/*@GetMapping("/hello")
	String hello(@RequestBody LoginDto loginDto) {
		String response = doctorService.authenticateUser(loginDto);
		System.out.println("response :"+ response);
		return "Hello World, Spring Boot Doctor.... Welcome to You!";
	}*/
	
	@GetMapping("/hello")
    public String hello(@RequestBody LoginDto loginDto) {
        try {
            ResponseEntity<String> responseEntity = doctorService.authenticateUser(loginDto);
            String response = responseEntity.getBody();
            System.out.println("Authentication response: " + response);
            return "Hello World, Spring Boot Doctor.... Welcome to You!";
        } catch (Exception e) {
            // Log the exception or handle it as per your application's error handling strategy
            System.err.println("Error while authenticating user: " + e.getMessage());
            return "Authentication failed. Please check your credentials.";
        }
    }
	
	//feign call
	// http://localhost:9192/api/1/patient
	@GetMapping("/{doctorId}/patient")
	public List<Patient> getpatiencesByDoctor(@PathVariable int doctorId) {
        return patientClient.getPatientByDoctorId(doctorId);
	}
	

	@GetMapping("/doctors")
	List<Doctor> doctors() {
		// System.out.println("Running");
		return doctorService.getDoctorsFromDatabase();

	}

	// http://localhost:9192/api/doctors/1
	@GetMapping("/doctors/{id}")
	Optional<Doctor> findByDoctorsId(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Doctor> product = doctorService.getDoctorById(id);
		product.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
		return product;
	}

	// http://localhost:9192/api/doctors/1
	@DeleteMapping("/doctors/{id}")
	void deleteDoctorsById(@PathVariable int id) {
		doctorService.deleteDoctorById(id);
	}

	// http://localhost:9192/api/doctors
	@PostMapping("/doctors")
	public Doctor createDoctor(@Valid @RequestBody Doctor newDoctor) {
		return doctorService.createDoctor(newDoctor);
	}

	// http://localhost:9192/api/doctors/1
	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor
	(@PathVariable(value = "id") Integer doctorId,@Valid @RequestBody Doctor newDoctor) {
		return doctorService.updateDoctor(doctorId,newDoctor);
	}

	// http://localhost:9192/api/doctors/req?id=1
	@GetMapping("/doctors/req")
	Optional<Doctor> findByDoctorIdUsingRequest(@RequestParam int id) {
		
		return doctorService.getDoctorById(id);
	}
	
	
	
	
	
}
