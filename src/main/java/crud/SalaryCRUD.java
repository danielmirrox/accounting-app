package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import db.MongoDBConnection;
import models.Salary;
import org.bson.types.ObjectId;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class SalaryCRUD {
    private static MongoCollection<Salary> getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoDBConnection.getDatabase().getCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoDBConnection.getDatabase()
                .getCollection("salaries", Salary.class)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public static void addSalary(ObjectId employeeId, String month, Double amount) {
        Salary salary = new Salary(employeeId, month, amount);
        getCollection().insertOne(salary);
    }

    public static List<Salary> listSalaries() {
        return getCollection().find().into(new ArrayList<>());
    }

    public static void deleteSalary(String salaryId) {
        getCollection().deleteOne(Filters.eq("_id", new ObjectId(salaryId)));
    }

    public static List<Salary> sortSalariesBy(String field, boolean reverse) {
        int sortDirection = reverse ? -1 : 1;
        return getCollection()
                .find()
                .sort(Sorts.ascending(field))
                .into(new ArrayList<>());
    }
}
