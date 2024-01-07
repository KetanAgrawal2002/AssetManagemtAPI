package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AssignedStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int assignmentID;
	@OneToOne
    @JoinColumn(name = "AssetID")
	private Assets asset;

	private int employeeID;
	public Assets getAsset() {
		return asset;
	}
	public void setAsset(Assets asset) {
		this.asset = asset;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
}
