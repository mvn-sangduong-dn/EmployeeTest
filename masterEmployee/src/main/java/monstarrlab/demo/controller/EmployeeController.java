package monstarrlab.demo.controller;


import monstarrlab.demo.model.Employee;
import monstarrlab.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
