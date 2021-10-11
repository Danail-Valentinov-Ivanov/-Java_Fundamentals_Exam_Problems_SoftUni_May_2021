package Mid_Exam_03_Retake;

import java.util.Arrays;
import java.util.Scanner;

public class prob2_Shoot_for_the_Win {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arraySequence = Arrays.stream(scanner.nextLine().split("\\s++"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int countShotTargets = 0;
        while (!command.equals("End")) {
        int index = Integer.parseInt(command);
            for (int i = 0; i < arraySequence.length; i++) {
                if (index >= 0 && index < arraySequence.length) {
                    if (arraySequence[i] != -1 && i == index) {
                        int oldValueCurrentElement = arraySequence[i];
                        arraySequence[i] = -1;
                        countShotTargets++;
                        for (int j = 0; j < arraySequence.length; j++) {
                            if (arraySequence[j] != -1 && arraySequence[j] > oldValueCurrentElement) {
                                arraySequence[j] -= oldValueCurrentElement;
                            } else if (arraySequence[j] != -1 && arraySequence[j] <= oldValueCurrentElement) {
                                arraySequence[j] += oldValueCurrentElement;
                            }
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", countShotTargets);
        for (int e : arraySequence) {
            System.out.print(e + " ");
        }
    }
}
