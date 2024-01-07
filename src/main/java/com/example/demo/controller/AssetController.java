package com.example.demo.controller;

	
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AssignmentStatus;
import com.example.demo.exception.NoValueInDB;
import com.example.demo.model.Assets;
import com.example.demo.repo.Assetrepo;

@RestController 
public class AssetController {
	

	@Autowired
	Assetrepo arepo;
	
	@PostMapping("/asset")
    public String addAsset(@RequestBody Assets asset) {
        arepo.save(asset);
    	return asset.toString()+"  Added Successfully";
    }
    
    @GetMapping("/asset/{assetID}")
    public Optional<Assets> viewAsset(@PathVariable("assetID") String id) {
        Optional<Assets> asset = arepo.findById(id);
        if(asset.isEmpty()) {
        	throw new NoValueInDB("No asset found for ID = "+id);
        }else {        	
        	return asset;
        }
    }
    
    @GetMapping("/asset")
    public Page<Assets> viewAllAsset(@RequestParam(defaultValue="0")int pageNo,
									 @RequestParam(defaultValue="10")int pageSize){
    	PageRequest paging  = PageRequest.of(pageNo, pageSize);
        Page<Assets> asset = arepo.findAll(paging);
        if(asset.isEmpty()) {
        	throw new NoValueInDB("No assets found");
        }else {        	
        	return asset;
        }
    }
    
    @GetMapping("/asset/name/{name}")
    public Page<Assets> findAssetByName(@PathVariable("name") String name,
    									@RequestParam(defaultValue="0")int pageNo,
    									@RequestParam(defaultValue="10")int pageSize) {
    	PageRequest paging  = PageRequest.of(pageNo, pageSize);
    	Page<Assets> asset = arepo.findByName(name,paging);
    	if(asset.isEmpty()) {
    		throw new NoValueInDB("No assets found with name "+name );
    	}else {    		
    		return asset;
    	}
    }
    
    
    @PutMapping("/asset")
    public String updateAsset(@RequestBody Assets asset) {
        arepo.save(asset);
    	return asset.toString()+" Updated Successfully";
    }
    
    @PutMapping("/asset/status/{assetID}")
    public String updateAssetStatus(@PathVariable("assetID") String id) {
    	Optional<Assets> asset = arepo.findById(id);
    	if(asset.isEmpty()) {
    		return "Asset not found";
    	}else {
    		//System.out.println(asset);
    		asset.get().setAssignmentStatus(AssignmentStatus.Recovered);
    		return id+" Recovered sucessfully";
    	}
    }
    
    @DeleteMapping("/asset/{assetID}")
    public String deleteAssetfun(@PathVariable("assetID") String id) {
        Optional<Assets> asset = arepo.findById(id);
        
        if(!asset.isEmpty() && asset.get().getAssignmentStatus()!=AssignmentStatus.Assigned) {        	
        	arepo.deleteById(id);
        	return "Asset wit AssetID"+id+"deleted successfully";
        }else {
        	return "Can not delete maybe its assigned to someone or not exist";
        	
        }
    }
	
}
