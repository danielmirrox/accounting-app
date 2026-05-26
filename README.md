# 📊 Accounting Application - Java Version

![Java](https://img.shields.io/badge/Java-11%2B-ED8B00?style=flat-square)
![MongoDB](https://img.shields.io/badge/MongoDB-4.2%2B-13AA52?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.6%2B-C71A36?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)

Полнофункциональное Java приложение для управления бухгалтерией компании с использованием MongoDB.

> 💡 **Оригинальная версия на Python была переписана на Java с сохранением всей структуры и функциональности.**

## 🚀 Быстрый старт

```bash
# Клонирование
git clone https://github.com/<username>/accounting-app-java.git
cd accounting-app-java

# Компиляция
mvn clean package

# Запуск
mvn exec:java -Dexec.mainClass="Main"
```

## 📋 Структура проекта

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

## ⚙️ Требования

- **Java** 11+
- **Maven** 3.6+
- **MongoDB** 4.2+ (запущен на портах 30001-30003 с репликацией)

## 📦 Компиляция и запуск

### Вариант 1: С использованием Maven
```bash
# Компиляция
mvn clean package

# Запуск
mvn exec:java -Dexec.mainClass="Main"
```

### Вариант 2: Прямой запуск JAR
```bash
java -cp target/accounting-app-1.0.0.jar Main
### Вариант 2: Прямой запуск JAR
```bash
java -cp target/accounting-app-1.0.0.jar Main
```

## 🎯 Функциональность

### Главное меню:
- **👥 Сотрудники** — добавить, показать, найти, удалить, сортировать
- **💰 Зарплаты** — добавить, показать, удалить, сортировать
- **🏢 Отделы** — добавить, показать, удалить, сортировать
- **📄 Документы** — добавить, показать, удалить
- **📊 Отчёты** — добавить, показать, удалить

## ✨ Особенности реализации

- ✅ POJO классы с Lombok аннотациями
- ✅ MongoDB POJO Codec Registry для автоматической сериализации
- ✅ Поиск по регулярным выражениям (case-insensitive)
- ✅ Сортировка по выбранным полям
- ✅ ObjectId для связей между сущностями
- ✅📚 Функциональность

### Архитектура

| Слой | Файлы | Описание |
|------|-------|---------|
| **Данные** | `db/` | Подключение к MongoDB с поддержкой Replica Set |
| *💡 *Модели** | `models/` | POJO классы для всех сущностей |
| **CRUD** | `crud/` | Операции Create, Read, Delete, Sort |
| **UI** | `ui/` | Интерактивное меню |
| **Утилиты** | `utils/` | Форматирование и инициализация данных |

## 🔧  Красивый форматированный вывод
- ✅ Автоматическое заполнение тестовыми данными
- ✅ Обработка исключений при работе с БД

## 📚 Функциональностьva Driver 4.11.1** - драйвер для работы с MongoDB
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

## 📖 MongoDB Replica Set

Проект использует MongoDB Replica Set на 3 инстансах:
- **mongo1**: `localhost:30001` (primary)
- **mongo2**: `localhost:30002` (secondary)
- **mongo3**: `localhost:30003` (secondary)

Для запуска используй:
```bash
docker-compose up -d
```

## 🤝 Вклад в проект

Приглашаем к участию! Пожалуйста:
1. Fork репозиторий
2. Создай ветку для новой функции (`git checkout -b feature/AmazingFeature`)
3. Commit изменения (`git commit -m 'Add some AmazingFeature'`)
4. Push в ветку (`git push origin feature/AmazingFeature`)
5. Открой Pull Request

## 📝 Лицензия

MIT — свободен для использования в личных и коммерческих проектах.

## 👤 Автор

Создано во время практики по СУБД MongoDB.

## 📞 Контакты

Вопросы? Открой Issue или свяжись со мной.

---

**Статус**: ✅ Готов к использованию | **Версия**: 1.0.0 | **Java**: 11+
