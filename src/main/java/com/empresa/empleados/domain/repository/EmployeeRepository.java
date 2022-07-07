package com.empresa.empleados.domain.repository;

import com.empresa.empleados.domain.Employee;

import java.util.List;
import java.util.Optional;

//le indicamos el nombre de los metodos que queremos que cualquier repositorio
//que vaya a trabajar con empleados de iimplementar
public interface EmployeeRepository {

    List<Employee> getAll();

    Optional<List<Employee>> getByPosition(String position);

    Optional<Employee> getEmployee(String employeeId);

    Employee save (Employee employee);

    void delete (String employeeId);
}
