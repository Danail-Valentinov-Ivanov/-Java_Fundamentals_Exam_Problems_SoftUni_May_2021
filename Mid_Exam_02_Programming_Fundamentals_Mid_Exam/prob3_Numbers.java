package Mid_Exam_02_Programming_Fundamentals_Mid_Exam;

import java.util.*;

public class prob3_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        List<Integer> listBiggerNumbers = new ArrayList<>();
        int sumValue = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            sumValue += arrayNumbers[i];
        }
        double averageValue = 1.0 * sumValue / arrayNumbers.length;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (arrayNumbers[i] > averageValue) {
                listBiggerNumbers.add(arrayNumbers[i]);
            }
        }
        Collections.sort(listBiggerNumbers);
        Collections.reverse(listBiggerNumbers);
        if (listBiggerNumbers.size() > 5) {
            while (listBiggerNumbers.size() > 5) {
                listBiggerNumbers.remove(listBiggerNumbers.size() - 1);
            }
        }
        if (listBiggerNumbers.isEmpty()) {
            System.out.print("No");
        } else {
            for (Integer e : listBiggerNumbers) {
                System.out.print(e + " ");
            }
        }
    }
}
