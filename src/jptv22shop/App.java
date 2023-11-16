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

    private boolean confirmTask() {
        System.out.print("Is that right task? (1 for yes, 0 for no): ");
        return InputFromKeyboard.inputNumberFromRange(0, 1) == 1;
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
            System.out.println("6. Top customers by buying ");
            System.out.println("7. Add money on costumer valet");
            System.out.println("8. Print all sells value");
            System.out.println("9. Quantity replenishement");
            System.out.println("10. Top selling products");
            System.out.println("11. Product data change");
            System.out.print("Enter number task: ");
            int task = InputFromKeyboard.inputNumberFromRange(0, 11);
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(!confirmTask()){
                        break;
                    }
                    productManager.addProduct();
                    break;
                case 2:
                    if(!confirmTask()){
                        break;
                    }
                    costumerManager.addCostumer();
                    break;
                case 3:
                    if(!confirmTask()){
                        break;
                    }
                    costumerManager.displayAllCostumers();
                    break;
                case 4:
                    if(!confirmTask()){
                        break;
                    }
                    productManager.displayAllProducts();
                    break;
                case 5:
                    if(!confirmTask()){
                        break;
                    }
                    purchaseManager.makePurchase();
                    break;
                case 6:
                    if(!confirmTask()){
                        break;
                    }
                    costumerManager.displayCustomerRating();
                    break;
                case 7:
                    if(!confirmTask()){
                        break;
                    }
                    costumerManager.addBalance();
                    break;
                case 8:
                    if(!confirmTask()){
                        break;
                    }
                    purchaseManager.displayTotalSales();
                    break;
                case 9:
                    if(!confirmTask()){
                        break;
                    }
                    productManager.replenishProductQuantity();
                    break;
                case 10:
                    if(!confirmTask()){
                        break;
                    }
                    purchaseManager.displayProductRanking();
                    break;
                case 11:
                    if(!confirmTask()){
                        break;
                    }
                    productManager.editProduct();
                    break;    
                default:
                    System.out.println("Select a number from the list of tasks!");
            }
        } while (repeat);
    }
}
