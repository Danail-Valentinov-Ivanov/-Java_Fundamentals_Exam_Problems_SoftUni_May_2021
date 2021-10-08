package Mid_Exam_1_Retake_12_August_2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob3_Memory_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Invalid input! Adding additional elements to the board
        //Congrats! You have found matching elements - ${element}!
        //Try again!
        //You have won in {number of moves until now} turns!
        //Sorry you lose :(
        //              {the current sequence's state}
        List<String> listNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String commands = scanner.nextLine();
        int countMoves = 0;
        while (!commands.equals("end")) {
            boolean isBreak = false;
            countMoves++;
            String[] currentCommand = commands.split("\\s+");
            int firstIndex = Integer.parseInt(currentCommand[0]);
            int secondIndex = Integer.parseInt(currentCommand[1]);
            if (firstIndex != secondIndex && firstIndex >= 0 && firstIndex < listNumbers.size()
                    && secondIndex >= 0 && secondIndex < listNumbers.size()) {
                for (int i = 0; i < listNumbers.size(); i++) {
                    for (int j = 0; j < listNumbers.size(); j++) {
                        if (firstIndex == i && secondIndex == j) {
                            isBreak = true;
                            if (listNumbers.get(i).equals(listNumbers.get(j))) {
                                System.out.printf("Congrats! You have found matching elements - %s!\n"
                                        , listNumbers.get(i));
                                if (j > i) {
                                    listNumbers.remove(j);
                                    listNumbers.remove(i);
                                } else {
                                    listNumbers.remove(i);
                                    listNumbers.remove(j);
                                }
                                if (listNumbers.size() == 0) {
                                    System.out.printf("You have won in %d turns!\n", countMoves);
                                    return;
                                }
                                i--;
                                j--;
                            } else {
                                System.out.println("Try again!");
                            }
                        }
                        if (isBreak) {
                            break;
                        }
                    }
                    if (isBreak) {
                        break;
                    }
                }
            } else {
                int halfList = listNumbers.size() / 2;
                String countMovesString = "-" + countMoves + "a";
                listNumbers.add(halfList, countMovesString);
                listNumbers.add(halfList + 1, countMovesString);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            commands = scanner.nextLine();
        }
        System.out.printf("Sorry you lose :(\n" +
                "%s", String.join(" ", listNumbers));
    }
}
