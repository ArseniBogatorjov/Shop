package managers;

import java.util.List;
import java.util.Scanner;
import entity.Costumer;
import entity.Product;
import tools.InputFromKeyboard;

public class PurchaseManager {
    private List<Costumer> costumerList;
    private List<Product> productList;
    private Scanner scanner;


    public PurchaseManager(List<Costumer> costumerList, List<Product> productList, Scanner scanner) {
        this.costumerList = costumerList;
        this.productList = productList;
        this.scanner = scanner;
        
    }

    public void makePurchase() {
        System.out.println("-------- Make a Purchase --------");
        System.out.println("Choose a customer:");

        for (int i = 0; i < costumerList.size(); i++) {
            System.out.println((i + 1) + ". " + costumerList.get(i).getFullName());
        }

        int customerChoice = InputFromKeyboard.inputNumberFromRange(1, costumerList.size());
        Costumer selectedCustomer = costumerList.get(customerChoice - 1);

        System.out.println("Choose a product to purchase:");

        for (int i = 0; i < productList.size(); i++) {
            System.out.println((i + 1) + ". " + productList.get(i));
        }
        System.out.print("Your choice:");
        int productChoice = InputFromKeyboard.inputNumberFromRange(1, productList.size());
        Product selectedProduct = productList.get(productChoice - 1);

        System.out.print("Enter the quantity to purchase: ");
        int quantityToPurchase = InputFromKeyboard.inputNumberFromRange(1, selectedProduct.getQuantity());

        double totalCost = selectedProduct.getPrice() * quantityToPurchase;

        if (totalCost <= selectedCustomer.getBalance() && quantityToPurchase <= selectedProduct.getQuantity()) {
            
            selectedCustomer.subtractBalance(totalCost);
            selectedProduct.subtractQuantity(quantityToPurchase);
            

            
            System.out.println("Purchase successful. New balance: " + selectedCustomer.getBalance());
        } else {
            System.out.println("Insufficient funds or insufficient quantity. Purchase aborted.");
        }
    }
}
