import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ljmu.auction.Admin;
import ljmu.auction.Auction;
import ljmu.auction.Buyer;
import ljmu.auction.Item;
import ljmu.auction.Seller;
import ljmu.auction.Status;
import ljmu.auction.User;

//Filename cannot be System.
public class Sys {

	private static final Scanner S = new Scanner(System.in);
	private static final String PATH = "/Users/jordanwalker/Eclipse/eclipse-workspace/CWData/";

	private List<Auction> auctions = Collections.synchronizedList(new LinkedList<Auction>());
	private List<User> user = new LinkedList<User>();

	private Seller seller;
	private Buyer buyer;
	private Admin adminastrator;

	public Sys() {

		try {
			// deSerialise();
			user.add(new Seller("Glyn", "123"));
			user.add(new Seller("Jordan", "123"));
			user.add(new Buyer("Glenn", "123"));
			user.add(new Buyer("Matty", "123"));
			user.add(new Admin("Liverpool", "123"));

			// same for more sellers/buyers
			// Seller.class.cast(user.get(0)).getItems().add(new Item("Ball"));
			// Seller.class.cast(user.get(0)).getItems().add(new Item("Shoe"));

			// auctions.add(new Auction(1.50, 2.50, LocalDateTime.now().plusSeconds(70),
			// Status.ACTIVE, new Item("Ball"),
			// Seller.class.cast(user.get(0))));

			auctions.add(new Auction(1.50, 2.50, LocalDateTime.now().plusSeconds(70), Status.PENDING, new Item("Ball"),
					Seller.class.cast(user.get(1))));
			/*
			 * auctions.add(new Auction(1.50, 2.50, LocalDateTime.now().plusSeconds(70),
			 * Status.ACTIVE, new Item("Shoe"), Seller.class.cast(user.get(0))));
			 * auctions.add(new Auction(1.50, 2.50, LocalDateTime.now().plusSeconds(70),
			 * Status.ACTIVE, new Item("Shoe"), Seller.class.cast(user.get(0))));
			 */
			// same for adding more auctions

			// auctions.get(0).placeBid(5.50, Buyer.class.cast(user.get(1)),
			// LocalDateTime.now());
		} catch (Exception e) {
			System.out.print(e.getMessage() + "\n");
		}
		System.out.println("-- eAuction System --");

		System.out.println();

		String selection;

		do {
			System.out.println("-- MAIN MENU --");
			System.out.println("1 - [U]ser / [A]dmin Log In");
			System.out.println("2 - [S]etup Account");
			System.out.println("3 - [B]rowse Auctions");
			System.out.println("4 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "U":
			case "A": {
				logIn();
				break;
			}

			case "2":
			case "S": {
				setupAccount();
				break;
			}
			case "3":
			case "B": {
				browseAuction();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("4"));

		// best practise to close scanners.
		S.close();

		// serialise();

		System.out.println("\n-- GOODBYE --");
		// Safety
		System.exit(0);
	}

	private void logIn() {
		System.out.print("\n-- CASE SENSITIVE --\n");
		System.out.print("Please Enter Username : ");
		String username = S.next();

		System.out.print("Please Enter Password : ");
		String password = S.next();

		User user = getUsername(username);
		try {

			if (user != null) {
				if (user.checkPassword(password)) {
					if (Seller.class.isInstance(user)) {
						seller = Seller.class.cast(user);
						if (!Seller.isBlocked()) {
							sellerMenu();
						} else {
							System.out.println("-- SELLER BLOCKED --\n");
						}
					} else if (Buyer.class.isInstance(user)) {
						buyer = Buyer.class.cast(user);
						buyerMenu();
					} else if (Admin.class.isInstance(user)) {
						adminastrator = Admin.class.cast(user);
						adminMenu();
					}
				}
			} else {
				System.out.println("-- ENTER VALID CREDENTIALS --\n");
			}
		} catch (Exception e) {
			System.out.println("");
		}

	}

	// Added functionality into just one login system.
	/*
	 * public void adminLogIn() { System.out.print("Please Enter Username : ");
	 * String adminUsername = S.next();
	 * 
	 * System.out.print("Please Enter Password : "); String password = S.next();
	 * 
	 * User user = getUsername(adminUsername);
	 * 
	 * if (user != null) { if (user.checkPassword(password)) { if
	 * (Admin.class.isInstance(user)) { adminastrator = Admin.class.cast(user);
	 * adminMenu();
	 * 
	 * } else if (User.class.isInstance(user)){
	 * System.out.println("-- ENTER VALID CREDENTIALS --\n");
	 * 
	 * } } }
	 * 
	 * }
	 */

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
			System.out.println("\n- SELLER MENU --");
			System.out.println("1 - [C]reate Item");
			System.out.println("2 - [S]tart Auction");
			System.out.println("3 - [V]iew Your Auction");
			System.out.println("4 - [P]ending Auctions");
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
				placeAuction();
				// browseAuction();
				// showUsers();
				// showItem();
				break;
			}
			case "3":
			case "V": {
				// setupAccount();
				// viewItem();
				// Seller.getItems();
				browseAuction();
				break;
			}
			case "4":
			case "P": {
				pendingAuction();
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("5"));
		System.out.println("");
	}

