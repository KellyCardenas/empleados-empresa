package com.empresa.empleados.persistence;

import com.empresa.empleados.persistence.crud.EmpleadoCrudRepository;
import com.empresa.empleados.persistence.entity.Empleado;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//le indicamos que esta clase se encarga de interactuar con la base de datos
@Repository
public class EmpleadoRepository {

    private EmpleadoCrudRepository empleadoCrudRepository;

    public List<Empleado> getAll(){
        return (List<Empleado>) empleadoCrudRepository.findAll();
    }

    public List<Empleado> getByCargo(String cargo){
        return empleadoCrudRepository.findByCargo(cargo);
    }

    public Optional<Empleado> getEmpleado(String idEmpleado){
        return empleadoCrudRepository.findById(idEmpleado);
    }

    public Empleado save (Empleado empleado){
        return empleadoCrudRepository.save(empleado);
    }

    public void delete(String idEmpleado){
        empleadoCrudRepository.deleteById(idEmpleado);
    }
}
