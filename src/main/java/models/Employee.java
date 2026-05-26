package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private ObjectId id;
    private String name;
    private String position;
    private Map<String, String> passport;

    public Employee(String name, String position, Map<String, String> passport) {
        this.name = name;
        this.position = position;
        this.passport = passport;
    }
}
