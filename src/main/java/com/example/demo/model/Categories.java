package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categories {
	
	@Id
	private String categoriesID;
	private String name;
	private String description;
	
	public String getCategoriesID() {
		return categoriesID;
	}
	public void setCategoriesID(String categoriesID) {
		this.categoriesID = categoriesID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
