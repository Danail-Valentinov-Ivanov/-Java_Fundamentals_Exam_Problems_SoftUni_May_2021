package Mid_Exam_05_Programming_Fundamentals_Mid_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob2_Mu_Online {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;
        int countCurrentRooms = 0;
        int countTotalRooms = 0;
        boolean isDied = false;
        List<String> listCommand = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        for (int i = 0; i < listCommand.size(); i++) {
            countCurrentRooms++;
            String[] currentCommand = listCommand.get(i).split("\\s+");
            switch (currentCommand[0]) {
                case "potion":
                    int healedNumber = Integer.parseInt(currentCommand[1]);
                    if (health + healedNumber <= 100) {
                        health += healedNumber;
                        System.out.printf("You healed for %d hp.\n", healedNumber);
                        System.out.printf("Current health: %d hp.\n", health);
                    } else {
                        int healedNumberToHealth100 = 100 - health;
                        health = 100;
                        System.out.printf("You healed for %d hp.\n", healedNumberToHealth100);
                        System.out.printf("Current health: %d hp.\n", health);
                    }
                    break;
                case "chest":
                    int foundBitcoins = Integer.parseInt(currentCommand[1]);
                    bitcoins += foundBitcoins;
                    System.out.printf("You found %d bitcoins.\n", foundBitcoins);
                    break;
                default:
                    String nameMonster = currentCommand[0];
                    int fightsMonster = Integer.parseInt(currentCommand[1]);
                    health -= fightsMonster;
                    if (health > 0) {
                        System.out.printf("You slayed %s.\n", nameMonster);
                    } else {
                        System.out.printf("You died! Killed by %s.\n", nameMonster);
                        System.out.printf("Best room: %d\n", countCurrentRooms);
                        isDied = true;
                    }
                    break;
            }
            if (isDied){
                break;
            }
            countTotalRooms++;
        }
        if (countTotalRooms == listCommand.size()) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitcoins);
            System.out.printf("Health: %d\n", health);
        }
    }
}
