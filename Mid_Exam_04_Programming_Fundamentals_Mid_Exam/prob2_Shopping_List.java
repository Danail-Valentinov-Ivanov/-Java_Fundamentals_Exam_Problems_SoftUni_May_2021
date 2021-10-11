package Mid_Exam_04_Programming_Fundamentals_Mid_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob2_Shopping_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Urgent {item} - add the item at the start of the list.  If the item already exists, skip this command.
        //Unnecessary {item} - remove the item with the given name, only if it exists in the list. Otherwise skip this command.
        //Correct {oldItem} {newItem} – if the item with the given old name exists, change its name with the new one. If it doesn't exist, skip this command.
        //Rearrange {item} - if the grocery exists in the list, remove it from its current position and add it at the end of the list.
        List<String> listGroseries = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("Go Shopping!")) {
            String[] currentCommand = commands.split("\\s+");
            switch (currentCommand[0]) {
                case "Urgent":
                    String item = currentCommand[1];
                    boolean isHaveEqualsItems = false;
                    for (int i = 0; i < listGroseries.size(); i++) {
                        if (item.equals(listGroseries.get(i))) {
                            isHaveEqualsItems = true;
                        }
                    }
                    if (!isHaveEqualsItems) {
                        listGroseries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    item = currentCommand[1];
                    isHaveEqualsItems = false;
                    for (int i = 0; i < listGroseries.size(); i++) {
                        if (item.equals(listGroseries.get(i))) {
                            isHaveEqualsItems = true;
                            listGroseries.remove(item);
                        }
                    }
                    break;
                case "Correct":
                    String oldItem = currentCommand[1];
                    String newItem = currentCommand[2];
                    isHaveEqualsItems = false;
                    for (int i = 0; i < listGroseries.size(); i++) {
                        if (oldItem.equals(listGroseries.get(i))) {
                            isHaveEqualsItems = true;
                            listGroseries.set(i, newItem);
                        }
                    }
                    break;
                case "Rearrange":
                    item = currentCommand[1];
                    isHaveEqualsItems = false;
                    int countRearranges = 0;
                    for (int i = 0; i < listGroseries.size() - countRearranges; i++) {
                        if (item.equals(listGroseries.get(i))) {
                            isHaveEqualsItems = true;
                            countRearranges++;
                            listGroseries.remove(i);
                            i--;
                            listGroseries.add(item);
                        }
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.print(String.join(", ", listGroseries));
    }
}
