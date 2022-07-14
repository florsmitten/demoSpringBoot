package com.springboot.restApi.PostgreSQL.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restApi.PostgreSQL.demo.model.Empleado;
import com.springboot.restApi.PostgreSQL.demo.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoResource {

	private final EmpleadoService empleadoService;

	public EmpleadoResource(EmpleadoService empleadoService) {
		super();
		this.empleadoService = empleadoService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Empleado>> getAllEmpleados(){
		
		List<Empleado> empleados = empleadoService.findAllEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}

	@GetMapping("/find/{documento}")
	public ResponseEntity<Empleado> getAllEmpleadosPorDocumento(@PathVariable("documento") Long documento){
		
		Empleado empleado = empleadoService.findEmpleadosByDocumento(documento);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado){
		
		Empleado newEmpleado = empleadoService.addEmpleado(empleado);
		return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado){
		
		Empleado updateEmpleado = empleadoService.updateEmpleado(empleado);
		return new ResponseEntity<>(updateEmpleado, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{documento}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable("documento") Long documento){
		
		empleadoService.deleteEmpleado(documento);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
