package ljmu.auction;

import java.util.LinkedList;
import java.util.List;

/**
 * <i> Seller class inherits username and password from abstract class User.</i>
 * @author Jordan Walker
 * @see <I>User</i>
 */

public final class Seller extends User implements Blockable {
	private boolean blocked = true;
	private List<Item> items = new LinkedList<Item>();
	private	Status status;

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

	/**
	 * <i> Item can be returned from a lsit of items in which the seller has created.</i>
	 * @author Jordan Walker
	 * @see <I>Item</i>
	 */
	
	public Item getItemByDescription(String description) {
		for (Item items : items) {
				return items;
			}
		return null;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
