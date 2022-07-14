package com.springboot.restApi.PostgreSQL.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restApi.PostgreSQL.demo.model.Empleado;

public interface EmpleadoRepo extends JpaRepository<Empleado, Long>{

	void deleteEmpleadoByDocumento(Long documento);

	Empleado findEmpleadoByDocumento(Long documento);

}
