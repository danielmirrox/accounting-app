package utils;

import crud.*;
import org.bson.types.ObjectId;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class DataInitializer {

    public static void initializeData() {
        System.out.println("⚙️  Начинается автозаполнение...");

        // Добавляем сотрудников
        List<ObjectId> empIds = new ArrayList<>();
        
        Map<String, String> passport1 = new HashMap<>();
        passport1.put("серия", "1234");
        passport1.put("номер", "567890");
        empIds.add(EmployeeCRUD.addEmployee("Иванов Иван", "Бухгалтер", passport1));

        Map<String, String> passport2 = new HashMap<>();
        passport2.put("серия", "5678");
        passport2.put("номер", "123456");
        empIds.add(EmployeeCRUD.addEmployee("Петрова Анна", "Кассир", passport2));

        Map<String, String> passport3 = new HashMap<>();
        passport3.put("серия", "9999");
        passport3.put("номер", "111111");
        empIds.add(EmployeeCRUD.addEmployee("Сидоров Юрий", "Программист", passport3));

        System.out.println("✅ Сотрудники добавлены");

        // Зарплаты
        SalaryCRUD.addSalary(empIds.get(0), "2025-04", 50000.0);
        SalaryCRUD.addSalary(empIds.get(0), "2025-05", 52000.0);
        SalaryCRUD.addSalary(empIds.get(1), "2025-05", 43000.0);
        SalaryCRUD.addSalary(empIds.get(2), "2025-05", 80000.0);

        System.out.println("✅ Зарплаты добавлены");

        // Отделы
        DepartmentCRUD.addDepartment("Бухгалтерия", "Иванов Иван");
        DepartmentCRUD.addDepartment("IT", "Сидоров Юрий");
        DepartmentCRUD.addDepartment("Касса", "Петрова Анна");

        System.out.println("✅ Отделы добавлены");

        // Документы
        DocumentCRUD.addDocument("Накладная", "2025-05-01", empIds.get(0));
        DocumentCRUD.addDocument("Акт", "2025-05-02", empIds.get(1));
        DocumentCRUD.addDocument("Счёт", "2025-05-03", empIds.get(2));

        System.out.println("✅ Документы добавлены");

        // Отчёты
        ReportCRUD.addReport("Финансовый", "Апрель 2025", empIds.get(0));
        ReportCRUD.addReport("Расчётный", "Май 2025", empIds.get(1));
        ReportCRUD.addReport("Технический", "Май 2025", empIds.get(2));

        System.out.println("✅ Отчёты добавлены");
        System.out.println("✅ Данные инициализированы!");
    }
}
