package com.epam.engx.cleancode.naming.task2;

import java.util.Arrays;
import java.util.Date;

public class User {

	private Date dateOfBirth;

	private String name;

	private boolean isAdmin;

	private User[] subordinateArray;

	private int rating;

	public User(String sName) {
		super();
		this.name = sName;
	}

	@Override
	public String toString() {
		return "User [dateOfBirthBirth=" + dateOfBirth + ", studentName=" + name + ", isAdmin=" + isAdmin + ", subordinateArray="
				+ Arrays.toString(subordinateArray) + ", Rating=" + rating + "]";
	}

}
