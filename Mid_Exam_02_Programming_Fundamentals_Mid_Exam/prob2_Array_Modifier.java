package Mid_Exam_02_Programming_Fundamentals_Mid_Exam;

import java.util.Arrays;
import java.util.Scanner;

public class prob2_Array_Modifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //“swap {index1} {index2}” take two elements and swap their places.
        //“multiply {index1} {index2}” take element at the 1st index and multiply it with element at 2nd index. Save the product at the 1st index.
        //“decrease” decreases all elements in the array with 1.
        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    int oldValue = arrayNumbers[index1];
                    arrayNumbers[index1] = arrayNumbers[index2];
                    arrayNumbers[index2] = oldValue;
                    break;
                case "multiply":
                    index1 = Integer.parseInt(command[1]);
                    index2 = Integer.parseInt(command[2]);
                    int multiplyValue = arrayNumbers[index1] * arrayNumbers[index2];
                    arrayNumbers[index1] = multiplyValue;
                    break;
                case "decrease":
                    for (int i = 0; i < arrayNumbers.length; i++) {
                        arrayNumbers[i] -= 1;
                    }
                    break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        String[] arrayPrint = new String[arrayNumbers.length];
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayPrint[i] = String.valueOf(arrayNumbers[i]);
        }
        System.out.println(String.join(", ", arrayPrint));
    }
}
