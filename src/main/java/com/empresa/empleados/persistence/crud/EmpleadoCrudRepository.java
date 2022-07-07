package com.empresa.empleados.persistence.crud;

import com.empresa.empleados.persistence.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoCrudRepository extends CrudRepository <Empleado, String> {

    //@Query(value = "SELECT * FROM empleados WHERE cargo = ? ", nativeQuery = true)
    List<Empleado> findByCargo (String cargo);

}
