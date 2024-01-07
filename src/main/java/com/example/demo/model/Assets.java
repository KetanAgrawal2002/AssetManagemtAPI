package com.example.demo.model;



import java.sql.Date;

import com.example.demo.AssignmentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Assets {
	
	@Id
	private String assetID;
	private String name;
	private Date purchaseDate;
	private String conditionNotes;
	@ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categoryID;
	private AssignmentStatus assignmentStatus;
	
	public String getAssetID() {
		return assetID;
	}
	public void setAssetID(String assetID) {
		this.assetID = assetID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getConditionNotes() {
		return conditionNotes;
	}
	public void setConditionNotes(String conditionNotes) {
		this.conditionNotes = conditionNotes;
	}

	public Categories getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Categories categoryID) {
		this.categoryID = categoryID;
	}
	public AssignmentStatus getAssignmentStatus() {
		return assignmentStatus;
	}
	public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}
	

	
	
	
}
