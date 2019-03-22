package ljmu.auction;
import java.time.LocalDateTime;

public class Auction {
	private double startPrice;
	private double reservePrice;
	private LocalDateTime closeDate;
	private char status;
	private Item item;
	
	public Auction(Double startPrice,Double reservePrice, LocalDateTime closeDate, char status, Item item) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.closeDate = closeDate;
		this.status = status;
		this.item = item;
		
	}

	
	public void placeBid() {
		
	}
	
	public void verify() {
		
	}
	
	public void close() {
		
	}
	
	public boolean isBlocked() {
		return false;
	}
	
	public void setBlocked() {
		
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

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
