package it.univr.employeemanager.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class EmployeeController {

    public EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public String createEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException{
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/get")
    public Employee getEmployee(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return employeeService.getEmployee(documentId);
    }

 /*   @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> employees = employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
*/
    @PutMapping("/put")
    public String updateEmployee(@RequestBody Employee employee) throws InterruptedException, ExecutionException{
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam String documentId) throws InterruptedException, ExecutionException{
        return employeeService.deleteEmployee(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndPoint(){
        return ResponseEntity.ok("Test Get EndPoint is Working");
    }

}
