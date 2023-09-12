// Final --> Day 5

package test;

public class Inventory {
    private Item head;

    class Item {
        private int sku; // The unique identifier of the item
        private String description; // The description of the item
        private String department; // The department the item belongs to
        private int purchasePrice; // The purchase price of the item
        private String supplier; // The supplier of the item
        private int quantity; // The quantity of the item in stock
        Item link; // A reference to the next item in the linked list

        Item(int sku, String description, String department, int purchasePrice, String supplier, int quantity, Item link) {// Constructor for creating an item object

            this.sku = sku;
            this.description = description;
            this.department = department;
            this.purchasePrice = purchasePrice;
            this.supplier = supplier;
            this.quantity = quantity;
            this.link = link;
        }

        public int getSku() {//this accessor method returns the sku of the item
            return sku;
        }

        public String getDescription() {//this accessor method returns the description of the item
            return description;
        }

        public String getDepartment() {//this accessor method returns the department of the item
            return department;
        }

        public int getPurchasePrice() {//this accessor method returns the price of the item
            return purchasePrice;
        }

        public String getSupplier() {//this accessor method returns the supplier of the item
            return supplier;
        }

        public int getQuantity() {	//this accessor method returns the quantity of the item
            return quantity;
        }

        public void setQuantity(int quantity) {//this mutator method alters the value of the quantity of the item
            this.quantity = quantity;
        }
    }

    public void insertFirst(int sku, String description, String department, int purchasePrice, String supplier, int quantity) {////this instance method receives information (sku (int), description (string), department (string), price (int), supplier (string), and quantity (int)) about an item and uses the constructor of the inner class Item to create an object based on it, and then sets the link of the new item to the current head and sets the new item as the head of the list.
        // Creating a new item object
        Item newItem = new Item(sku, description, department, purchasePrice, supplier, quantity, null);
        // Setting the link of the new item to the current head
        newItem.link = head;
        // Setting the new item as the head of the list
        head = newItem;
    }

    public boolean sellItem(int sku, int quantity) {//This instance method, 'sellItem', receives the sku (int) and quantity (int) of an item as input, it then searches the items in the store. If the item is found, the method decrements the quantity of the item by the specified amount and returns true. If the item is not found or there is not enough quantity of the item, the method returns false.
        // Initializing the current pointer to head of the list
        Item current = head;
        // Iterating through the linked list
        while (current != null) {
            // Checking if the current item matches the specified sku
            if (current.getSku() == sku) {
                // checking if the item has enough quantity to be sold
                if (current.getQuantity() >= quantity) {
                    // decreasing the quantity of the item
                    current.setQuantity(current.getQuantity() - quantity);
                    // returning true if successful
                    return true;
                }
                // returning false if not enough quantity
                return false;
            }
            // moving the current pointer to the next item
            current = current.link;
        }
        // returning false if no item found
        return false;
    }

    public boolean restockItem(int sku, int quantity) {//This instance method, 'restockItem', receives the sku (int) and quantity (int) of an item and attempts to restock it. If successful, it returns "true", otherwise, it returns "false" if the item does not exist in the store to be restocked.
        // Initializing the current pointer to head of the list
        Item current = head;
        // Iterating through the linked list
        while (current != null) {
            // Checking if the current item matches the specified sku
            if (current.getSku() == sku) {
                // increasing the quantity of the item
                current.setQuantity(current.getQuantity() + quantity);
                // returning true if successful
                return true;
            }
            // moving the current pointer to the next item
            current = current.link;
        }
        // returning false if no item found
        return false;
    }

    public Item searchItem(int sku) {//This instance method, 'searchItem', takes in an integer input of an item's SKU as a parameter. It iterates through the linked list of items and checks if the current item's SKU matches the specified SKU. If a match is found, the method returns the item object. If no match is found, the method returns a null value.
        // Initializing the current pointer to head of the list
        Item current = head;
        // Iterating through the linked list
        while (current != null) {
            // Checking if the current item matches the specified sku
            if (current.getSku() == sku) {
                // returning the item object
                return current;
            }
            // moving the current pointer to the next item
            current = current.link;
        }
        // returning null if no item found
        return null;
    }
    
    public void printItems(String department) {//This instance method, 'printItems', takes in a string input of a department name as a parameter. It iterates through the linked list of items and prints out the details of all items that belong to the specified department. If no items are found in the specified department, the method notifies the user that no items were found.
        // Initializing the current pointer to head of the list
        Item current = head;
        // Initializing a counter to keep track of number of items found
        int count = 0;
        // Iterating through the linked list
        while (current != null) {
            // Checking if the current item belongs to the specified department
            if (current.getDepartment().equals(department)) {
                // incrementing the counter
                count++;
                // Printing the item details
                System.out.println("SKU: " + current.getSku());
                System.out.println("Description: " + current.getDescription());
                System.out.println("Department: " + current.getDepartment());
                System.out.println("Purchase Price: " + current.getPurchasePrice());
                System.out.println("Supplier: " + current.getSupplier());
                System.out.println("Quantity: " + current.getQuantity());
                System.out.println("------------------");
            }
            // moving the current pointer to the next item
            current = current.link;
        }
        // checking if no items found
        if(count == 0)
        System.out.println("No item found in department: " + department);
    }

}