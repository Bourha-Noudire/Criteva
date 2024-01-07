package bf.isge.gsn.todo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "evaluation")
public class Evaluation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column
  private Integer id_critere;

  @Column
  private Integer note;

  @Column(length = 128, nullable = false)
  private String avis;

  public Evaluation() {

  }

  public Evaluation(String avis, int note) {
    this.avis = avis;
    this.note = note;
  }
  public void setIdCritere(Integer id_critere) {
    this.id_critere = id_critere;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", avis=" + avis + ", note=" + note + "]";
  }

}
