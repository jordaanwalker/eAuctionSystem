package ljmu.auction;

public class Item {
	
	private static String description;
	
	public Item(String description) {
		this.description = description;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Item : " + description;
	}

	public static String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
