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
	private static List<User> user = Collections.synchronizedList(new LinkedList<User>());

	private static Seller seller;
	private static Buyer buyer;

	public void System() {
		user.add(new Seller("Jordan", "123"));
		user.add(new Buyer("Ellen", "123"));
		// same for more sellers/buyers

		auction.add(new Auction(1.50, 2.50, LocalDateTime.now().minusSeconds(40), 'A', new Item("Ball")));
		// same for adding more auctions
	}

	public static void main(String[] args) {
		System.out.println("-- eAuction System --");

		System.out.println();

		String selection;

		do {
			System.out.println("-- MAIN MENU --");
			System.out.println("1 - [L]og In");
			System.out.println("2 - [B]rowse Auctions");
			System.out.println("3 - [S]etup Account");
			System.out.println("4 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "L": {
				logIn();
				break;
			}
			case "2":
			case "B": {
				browseAuction();
				break;
			}
			case "3":
			case "S": {
				setupAccount();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("4"));

		// best practise to close scanners.
		S.close();

		System.out.println("-- GOODBYE --");

	}

	private static void logIn() {
		System.out.print("Please Enter Username : ");
		String username = S.next().toUpperCase();

		System.out.print("Please Enter Password : ");
		String password = S.next().toUpperCase();

		User user = getUsername(username);

		if (user != null) {
			if (user.checkPassword(password)) {
				if (Seller.class.isInstance(user)) {
					seller = Seller.class.cast(user);

					if (!Seller.isBlocked()) {
						sellerMenu();
					}
				}
			}
		} else {
			buyer = Buyer.class.cast(user);
			buyerMenu();
		}
		System.out.print("No Entry");
	}

	private static User getUsername(String username) {
		/*
		 * user.stream() .filter(o -> o.getUsername().equals(username));
		 * if(o.isPresent()) { return o.get();
		 */

		for (User user : user) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public static void sellerMenu() {
		System.out.print("welcome1");
	}

	public static void buyerMenu() {
		System.out.print("welcome2");
	}

	public static void browseAuction() {
		System.out.print("-- BROWSE AUCTION -- \n");
	}

	public static void setupAccount() {
		
		System.out.print( "-- SETUP ACCOUNT -- \n");
		//need a new username - check is already exists
		//need a password
		//save to a .txt file
		System.out.print("Please Enter a Username : ");
		String newUsername = S.next();
		
		System.out.print("Please Enter a Password : ");
		String newPassword = S.next();
		
		//user.add(new User(newUsername, newPassword));
		System.out.print("Your account has been created - Sign in to view! \n");
		}

	public void placeAuction() {

	}

	public void run() {
		main(null);
	}
}
