package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    private ObjectId id;
    private String type;
    private String period;
    private ObjectId authorId;

    public Report(String type, String period, ObjectId authorId) {
        this.type = type;
        this.period = period;
        this.authorId = authorId;
    }
}
