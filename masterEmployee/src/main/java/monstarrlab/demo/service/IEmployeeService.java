package monstarrlab.demo.service;


import monstarrlab.demo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployee(String name, String positionId);
}
