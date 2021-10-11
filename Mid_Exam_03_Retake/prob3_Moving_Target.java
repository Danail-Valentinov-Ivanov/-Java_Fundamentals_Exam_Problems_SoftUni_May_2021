package Mid_Exam_03_Retake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob3_Moving_Target {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Shoot {index} {power}
//Shoot the target at the index, if it exists by reducing its value by the given power (integer value).A target is considered shot when its value reaches 0.
//Remove the target, if it is shot.
//Add {index} {value}
//Insert a target with the received value at the received index, if it exist. If not, print: "Invalid placement!"
//Strike {index} {radius}
        List<Integer> listTargets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("End")) {
            String[] currentCommand = commands.split("\\s+");
            switch (currentCommand[0]) {
                case "Shoot":
                    int index = Integer.parseInt(currentCommand[1]);
                    int power = Integer.parseInt(currentCommand[2]);
                    if (index >= 0 && index < listTargets.size()) {
                        listTargets.set(index, listTargets.get(index) - power);
                        if (listTargets.get(index) <= 0) {
                            listTargets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    index = Integer.parseInt(currentCommand[1]);
                    int value = Integer.parseInt(currentCommand[2]);
                    if (index >= 0 && index < listTargets.size()) {
                        listTargets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    index = Integer.parseInt(currentCommand[1]);
                    int radius = Integer.parseInt(currentCommand[2]);
                    boolean isInvalidIndex = false;
                    int minIndex = index - radius;
                    int maxIndex = index + radius;
                    for (int i = minIndex; i <= maxIndex; i++) {
                        if (i < 0 || i >= listTargets.size()) {
                            isInvalidIndex = true;
                        }
                    }
                    if (isInvalidIndex){
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = minIndex; i <= maxIndex; i++) {
                            listTargets.remove(minIndex);
                        }
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.println(listTargets.toString().replaceAll("[\\[\\]]", "")
                .replace(", ", "|"));
    }
}
