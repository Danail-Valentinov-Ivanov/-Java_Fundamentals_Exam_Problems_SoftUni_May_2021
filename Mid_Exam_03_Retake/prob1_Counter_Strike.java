package Mid_Exam_03_Retake;

import java.util.Scanner;

public class prob1_Counter_Strike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String distance = (scanner.nextLine());
        int countBattles = 0;
        boolean isWon = true;
        while (!distance.equals("End of battle")) {
            if (initialEnergy > 0 && initialEnergy >= Integer.parseInt(distance)) {
                int distanceValue = Integer.parseInt(distance);
                initialEnergy -= distanceValue;
                countBattles++;
                if (countBattles % 3 == 0) {
                    initialEnergy += countBattles;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy"
                        , countBattles, initialEnergy);
                isWon = false;
                break;
            }
            distance = scanner.nextLine();
        }
        if (isWon) {
            System.out.printf("Won battles: %d. Energy left: %d", countBattles, initialEnergy);
        }
    }
}
