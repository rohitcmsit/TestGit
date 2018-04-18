package com.springboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
@Service
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository repository;
	
	
	public void insertEmployee(Employee employee) {
		
		repository.save(employee);
		
			
	}


    public List<Employee> findAll(){
	 
      return repository.findAll();
     }
    
    public void deleteEmp(Employee employee){
    	
    	repository.delete(employee);
    }
 
 

}
