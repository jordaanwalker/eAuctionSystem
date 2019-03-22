import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ljmu.auction.*;

//Filename cannot be System.
public class Sys {

	private static final Scanner S = new Scanner(System.in);

	private List<Auction> auction = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> user = Collections.synchronizedList(new LinkedList<User>());

	private Seller seller;
	private Buyer buyer;

	public void System() {
		user.add(new Seller("Jordan", "123"));
		// same for more sellers/buyers

		auction.add(new Auction(1.50, 2.50, LocalDateTime.now().minusSeconds(40), 'A', new Item("Ball")));
		// same for adding more auctions
	}

	public static void main(String[] args) {
		System.out.println("-- eAuction System --");

		System.out.println();

		String selection = "";

		do {
			System.out.println("-- MAIN MENU --");
			System.out.println("1 - [L]og In");
			System.out.println("2 - [S]earch & Reserve Room");
			System.out.println("3 - [C]ancel Room");
			System.out.println("4 - [T]oDo");
			System.out.println("5 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "L": {
				logIn();
				break;
			}
			case "2":
			/* case "" : */ {
				//
				break;
			}
			case "3":
			/* case "C" : */ {
				//
				break;
			}
			case "4":
			/* case "T" : */ {

				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("5"));

		// best practise to close scanners.
		S.close();

		System.out.println("-- GOODBYE --");

	}
	
	private static void logIn() {
		System.out.print("Please Enter Username : ");
		String userName = S.next();

		System.out.print("Please Enter Password : ");
		String password = S.next();

		// User user = getUsername(userName);
	}
	
	public void placeAuction() {

	}

	public void browseAuction() {

	}

	public void setupAccount() {

	}

}
