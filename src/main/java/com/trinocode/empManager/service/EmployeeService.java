package com.trinocode.empManager.service;

import com.trinocode.empManager.exception.UserNotFoundException;
import com.trinocode.empManager.model.Employee;
import com.trinocode.empManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepo empRepo;
    @Autowired
    public EmployeeService(EmployeeRepo empRepo) {
        this.empRepo = empRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmpCode(UUID.randomUUID().toString());
       return  empRepo.save(employee);
    }

    public List<Employee> findEmployees(){
        return empRepo.findAll();
    }

    public Employee updateEmployee(Employee employee ){
        return  empRepo.save(employee);
    }

    public void deleteEmployee(Long id){
         empRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id){
        return empRepo.findEmployeeById(id).orElseThrow(() ->new UserNotFoundException("User by id " +id+ " not found"));
    }

}
