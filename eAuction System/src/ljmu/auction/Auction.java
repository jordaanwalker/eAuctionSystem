package ljmu.auction;
import java.util.Date;

public class Auction {
	private double startPrice;
	private double reservePrice;
	private Date closeDate;
	private char status;
	
	public Auction(Double startPrice,Double reservePrice, Date closeDate, char status) {
		this.startPrice = startPrice;
		this.reservePrice = reservePrice;
		this.closeDate = closeDate;
		this.status = status;
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

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	
}
