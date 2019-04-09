package ljmu.auction;

import java.util.LinkedList;
import java.util.List;

public final class Seller extends User implements Blockable {
	private boolean blocked = true;
	private List<Item> items = new LinkedList<Item>();

	public Seller(String username, String password) {
		super(username, password);
	}

	public static boolean isBlocked() {
		return false;
	}

	public boolean setBlocked() {
		return blocked;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Item> getItems() {
		return items;

	}

	public Item getItemByDescription(String description) {
		for (Item items : items) {
				return items;
			}
		return null;
	}

}
