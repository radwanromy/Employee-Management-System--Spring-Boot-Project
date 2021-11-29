package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setJobId(employeeDetails.getJobId());
		employee.setESalary(employeeDetails.getESalary());
		employee.setHireDate(employeeDetails.getHireDate());
		employee.setDeptId(employeeDetails.getDeptId());
		employee.setPhnNum(employeeDetails.getPhnNum());
		employee.setAddInfo(employeeDetails.getAddInfo());
		employee.setPostCode(employeeDetails.getPostCode());
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}


/* // 20211129164034
// http://localhost:9000/api/v1/employees

[
  {
    "id": 1,
    "firstName": "Radwan",
    "lastName": "Romy",
    "emailId": "radwanromy@gmail.com",
    "jobId": "SE",
    "hireDate": "1998-06-09T18:00:00.000+00:00",
    "deptId": "CSE",
    "phnNum": "+8801717799111",
    "addInfo": "Dhaka,Bangladesh",
    "postCode": 1216,
    "esalary": 10000
  },
  {
    "id": 2,
    "firstName": "Leo",
    "lastName": "Messi",
    "emailId": "leomessi@fcb.com",
    "jobId": "PLAYER",
    "hireDate": "0999-12-31T18:00:00.000+00:00",
    "deptId": "FCB",
    "phnNum": "+800-916-6008",
    "addInfo": "Paris, France",
    "postCode": 9877,
    "esalary": 700000000
  },
  {
    "id": 3,
    "firstName": "Ansu",
    "lastName": "Fati",
    "emailId": "Ansufati@fcb.com ",
    "jobId": "PLAYER",
    "hireDate": "0999-12-31T18:00:00.000+00:00",
    "deptId": "FCB",
    "phnNum": "+800-916-54964",
    "addInfo": "Barcelona, Spain",
    "postCode": 8546,
    "esalary": 100000000
  }
] */