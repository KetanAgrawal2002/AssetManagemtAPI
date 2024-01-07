package com.example.demo.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AssignmentStatus;
import com.example.demo.exception.NoValueInDB;
import com.example.demo.model.Assets;
import com.example.demo.model.AssignedStatus;
import com.example.demo.repo.Assetrepo;
import com.example.demo.repo.AssignedStatusRepo;

@RestController 
public class AssetAssignmentController {

	
	@Autowired
	AssignedStatusRepo aspc;
	@Autowired
	Assetrepo assetrepo;
	
	@PostMapping("/assign/{assetID}/{EmployeeID}")
    public String addAsset(@PathVariable("assetID") String assetID,@PathVariable("EmployeeID")int empID) {
        Optional<Assets> asset = assetrepo.findById(assetID.toLowerCase());
        if(asset.isEmpty()) {
        	return "Asset does not exists please first add asset";
        }else {
        	if(asset.get().getAssignmentStatus()==AssignmentStatus.Assigned) {
        		return "Asset already assigned to other employee";
        	}else {
        		asset.get().setAssignmentStatus(AssignmentStatus.Assigned);
        		AssignedStatus as = new AssignedStatus();
        		as.setAsset(asset.get());
        		as.setEmployeeID(empID);
        		aspc.save(as);
        		
        	}
        }
       
    	return "Asset Assigned to Employee"+empID;
    }
	
	@GetMapping("/assign")
	public Page<AssignedStatus> getAll(@RequestParam(defaultValue="0")int pageNo, 
										@RequestParam(defaultValue="10")int pageSize){
		PageRequest paging  = PageRequest.of(pageNo, pageSize);
		Page<AssignedStatus> assignedAssets = aspc.findAll(paging);
		if(assignedAssets.isEmpty()) {
			throw new NoValueInDB("No assets alloted to employee");
		}else {
			return assignedAssets;
		}
	}
	
}
