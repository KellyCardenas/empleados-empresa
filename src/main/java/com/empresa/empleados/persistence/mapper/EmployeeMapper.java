package com.empresa.empleados.persistence.mapper;

import com.empresa.empleados.domain.Employee;
import com.empresa.empleados.persistence.entity.Empleado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(source = "idEmpleado", target = "employeeId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "fechaVinculacion", target = "bindindDate"),
            @Mapping(source = "cargo", target = "position"),
            @Mapping(source = "salario", target = "salary")
    })
    Employee toEmployee(Empleado empleado);

    List<Employee> toEmployees(List<Empleado> empleados);

    @InheritInverseConfiguration
    Empleado toEmpleado (Employee employee);

}
