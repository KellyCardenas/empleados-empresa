package com.empresa.empleados.persistence;

import com.empresa.empleados.domain.Employee;
import com.empresa.empleados.domain.repository.EmployeeRepository;
import com.empresa.empleados.persistence.crud.EmpleadoCrudRepository;
import com.empresa.empleados.persistence.entity.Empleado;
import com.empresa.empleados.persistence.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//le indicamos que esta clase se encarga de interactuar con la base de datos
@Repository
public class EmpleadoRepository implements EmployeeRepository {

    //Los objetos que tengan esta anotación, le cedemos el control a spring para
    //que cree las instancias
    @Autowired
    private EmpleadoCrudRepository empleadoCrudRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll(){
        List<Empleado> empleados = (List<Empleado>) empleadoCrudRepository.findAll();
        return employeeMapper.toEmployees(empleados);
    }

    @Override
    public Optional<List<Employee>> getByPosition(String position) {
        List<Empleado> empleados = empleadoCrudRepository.findByCargo(position);
        return Optional.of(employeeMapper.toEmployees(empleados));
    }

    @Override
    public Optional<Employee> getEmployee(String employeeId) {

        return empleadoCrudRepository.findById(employeeId).map(empleado -> employeeMapper.toEmployee(empleado));
    }

    @Override
    public Employee save(Employee employee) {

        Empleado empleado = employeeMapper.toEmpleado(employee);
        return employeeMapper.toEmployee(empleadoCrudRepository.save(empleado));
    }


    @Override
    public void delete(String employeeId){

        empleadoCrudRepository.deleteById(employeeId);
    }
}
