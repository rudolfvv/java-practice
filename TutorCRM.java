import java.util.ArrayList;
import java.util.Scanner;

public class TutorCRM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> database = new ArrayList<>();

        System.out.println("=== ДОБРО ПОЖАЛОВАТЬ В TUTOR CRM ===");

        while (true) {
            System.out.println("\n[1] Добавить ученика | [2] Пополнить баланс занятий | [3] Провести урок + поставить оценку | [4] Показать всех | [5] Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (choice == 5) {
                System.out.println("Завершение работы системы. Хорошего дня!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите имя нового ученика: ");
                    String name = scanner.nextLine();
                    database.add(new Student(name));
                    System.out.println("Ученик " + name + " успешно добавлен в CRM.");
                    break;

                case 2:
                    if (database.isEmpty()) {
                        System.out.println("База данных пуста!");
                        break;
                    }
                    System.out.print("Введите имя ученика для оплаты: ");
                    String searchName = scanner.nextLine();
                    Student target = null;
                    for (Student s : database) {
                        if (s.getName().equalsIgnoreCase(searchName)) {
                            target = s;
                            break;
                        }
                    }
                    if (target != null) {
                        System.out.print("Сколько уроков оплачено?: ");
                        int lessons = scanner.nextInt();
                        target.buyLessons(lessons);
                        System.out.println("Баланс обновлен. Текущий баланс " + target.getName() + ": " + target.getLessonBalance() + " уроков.");
                    } else {
                        System.out.println("Ученик не найден.");
                    }
                    break;

                case 3:
                    if (database.isEmpty()) {
                        System.out.println("База данных пуста!");
                        break;
                    }
                    System.out.print("Кто пришел на урок?: ");
                    String lessonUser = scanner.nextLine();
                    Student currentStudent = null;
                    for (Student s : database) {
                        if (s.getName().equalsIgnoreCase(lessonUser)) {
                            currentStudent = s;
                            break;
                        }
                    }
                    if (currentStudent != null) {
                        if (currentStudent.getLessonBalance() <= 0) {
                            System.out.println("Ошибка! У ученика " + currentStudent.getName() + " закончились оплаченные уроки!");
                        } else {
                            currentStudent.conductLesson();
                            System.out.print("Урок проведен. Какую оценку ставим за сегодня?: ");
                            int grade = scanner.nextInt();
                            currentStudent.addGrade(grade);
                            System.out.println("Данные сохранены. Остаток уроков: " + currentStudent.getLessonBalance());
                        }
                    } else {
                        System.out.println("Ученик не найден.");
                    }
                    break;

                case 4:
                    if (database.isEmpty()) {
                        System.out.println("В CRM пока нет ни одного ученика.");
                        break;
                    }
                    System.out.println("\n--- СПИСОК ВСЕХ УЧЕНИКОВ ---");
                    for (Student s : database) {
                        System.out.println("Имя: " + s.getName() + " | Оплачено уроков: " + s.getLessonBalance() + " | Оценки: " + s.getGrades());
                    }
                    break;

                default:
                    System.out.println("Неверный пункт меню.");
            }
        }
        scanner.close();
    }
}
