package com.yusuf.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Controller - handles the http requests
@RestController
public class HelloWorldController {
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
//	public String helloWorld() {
//		return "Hello World";
//	}
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello, this is Yusuf";
	}
	
	// Creating a hello-world-bean
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("This will return a JSON");
	}
}