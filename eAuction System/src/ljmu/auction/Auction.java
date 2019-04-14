package ljmu.auction;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Auction implements Blockable, Serializable{
	private double startPrice;
	private double reservePrice;
	private LocalDateTime closeDate;
	private	Status status;
	private Item item;
	private Seller seller;
	
	
	public Auction(Double startPrice,Double reservePrice, LocalDateTime chooseStartDate, Status status, Item item, Seller seller) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.closeDate = chooseStartDate;
		this.status = status;
		this.item = item;
		this.seller = seller;
		
	}

	
	public void placeBid(double amount, Buyer buyer, LocalDateTime when) {
		new Bid(amount, buyer, when);
	}
	
	public Status verify() {
		
		return status = Status.PENDING;
		
	}
	
	public synchronized void close() {
		status = Status.CLOSED;
		
		Bid highest;
		
		if((highest = getHighestBid()) != null) {
			highest.getWho().victory(this);
		}
	}
	// ToDo : Fix This, returns null for now.
	private Bid getHighestBid() {
		
		return null;
	}


	public boolean isBlocked() {
		if(Status.BLOCKED != null) {
			return true;
		}
		return false;
	}
	
	public void setBlocked() {
		
	}
	
	@Override
	public String toString() {
		return String.format("Item : %s \nStart Price : £%.2f \nReserve Price : £%.2f \n"+"Close Date : " + closeDate
				+ "\nSeller : " + Seller.class.cast(seller) + "\n", item, startPrice, reservePrice);
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public double getReservePrice() {
		return reservePrice;
	}

	public void setReservePrice(double reservePrice) {
		this.reservePrice = reservePrice;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public synchronized String getCloseDateFormat() {
		return closeDate.format(DateTimeFormatter.ofPattern("d MM yy HH:mm"));
		
	}
	
	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public void activate() {
		status = Status.ACTIVE;
		
	}
	public Item getItem() {
		return item;
		
	}
	
}
