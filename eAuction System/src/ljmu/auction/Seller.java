package ljmu.auction;
public final class Seller extends User implements Blockable {

	
	
	
	public Seller(String username, String password) {
		super(username, password);
	}

	public static boolean isBlocked() {
		return false;
	}
	
	public void setBlocked() {
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
