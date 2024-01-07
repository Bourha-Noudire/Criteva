package bf.isge.gsn.todo.dao;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bf.isge.gsn.todo.model.entities.Tutorial;

@Repository
@Transactional
public interface TutorialRepository extends CrudRepository<Tutorial, Integer> {
  List<Tutorial> findByTitleContainingIgnoreCase(String keyword);

  @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
  @Modifying
  public void updatePublishedStatus(Integer id, boolean published);
/*
  @Query("UPDATE Tutorial t SET t.score = :score WHERE t.id = :id")
  @Modifying
  void updateEvaluationScore(Integer id, Integer score);*/
}
