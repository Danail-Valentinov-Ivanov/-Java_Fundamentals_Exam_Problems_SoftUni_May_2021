package Mid_Exam_Retake_6_August_2019;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob3_Man_O_War {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Fire 8 100
        //Defend 3 6 11
        //Defend 0 3 5
        //Repair 1 33
        //Status
        //Defend {startIndex} {endIndex} {damage} - the warship attacks the pirate ship with the given damage at that range (indexes are inclusive). Check if both indexes are valid and if not skip the command. If the section breaks (health <= 0) the pirate ship sinks, print the following and stop the program:
        //"You lost! The pirate ship has sunken."
        //Repair {index} {health} - the crew repairs a section of the pirate ship with the given health. Check if the index is valid and if not skip the command. The health of the section cannot exceed the maximum health capacity.
        //Status – prints the count of all sections of the pirate ship that need repair soon, which are all sections that are lower than 20% of the maximum health capacity. Print the following:
        //"{count} sections need repair."
        List<Integer> listStatusPirateShips = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listStatusWarShips = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        boolean isWonPirateShip = false;
        boolean isWonWarShip = false;
        int countForRepair = 0;
        while (!command.equals("Retire")) {
            String[] stringCommand = command.split("\\s+");
            switch (stringCommand[0]) {
                case "Fire":
                    int index = Integer.parseInt(stringCommand[1]);
                    int damageWarShip = Integer.parseInt(stringCommand[2]);
                    if (index >= 0 && index < listStatusWarShips.size()) {
                        int oldValue = listStatusWarShips.get(index);
                        int newValue = oldValue - damageWarShip;
                        if (newValue > 0) {
                            listStatusWarShips.set(index, newValue);
                        } else {
                            isWonPirateShip = true;
                            break;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(stringCommand[1]);
                    int endIndex = Integer.parseInt(stringCommand[2]);
                    int damagePirateShip = Integer.parseInt(stringCommand[3]);
                    if (startIndex >= 0 && startIndex < listStatusPirateShips.size()
                            && endIndex >= 0 && endIndex < listStatusPirateShips.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int oldValuePirateShip = listStatusPirateShips.get(i);
                            int newValuePirateShip = oldValuePirateShip - damagePirateShip;
                            if (newValuePirateShip > 0) {
                                listStatusPirateShips.set(i, newValuePirateShip);
                            } else {
                                isWonWarShip = true;
                                break;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(stringCommand[1]);
                    int health = Integer.parseInt(stringCommand[2]);
                    if (indexRepair >= 0 && indexRepair < listStatusPirateShips.size()) {
                        int oldValuePirateShip = listStatusPirateShips.get(indexRepair);
                        int newValuePirateShip = oldValuePirateShip + health;
                        if (newValuePirateShip <= maxHealthCapacity) {
                            listStatusPirateShips.set(indexRepair, newValuePirateShip);
                        } else {
                            listStatusPirateShips.set(indexRepair, maxHealthCapacity);
                        }
                    }
                    break;
                case "Status":
                    countForRepair = 0;
                    double needRepair = maxHealthCapacity * 0.2;
                    for (int i = 0; i < listStatusPirateShips.size(); i++) {
                        if (listStatusPirateShips.get(i) < needRepair) {
                            countForRepair++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", countForRepair);
                    break;
            }
            command = scanner.nextLine();
        }
//        if (isWonPirateShip||isWonWarShip){
//            System.out.printf("%d sections need repair.\n", countForRepair);
//        }
        if (isWonPirateShip) {
            System.out.println("You won! The enemy ship has sunken.");
        } else if (isWonWarShip) {
            System.out.println("You lost! The pirate ship has sunken.");
        } else {
            int sumIndexPirateShip = 0;
            for (Integer e :
                    listStatusPirateShips) {
                sumIndexPirateShip += e;
            }
            System.out.printf("Pirate ship status: %d\n", sumIndexPirateShip);
            int sumIndexWarShip = 0;
            for (Integer e :
                    listStatusWarShips) {
                sumIndexWarShip += e;
            }
            System.out.printf("Warship status: %d\n", sumIndexWarShip);
        }
    }
}
