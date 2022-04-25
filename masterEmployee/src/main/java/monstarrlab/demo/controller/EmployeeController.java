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



@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody @Validated EmployeeDTO employeeDTO,
                                            BindingResult bindingResult){
        if(employeeService.checkAndSaveEmployee(employeeDTO,bindingResult) == null){
        return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(employeeService.checkAndSaveEmployee(employeeDTO,bindingResult),HttpStatus.BAD_REQUEST);
    }

}
