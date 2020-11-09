import java.util.Scanner;

public class FoodItem {

	private int itemCode;
	private float itemCost;
	private String itemName;
	private float itemPrice;

	/**
	 * Default Constructor
	 */
	public FoodItem() {
		itemCode = 0;
		itemName = "";
		itemPrice = 0.0f;
		itemCost = 0.0f;
	}

	/**
	 * Reads from the Scanner object passed in and fills the data member fields of
	 * the class with valid data.
	 * 
	 * @param scanner  - Scanner to use for input
	 * @param fromFile - Is input from file
	 * @return <code>true</code> if all data members were successfully populated,
	 *         <code>false</code> otherwise
	 */
	public boolean addItem(Scanner scanner) {
		boolean validInput = false;

		System.out.print("Enter the name for the item: ");
		itemName = scanner.next();
		
		// Input the cost
		validInput = false;
		while (!validInput) {
			System.out.print("Enter the cost of the item: ");
			if (scanner.hasNextFloat()) {
				itemCost = scanner.nextFloat();
				if (itemCost < 0) {
					validInput = false;
					System.out.println("Invalid input");
					itemCost = 0;
				} else
					validInput = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				validInput = false;
			}
		}

		// Input the price
		validInput = false;
		while (!validInput) {
			System.out.print("Enter the sales price of the item: ");
			if (scanner.hasNextFloat()) {
				itemPrice = scanner.nextFloat();
				if (itemPrice < 0) {
					validInput = false;
					System.out.println("Invalid input");
					itemPrice = 0;
				} else
					validInput = true;
			} else {
				System.out.println("Invalid input");
				scanner.next();
				validInput = false;
			}
		}
		return true;
	}

	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Reads a valid itemCode from the Scanner object and returns true/false if
	 * successful
	 * 
	 * @param scanner  - Scanner to use for input
	 * @param fromFile - Is input from file
	 * @return <code>true</code> if code was populated, <code>false</code> otherwise
	 */
	public boolean inputCode(Scanner scanner) {
		boolean validInput = false;
		while (!validInput) {
			System.out.print("Enter the code for the item: ");
			if (scanner.hasNextInt()) {
				itemCode = scanner.nextInt();
				validInput = true;
			} else {
				System.out.println("Invalid code");
				// Clear the invalid input
				scanner.next();
			}
		}
		return validInput;
	}

	/**
	 * Compares this object's item code with the one passed in
	 * 
	 * @param item - object to compare with
	 * @return <code>true</code> if the itemCode of the object being acted on and
	 *         the item object parameter are the same value, <code>false</code>
	 *         otherwise
	 */
	public boolean isEqual(FoodItem item) {
		return itemCode == item.itemCode;
	}

	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " price: $" + String.format("%.2f", itemPrice) + " cost: $"
				+ String.format("%.2f", itemCost);
	}

}