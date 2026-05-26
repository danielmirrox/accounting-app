package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private ObjectId id;
    private String name;
    private String head;

    public Department(String name, String head) {
        this.name = name;
        this.head = head;
    }
}
