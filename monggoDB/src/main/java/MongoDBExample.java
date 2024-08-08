import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Scanner;

public class MongoDBExample {

    public static void main(String[] args) {
        // Kết nối đến MongoDB
        String uri = "mongodb://localhost:27017"; // Địa chỉ kết nối tới MongoDB
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("yourDatabaseName");
            MongoCollection<Document> collection = database.getCollection("yourCollectionName");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Chọn hành động: ");
                System.out.println("1. Chèn tài liệu");
                System.out.println("2. Truy vấn tài liệu");
                System.out.println("3. Cập nhật tài liệu");
                System.out.println("4. Xóa tài liệu");
                System.out.println("5. Truy vấn toàn bộ bản ghi");
                System.out.println("0. Thoát");
                System.out.print("Nhập số lựa chọn (0-5): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Xóa newline còn lại

                switch (choice) {
                    case 1:
                        // Chèn tài liệu
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Xóa newline còn lại
                        System.out.print("Nhập thành phố: ");
                        String city = scanner.nextLine();

                        Document insertDoc = new Document("name", name)
                                .append("age", age)
                                .append("city", city);
                        collection.insertOne(insertDoc);
                        System.out.println("Document inserted successfully");
                        break;

                    case 2:
                        // Truy vấn tài liệu
                        System.out.print("Nhập tên để truy vấn: ");
                        String queryName = scanner.nextLine();
                        Document queryDoc = new Document("name", queryName);
                        Document resultDoc = collection.find(queryDoc).first();
                        if (resultDoc != null) {
                            System.out.println("Document found: " + resultDoc.toJson());
                        } else {
                            System.out.println("No document found");
                        }
                        break;

                    case 3:
                        // Cập nhật tài liệu
                        System.out.print("Nhập tên của tài liệu cần cập nhật: ");
                        String updateName = scanner.nextLine();
                        System.out.print("Nhập tuổi mới: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine(); // Xóa newline còn lại

                        Document updateQueryDoc = new Document("name", updateName);
                        Document updateFieldsDoc = new Document("age", newAge);
                        Document updateOperationDoc = new Document("$set", updateFieldsDoc);
                        collection.updateOne(updateQueryDoc, updateOperationDoc);
                        System.out.println("Document updated successfully");
                        break;

                    case 4:
                        // Xóa tài liệu
                        System.out.print("Nhập tên của tài liệu cần xóa: ");
                        String deleteName = scanner.nextLine();
                        Document deleteQueryDoc = new Document("name", deleteName);
                        collection.deleteOne(deleteQueryDoc);
                        System.out.println("Document deleted successfully");
                        break;

                    case 5:
                        // Truy vấn toàn bộ bản ghi
                        System.out.println("Danh sách toàn bộ bản ghi:");
                        try {
                            for (Document doc : collection.find()) {
                                System.out.println(doc.toJson());
                            }
                        } catch (Exception e) {
                            System.err.println("Error while fetching documents: " + e.getMessage());
                        }
                        break;

                    case 0:
                        // Thoát
                        System.out.println("Thoát khỏi chương trình.");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn từ 0 đến 5.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e.getMessage());
        }
    }
}
