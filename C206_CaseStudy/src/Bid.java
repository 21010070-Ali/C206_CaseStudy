/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 3:55:47 pm
 */

import java.time.LocalDate;

/**
 * @author 21013223
 *
 */
public class Bid extends Item{

	private String bidid; 
	private double price; 
	
	public Bid(String username, String email, String itemname, String itemdesc, double currentprice,
			LocalDate startdate, LocalDate enddate, double bidincreament, double highestprice, String category, 
			String bidid, double price) {
		
		super(username, email, itemname, itemdesc, currentprice, startdate, enddate, bidincreament, highestprice,
				category);
		
		this.bidid = bidid;
		this.price = price; 
		
	}

	public String getBidid() {
		return bidid;
	}

	public void setBidid(String bidid) {
		this.bidid = bidid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
