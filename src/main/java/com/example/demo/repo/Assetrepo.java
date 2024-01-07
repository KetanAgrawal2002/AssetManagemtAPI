package com.example.demo.repo;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Assets;

public interface Assetrepo extends JpaRepository<Assets, String> {
	
    @Query("SELECT a FROM Assets a WHERE a.name = ?1")
    Page<Assets> findByName(String name, PageRequest paging);
//    
//    @Query("DELETE FROM Assets a WHERE a.assetID = ?1 AND a.assignmentStatus != 1")
//    void deleteAsset(String assetID);
	
}
