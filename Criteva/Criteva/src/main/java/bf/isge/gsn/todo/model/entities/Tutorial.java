package bf.isge.gsn.todo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(length = 128, nullable = false)
  private String title;

  @Column(length = 256)
  private String description;

  @Column
  private boolean published;

  public Tutorial() {}

  public Tutorial(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }

  public boolean isPublished() {
    return published;
  }
  public void setPublished(boolean published) {
    this.published = published;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", published=" + published + "]";
  }

}
