package monstarrlab.demo.repository;

import monstarrlab.demo.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Long> {
}
