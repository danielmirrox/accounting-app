package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import db.MongoDBConnection;
import models.Department;
import org.bson.types.ObjectId;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DepartmentCRUD {
    private static MongoCollection<Department> getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoDBConnection.getDatabase().getCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoDBConnection.getDatabase()
                .getCollection("departments", Department.class)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public static void addDepartment(String name, String head) {
        Department department = new Department(name, head);
        getCollection().insertOne(department);
    }

    public static List<Department> listDepartments() {
        return getCollection().find().into(new ArrayList<>());
    }

    public static void deleteDepartment(String deptId) {
        getCollection().deleteOne(Filters.eq("_id", new ObjectId(deptId)));
    }

    public static List<Department> sortDepartmentsBy(String field, boolean reverse) {
        int sortDirection = reverse ? -1 : 1;
        return getCollection()
                .find()
                .sort(Sorts.ascending(field))
                .into(new ArrayList<>());
    }
}
