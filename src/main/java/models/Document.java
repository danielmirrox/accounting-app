package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    private ObjectId id;
    private String type;
    private String date;
    private ObjectId responsibleId;

    public Document(String type, String date, ObjectId responsibleId) {
        this.type = type;
        this.date = date;
        this.responsibleId = responsibleId;
    }
}
