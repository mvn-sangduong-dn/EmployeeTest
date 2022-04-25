package monstarrlab.demo.service.Impl;


import monstarrlab.demo.repository.IEmployeeRepository;
import monstarrlab.demo.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public void deleteEmployee(long id) {
        iEmployeeRepository.deleteById(id);
    }
}
