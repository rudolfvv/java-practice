public class StudentTracker {
    public static void main(String[] args) {
        // Поменяли оценки внутри фигурных скобок
        int[] grades = {3, 2, 3, 4, 2, 3}; 
        
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        
        double average = sum / grades.length;
        
        System.out.println("--- Анализ успеваемости ученика ---");
        System.out.println("Всего выставлено оценок: " + grades.length);
        System.out.println("Средний балл: " + String.format("%.2f", average));
        
        if (average >= 4.0) {
            System.out.println("Статус: Отличный результат, допущен к экзамену!");
        } else {
            System.out.println("Статус: Внимание! Требуются дополнительные занятия.");
        }
    }
}
