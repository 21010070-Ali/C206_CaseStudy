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

	private int bidid;
	private String buyeremail;
	private String buyerusername;
	private int dealid;
	
	public Bid(int bidid, String buyeremail, String buyerusername, String email, String username, String itemname, String itemdesc
			, double highestprice, String category) {
		
		super(username, email, itemname, itemdesc, highestprice, category);
		this.bidid = bidid;
		this.buyeremail = buyeremail;
		this.buyerusername = buyerusername;
		
	}
	
	public Bid(int dealid, String buyeremail, String buyerusername, String email, String username, String itemname,
			double highestprice, LocalDate enddate) {
		
		super(username, email, itemname, highestprice, enddate);
		this.dealid = dealid;
		this.buyeremail = buyeremail;
		this.buyerusername = buyerusername;
		
	}
	

	public int getDealid() {
		return dealid;
	}

	public void setDealid(int dealid) {
		this.dealid = dealid;
	}


	public int getBidid() {
		return bidid;
	}

	public void setBidid(int bidid) {
		this.bidid = bidid;
	}

	public String getBuyeremail() {
		return buyeremail;
	}

	public void setBuyeremail(String buyeremail) {
		this.buyeremail = buyeremail;
	}

	public String getBuyerusername() {
		return buyerusername;
	}

	public void setBuyerusername(String buyerusername) {
		this.buyerusername = buyerusername;
	}	

}
