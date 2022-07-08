package com.empresa.empleados.web.controller;

import com.empresa.empleados.domain.Employee;
import com.empresa.empleados.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//va a ser controlador de una api rest
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee (@PathVariable("employeeId") String employeeId){
        return employeeService.getEmployee(employeeId)
                .map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<Employee>> getByPosition (@PathVariable("position") String position){
        return employeeService.getByPosition(position)
                .map(employees -> new ResponseEntity<>(employees, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){

        if (employeeService.ageValidation(employee.getBirthDate())>=18) {
            return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity delete(@PathVariable("employeeId") String employeeId){

        if(employeeService.delete(employeeId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/birthDay/{employeeId}")
    public ResponseEntity<String> getTimeBirthDay(@PathVariable("employeeId") String employeeId){
        return new ResponseEntity<>(employeeService.getTime(employeeId, 0), HttpStatus.OK);
    }

    @GetMapping("/bindindDate/{employeeId}")
    public ResponseEntity<String> getTimeCompany(@PathVariable("employeeId") String employeeId){
        return new ResponseEntity<>(employeeService.getTime(employeeId, 1), HttpStatus.OK);
    }

}
