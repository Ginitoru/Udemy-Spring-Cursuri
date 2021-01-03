package com.luv2code.jackson.json.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) throws IOException {




		//create object mapper
//		ObjectMapper mapper = new ObjectMapper();
//
//		//read JSON file and map/convert to Java POJO
//		//data/sample-lite.json
//
//		Student theStudent = mapper.readValue(
//					new File("data/sample-lite.json"), Student.class);
//
//
//
//
//		//print fistname and last name
//		System.out.println("first name: " + theStudent.getFirstName());
//		System.out.println("last name: " + theStudent.getLastName());



		//create object mapper
		ObjectMapper mapper = new ObjectMapper();

		//read JSON file and map/convert to Java POJO
		//data/sample-lite.json

		Student theStudent = mapper.readValue(
					new File("data/sample-full.json"), Student.class);




		//print fistname and last name
		System.out.println("first name: " + theStudent.getFirstName());
		System.out.println("last name: " + theStudent.getLastName());

		Address address = theStudent.getAddress();

		System.out.println("Street: " + address.getStreet() + " " + address.getCity() + " " + address.getZip());



		Arrays.asList(theStudent.getLanguages())
							.forEach(System.out::println);







	}
}




