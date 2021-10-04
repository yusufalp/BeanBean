package com.yusuf.rest.webservices.restfulwebservices.filtering;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// 	Static Filtering

//	You can ignore selected fields using JsonIgnoreProperties
@JsonIgnoreProperties(value= {"field3"})
public class FilterBean {

	private String field1;
	private String field2;
	
	// 	If you want to ignore a individually, enter this before each variable
	//	@JsonIgnore
	private String field3;
	
	public FilterBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	} 
	
}
