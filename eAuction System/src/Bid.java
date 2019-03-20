import java.util.Date;

public class Bid {
	private double amount;
	//private Buyer who;
	private Date when;
	
	public Bid(double amount, Date when) {
		this.amount = amount;
		this.when = when;
	}
	
	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getWhen() {
		return when;
	}


	public void setWhen(Date when) {
		this.when = when;
	}


}
