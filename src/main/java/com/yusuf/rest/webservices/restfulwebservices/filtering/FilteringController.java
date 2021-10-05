package com.yusuf.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveFilterBean() {
		FilterBean filterBean = new FilterBean("a","b","c");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilterBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
		mapping.setFilters(filters);
		
		return mapping; 
	}
}
