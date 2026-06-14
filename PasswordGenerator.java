import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Набор символов, из которых будет собираться пароль
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        
        System.out.println("=== ГЕНЕРАТОР НАДЁЖНЫХ ПАРОЛЕЙ ===");
        System.out.print("Введите желаемую длину пароля: ");
        int length = scanner.nextInt();
        
        // Переменная для сборки пароля
        String password = "";
        
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password += characters.charAt(randomIndex);
        }
        
        System.out.println("\nВаш безопасный пароль:");
        System.out.println(password);
        
        scanner.close();
    }
}
