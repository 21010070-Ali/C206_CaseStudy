/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 3:40:19 pm
 */

package draft;

import java.time.LocalDate;

/**
 * @author 21013223
 *
 */
public class Item extends Useracc {

	private String itemname;
	private String itemdesc;
	private double currentprice;
	private LocalDate startdate;
	private LocalDate enddate;
	private double bidincreament;
	private String category;
	private double highestprice;

	// Add item for seller
	public Item(String username, String password, String email, String itemname, String itemdesc, double currentprice,
			LocalDate startdate, LocalDate enddate, double bidincreament, String category, String role) {

		super(username, password, email, role);
		this.itemname = itemname;
		this.itemdesc = itemdesc;
		this.currentprice = currentprice;
		this.startdate = startdate;
		this.enddate = enddate;
		this.bidincreament = bidincreament;
		this.category = category;

	}

	// View item
	public Item(String username, String email, String itemname, String itemdesc, double currentprice,
			LocalDate startdate, LocalDate enddate, double bidincreament, double highestprice, String category) {

		super(username, email);
		this.itemname = itemname;
		this.itemdesc = itemdesc;
		this.currentprice = currentprice; // starting bid price
		this.highestprice = highestprice; // current bid price
		this.startdate = startdate;
		this.enddate = enddate;
		this.bidincreament = bidincreament;
		this.category = category;

	}

	public String getItemname() {
		return itemname;
	}

	public double getHighestprice() {
		return highestprice;
	}

	public void setHighestprice(double highestprice) {
		this.highestprice = highestprice;
	}

	public void setCurrentprice(double currentprice) {
		this.currentprice = currentprice;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemdesc() {
		return itemdesc;
	}

	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}

	public double getCurrentprice() {
		return currentprice;
	}

	public void setMinbidprice(double currentprice) {
		this.currentprice = currentprice;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public double getBidincreament() {
		return bidincreament;
	}

	public void setBidincreament(double bidincreament) {
		this.bidincreament = bidincreament;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
