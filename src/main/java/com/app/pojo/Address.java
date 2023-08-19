package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address extends BaseEntity{

	@Column(name="address_line1",nullable = false , length = 50)
	private String addressLine1;
	@Column(name="address_line2",nullable = false,length = 50)
	private String addressLine2;
	@Column(name="city",nullable = false , length = 20)
	private String city;
	@Column(name="postal_code",nullable = false,length = 20)
	private String postalCode;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	

	//	@OneToOne(cascade = CascadeType.ALL) //mandatory 
//	@MapsId //to tell hibernate : adr PK will be same emp PK + add FK constraint
	@ManyToOne
	@JoinColumn(name="profile_id")
	private ProfileDetail profileDetail;

	public AddressType getAddressType() {
		return addressType;
	}
	
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public ProfileDetail getProfileDetail() {
		return profileDetail;
	}

	public void setProfileDetail(ProfileDetail profileDetail) {
		this.profileDetail = profileDetail;
	}
	
	
	
	
}
