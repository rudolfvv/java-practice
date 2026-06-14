import java.util.Scanner;

public class InteractiveTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Введите имя ученика: ");
        String name = input.nextLine();
        
        System.out.print("Введите все оценки через пробел: ");
        String line = input.nextLine();
        
        // Разбиваем строку на массив отдельных чисел
        String[] gradesAsText = line.split(" ");
        
        double sum = 0;
        int count = 0;
        
        for (String text : gradesAsText) {
            if (!text.isEmpty()) {
                sum += Integer.parseInt(text);
                count++;
            }
        }
        
        double average = (count > 0) ? (sum / count) : 0.0;
        
        System.out.println("\n--- Результаты анализа ---");
        System.out.println("Ученик: " + name);
        System.out.println("Всего оценок учтено: " + count);
        System.out.println("Средний балл: " + String.format("%.2f", average));
        
        if (average >= 4.0) {
            System.out.println("Статус: Допущен к экзаменам.");
        } else {
            System.out.println("Статус: Требуется подтянуть предметы.");
        }
        
        input.close();
    }
}
