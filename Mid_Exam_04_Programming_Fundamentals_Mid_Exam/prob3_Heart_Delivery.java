package Mid_Exam_04_Programming_Fundamentals_Mid_Exam;

import java.util.Arrays;
import java.util.Scanner;

public class prob3_Heart_Delivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayEachHouses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int startIndex = 0;
        int lastPosition = 0;
        while (!command.equals("Love!")) {
            String[] currentCommand = command.split("\\s+");
            int jump = Integer.parseInt(currentCommand[1]);
            if (startIndex + jump >= arrayEachHouses.length) {
                startIndex = 0;
                jump = 0;
            }
            int index = startIndex + jump;
            if (arrayEachHouses[index] == 0) {
                System.out.printf("Place %d already had Valentine's day.\n", index);
            } else {
                startIndex = index;
                arrayEachHouses[index] -= 2;
                if (arrayEachHouses[index] == 0) {
                    System.out.printf("Place %d has Valentine's day.\n", index);
                }
                lastPosition = index;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.\n", lastPosition);
        int countDoesNotNull = 0;
        for (int e : arrayEachHouses) {
            if (e != 0) {
                countDoesNotNull++;
            }
        }
        if (countDoesNotNull == 0) {
            System.out.print("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", countDoesNotNull);
        }
    }
}
