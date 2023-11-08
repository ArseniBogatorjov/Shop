package jptv22shop;

import tools.InputFromKeyboard;
import managers.ProductManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private ProductManager productManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.productManager = new ProductManager(new ArrayList<>(), scanner);
    }

    void run() {
        boolean repeat = true;

        System.out.println("------ Shop ------");
        do {
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add product");
            System.out.println("2. Add buyer");
            System.out.println("3. Print buyers list");
            System.out.println("4. Print product list");
            System.out.println("5. Buy");
            System.out.println("6. Check");
            System.out.println("7. Add money on valet");
            System.out.println("8. Print all sell list");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0, 8);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    productManager.displayAllProducts();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Select a number from the list of tasks!");
            }
        } while (repeat);
    }
}
