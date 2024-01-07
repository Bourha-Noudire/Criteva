package bf.isge.gsn.todo.model.dto;

import bf.isge.gsn.todo.model.entities.User;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TodoDTO {
    int id;
    String title;
    String description;
    LocalDate createdAt;
    Boolean archived;
    User author;
}
