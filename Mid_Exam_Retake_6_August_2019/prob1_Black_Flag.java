package Mid_Exam_Retake_6_August_2019;

import java.util.Scanner;

public class prob1_Black_Flag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;
        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder += 1.0 * dailyPlunder / 2;
            }
            if (i % 5 == 0) {
                totalPlunder *= 0.7;
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double collectedPlunder = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", collectedPlunder);
        }
    }
}
