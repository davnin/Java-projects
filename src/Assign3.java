/**
	 * @name Inventory 
	 * @version 1.3
	 * @author David Nindorera
	 * @email nindorera26@outlook.com
*/
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Assign3 {
	/**
	 * Main Menu
	 * 
	 * @param args - Parameters passed into the application
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useDelimiter(Pattern.compile("[\\r\\n]+"));
		LocalDate todaysDate = LocalDate.now();
		Inventory inventory = new Inventory();

		int bool = 0;
		while (bool != 9) {
			try {
				displayMenu();
				if (input.hasNext(Pattern.compile("[1-9]"))) {
					bool = input.nextInt();
					switch (bool) {
					case 1:
						// Add item to inventory
						if (!inventory.addItem(input))
							System.out.println("Error...could not add item");
						break;
					case 2:
						// Display current inventory
						System.out.println(inventory);
						break;
					case 3:
						// Buy items
						if (!inventory.updateQuantity(input, true))
							System.out.println("Error...could not buy item");
						break;
					case 4:
						// Sell items
						if (!inventory.updateQuantity(input, false))
							System.out.println("Error...could not sell item");
						break;
					case 5:
						// Search for item
						inventory.searchForItem(input);

						break;
					case 6:
						// Read inventory from file
						inventory.removeExpiredItems(todaysDate);
						break;
					case 7:
						inventory.summarizeExpiry(input);
						break;
					case 8:
						System.out.print("Please enter today's date (yyyy-mm-dd): ");
						if (input.hasNext()) {
							String tempDate = input.next();
							try {
								todaysDate = LocalDate.parse(tempDate);
							} catch (Exception e) {
								System.out.println("Could not create date from input, please use format yyyy-mm-dd");
								System.out.println(e.getLocalizedMessage());
							}
						}
						break;
					case 9:
						System.out.println("Exiting...");
						break;
					default:
						System.out.println("Something went wrong");
						break;
					}
				} else {
					System.out.println("Incorrect value entered");
					input.next();
				}
			} catch (Exception e) {
				System.out.println("Error Occurred: " + e.getMessage());
			}
		}
		input.close();
	}

	/**
	 * Helper method to display menu
	 */
	public static void displayMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: Search for Item");
		System.out.println("6: Remove Expired Items");
		System.out.println("7: Print Expiry");
		System.out.println("8: Change Today's Date");
		System.out.println("9: To Exit");
		System.out.print("> ");
	}

}
