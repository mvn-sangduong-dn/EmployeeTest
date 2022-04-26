package monstarrlab.demo.service.Impl;



import monstarrlab.demo.dto.EmployeeDTO;
import monstarrlab.demo.model.Employee;
import monstarrlab.demo.repository.IEmployeeRepository;
import monstarrlab.demo.repository.IPositionRepository;
import monstarrlab.demo.service.IEmployeeService;

import monstarrlab.demo.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IPositionService iPositionService;



    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }


        @Override
        public List<Employee> getEmployee(String name, String positionId) {
            return iEmployeeRepository.getEmployee("%"+name+"%","%"+positionId+"%");
    }
        @Override
        public boolean deleteEmployee(long id) {
        if(iEmployeeRepository.existsById(id)){
            iEmployeeRepository.deleteById(id);
            return true;
        }
            return false;
        }
    @Override
    public Map<String, String> checkCreateAndSaveEmployee(EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Map<String,String> errors=  new LinkedHashMap<>();
        for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {
            errors.put(bindingResult.getFieldErrors().get(i).getField(),bindingResult.getFieldErrors().get(i).getDefaultMessage());
        }
        if(bindingResult.hasErrors()){
            return errors;
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        employee.setPosition(iPositionService.getPositionById(employeeDTO.getPosition()));
        iEmployeeRepository.save(employee);
        return null;
    }

    @Override
    public Map<String, String> checkUpdateAndSaveEmployee(EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Map<String,String> errors=  new LinkedHashMap<>();
        if(iEmployeeRepository.existsById(employeeDTO.getId())) {
            for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {
                errors.put(bindingResult.getFieldErrors().get(i).getField(), bindingResult.getFieldErrors().get(i).getDefaultMessage());
            }
            if (bindingResult.hasErrors()) {
                return errors;
            }
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDTO, employee);
            employee.setPosition(iPositionService.getPositionById(employeeDTO.getPosition()));
            iEmployeeRepository.save(employee);
            return null;
        }
        errors.put("messErros","Id không tồn tại");
        return errors;
    }

}
