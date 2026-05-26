package ui;

import crud.*;
import models.*;
import utils.PrettyPrinter;
import org.bson.types.ObjectId;

import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Сотрудники");
            System.out.println("2. Зарплаты");
            System.out.println("3. Отделы");
            System.out.println("4. Документы");
            System.out.println("5. Отчёты");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> employeeMenu();
                case "2" -> salaryMenu();
                case "3" -> departmentMenu();
                case "4" -> documentMenu();
                case "5" -> reportMenu();
                case "0" -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }

    private void employeeMenu() {
        while (true) {
            System.out.println("\n-- Сотрудники --");
            System.out.println("1. Добавить");
            System.out.println("2. Показать всех");
            System.out.println("3. Найти по имени");
            System.out.println("4. Удалить");
            System.out.println("5. Сортировать");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("ФИО: ");
                    String name = scanner.nextLine();
                    System.out.print("Должность: ");
                    String position = scanner.nextLine();
                    System.out.print("Серия паспорта: ");
                    String series = scanner.nextLine();
                    System.out.print("Номер паспорта: ");
                    String number = scanner.nextLine();

                    Map<String, String> passport = new HashMap<>();
                    passport.put("серия", series);
                    passport.put("номер", number);

                    EmployeeCRUD.addEmployee(name, position, passport);
                    System.out.println("✅ Сотрудник добавлен");
                }
                case "2" -> PrettyPrinter.printEmployees(EmployeeCRUD.listEmployees());
                case "3" -> {
                    System.out.print("Поиск по имени: ");
                    String name = scanner.nextLine();
                    PrettyPrinter.printEmployees(EmployeeCRUD.findEmployeeByName(name));
                }
                case "4" -> {
                    System.out.print("ID сотрудника: ");
                    String id = scanner.nextLine();
                    EmployeeCRUD.deleteEmployee(id);
                    System.out.println("✅ Сотрудник удалён");
                }
                case "5" -> {
                    System.out.println("Сортировать по:\n1. Имени\n2. Должности");
                    System.out.print("Выбор: ");
                    String ch = scanner.nextLine();
                    if (ch.equals("1")) {
                        PrettyPrinter.printEmployees(EmployeeCRUD.sortEmployeesBy("name", false));
                    } else if (ch.equals("2")) {
                        PrettyPrinter.printEmployees(EmployeeCRUD.sortEmployeesBy("position", false));
                    }
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }

    private void salaryMenu() {
        while (true) {
            System.out.println("\n-- Зарплаты --");
            System.out.println("1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Удалить");
            System.out.println("4. Сортировать");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("ID сотрудника: ");
                    String empId = scanner.nextLine();
                    System.out.print("Месяц: ");
                    String month = scanner.nextLine();
                    System.out.print("Сумма: ");
                    Double amount = Double.parseDouble(scanner.nextLine());
                    SalaryCRUD.addSalary(new ObjectId(empId), month, amount);
                    System.out.println("✅ Зарплата добавлена");
                }
                case "2" -> PrettyPrinter.printSalaries(SalaryCRUD.listSalaries());
                case "3" -> {
                    System.out.print("ID зарплаты: ");
                    String id = scanner.nextLine();
                    SalaryCRUD.deleteSalary(id);
                    System.out.println("✅ Зарплата удалена");
                }
                case "4" -> {
                    System.out.println("Сортировать по:\n1. Сумме\n2. Месяцу");
                    System.out.print("Выбор: ");
                    String ch = scanner.nextLine();
                    if (ch.equals("1")) {
                        PrettyPrinter.printSalaries(SalaryCRUD.sortSalariesBy("amount", false));
                    } else if (ch.equals("2")) {
                        PrettyPrinter.printSalaries(SalaryCRUD.sortSalariesBy("month", false));
                    }
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }

    private void departmentMenu() {
        while (true) {
            System.out.println("\n-- Отделы --");
            System.out.println("1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Удалить");
            System.out.println("4. Сортировать");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Название отдела: ");
                    String name = scanner.nextLine();
                    System.out.print("Начальник: ");
                    String head = scanner.nextLine();
                    DepartmentCRUD.addDepartment(name, head);
                    System.out.println("✅ Отдел добавлен");
                }
                case "2" -> PrettyPrinter.printDepartments(DepartmentCRUD.listDepartments());
                case "3" -> {
                    System.out.print("ID отдела: ");
                    String id = scanner.nextLine();
                    DepartmentCRUD.deleteDepartment(id);
                    System.out.println("✅ Отдел удален");
                }
                case "4" -> {
                    System.out.println("Сортировать по:\n1. Названию\n2. Начальнику");
                    System.out.print("Выбор: ");
                    String ch = scanner.nextLine();
                    if (ch.equals("1")) {
                        PrettyPrinter.printDepartments(DepartmentCRUD.sortDepartmentsBy("name", false));
                    } else if (ch.equals("2")) {
                        PrettyPrinter.printDepartments(DepartmentCRUD.sortDepartmentsBy("head", false));
                    }
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }

    private void documentMenu() {
        while (true) {
            System.out.println("\n-- Документы --");
            System.out.println("1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Удалить");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Тип документа: ");
                    String type = scanner.nextLine();
                    System.out.print("Дата: ");
                    String date = scanner.nextLine();
                    System.out.print("ID ответственного: ");
                    String respId = scanner.nextLine();
                    DocumentCRUD.addDocument(type, date, new ObjectId(respId));
                    System.out.println("✅ Документ добавлен");
                }
                case "2" -> PrettyPrinter.printDocuments(DocumentCRUD.listDocuments());
                case "3" -> {
                    System.out.print("ID документа: ");
                    String id = scanner.nextLine();
                    DocumentCRUD.deleteDocument(id);
                    System.out.println("✅ Документ удален");
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }

    private void reportMenu() {
        while (true) {
            System.out.println("\n-- Отчёты --");
            System.out.println("1. Добавить");
            System.out.println("2. Показать все");
            System.out.println("3. Удалить");
            System.out.println("0. Назад");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Тип отчёта: ");
                    String type = scanner.nextLine();
                    System.out.print("Период: ");
                    String period = scanner.nextLine();
                    System.out.print("ID автора: ");
                    String authorId = scanner.nextLine();
                    ReportCRUD.addReport(type, period, new ObjectId(authorId));
                    System.out.println("✅ Отчёт добавлен");
                }
                case "2" -> PrettyPrinter.printReports(ReportCRUD.listReports());
                case "3" -> {
                    System.out.print("ID отчёта: ");
                    String id = scanner.nextLine();
                    ReportCRUD.deleteReport(id);
                    System.out.println("✅ Отчёт удален");
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Неправильный выбор");
            }
        }
    }
}
