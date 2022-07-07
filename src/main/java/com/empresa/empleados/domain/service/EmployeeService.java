package com.empresa.empleados.domain.service;

import com.empresa.empleados.domain.Employee;
import com.empresa.empleados.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.getAll();
    }

    public Optional<Employee> getEmployee(String employeeId){
        return employeeRepository.getEmployee(employeeId);
    }

    public Optional<List<Employee>> getByPosition( String position){
        return employeeRepository.getByPosition(position);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public boolean delete (String employeeId){
        return getEmployee(employeeId).map(employee -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }

    indica si es mayor de edad
    public int ageValidation(LocalDate birthDate) {

        LocalDate dateNow = LocalDate.now();

        int currentYear = dateNow.getYear();
        int birthYear = birthDate.getYear();

        int aux = currentYear - birthYear;

        if (dateNow.getMonthValue() < birthDate.getMonthValue()) {
            aux--;
        }
        return aux;
    }
}
