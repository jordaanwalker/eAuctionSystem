package ljmu.auction;
import java.time.LocalDateTime;
import java.util.Date;

public class Auction {
	private double startPrice;
	private double reservePrice;
	private String closeDate;
	private char status;
	private Item item;
	
	public Auction(Double startPrice,Double reservePrice, String chooseStartDate, Item item) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.closeDate = chooseStartDate;
		//this.status = status;
		this.item = item;
		
	}

	
	public static void placeBid() {
		
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
	
	@Override
	public String toString() {
		return "Auction : [startPrice=" + startPrice + ", reservePrice=" + reservePrice + ", closeDate=" + closeDate
				+ ", item=" + item + "]";
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

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
