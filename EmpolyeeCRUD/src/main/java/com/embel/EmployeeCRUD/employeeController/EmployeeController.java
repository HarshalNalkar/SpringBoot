package com.embel.EmployeeCRUD.employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embel.EmployeeCRUD.employeeEntity.EmployeeEntity;
import com.embel.EmployeeCRUD.service.EmployeeService;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<EmployeeEntity> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public EmployeeEntity getEmployeeByID(@PathVariable Long id) {
		return employeeService.getEmployeeByID(id);
	}
	
	@PostMapping("/add")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.createEmployee(employeeEntity);
	}
	
	@PutMapping("/{id}")
	public EmployeeEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeEntity employeeEntity) {
		return employeeService.updateEmployee(id, employeeEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
}
