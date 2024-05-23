	package com.embel.EmployeeCRUD.service;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.embel.EmployeeCRUD.employeeEntity.EmployeeEntity;
	import com.embel.EmployeeCRUD.repository.EmployeeRepository;
	
	@Service
	public class EmployeeService {
		
		@Autowired
		private EmployeeRepository employeeRepository;
		
		public List<EmployeeEntity> getAllEmployees() {
			return employeeRepository.findAll();
		}
	
		public EmployeeEntity getEmployeeByID(Long id) {
			return employeeRepository.findById(id).orElseThrow();
		}
	
		public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
			return employeeRepository.save(employeeEntity);
		}
	
		public EmployeeEntity updateEmployee(long id, EmployeeEntity employeeEntity) {
			
			EmployeeEntity existingEmployeeEntity =getEmployeeByID(id);
			
			existingEmployeeEntity.setName(employeeEntity.getName());
			existingEmployeeEntity.setEmail(employeeEntity.getEmail());
			existingEmployeeEntity.setContact(employeeEntity.getContact());
			existingEmployeeEntity.setDesignation(employeeEntity.getDesignation());
			
			return employeeRepository.save(existingEmployeeEntity);
		}
	
		public void deleteEmployee(long id) {
			employeeRepository.deleteById(id);;
		}
	
	}
