package bf.isge.gsn.todo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="users")
public class User {
    @Id
    @GeneratedValue
    int id;
    String name;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    List<Todo> todoList;
}
