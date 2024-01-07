package bf.isge.gsn.todo.model.dto;

import lombok.Data;

@Data
public class CreateTodoDTO {
    private String title;
    private String description;
    private Integer authorId;
}
