package monstarrlab.demo.repository;

import monstarrlab.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee WHERE `name` LIKE :name AND position_id LIKE :position_id", nativeQuery = true)
    List<Employee> getEmployee(@Param("name") String name, @Param("position_id") String positionId);

}
