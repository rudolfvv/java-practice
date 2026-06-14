public class BankDeposit {
    public static void main(String[] args) {
        double depositAmount = 100000.0;
        double annualRate = 12.0;
        int years = 3;

        // Расчет сложного процента с ежегодной капитализацией
        double finalAmount = depositAmount * Math.pow(1 + (annualRate / 100), years);

        System.out.println("Расчет доходности вклада:");
        System.out.println("Сумма вклада: " + depositAmount + " руб.");
        System.out.println("Ставка: " + annualRate + "% годовых");
        System.out.println("Итог через " + years + " лет: " + String.format("%.2f", finalAmount) + " руб.");
    }
}
