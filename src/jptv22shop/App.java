package jptv22shop;

import tools.InputFromKeyboard;
import managers.ProductManager;
import managers.CostumerManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import managers.PurchaseManager;

public class App {
    private final Scanner scanner;
    private ProductManager productManager;
    private CostumerManager costumerManager;
    private PurchaseManager purchaseManager;


    public App() {
        this.scanner = new Scanner(System.in);
        this.productManager = new ProductManager(new ArrayList<>(), scanner);
        this.costumerManager = new CostumerManager(new ArrayList<>(),scanner);
        this.purchaseManager = new PurchaseManager(costumerManager.getCostumerList(), productManager.getProductList(), scanner);
    

    }

    void run() {
        boolean repeat = true;

        System.out.println("------Perfume Shop ------");
        do {
            System.out.println("List tasks:");
            System.out.println("0. Exit");
            System.out.println("1. Add product");
            System.out.println("2. Add Costumer");
            System.out.println("3. Print costumer list");
            System.out.println("4. Print product list");
            System.out.println("5. Buy product for costumer");
            System.out.println("6. Costumer Check buy");
            System.out.println("7. Add money on costumer valet");
            System.out.println("8. Print all sell value list");
            System.out.println("9. Quantity replenishement");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0, 9);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    costumerManager.addCostumer();
                    break;
                case 3:
                    costumerManager.displayAllCostumers();
                    break;
                case 4:
                    productManager.displayAllProducts();
                    break;
                case 5:
                    purchaseManager.makePurchase();
                    break;
                case 6:
                    break;
                case 7:
                    costumerManager.addBalance();
                    break;
                case 8:
                    break;
                case 9:
                    productManager.replenishProductQuantity();
                    break;
                default:
                    System.out.println("Select a number from the list of tasks!");
            }
        } while (repeat);
    }
}
