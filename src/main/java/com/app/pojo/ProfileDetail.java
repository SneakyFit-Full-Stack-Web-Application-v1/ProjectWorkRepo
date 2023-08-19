package com.app.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="profile_detail")
public class ProfileDetail extends BaseEntity {

	@Column(name="first_name",nullable = false , length = 50)

	private String firstName;
	@Column(name="last_name",nullable = false , length = 50)
	private String lastName;
	
	@Column(name="mobile",nullable = false , length = 13)
	private String mobileNumber;
	@Column(name="email",nullable = false , length = 50, unique = true)
	
	private String email;
	@Column(name="dob" ,nullable = false  )
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	@Column(name="gender",nullable = false )
	private Gender gender;
	@Enumerated(EnumType.STRING)
	@Column(name="role",nullable = false )
	private Role role;
	@Column(name="password",nullable = false , length = 20)
	private String password;
	
	@OneToMany(mappedBy = "profileDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses = new ArrayList<Address>();
	
	@OneToMany(mappedBy = "profileDetail", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Rating> ratings = new ArrayList<Rating>();
	
	@OneToMany(mappedBy = "profileDetail",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Review> reviews=new ArrayList<Review>();
	
	@Embedded
	@ElementCollection
	@CollectionTable(name = "payment_information",joinColumns = @JoinColumn(name="profile_id"))
	private List<PaymentInformation> paymentInformations=new ArrayList<PaymentInformation>();
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address addr) {
		addresses.add(addr);
		addr.setProfileDetail(this);
	}
	
	public void removeAddress(Address addr) {
		addresses.remove(addr);
		addr.setProfileDetail(null);
	}
	
	public void addRatings(Rating rate)
	{
		ratings.add(rate);
		rate.setProfileDetail(this);
	}
	
	public void removeRatings(Rating rate)
	{
		ratings.remove(rate);
		rate.setProfileDetail(null);
	}
	
	public void addReview(Review review) {
		reviews.add(review);
		review.setProfileDetail(this);
	}
	
	public void removeReview(Review review) {
		reviews.remove(review);
		review.setProfileDetail(null);
	}
	
	
}
