package com.yusuf.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {
	
	private String text;

	public HelloWorldBean(String text) {
		// TODO Auto-generated constructor stub
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [text=%s]", text);
	}
	
}
