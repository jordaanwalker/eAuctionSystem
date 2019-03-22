import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ljmu.auction.*;


public class System {
	private final Scanner S = new Scanner(java.lang.System.in);

	private List<Auction> auction = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> user = Collections.synchronizedList(new LinkedList<User>());

	private Seller seller;
	private Buyer buyer;

	public void System() {
		user.add(new Seller("Jordan", "123"));
		//same for more sellers/buyers
		
		auction.add(new Auction(1.50, 2.50, LocalDateTime.now().minusSeconds(40), 'A', new Item("Ball")));
		//same for adding more auctions
	}
	public void placeAuction() {

	}

	public void browseAuction() {

	}

	public void setupAccount() {

	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
