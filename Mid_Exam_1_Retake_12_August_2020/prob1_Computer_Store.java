package Mid_Exam_1_Retake_12_August_2020;

import java.util.Scanner;

public class prob1_Computer_Store {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isDiscount = false;
        boolean isStop = false;
        double totalPrice = 0;
        double priceWithoutTaxes = 0;

        while (isStop = true) {
            if (input.equals("regular") || input.equals("special")) {
                if (input.equals("special")) {
                    isDiscount = true;
                }
                break;
            }
            double price = Double.parseDouble(input);
            if (price > 0) {
                priceWithoutTaxes += price;
            } else {
                System.out.println("Invalid price!");
            }
            input = scanner.nextLine();
        }
        double taxes = priceWithoutTaxes * 0.2;
        double finalPrice = priceWithoutTaxes + taxes;
        if (isDiscount) {
            totalPrice = finalPrice - (finalPrice * 0.1);
        } else {
            totalPrice = finalPrice;
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$\n", totalPrice);
        }

    }
}
