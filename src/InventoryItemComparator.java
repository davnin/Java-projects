import java.util.Comparator;


public class InventoryItemComparator implements Comparator<InventoryItem> {

	/*
	 * Compares given two objects
	 * */
	@Override
	public int compare(InventoryItem object1, InventoryItem object2)
	{
		// Compare by item code
		return object1.getItemCode() - object2.getItemCode();
	}

}
