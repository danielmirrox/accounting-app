package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    private ObjectId id;
    private ObjectId employeeId;
    private String month;
    private Double amount;

    public Salary(ObjectId employeeId, String month, Double amount) {
        this.employeeId = employeeId;
        this.month = month;
        this.amount = amount;
    }
}
