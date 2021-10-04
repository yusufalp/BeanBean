package com.yusuf.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public FilterBean retrieveFilterBean() {
		return new FilterBean("a","b","c");
	}
}
