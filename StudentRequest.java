package com.satya.request;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentRequest {
	
	private String name;
	
	private String email;
	
	private String rollNum;
	
	private long mobNum;

}
