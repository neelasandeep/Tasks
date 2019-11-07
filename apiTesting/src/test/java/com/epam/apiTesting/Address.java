package com.epam.apiTesting;

import java.util.Map;

public class Address {
	private String street;
	private String suite;
	private String city;
	private String Zipcode;
	private Map<String, String> geo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}

	public Map<String, String> getGeo() {
		return geo;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", suite=" + suite + ", city=" + city + ", Zipcode=" + Zipcode + ", geo="
				+ geo + "]";
	}

	public void setGeo(Map<String, String> geo) {
		this.geo = geo;
	}

}
