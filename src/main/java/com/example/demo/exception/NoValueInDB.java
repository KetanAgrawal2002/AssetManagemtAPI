package com.example.demo.exception;

public class NoValueInDB extends RuntimeException{
	public NoValueInDB(String msg) {
		super(msg);
	}
}
