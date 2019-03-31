import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ljmu.auction.*;

//Filename cannot be System.
public class Sys {

	private static final Scanner S = new Scanner(System.in);

	private static List<Auction> auction = Collections.synchronizedList(new LinkedList<Auction>());
	private static List<User> user = Collections.synchronizedList(new LinkedList<User>());
	private static List<Item> itemList = Collections.synchronizedList(new LinkedList<Item>());
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	private static Seller seller;
	private static Buyer buyer;

	public static void loadData() {
		user.add(new Seller("Jordan", "123"));
		user.add(new Buyer("Ellen", "123"));
		// same for more sellers/buyers

		//auction.add(new Auction(1.50, 2.50, ("12-12-2012"), new Item("Ball")));
		// same for adding more auctions
	}

	public static void entryMenu() {
		loadData();
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
				// browseAuction();
				// showUsers();
				sellerMenu();
				// buyerMenu();
				break;
			}
			case "3":
			case "S": {
				setupAccount();
				break;
			}
			case "5":
			case "V": {
				showUsers();
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
					// if (!Seller.isBlocked()) {
					sellerMenu();
				} else {
					buyer = Buyer.class.cast(user);
					buyerMenu();
				}
			}
			// }
		}
		// System.out.println("No Entry");
	}

	public static User getUsername(String username) {
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
		String selection;

		do {
			System.out.println("-- SELLER MENU --");
			System.out.println("1 - [C]reate Item");
			System.out.println("2 - [S]tart Auction");
			System.out.println("3 - [V]iew Your Auction");
			System.out.println("4 - [R]emove Item");
			System.out.println("5 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "C": {
				createItem();
				break;
			}
			case "2":
			case "S": {
				createAuction();
				// browseAuction();
				// showUsers();
				// showItem();
				break;
			}
			case "3":
			case "V": {
				// setupAccount();
				viewItem();
				break;
			}
			case "4":
			case "R": {
				viewAuctions();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("5"));
	}

	public static void buyerMenu() {
		String selection;

		do {
			System.out.println("-- BUYER MENU --");
			System.out.println("1 - [B]id On Auction");
			System.out.println("2 - B[R]owse Auction");
			System.out.println("3 - [V]iew Your Auction");
			System.out.println("4 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "B": {
				//
				break;
			}
			case "2":
			case "R": {
				// browseAuction();
				// showUsers();
				break;
			}
			case "3":
			case "V": {
				// setupAccount();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("4"));
	}

	public static void browseAuction() {
		System.out.print("-- BROWSE AUCTION -- \n");

	}

	public static void setupAccount() {
		String newUser = "";
		System.out.print("-- SETUP ACCOUNT -- \n");
		// need a new username - check is already exists
		// need a password
		// save to a .txt file
		do {
			System.out.print("Please Select Type Of User [S/B] : ");
			newUser = S.next().toUpperCase();

		} while (!newUser.equals("S") & !newUser.equals("B"));

		System.out.print("Please Enter a Username : ");
		String newUsername = S.next();

		System.out.print("Please Enter a Password : ");
		String newPassword = S.next();

		if (newUser.equals("S")) {
			user.add(new Seller(newUsername, newPassword));
		}

		if (newUser.equals("B")) {
			user.add(new Buyer(newUsername, newPassword));
		}
		// user.add(new User(newUsername, newPassword));
		System.out.print("Your account has been created - Sign in to view! \n");
	}

	// when new item added, it changes every item in list to that item.
	private static void createItem() {
		System.out.print("Item Description : ");
		String item = S.next();

		itemList.add(new Item(item));
/*		if (itemList.isEmpty() & !Item.getDescription().equals(item)) {
			itemList.add(new Item(item));
			System.out.println("-- ITEM CREATED -- \n");
		} else {
			System.out.println("-- ITEM ALREADY EXISTS -- \n");
		}
*/
	}

	private static void createAuction() {
		String chooseItem = "";

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}

		/*
		 * Error with -- NO ITEM CREATED -- repeating. do {
		 * 
		 * if(items.isEmpty()) { System.out.print("--NO CREATED --"); } else {
		 * System.out.print("Choose From List : "); chooseItem = S.next(); }
		 * 
		 * } while (!chooseItem.equals(Item.getDescription()));
		 * 
		 */

		do {

			if (itemList.isEmpty()) {
				System.out.print("--NO ITEMS CREATED --");
			} else {
				System.out.print("Choose From List : ");
				chooseItem = S.next();
			}
		} while (!chooseItem.equals(Item.getDescription()));

		System.out.print("Start Price : ");
		Double choosePrice = S.nextDouble();
		
		System.out.print("Reserve Price  : ");
		Double chooseReservePrice = S.nextDouble();
		
		System.out.print("Closing Date [E.g 09-04-2019] : ");
		String chooseStartDate = S.next();
		try {
			Date d = dateFormat.parse(chooseStartDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Date entered in wrong format, Please try again");
		}
		auction.add(new Auction(choosePrice, chooseReservePrice, chooseStartDate, new Item(chooseItem)));

	}

	public void placeAuction() {

	}

	// Test to ensure users were added.

	private static void showUsers() {
		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).toString());
		}
	}

	// Test to ensure items are created.

	private static void viewItem() {

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}
	}
	
	private static void viewAuctions() {

		for (int i = 0; i < auction.size(); i++) {
			System.out.println(auction.get(i).toString());
		}
	}

	// public static Item getItem(String description) {
	/*
	 * user.stream() .filter(o -> o.getUsername().equals(username));
	 * if(o.isPresent()) { return o.get();
	 */
	/*
	 * for (Item items : items) { if (!items.getDescription().equals(description)) {
	 * return items; } } return null; }
	 */

	public static void main(String[] args) {
		entryMenu();

	}

	public void run() {
		entryMenu();

	}
}