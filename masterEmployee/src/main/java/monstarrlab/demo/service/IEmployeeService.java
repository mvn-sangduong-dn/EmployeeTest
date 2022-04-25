package monstarrlab.demo.service;


import monstarrlab.demo.dto.EmployeeDTO;
import monstarrlab.demo.model.Employee;
import org.springframework.validation.BindingResult;

import java.util.Map;

public interface IEmployeeService {
    void saveEmployee(Employee employee);
    Map<String,String> checkAndSaveEmployee(EmployeeDTO employeeDTO, BindingResult bindingResult);
}
