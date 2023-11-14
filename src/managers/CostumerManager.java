package managers;

import java.util.List;
import java.util.Scanner;
import entity.Costumer;
import java.util.ArrayList;
import tools.InputFromKeyboard;

public class CostumerManager {
    private List<Costumer> costumerList;
    private Scanner scanner;

    public CostumerManager(List<Costumer> costumerList, Scanner scanner) {
        this.costumerList = costumerList;
        this.scanner = scanner;
    }

    public void addCostumer() {
        System.out.println();
        System.out.println("-------- Add new costumer --------");
        System.out.println();

        System.out.println("Enter costumer firstname:");
        String Fname = scanner.nextLine();

        System.out.println("Enter costumer lastname:");
        String Lname = scanner.nextLine();

        System.out.println("Enter costumer telephone number:");
        int Tnumber = scanner.nextInt();

        // Очистка буфера ввода
        scanner.nextLine();

        Costumer newCostumer = new Costumer(Fname, Lname, Tnumber, 0);
        costumerList.add(newCostumer);
        System.out.println("Costumer was successfully added");
    }

    public void addBalance() {
        System.out.println("-------- Add Balance to Costumer --------");
        System.out.println("Choose a costumer:");

        for (int i = 0; i < costumerList.size(); i++) {
            System.out.println((i + 1) + ". " + costumerList.get(i).getFullName());
        }
        System.out.print("Your choice:");
        int choice = InputFromKeyboard.inputNumberFromRange(1, costumerList.size());

        double amount;
        while (true) {
            System.out.print("Enter the amount to add (in x.xx format): ");
            String priceString = scanner.nextLine();
            try {
                amount = Double.parseDouble(priceString);
                if (amount > 0 && priceString.matches("^\\d+\\.\\d{2}$")) {
                    break;
                } else {
                    System.out.println("amount must be in format x.xx and greater than zero");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount entry format.");
            }
        }
 
        Costumer selectedCostumer = costumerList.get(choice - 1);
        selectedCostumer.addBalance(amount);

        System.out.println("Balance added successfully. New balance: " + selectedCostumer.getBalance());
    }

    public List<Costumer> getCostumerList() {
        return costumerList;
    }

    public void displayAllCostumers() {
        System.out.println("List of all costumers:");
        for (Costumer costumer : costumerList) {
            System.out.println(costumer);
        }
    }
}
