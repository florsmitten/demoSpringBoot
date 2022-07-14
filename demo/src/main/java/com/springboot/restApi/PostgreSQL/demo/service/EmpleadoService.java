package com.springboot.restApi.PostgreSQL.demo.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restApi.PostgreSQL.demo.repo.EmpleadoRepo;
import com.springboot.restApi.PostgreSQL.demo.model.Empleado;

@Service
@Transactional
public class EmpleadoService {

	private final EmpleadoRepo empleadoRepo;
	
	@Autowired
	public EmpleadoService(EmpleadoRepo empleadoRepo) {
		
		this.empleadoRepo = empleadoRepo;	
	}
	
	public Empleado addEmpleado(Empleado empleado) {
		
		empleado.setCodigo(UUID.randomUUID().toString());
		return empleadoRepo.save(empleado);
	}
	
	public List<Empleado> findAllEmpleados(){
		
		return empleadoRepo.findAll();
	}
	
	public Empleado updateEmpleado(Empleado empleado){
		
		return empleadoRepo.save(empleado);
	}
	
	public Empleado findEmpleadosByDocumento(Long documento){
		
		return empleadoRepo.findEmpleadoByDocumento(documento);
	}
	
	public void deleteEmpleado(Long documento){
		
		empleadoRepo.deleteEmpleadoByDocumento(documento);
	}
}
