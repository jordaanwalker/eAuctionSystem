package ljmu.auction;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static String description;
	
	public Item(String description) {
		this.description = description;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return description;
	}

	public static String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
