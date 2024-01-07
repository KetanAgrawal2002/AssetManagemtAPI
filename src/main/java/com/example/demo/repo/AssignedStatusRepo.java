package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.AssignedStatus;

public interface AssignedStatusRepo extends JpaRepository<AssignedStatus, Integer>  {

}
