package monstarrlab.demo.service;


import monstarrlab.demo.model.Employee;



import java.util.List;

public interface IEmployeeService {
    void saveEmployee(Employee employee);
    List<Employee> getEmployee(String name, String positionId);
    void deleteEmployee(long id);


}
