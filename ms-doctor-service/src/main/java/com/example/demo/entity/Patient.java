package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;  
	
	@Column(name = "PatientName", nullable = false)
	private String patientName;
	@Column(name = "gender", nullable = false)
	private String gender;
	@Column(name = "age", nullable = false)
	private int age;
	@Column(name = "Phone", nullable = false)
	private String phone;
	@Column(name = "address", nullable = false)
	private String address;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String patientName, String gender, int age, String phone, String address) {
		super();
		this.patientName = patientName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
