package monstarrlab.demo.repository;

import monstarrlab.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {


}
