package com.example.RESTfull.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private Integer id;
	
	@Size(min=2,message = "이름은 두 글자 이상 작성해주세요")
	private String name;
	
	@Past
	private Date joinDate;
	
	
}
