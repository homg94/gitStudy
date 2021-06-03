package com.example.RESTfull.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

	private Date timesStamp;
	private String Msg;
	private String Details;
	
}
