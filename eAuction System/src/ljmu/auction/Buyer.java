package ljmu.auction;

import java.util.LinkedList;
import java.util.List;

public final class Buyer extends User{

	private List<Auction> wins = new LinkedList<Auction>();
	public Buyer(String username, String password) {
		super(username, password);
	}

	public void victory(Auction auction) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
