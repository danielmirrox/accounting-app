package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import db.MongoDBConnection;
import models.Report;
import org.bson.types.ObjectId;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ReportCRUD {
    private static MongoCollection<Report> getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoDBConnection.getDatabase().getCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoDBConnection.getDatabase()
                .getCollection("reports", Report.class)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public static void addReport(String type, String period, ObjectId authorId) {
        Report report = new Report(type, period, authorId);
        getCollection().insertOne(report);
    }

    public static List<Report> listReports() {
        return getCollection().find().into(new ArrayList<>());
    }

    public static void deleteReport(String reportId) {
        getCollection().deleteOne(Filters.eq("_id", new ObjectId(reportId)));
    }

    public static List<Report> sortReportsBy(String field, boolean reverse) {
        int sortDirection = reverse ? -1 : 1;
        return getCollection()
                .find()
                .sort(Sorts.ascending(field))
                .into(new ArrayList<>());
    }
}
