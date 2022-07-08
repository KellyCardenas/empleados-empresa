package com.empresa.empleados.domain.service;

import com.empresa.empleados.domain.Employee;
import com.empresa.empleados.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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

    public Employee save(Employee employee)  {
            return employeeRepository.save(employee);
    }

    public boolean delete (String employeeId){
        return getEmployee(employeeId).map(employee -> {
            employeeRepository.delete(employeeId);
            return true;
        }).orElse(false);
    }

    //indica si es mayor de edad
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

    public String getTime(String employeeId, int option) {

        Employee employee = employeeRepository.getEmployee(employeeId).get();
        LocalDate date = LocalDate.now();

        LocalDate dateAux;

        if (option == 0) {
            dateAux = employee.getBirthDate();
        }else {
            dateAux = employee.getBindindDate();
        }

        int currentYear = date.getYear();
        int year = dateAux.getYear();

        int aux = currentYear - year;
        int month = 0;
        int days = 0;

        if (date.getMonthValue() < dateAux.getMonthValue() || date.getMonthValue() == dateAux.getMonthValue()) {

            aux--;
            month = date.getMonthValue() + (12 - dateAux.getMonthValue());
        }
        else {
            month = Math.abs((date.getMonthValue()) - (dateAux.getMonthValue()));
        }


        if (date.getDayOfMonth() < dateAux.getDayOfMonth()) {
            month--;
            if(date.getMonthValue()== 4 || date.getMonthValue() == 6 || date.getMonthValue() == 9 || date.getMonthValue() == 11) {
                days = 30 - dateAux.getDayOfMonth() + date.getDayOfMonth();
            }else if(date.getMonthValue()== 2) {
                days = 28 - dateAux.getDayOfMonth() + date.getDayOfMonth();
            }else {
                days = 31 - dateAux.getDayOfMonth() + date.getDayOfMonth();
            }
        }else {
            days = Math.abs(date.getDayOfMonth() - dateAux.getDayOfMonth());
        }


        if (option == 0) {
            return "Años: " + aux + " meses: " + month + " días: " + days;
        }else {
            return "Años: " + aux + " meses: " + month ;
        }


    }

}
