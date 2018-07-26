package com.db.example.db.one.to.n.controllers;

import com.db.example.db.one.to.n.entities.Company;
import com.db.example.db.one.to.n.repositories.CompanyRepository;
import com.db.example.db.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyRepository repository;

    @Autowired
    public CompanyController(CompanyRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        System.out.println(company);
        System.out.println(company.getEmployeeList());
        company.getEmployeeList().stream()
                .forEach(employee -> employee.setCompany(company));
        return repository.save(company);
    }

//    @Transactional
//    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Company> findAll(){
//        return repository.findAll();
//    }

//    @Transactional
//    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public  findById(){
//        return repository.findById(@PathVariable Long id);
//    }

//    @Transactional
//    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Company> changeCompany(@PathVariable int OrderId){
//        System.out.println();
//        return repository.findAll();
//    }
}
