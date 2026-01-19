package com.satya.request;

import lombok.Data;

@Data
public class UserRequest {
	private int id;
	private String name;
	private String password;
	private long mobileNum;
	private String place;

}
