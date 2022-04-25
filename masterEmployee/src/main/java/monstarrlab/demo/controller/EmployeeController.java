package monstarrlab.demo.controller;



import monstarrlab.demo.dto.EmployeeDTO;
import monstarrlab.demo.model.Employee;
import monstarrlab.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;



    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody @Validated EmployeeDTO employeeDTO,
                                            BindingResult bindingResult){
        Map<String,String> erross = employeeService.checkAndSaveEmployee(employeeDTO,bindingResult);
        if(erross == null){
        return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(erross,HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/list")
    public ResponseEntity<?> getListEmployee(@RequestParam(defaultValue = "") String name,
                                             @RequestParam(defaultValue = "") String positionId){
        List<Employee> employeeList = employeeService.getEmployee(name,positionId);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
