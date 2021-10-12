package Mid_Exam_05_Programming_Fundamentals_Mid_Exam;

import java.util.Scanner;

public class prob1_Bonus_Scoring_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //{total bonus} = {student attendances} / {course lectures} * (5 + {additional bonus})
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        int countOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxTotalBonus = 0;
        int maxAttendances = 0;
        for (int i = 1; i <= countOfStudents; i++) {
            int studentAttendances = Integer.parseInt(scanner.nextLine());
            double totalBonus = 1.0 * studentAttendances / countOfLectures * (5 + additionalBonus);
            if (totalBonus > maxTotalBonus) {
                maxTotalBonus = totalBonus;
                maxAttendances = studentAttendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxTotalBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
