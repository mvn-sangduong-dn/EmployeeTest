package monstarrlab.demo.controller;


import monstarrlab.demo.model.Employee;
import monstarrlab.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @GetMapping("/list")
    public ResponseEntity<?> getListEmployee(@RequestParam(defaultValue = "") String name,
                                             @RequestParam(defaultValue = "") String positionId){
        List<Employee> employeeList = employeeService.getEmployee(name,positionId);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
