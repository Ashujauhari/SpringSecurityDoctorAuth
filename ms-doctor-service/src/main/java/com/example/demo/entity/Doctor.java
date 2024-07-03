package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;  
	
	@Column(name = "doctorName", nullable = false)
	private String docName;
	@Column(name = "qualification", nullable = false)
	private String qualification;
	@Column(name = "experience", nullable = false)
	private String exprnc;
	@Column(name = "Phone", nullable = false)
	private String phone;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "specialization", nullable = false)
	private String specialization;
	@Column(name = "Fees", nullable = false)
	private int basicFee;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "doc_id", referencedColumnName = "id")
	List<Patient> products = new ArrayList<>();
	
	
	public Doctor() {
		super();
	}


	public Doctor(String docName, String qualification, String exprnc, String phone, String address,
			String specialization, int basicFee) {
		super();
		this.docName = docName;
		this.qualification = qualification;
		this.exprnc = exprnc;
		this.phone = phone;
		this.address = address;
		this.specialization = specialization;
		this.basicFee = basicFee;
	}


	public int getDocId() {
		return id;
	}


	public void setDocId(int docId) {
		this.id = docId;
	}


	public String getDocName() {
		return docName;
	}


	public void setDocName(String docName) {
		this.docName = docName;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getExprnc() {
		return exprnc;
	}


	public void setExprnc(String exprnc) {
		this.exprnc = exprnc;
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


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public int getBasicFee() {
		return basicFee;
	}


	public void setBasicFee(int basicFee) {
		this.basicFee = basicFee;
	}
	
	
	
	
}
