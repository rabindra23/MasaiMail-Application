package com.masai.mailapp.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@Column(unique = true)
	private String email;
	@Pattern(regexp="^[A-Z][a-z]*",message ="{firstName.invalid}")
    private String firstName;
	@Pattern(regexp="^[A-Z][a-z]*",message= "{lastname.invalid}")
    private String lastName;
	@Size(min=10,max=10,message="{mobileNumber.invalid}")
    private String mobileNumber;
	@Past(message="{dateOfBirth.invalid}")
    private LocalDate dateOfBirth;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Email> em;
    
    public User() {}

	public User(String email, String firstName, String lastName, String mobileNumber, LocalDate dateOfBirth,
			List<Email> em) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.dateOfBirth = dateOfBirth;
		this.em = em;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<Email> getEm() {
		return em;
	}

	public void setEm(List<Email> em) {
		this.em = em;
	}
    
}
