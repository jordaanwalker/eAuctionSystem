package ljmu.auction;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Bid implements Serializable{
	
	private double amount;
	private Buyer who;
	private LocalDateTime when;

	public Bid(double amount, Buyer who, LocalDateTime when) {
		this.amount = amount;
		this.who = who;
		this.when = when;
	}

	@Override
	public String toString() {
		return "Bid [amount=" + amount + ", who=" + who + ", when=" + when + "]";
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Buyer getWho() {
		return who;
	}

	public void setWho(Buyer who) {
		this.who = who;
	}

	public LocalDateTime getWhen() {
		return when;
	}

	public void setWhen(LocalDateTime when) {
		this.when = when;
	}

}
