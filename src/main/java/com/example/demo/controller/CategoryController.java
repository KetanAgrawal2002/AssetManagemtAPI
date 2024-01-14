package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;

import org.springframework.cache.annotation.Cacheable;
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

import com.example.demo.exception.NoValueInDB;
import com.example.demo.model.Categories;
import com.example.demo.repo.CategoriesRepo;

@RestController

public class CategoryController {

    @Autowired
    CategoriesRepo crepo;

    @CacheEvict(value="category", allEntries=true)
    @PostMapping("/category")
    public Categories addCategory(@RequestBody Categories category) {
        crepo.save(category);
    	return category;
    }
    
    @Cacheable(value="category")
    @GetMapping("/category/{categoriesID}")
    public Optional<Categories> viewCategory(@PathVariable("categoriesID") String id) {
        Optional<Categories> cat = crepo.findById(id);
        if(cat.isEmpty()) {
        	throw new NoValueInDB("No categories Present with ID = "+id);
        }else {        	
        	return cat;
        }
    }
    
    @Cacheable(value="category")
    @GetMapping("/category")
    public Page<Categories> viewAllCategory(@RequestParam(defaultValue = "0") int pageNo,
    										@RequestParam(defaultValue = "10") int pageSize ) {
    	PageRequest paging = PageRequest.of(pageNo, pageSize);
        Page<Categories> cat = crepo.findAll(paging);
        if(cat.isEmpty()) {
        	throw new NoValueInDB("No categories Present");
        }else {
        	return cat;
        }
    }
    
    
    @CacheEvict(value="category", allEntries=true)
    @PutMapping("/category")
    public Categories updateCategory(@RequestBody Categories category) {
        crepo.save(category);
    	return category;
    }
    
    @CacheEvict(value="category", allEntries=true)
    @DeleteMapping("/category/{categoriesID}")
    public Optional<Categories> deleteCategory(@PathVariable("categoriesID") String id) {
        Optional<Categories> cat = crepo.findById(id);
        if(cat.isEmpty()) {
        	return null;
        }else {
        	crepo.deleteById(id);
        	return cat;
        }
    }
    

    
}

