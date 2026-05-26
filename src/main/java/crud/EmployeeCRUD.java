package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import db.MongoDBConnection;
import models.Employee;
import org.bson.types.ObjectId;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class EmployeeCRUD {
    private static MongoCollection<Employee> getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoDBConnection.getDatabase().getCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoDBConnection.getDatabase()
                .getCollection("employees", Employee.class)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public static ObjectId addEmployee(String name, String position, java.util.Map<String, String> passport) {
        Employee employee = new Employee(name, position, passport);
        getCollection().insertOne(employee);
        return employee.getId();
    }

    public static List<Employee> listEmployees() {
        return getCollection().find().into(new ArrayList<>());
    }

    public static void deleteEmployee(String empId) {
        getCollection().deleteOne(Filters.eq("_id", new ObjectId(empId)));
    }

    public static List<Employee> findEmployeeByName(String name) {
        return getCollection()
                .find(Filters.regex("name", name, "i"))
                .into(new ArrayList<>());
    }

    public static List<Employee> sortEmployeesBy(String field, boolean reverse) {
        int sortDirection = reverse ? -1 : 1;
        return getCollection()
                .find()
                .sort(Sorts.ascending(field))
                .into(new ArrayList<>());
    }
}
