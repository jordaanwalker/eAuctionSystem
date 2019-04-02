
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ljmu.auction.*;

//Filename cannot be System.
public class Sys {

	private static final Scanner S = new Scanner(System.in);

	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> user = Collections.synchronizedList(new LinkedList<User>());
	private List<Item> itemList = Collections.synchronizedList(new LinkedList<Item>());

	private Seller seller;
	private Buyer buyer;

	public Sys() {
		user.add(new Seller("Jordan", "123"));
		user.add(new Buyer("Ellen", "123"));
		// same for more sellers/buyers

		auctions.add(new Auction(1.50, 2.50, LocalDateTime.now().plusSeconds(70), Status.ACTIVE, new Item("Ball")));
		// same for adding more auctions
		itemList.add(new Item("Shoe"));

		System.out.println("-- eAuction System --");

		System.out.println();

		String selection;

		do {
			System.out.println("-- MAIN MENU --");
			System.out.println("1 - [L]og In");
			System.out.println("2 - [B]rowse Auctions");
			System.out.println("3 - [S]etup Account");
			// System.out.println("4 - [A]dmin");
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
			case "B": {
				viewAuctions();
				// showUsers();
				// sellerMenu();
				// buyerMenu();
				break;
			}
			case "3":
			case "S": {
				setupAccount();
				break;
			}
			case "4":
			case "V": {
				showUsers();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("5"));

		// best practise to close scanners.
		S.close();

		System.out.println("-- GOODBYE --");
		// Safety
		System.exit(0);
	}

	private void logIn() {
		System.out.print("Please Enter Username : ");
		String username = S.next();

		System.out.print("Please Enter Password : ");
		String password = S.next();

		User user = getUsername(username);

		if (user != null) {
			if (user.checkPassword(password)) {
				if (Seller.class.isInstance(user)) {
					seller = Seller.class.cast(user);
					if (!Seller.isBlocked()) {
						sellerMenu();
					}
				} else {
					buyer = Buyer.class.cast(user);
					buyerMenu();
				}
			}
		} else {
			System.out.println("No Entry");
		}
	}

	private User getUsername(String username) {

		/*
		 * user.stream() .filter(o -> o.getUsername().equals(username)).forEach(o ->
		 * o.); if(o -> o.isPresent()) { return o.get(); }
		 */

		for (User user : user) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;

	}

	public void sellerMenu() {
		String selection;

		do {
			System.out.println("-- SELLER MENU --");
			System.out.println("1 - [C]reate Item");
			System.out.println("2 - [S]tart Auction");
			System.out.println("3 - [V]iew Your Auction");
			System.out.println("4 - [R]emove Item");
			System.out.println("5 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next();

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

	public void buyerMenu() {
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
				browseAuction();
				break;
			}
			case "3":
			case "V": {
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("4"));
	}

	public void browseAuction() {
		System.out.print("-- BROWSE ACTIVE AUCTION -- \n");
		// List<Auction> auctions = this.auction.stream().filter(o ->)
		// List<Auction> auctions = new LinkedList<Auction>();

		for (Auction auction : auctions) {
			if (auction.getStatus().equals(Status.ACTIVE)) {
				// auctions.add(auction);
				System.out.println(auctions.toString());
			}
		}
		if (auctions.isEmpty()) {
			System.out.println("-- NO ACTIVE AUCTIONS --");
			return;
		}
	}
	
	private void bidOnAuction() {
		
	}

	public void setupAccount() {
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
	private void createItem() {
		System.out.print("Item Description : ");
		String item = S.next();

		// itemList.add(new Item(item));
		if (itemList.isEmpty() & !Item.getDescription().equals(item)) {
			itemList.add(new Item(item));
			System.out.println("-- ITEM CREATED -- \n");
		} else {
			System.out.println("-- ITEM ALREADY EXISTS -- \n");
			return;
		}

	}

	private void createAuction() {
		String chooseItem = "";

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}
		do {
			if (itemList.isEmpty()) {
				System.out.println("--NO ITEMS CREATED -- \n");
				return;
			} else {
				System.out.print("Choose From List : ");
				chooseItem = S.next();
			}
		} while (!chooseItem.equals(Item.getDescription()));

		System.out.print("Start Price : ");
		Double choosePrice = Double.parseDouble(S.next());

		System.out.print("Reserve Price  : ");
		Double chooseReservePrice = Double.parseDouble(S.next());

		System.out.print("Closing Date [E.g 9 Apr 19 12:00] : ");
		LocalDateTime chooseStartDate = LocalDateTime.parse(S.next(), DateTimeFormatter.ofPattern("d MMM yy HH:mm"));

		Auction auction = new Auction(choosePrice, chooseReservePrice, chooseStartDate, Status.ACTIVE,
				new Item(chooseItem));

		System.out.print("Activate Auction? [Y/N] : ");
		String choice = S.next().toUpperCase();
		do {
			if (choice.equals("Y")) {
				auction.activate();
				auctions.add(auction);
				System.out.print("-- AUCTION ACTIVATED --");
			} else if (choice.equals("N")) {
				System.out.print("-- AUCTION NOT ACTIVATED --");
			}
		} while (!choice.equals("Y") || choice.equals("N"));
	}

	public void placeAuction() {

	}

	// Test to ensure users were added.
	//Can be implemented into an amdin menu.
	private void showUsers() {
		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).toString());
		}
	}

	// Test to ensure items are created.

	private void viewItem() {

		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}
	}

	private void viewAuctions() {

		for (int i = 0; i < auctions.size(); i++) {
			System.out.println(auctions.get(i).toString());
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
		new Sys();
	}

	public void run() {
		new Sys();

	}
}