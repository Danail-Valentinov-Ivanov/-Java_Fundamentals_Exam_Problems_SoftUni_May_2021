package Mid_Exam_04_Programming_Fundamentals_Mid_Exam;

import java.util.Scanner;

public class prob1_National_Court_equal_with_prob1_Mid_Exam_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //On first three lines -  each employee efficiency -  integer in range [1 - 100]
        //On the fourth line - students count – integer in range [0 – 10000]
        int efficiencyFirstEmployee = Integer.parseInt(scanner.nextLine());
        int efficiencySecondEmployee = Integer.parseInt(scanner.nextLine());
        int efficiencyThirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int sumEfficiencyAllEmployees = efficiencyFirstEmployee + efficiencySecondEmployee
                + efficiencyThirdEmployee;
        int countHours = 0;
        while (studentsCount > 0) {
            for (int i = 1; i <= 3; i++) {
                studentsCount -= sumEfficiencyAllEmployees;
                countHours++;
                if (studentsCount <= 0) {
                    break;
                }
            }
            if (studentsCount <= 0) {
                break;
            }
            countHours++;
        }
        System.out.printf("Time needed: %dh.", countHours);
    }
}
