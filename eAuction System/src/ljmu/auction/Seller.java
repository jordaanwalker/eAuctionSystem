package ljmu.auction;
public class Seller extends User {

	
	
	
	public Seller(String username, String password) {
		super(username, password);
	}

	public static boolean isBlocked() {
		return true;
	}
	
	public void setBlocked() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
