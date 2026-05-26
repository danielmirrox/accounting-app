import db.MongoDBConnection;
import ui.Menu;
import utils.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Подключение к БД
            MongoDBConnection.connect();
            System.out.println("✅ Подключение к MongoDB установлено");

            // Спрашиваем, нужна ли инициализация
            Scanner scanner = new Scanner(System.in);
            System.out.print("Инициализировать данные? (y/n): ");
            String response = scanner.nextLine();
            
            if (response.equalsIgnoreCase("y")) {
                DataInitializer.initializeData();
            }

            // Запуск меню
            Menu menu = new Menu();
            menu.mainMenu();

            // Отключение от БД
            MongoDBConnection.disconnect();
            System.out.println("✅ Соединение закрыто");

        } catch (Exception e) {
            System.err.println("❌ Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
