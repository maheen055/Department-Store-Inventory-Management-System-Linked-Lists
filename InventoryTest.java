package test;
import java.util.Scanner;

public class InventoryTest {//this main program has complete functionality according to the requirments (plus some more!)
    public static void main(String[] args) {
        // Initialize an inventory object
        Inventory inventory = new Inventory();

        // Adding some items to the inventory using the constructor
        inventory.insertFirst(1, "Bag", "Accessories", 5000, "Gucci", 5);
        inventory.insertFirst(2, "Jeans", "Apparel", 65, "Garage", 15);
        inventory.insertFirst(3, "Jeans", "Apparel", 40, "Old Navy", 15);
        inventory.insertFirst(4, "Shirt", "Apparel", 10, "Urban", 10);
        inventory.insertFirst(5, "Shoes", "Footwear", 80, "Addidas", 20);
        inventory.insertFirst(6, "iPhone 14", "Electronics", 2100, "Apple", 100);

        // Initialize scanner for user input
        Scanner input = new Scanner(System.in);

        // Create a boolean variable to keep track of whether the program should exit
        boolean exit = false;

        // Loop through until the program is exited
        while (!exit) {
        	
        	// Prompt the user to enter the password
            System.out.println("Please enter the password:");
            String password = input.next();
            
            // Check if the entered password is correct
            if (password.equals("ICS4U0")) { 
            	
                // Inner loop for the options menu
                while (!exit) {
                	
                	// Print the options menu
                    System.out.println("Please select an option:");
                    System.out.println("1. Sell an item");
                    System.out.println("2. Restock an item");
                    System.out.println("3. Search for a particular item");
                    System.out.println("4. Print all items in a department");
                    System.out.println("5. Exit");
                    
                    // Take user input for their choice
                    int choice = input.nextInt();

                    // Switch statement for the different options
                    if (choice == 1) {
                    	// Prompt user for the SKU and quantity of the item they want to sell
                        System.out.println("Enter the SKU of the item you want to sell:");
                        int sku = input.nextInt();
                        System.out.println("Enter the quantity of the item you want to sell:");
                        int quantity = input.nextInt();
                        
                        // Attempt to sell the item and store the result in a variable
                        boolean success = inventory.sellItem(sku, quantity);
                        
                        // Print appropriate message based on the result of the operation
                        if (success) {
                            System.out.println("Item sold successfully!");
                        } else {
                            System.out.println("Item not found or not in stock!");
                        }
                    } else if (choice == 2) {
                        // prompt user to enter SKU and quantity of item to restock
                        System.out.println("Enter the SKU of the item you want to restock:");
                        int sku = input.nextInt();
                        System.out.println("Enter the quantity of the item you want to restock:");
                        int quantity = input.nextInt();
                        // call restockItem method on inventory object
                        boolean success = inventory.restockItem(sku, quantity);
                        // check if restocking was successful
                        if (success) {
                            System.out.println("Item restocked successfully!");
                        } else {
                            System.out.println("Item not found!");
                        }
                    } else if (choice == 3) {
                        // prompt user to enter SKU of item to search for
                        System.out.println("Enter the SKU of the item you want to search for:");
                        int sku = input.nextInt();
                        // call searchItem method on inventory object
                        Inventory.Item item = inventory.searchItem(sku);
                        // check if item was found
                        if (item != null) {
                            // print item details
                            System.out.println("SKU: " + item.getSku());
                            System.out.println("Description: " + item.getDescription());
                            System.out.println("Department: " + item.getDepartment());
                            System.out.println("Purchase Price: " + item.getPurchasePrice());
                            System.out.println("Supplier: " + item.getSupplier());
                            System.out.println("Quantity: " + item.getQuantity());
                        } else {
                            System.out.println("Item not found!");
                        }
                    } else if (choice == 4) {
                        // prompt user to enter department to print items for
                        System.out.println("Enter the department you want to print items for:");
                        String department = input.next();
                        // call printItems method on inventory object
                        inventory.printItems(department);
                    } else if (choice == 5) {
                        exit = true;
                        System.out.println("Exiting... \n \nHave a good day! :)");
                    } else {
                        System.out.println("Invalid choice. Please select a valid option.");
                    }
                }
	        } else {
	        	System.out.println("Incorrect password. Please try again.");
	        }
	    }
	}
}
