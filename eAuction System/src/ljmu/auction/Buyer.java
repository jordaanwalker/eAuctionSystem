package ljmu.auction;

import java.util.LinkedList;

/**
 * <i> Buyer class inherits username and password from abstract class User.</i>
 * @author Jordan Walker
 * @see <I>User</i>
 */

import java.util.List;

public final class Buyer extends User{

	private List<Auction> wins = new LinkedList<Auction>();
	private List<Bid> bids = new LinkedList<Bid>();
	
	public Buyer(String username, String password) {
		super(username, password);
	}

	public void victory(Auction auction) {
		
	}
	
	public List<Bid> getBids() {
		for (Bid bid : bids) {
			return bids;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
