package ljmu.auction;
import java.io.Serializable;
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

	
	public void placeBid(double d, Buyer buyer, LocalDateTime localDateTime) {
		
	}
	
	public void verify() {
		
	}
	
	public synchronized void close() {
		status = Status.CLOSED;
		
		Bid highest;
		
		if((highest = getHighestBid()) != null) {
			highest.getWho().victory(this);
		}
	}
	// ToDo : Fix This
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
				+ "\nSeller : " + seller + "", item, startPrice, reservePrice);
	}
//String.format("No:%02d  Type:%s  Price:%.2f  isBalcony:%s  isLounge:%s  isReserve:%s  %s",

	public double getStartPrice() {
		return startPrice;
	}

	/*@Override
	public String toString() {
		return "Auction [startPrice=" + startPrice + ", reservePrice=" + reservePrice + ", closeDate=" + closeDate
				+ ", status=" + status + ", item=" + item + "]";
	}*/


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
	
	
}
