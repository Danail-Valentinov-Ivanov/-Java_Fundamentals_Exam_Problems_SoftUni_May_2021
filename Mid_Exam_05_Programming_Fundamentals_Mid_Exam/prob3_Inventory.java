package Mid_Exam_05_Programming_Fundamentals_Mid_Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob3_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"Collect - {item}" – Receiving this command, you should add the given item in your inventory. If the item already exists, you should skip this line.
        //"Drop - {item}" – You should remove the item from your inventory, if it exists.
        //"Combine Items - {oldItem}:{newItem}" – You should check if the old item exists, if so, add the new item after the old one. Otherwise, ignore the command.
        //"Renew – {item}" – If the given item exists, you should change its position and put it last in your inventory.
        List<String> listItems = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());
        String commands = scanner.nextLine();
        while (!commands.equals("Craft!")) {
            String[] currentCommand = commands.split(" - ");
            switch (currentCommand[0]) {
                case "Collect":
                    String item = currentCommand[1];
                    boolean isItemEqual = false;
                    for (int i = 0; i < listItems.size(); i++) {
                        if (item.equals(listItems.get(i))) {
                            isItemEqual = true;
                            break;
                        }
                    }
                    if (!isItemEqual) {
                        listItems.add(item);
                    }
                    break;
                case "Drop":
                    item = currentCommand[1];
                    for (int i = 0; i < listItems.size(); i++) {
                        if (item.equals(listItems.get(i))) {
                            listItems.remove(item);
                            i--;
                        }
                    }
                    break;
                case "Combine Items":
                    String[] oldNewItems = currentCommand[1].split(":");
                    String oldItem = oldNewItems[0];
                    String newItem = oldNewItems[1];
                    for (int i = 0; i < listItems.size(); i++) {
                        if (oldItem.equals(listItems.get(i))) {
                            listItems.add(i + 1, newItem);
                        }
                    }
                    break;
                case "Renew":
                    item = currentCommand[1];
                    int countEqual = 0;
                    for (int i = 0; i < listItems.size() - countEqual; i++) {
                        if (item.equals(listItems.get(i))) {
                            listItems.add(listItems.get(i));
                            listItems.remove(i);
                            countEqual++;
                            i--;
                        }
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.print(String.join(", ", listItems));
    }
}
