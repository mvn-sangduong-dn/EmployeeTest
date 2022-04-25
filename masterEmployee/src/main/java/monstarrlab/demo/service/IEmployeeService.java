package monstarrlab.demo.service;


import monstarrlab.demo.dto.EmployeeDTO;
import monstarrlab.demo.model.Employee;
import org.springframework.validation.BindingResult;

import java.util.Map;



import java.util.List;

public interface IEmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> getEmployee(String name, String positionId);
    void deleteEmployee(long id);
    Map<String,String> checkAndSaveEmployee(EmployeeDTO employeeDTO, BindingResult bindingResult);


}
