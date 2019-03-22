package ljmu.auction;
public class Seller extends User {

	
	
	
	public Seller(String username, String password) {
		super(username, password);
	}

	public boolean isBlocked() {
		return false;
	}
	
	public void setBlocked() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
