package bf.isge.gsn.todo.dao;

import bf.isge.gsn.todo.model.entities.Evaluation;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
  /*List<Evaluation> findByIdContainingIgnoreCase(String keyword);*/
}
