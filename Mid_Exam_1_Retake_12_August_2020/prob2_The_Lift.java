package Mid_Exam_1_Retake_12_August_2020;

import java.util.Arrays;
import java.util.Scanner;

public class prob2_The_Lift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPeople = Integer.parseInt(scanner.nextLine());
        int queuePeople = 0;
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isFull = false;

        for (int i = 0; i < arr.length; i++) {
            isFull = false;
            if (numPeople >= (4 - arr[i])) {
                numPeople -= (4 - arr[i]);
                arr[i] = 4;
            }
            if (arr[i] == arr[arr.length - 1] && numPeople > (4 - arr[i])) {
                queuePeople = numPeople - (4 - arr[i]);
                arr[i] = 4;
            }
            if (numPeople < (4 - arr[i])) {
                arr[i] = numPeople + arr[i];
                numPeople -= numPeople;
            }
            if (arr[i] == 4) {
                isFull = true;
            }
        }
        if (isFull && queuePeople == 0) {
            for (int index : arr) {
                System.out.print(index + " ");
            }
        } else if (isFull && queuePeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", queuePeople);
            for (int index : arr) {
                System.out.print(index + " ");
            }
        } else if (!isFull && queuePeople == 0) {
            System.out.print("The lift has empty spots!\n");
            for (int index : arr) {
                System.out.print(index + " ");
            }
        }
    }
}
