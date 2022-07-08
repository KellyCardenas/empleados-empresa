package com.empresa.empleados.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table
public class Empleado {

    @Id
    @NotEmpty (message = "El campo no puede ser vacio")
    private String idEmpleado;

    @NotEmpty (message = "El campo no puede ser vacio")
    private String nombre;

    @NotEmpty (message = "El campo no puede ser vacio")
    private String apellido;

    @NotEmpty (message = "El campo no puede ser vacio")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotEmpty (message = "El campo no puede ser vacio")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaVinculacion;

    @NotEmpty (message = "El campo no puede ser vacio")
    private String cargo;

    @NotEmpty (message = "El campo no puede ser vacio")
    private Double salario;


    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaVinculacion() {
        return fechaVinculacion;
    }

    public void setFechaVinculacion(LocalDate fechaVinculacion) {
        this.fechaVinculacion = fechaVinculacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
