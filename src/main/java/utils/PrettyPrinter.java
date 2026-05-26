package utils;

import models.*;

import java.util.List;

public class PrettyPrinter {

    public static String formatEmployee(Employee emp) {
        String series = emp.getPassport() != null ? emp.getPassport().getOrDefault("серия", "-") : "-";
        String number = emp.getPassport() != null ? emp.getPassport().getOrDefault("номер", "-") : "-";

        return String.format("""
                ID: %s
                ФИО: %s
                Должность: %s
                Паспорт: %s %s
                %s""", 
                emp.getId(), emp.getName(), emp.getPosition(), series, number, "-".repeat(30));
    }

    public static String formatSalary(Salary salary) {
        return String.format("""
                ID: %s
                Сотрудник ID: %s
                Месяц: %s
                Сумма: %.2f
                %s""", 
                salary.getId(), salary.getEmployeeId(), salary.getMonth(), 
                salary.getAmount(), "-".repeat(30));
    }

    public static String formatDepartment(Department dept) {
        return String.format("""
                ID: %s
                Название: %s
                Начальник: %s
                %s""", 
                dept.getId(), dept.getName(), dept.getHead(), "-".repeat(30));
    }

    public static String formatDocument(Document doc) {
        return String.format("""
                ID: %s
                Тип: %s
                Дата: %s
                Ответственный ID: %s
                %s""", 
                doc.getId(), doc.getType(), doc.getDate(), 
                doc.getResponsibleId(), "-".repeat(30));
    }

    public static String formatReport(Report report) {
        return String.format("""
                ID: %s
                Тип: %s
                Период: %s
                Автор ID: %s
                %s""", 
                report.getId(), report.getType(), report.getPeriod(), 
                report.getAuthorId(), "-".repeat(30));
    }

    public static void printEmployees(List<Employee> employees) {
        employees.forEach(emp -> System.out.println(formatEmployee(emp)));
    }

    public static void printSalaries(List<Salary> salaries) {
        salaries.forEach(sal -> System.out.println(formatSalary(sal)));
    }

    public static void printDepartments(List<Department> departments) {
        departments.forEach(dept -> System.out.println(formatDepartment(dept)));
    }

    public static void printDocuments(List<Document> documents) {
        documents.forEach(doc -> System.out.println(formatDocument(doc)));
    }

    public static void printReports(List<Report> reports) {
        reports.forEach(rep -> System.out.println(formatReport(rep)));
    }
}
