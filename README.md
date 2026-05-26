# Accounting Application - Java Version

Java версия приложения для управления бухгалтерией компании с MongoDB.

## Структура проекта

```
├── pom.xml                              # Maven конфигурация
├── src/main/java/
│   ├── Main.java                        # Точка входа
│   ├── db/
│   │   └── MongoDBConnection.java       # Подключение к MongoDB
│   ├── models/
│   │   ├── Employee.java                # Модель сотрудника
│   │   ├── Salary.java                  # Модель зарплаты
│   │   ├── Department.java              # Модель отдела
│   │   ├── Document.java                # Модель документа
│   │   └── Report.java                  # Модель отчёта
│   ├── crud/
│   │   ├── EmployeeCRUD.java            # CRUD для сотрудников
│   │   ├── SalaryCRUD.java              # CRUD для зарплат
│   │   ├── DepartmentCRUD.java          # CRUD для отделов
│   │   ├── DocumentCRUD.java            # CRUD для документов
│   │   └── ReportCRUD.java              # CRUD для отчётов
│   ├── ui/
│   │   └── Menu.java                    # Интерактивное меню
│   └── utils/
│       ├── PrettyPrinter.java           # Форматирование вывода
│       └── DataInitializer.java         # Инициализация тестовых данных
└── README.md
```

## Требования

- Java 11+
- Maven 3.6+
- MongoDB 4.2+ (запущен на портах 30001-30003)

## Компиляция и запуск

### 1. Компиляция проекта
```bash
cd java_version
mvn clean package
```

### 2. Запуск приложения
```bash
mvn exec:java -Dexec.mainClass="Main"
```

Или запустить напрямую:
```bash
java -cp target/accounting-app-1.0.0.jar Main
```

## Функциональность

### Главное меню:
1. **Сотрудники** - добавить, показать, найти, удалить, сортировать
2. **Зарплаты** - добавить, показать, удалить, сортировать
3. **Отделы** - добавить, показать, удалить, сортировать
4. **Документы** - добавить, показать, удалить
5. **Отчёты** - добавить, показать, удалить

## Особенности реализации

- ✅ POJO классы с Lombok аннотациями
- ✅ MongoDB POJO Codec Registry для автоматической сериализации
- ✅ Поиск по регулярным выражениям (case-insensitive)
- ✅ Сортировка по выбранным полям
- ✅ ObjectId для связей между сущностями
- ✅ Красивый форматированный вывод
- ✅ Автоматическое заполнение тестовыми данными

## Зависимости

- **MongoDB Java Driver 4.11.1** - драйвер для работы с MongoDB
- **Lombok 1.18.30** - сокращение boilerplate кода

## Примеры использования

### Добавление сотрудника
```java
Map<String, String> passport = new HashMap<>();
passport.put("серия", "1234");
passport.put("номер", "567890");
ObjectId id = EmployeeCRUD.addEmployee("Иванов Иван", "Бухгалтер", passport);
```

### Поиск по имени
```java
List<Employee> results = EmployeeCRUD.findEmployeeByName("Иван");
PrettyPrinter.printEmployees(results);
```

### Сортировка
```java
List<Employee> sorted = EmployeeCRUD.sortEmployeesBy("name", false);
```

## Лицензия

MIT
