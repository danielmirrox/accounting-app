package crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import db.MongoDBConnection;
import models.Document;
import org.bson.types.ObjectId;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class DocumentCRUD {
    private static MongoCollection<Document> getCollection() {
        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoDBConnection.getDatabase().getCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        return MongoDBConnection.getDatabase()
                .getCollection("documents", Document.class)
                .withCodecRegistry(pojoCodecRegistry);
    }

    public static void addDocument(String type, String date, ObjectId responsibleId) {
        Document document = new Document(type, date, responsibleId);
        getCollection().insertOne(document);
    }

    public static List<Document> listDocuments() {
        return getCollection().find().into(new ArrayList<>());
    }

    public static void deleteDocument(String docId) {
        getCollection().deleteOne(Filters.eq("_id", new ObjectId(docId)));
    }

    public static List<Document> sortDocumentsBy(String field, boolean reverse) {
        int sortDirection = reverse ? -1 : 1;
        return getCollection()
                .find()
                .sort(Sorts.ascending(field))
                .into(new ArrayList<>());
    }
}
