package monstarrlab.demo.service.Impl;


import monstarrlab.demo.model.Employee;
import monstarrlab.demo.repository.IEmployeeRepository;
import monstarrlab.demo.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }
        @Override
        public List<Employee> getEmployee(String name, String positionId) {
            return iEmployeeRepository.getEmployee("%"+name+"%","%"+positionId+"%");
    }
}
