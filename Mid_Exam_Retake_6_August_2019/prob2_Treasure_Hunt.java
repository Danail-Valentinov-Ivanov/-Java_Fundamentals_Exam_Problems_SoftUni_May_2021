package Mid_Exam_Retake_6_August_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class prob2_Treasure_Hunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"{loot1}|{loot2}|{loot3}… {lootn}"
        //The following lines represent commands until "Yohoho!" which ends the treasure hunt:
        //Loot {item1} {item2}…{itemn} – pick up treasure loot along the way. Insert the items at the beginning of the chest. If an item is already contained don't insert it.
        //Drop {index} – remove the loot at the given position and add it at the end of the treasure chest. If the index is invalid skip the command.
        //Steal {count} – someone steals the last count loot items. If there are less items than the given count remove as much as there are. Print the stolen items separated by ', ':
        //{item1}, {item2}, {item3} … {itemcount}
        List<String> listChest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        List<String> listStealItems = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] currentLoot = command.split("\\s+");
            switch (currentLoot[0]) {
                case "Loot":
                    for (int i = 1; i < currentLoot.length; i++) {
                        boolean isEquals = false;
                        for (int j = 0; j < listChest.size(); j++) {
                            if (currentLoot[i].equals(listChest.get(j))) {
                                isEquals = true;
                            }
                        }
                        if (!isEquals) {
                            listChest.add(0, currentLoot[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(currentLoot[1]);
                    if (dropIndex >= 0 && dropIndex < listChest.size()) {
                        String helpValue = listChest.get(dropIndex);
                        listChest.remove(dropIndex);
                        listChest.add(helpValue);
                    }
                    break;
                case "Steal":
                    int stealCount = Integer.parseInt(currentLoot[1]);
                    for (int i = 0; i < stealCount; i++) {
                        listStealItems.add(0, listChest.get(listChest.size() - 1));
                        listChest.remove(listChest.size() - 1);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        int sumChars = 0;
        double averageGain = 0;
        for (int i = 0; i < listChest.size(); i++) {
            String currentItem = listChest.get(i);
            int lengthItem = currentItem.length();
            sumChars += lengthItem;
            averageGain = 1.0 * sumChars / listChest.size();
        }
        System.out.println(String.join(", ", listStealItems));
        if (listChest.isEmpty()) {
            System.out.print("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}
