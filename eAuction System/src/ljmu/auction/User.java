package ljmu.auction;

import java.io.Serializable;
import java.util.List;

/**
 * <i> User class is abstract. </i>
 * @author Jordan Walker
 * @see <I>Seller</i>
 * @see <i>Buyer</i>
 */
public class User implements Serializable {
	protected String username;
	protected String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//Java Doc here maybe
	public boolean checkPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
