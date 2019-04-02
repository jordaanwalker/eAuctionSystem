package ljmu.auction;

import java.util.List;
import java.time.LocalDateTime;

public class CheckStatus implements Runnable {

	private List<Auction> auctions;
	private Integer delay;

	public CheckStatus(List<Auction> auctions, Integer seconds) {
		this.auctions = auctions;
		this.setSeconds(seconds);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(delay);

				synchronized (auctions) {
					auctions.stream().filter(o -> o.getStatus().equals(Status.ACTIVE))
					.filter(o -> o.getCloseDate().isBefore(LocalDateTime.now())).forEach(o -> o.close());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public synchronized void setSeconds(Integer seconds) {
		this.delay = seconds * 1000;
	}

}