	public void buyerMenu() {
		String selection;

		do {
			System.out.println("\n-- BUYER MENU --");
			System.out.println("1 - [B]id On Auction");
			System.out.println("2 - B[R]owse Auctions");
			System.out.println("3 - [V]iew Won Auctions");
			System.out.println("4 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "B": {
				bidOnAuction();
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
		System.out.println("");
	}

	public void adminMenu() {
		String selection;

		do {
			System.out.println("\n-- ADMIN MENU --");
			System.out.println("1 - [B]lock Seller");
			System.out.println("2 - Block [A]uction");
			System.out.println("3 - [V]iew Users");
			System.out.println("4 - [Q]uit");
			System.out.print("Pick : ");

			selection = S.next().toUpperCase();

			switch (selection) {
			case "1":
			case "B": {
				blockSellerByUsername();
				break;
			}
			case "2":
			case "A": {
				browseAuction();
				break;
			}
			case "3":
			case "V": {
				break;
			}
			}
		} while (!selection.equals("Q") & !selection.equals("4"));
		System.out.println("");
	}

	public void browseAuction() {
		System.out.print("\n-- BROWSE ACTIVE AUCTION -- \n");
		List<Auction> auctions = new LinkedList<Auction>();

		for (Auction auction : this.auctions) {
			if (auction.getStatus().equals(Status.ACTIVE)) {
				auctions.add(auction);
			}
		}
		if (auctions.isEmpty()) {
			System.out.println("\n-- NO ACTIVE AUCTIONS --\n");
		}

		for (Auction auction : auctions) {
			System.out.println(auction.toString());
		}
	}

	private void bidOnAuction() {

		for (Auction auction : auctions) {
			if (auction.getStatus().equals(Status.ACTIVE)) {
				System.out.println("\n" + auction.toString());
			}
		}

		System.out.println("Select Item : ");
		String chooseItem = S.next();

		try {
			for (Auction auction : auctions) {
				if (chooseItem.equals(auction.getItem())) {
				}

			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public void setupAccount() {
		String newUser = "";
		System.out.print("\n-- SETUP ACCOUNT -- \n");
		// need a new username - check is already exists
		// need a password
		// save to a .txt file
		do {
			System.out.print("Please Select Type Of User [S/B/A] : ");
			newUser = S.next().toUpperCase();

		} while (!newUser.equals("S") & !newUser.equals("B") & !newUser.equals("A"));

		System.out.print("\n-- CASE SENSITIVE --\n");

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

		if (newUser.equals("A")) {
			user.add(new Admin(newUsername, newPassword));
		}
		// user.add(new User(newUsername, newPassword));
		System.out.println("\n-- ACCOUNT CREATED --\n");
	}

	// when new item added, it changes every item in list to that item.
	/*
	 * private void createItem() { System.out.print("Item Description : "); String
	 * item = S.next();
	 * 
	 * // itemList.add(new Item(item)); if (itemList.isEmpty() &
	 * !Item.getDescription().equals(item)) { itemList.add(new Item(item));
	 * System.out.println("-- ITEM CREATED -- \n"); } else {
	 * System.out.println("-- ITEM ALREADY EXISTS -- \n"); return; }
	 * 
	 * }
	 */

	private void placeAuction() {
		try {
			String chooseItem = "";
			do {
				if (Seller.class.cast(seller).getItems().isEmpty()) {
					System.out.println("\n-- NO ITEMS CREATED--");
					return;
				} else {

					System.out.println("\n" + Seller.class.cast(seller).getItems());

					System.out.println("-- CHOOSE FROM LIST ABOVE--");
					System.out.print("Item : ");
					chooseItem = S.next();
				}
			} while (!chooseItem.equals(Item.getDescription()));

			System.out.print("Start Price : ");
			Double choosePrice = Double.parseDouble(S.next());

			System.out.print("Reserve Price  : ");
			Double chooseReservePrice = Double.parseDouble(S.next());

			System.out.print("Closing Date [E.g 15-Apr-2019-12:00] : ");
			LocalDateTime chooseCloseDate = LocalDateTime.parse(S.next(),
					DateTimeFormatter.ofPattern("dd-MMM-yyyy-HH:mm"));

			Auction auction = new Auction(choosePrice, chooseReservePrice, chooseCloseDate, Status.PENDING,
					new Item(chooseItem), Seller.class.cast(seller));

			System.out.print("Activate Auction? [Y/N] : ");
			String choice = S.next().toUpperCase();
			do {
				if (choice.equals("Y")) {
					auction.activate();
					auctions.add(auction);
					System.out.print("\n-- AUCTION ACTIVATED --\n");
					return;
				} else if (choice.equals("N")) {
					auction.verify();
					auctions.add(auction);
					System.out.print("\n-- AUCTION NOT ACTIVATED --\n");
					return;
				}
			} while (!choice.equals("Y") || choice.equals("N"));
			// }
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	/*
	 * public void createItem() { System.out.print("Please Enter Item : "); String
	 * item = S.next();
	 * 
	 * Seller.class.cast(new Item(item)); return; }
	 */

	private void createItem() {
		System.out.print("Item Description : ");
		String item = S.next();
		try {

			if (!item.equals(Item.getDescription())) {
				Seller.class.cast(seller).getItems().add(new Item(item));
				System.out.print("\n-- ITEM CREATED --\n");
			} else {
				System.out.print("\n-- ITEM ALREADY EXISTS --\n");
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	// Test to ensure users were added.
	// Can be implemented into an amdin menu.
	private void blockSellerByUsername() {
		/*
		 * for (int i = 0; i < user.size(); i++) {
		 * System.out.println(user.get(i).toString()); }
		 */
		System.out.print("Please Enter Username : ");
		String username = S.next();

		User user = getUsername(username);
		do {
			if (Seller.class.isInstance(user)) {
				System.out.println(user.toString());
				break;
			} else {
				System.out.print("\n-- INVALID SELLER --\n");
				return;
			}
		} while (!username.equals(Seller.class.isInstance(user)));

		System.out.print("Block? [Y/N] : ");
		String choice = S.next();
		if (choice.equals("Y")) {
			seller.setBlocked();
			System.out.print("\n-- SELLER BLOCKED --\n");
		} else {
			System.out.print("\n-- SELLER NOT BLOCKED --\n");
		}
	}

	// Test to ensure items are created.

	/*
	 * private void viewItem() {
	 * 
	 * for (int i = 0; i < itemList.size(); i++) {
	 * System.out.println(itemList.get(i).toString()); } }
	 */

	// public static Item getItem(String description) {
	/*
	 * user.stream() .filter(o -> o.getUsername().equals(username));
	 * if(o.isPresent()) { return o.get();
	 */
	/*
	 * for (Item items : items) { if (!items.getDescription().equals(description)) {
	 * return items; } } return null; }
	 */

	public void pendingAuction() {

		System.out.print("\n-- VIEW PENDING AUCTIONS -- \n");
		List<Auction> auctions = new LinkedList<Auction>();

		for (Auction auction : this.auctions) {
			if (auction.getStatus().equals(Status.PENDING)) {
				auctions.add(auction);
			}
		}
		if (auctions.isEmpty()) {
			System.out.print("\n-- NO PENDING AUCTIONS --\n");
			return;
		}

		for (Auction auction : auctions) {
			System.out.print("\n" + auction.toString());
		}

		String item;
		do {
			System.out.print("Please Select Auction : ");
			item = S.next();

		} while (!item.equals(Item.getDescription()));

		for (Auction auction : auctions) {
			System.out.print("Activate Auction? [Y/N] : ");
			String choice = S.next().toUpperCase();
			do {
				if (choice.equals("Y")) {
					auction.activate();
					auctions.add(auction);
					System.out.print("\n-- AUCTION ACTIVATED --\n");
					return;
				} else if (choice.equals("N")) {
					auction.setStatus(Status.PENDING);
					auctions.add(auction);
					System.out.print("\n-- AUCTION NOT ACTIVATED --\n");
					return;
				}
			} while (!choice.equals("Y") || choice.equals("N"));
		}
	}

	public static void main(String[] args) {
		// new Sys();
	}

	public void run() {
		new Sys();

	}

	public void getBidOnAuctions() {
	}

	public void deSerialise() {
		ObjectInputStream ois;

		try {
			ois = new ObjectInputStream(new FileInputStream(PATH + "users.ser"));
			user = (List<User>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void serialise() {
		ObjectOutputStream oos;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH + "users.ser"));
			oos.writeObject(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}