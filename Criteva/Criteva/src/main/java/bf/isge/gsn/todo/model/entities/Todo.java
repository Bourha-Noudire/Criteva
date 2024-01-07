package bf.isge.gsn.todo.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    int id;
    String title;
    String description;
    LocalDate createdAt;
    boolean archived;
    @ManyToOne
    User author;
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDate.now();
    }
}
