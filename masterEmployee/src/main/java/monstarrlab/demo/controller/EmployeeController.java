package monstarrlab.demo.controller;


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
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
