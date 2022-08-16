
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 5:04:09 pm
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CAOS {

	static ArrayList<String> catlist = new ArrayList<String>();
	static ArrayList<Item> itemlist = new ArrayList<Item>();
	static ArrayList<Useracc> userlist = new ArrayList<Useracc>();
	static ArrayList<Moderation> blocklist = new ArrayList<Moderation>();
	static ArrayList<Bid> bidlist = new ArrayList<Bid>();
	static ArrayList<Bid> deallist = new ArrayList<Bid>();

	private static String email;
	private static String password;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CAOS c1 = new CAOS();
		c1.start();

	}

	public void start() {

		settingup();
		int signinoption = -1;

		while (signinoption != 4) {
			int buyersoption = -1;
			int sellerfirstopt = -1;
			int sellersecondopt = -1;
			int adminmenuopt = -1;

			signinmenu();
			signinoption = Helper.readInt("Enter option: ");

			if (signinoption == 1) {

				if (acclogin() == true) {

					if (rolechecker(email) == 1) { // checker role

						while (buyersoption != 5) {

							buyermenu();

							buyersoption = Helper.readInt("Enter option : ");

							if (buyersoption == 1) {

								viewauctionbycategory();

							} else if (buyersoption == 2) {

								placebidsbuyers();

							} else if (buyersoption == 3) {

								if (viewtransac().length() != 0) {

									System.out.println(viewtransac());

								} else {

									System.out.println("Null/No transaction found.");
								}

							} else if (buyersoption == 4) {

								admindeletebid();

							} else if (buyersoption == 5){

								System.out.println("Logging Out...");

							} else {
								
								System.out.println("Invalid Input");
							}

						}

					} else if (rolechecker(email) == 2) {

						while (sellerfirstopt != 4) {

							sellermenu();
							sellerfirstopt = Helper.readInt("Enter option: ");

							if (sellerfirstopt == 1) {

								viewauctionbycategory();

							} else if (sellerfirstopt == 2) {

								viewmyauction();

							} else if (sellerfirstopt == 3) {

								sellermenusecond();
								sellersecondopt = Helper.readInt("Enter option: ");

								if (sellersecondopt == 1) {

									selleraddnewitem();

								} else if (sellersecondopt == 2) {

									sellerdeleteitem();

								} else if (sellersecondopt == 3) {

									sellerupdateitem();

								} else if (sellersecondopt == 4) {

									sellerclosedeal();

								} else if (sellersecondopt == 5) {

									System.out.println(adminviewdeals());

								} else if (sellersecondopt == 6) {
									
									System.out.println("Exiting Out...");
									
								} else { 
									
									System.out.println("Invalid");
								}

							}

						}

					} else if (rolechecker(email) == 3) {
						
						int adminmenusecondopt = -1;
						int adminmenopt = -1;
						int thirdadminopt = -1;
						int adminmenuoppt = -1;
						int secondadminopt = -1;
						adminmenuopt = -1;
						adminmenu();
						
						adminmenuopt = Helper.readInt("Enter option > ");

						while (adminmenuopt != 5) {
							
							if (adminmenuopt == 1) {
								
								adminmanagebidmenu();
								adminmenusecondopt = Helper.readInt("Enter option > ");
								
								if (adminmenusecondopt == 1) {
									
									if (viewtransac().length() != 0) {
										
										System.out.println(viewtransac());
										break;
										
									} else { 
										
										System.out.println("Null Value");
										break;
									}
									
								} else if (adminmenusecondopt == 2) {
									
									admindeletebid();
									break;
									
								} else { 
									
									System.out.println("Invalid user option. ");
									
								}
											
							} else if (adminmenuopt == 2) {
								
								adminmanagedealmenu();
								adminmenopt = Helper.readInt("Enter option > ");
								
								if (adminmenopt == 1) {
									
									if (adminviewdeals().length() != 0) {
										
										System.out.println(adminviewdeals());
										break;
									
									} else { 
										
										System.out.println("Null Value");
										break;
									}
									
									
								} else if (adminmenopt == 2) { 
									
									admindeletedeal();
									
								} else { 
									
									System.out.println("Invalid user option. ");
									
								}
								
							} else if (adminmenuopt == 3) {
								
								adminmanage();
								secondadminopt = Helper.readInt("Enter option > ");
								
								if (secondadminopt == 1) {
									
									viewalluseradmin();
									
								} else if (secondadminopt == 2) {
									
									addadmin();
									
								} else if (secondadminopt == 3) {
									
									admindeleteuser();
									
								} else if (secondadminopt == 4) {
									
									adminblockuser();
									
								} else if (secondadminopt == 5) {
									
									System.out.println("Exiting...");
									
								} else { 
									
									System.out.println("Invalid option...");
									
								}
								
							} else if (adminmenuopt == 4) {
								
								admincatmenu();
								thirdadminopt = Helper.readInt("Enter option > ");
								
								if (thirdadminopt == 1) {
									
									addallcat();
									
								} else if (thirdadminopt == 2) {
									
									deletecat();
									
								} else if (thirdadminopt == 3) {
									
									viewallcat();
									
								} else if (thirdadminopt == 4) {
									
									System.out.println("Exiting...");
									
								} else { 
									
									System.out.println("Invalid option inputted.");
									
								}
								
								
							} else if (adminmenuopt == 5) {
								
								System.out.println("Logging Out...");
								
							} else { 
								
								System.out.println("Invalid user input.");
							}

						}
					}

				} else {

					System.out.println("Invalid email/password entered.\n");

				}

			} else if (signinoption == 2) {

				newaccmenu();
				int accmenu = Helper.readInt("Enter option > ");

				if (accmenu == 1) {

					if (addingbuyeracc() == true) {

						System.out.println("Successful Added! Welcome to CAOS Family ");
						System.out.println("Please relogin. ");

					} else {

						System.out.println("Username/Email Duplicated");
					}

				} else if (accmenu == 2) {

					if (addingselleracc() == true) {

						System.out.println("Successful Added! Welcome to CAOS Family ");
						System.out.println("Please relogin. ");

					} else {

						System.out.println("Username/Email Duplicated");
					}

				} else if (accmenu == 3) {

					System.out.println("Exiting Registration");

				} else {

					System.out.println("Invalid user input.");

				}

			} else if (signinoption == 3) {

				System.out.println(viewAll());

			} else if (signinoption == 4) {

				System.out.println("Thanks for using CAOS Software");

			} else {

				System.out.println("Invalid user input");
			}

		}

	}
	
	public static boolean addingselleracc() { // DARREN LEE
	
		boolean successaddseller = false;
		boolean isfound = false;
		int currentsize = userlist.size();
		String newpw = "";
	
		String newemail = Helper.readString("Enter email address > ");
		String newusername = Helper.readString("Enter username > ");
	
		for (Useracc i : userlist) {
	
			if (i.getEmail().equalsIgnoreCase(newemail) || i.getUsername().equalsIgnoreCase(newusername)) {
	
				for (Moderation x : blocklist) {
	
					if (x.getEmail().equalsIgnoreCase(newemail) || i.getUsername().equalsIgnoreCase(newusername)) {
	
						isfound = true;
						break;
	
					}
				}
	
			}
	
		}
	
		if (isfound == false) {
	
			newpw = Helper.readString("Enter new password > ");
			String newpw1 = Helper.readString("Enter password again > ");
	
			if (newpw.equals(newpw1) == true) {
	
				Useracc b1 = new Useracc(newusername, "Buyer", newemail, newpw);
				userlist.add(b1);
	
				if (currentsize != userlist.size()) {
	
					successaddseller = true;
	
				}
	
			}
	
		}
	
		return successaddseller;
	}

	public static boolean addingbuyeracc() { // DARREN LEE 
	
		boolean successaddbuyer = false;
		boolean isfound = false;
		int currentsize = userlist.size();
		String newpw = "";
	
		String newemail = Helper.readString("Enter email address > ");
		String newusername = Helper.readString("Enter username > ");
	
		for (Useracc i : userlist) {
	
			if (i.getEmail().equalsIgnoreCase(newemail) || i.getUsername().equalsIgnoreCase(newusername)) {
	
				for (Moderation x : blocklist) {
	
					if (x.getEmail().equalsIgnoreCase(newemail) || i.getUsername().equalsIgnoreCase(newusername)) {
	
						isfound = true;
						break;
	
					}
				}
	
			}
	
		}
	
		if (isfound == false) {
	
			newpw = Helper.readString("Enter new password > ");
			String newpw1 = Helper.readString("Enter password again > ");
	
			if (newpw.equals(newpw1) == true) {
	
				Useracc b1 = new Useracc(newusername, "Buyer", newemail, newpw);
				userlist.add(b1);
	
				if (currentsize != userlist.size()) {
	
					successaddbuyer = true;
	
				}
	
			}
	
		}
	
		return successaddbuyer;
	}

	public static boolean viewalluseradmin() { // DARREN LEE 
		
		boolean isfound = false;
		
		for (int i = 0; i < userlist.size(); i++) {
			
			System.out.println("");
			System.out.println("User " + i);
			System.out.println("Username: " + userlist.get(i).getUsername());
			System.out.println("User Email: " + userlist.get(i).getEmail());
			System.out.println("User Role: " + userlist.get(i).getRole());
			System.out.println("");
			isfound = true;
		}
		
		return isfound;
	}

	public static boolean addallcat() { // ALI 
	
		boolean isadded = false;
	
		String newcat = Helper.readString("Enter category > ");
	
		for (String i : catlist) {
	
			if (i.equalsIgnoreCase(newcat) == false) {
				System.out.println("Added successful");
	
				isadded = true;
				break;
	
			}
		}
	
		if (isadded == true) {
	
			catlist.add(newcat);
	
		} else {
	
			System.out.println("Category Name existsed");
	
		}
	
		return isadded;
	}

	public static boolean viewallcat() { // ALI 
	
		boolean isfound = false;
	
		for (String i : catlist) {
	
			System.out.println(i);
			isfound = true;
		}
	
		return isfound;
	}

	public static boolean deletecat() { // ALI 
	
		boolean isdeleted = false;
		int currentsize = itemlist.size();
		boolean isfound = false;
	
		String newcat = Helper.readString("Enter category > ");
	
		for (String i : catlist) {
	
			if (i.equalsIgnoreCase(newcat) == true) {
	
				isfound = false;
	
			}
	
		}
	
		if (isfound == false) {
	
			catlist.remove(newcat);
			
			for (int i = 0; i < itemlist.size(); i++) {
	
				if (itemlist.get(i).getCategory().equalsIgnoreCase(newcat)) {
					
					itemlist.remove(i);
					
				}
			}
			
			if (currentsize != itemlist.size()) {
				
				System.out.println("Remove successful");
				isdeleted = true;
	
			}
	
		} else {
	
			System.out.println("Category Name existsed");
	
		}
	
		return isdeleted;
	
	}

	public static boolean selleraddnewitem() { // PENG JIE 
	
		boolean isadded = false;
	
		int currentsize = itemlist.size();
	
		String newcat = "";
	
		String newitemname = Helper.readString("Enter item name > ");
		String newitemdesc = Helper.readString("Enter item description > ");
		double newstartprice = Helper.readDouble("Enter start price > ");
	
		String startdate = Helper.readString("Enter start date (yyyy-mm-dd) > ");
		LocalDate formatstartdate = LocalDate.parse(startdate);
	
		int duration = Helper.readInt("How long this auction will last? ");
		LocalDate formatenddate = formatstartdate.plusDays(duration);
	
		double bidincreament = Helper.readDouble("Enter bid increament > $\n");
	
		String newcat1 = Helper.readString("Enter Category Name: ");
	
		System.out.println();
	
		Helper.line(50, "~");
		System.out.println("NEW ITEM REVIEW");
		Helper.line(50, "~");
	
		newcat += "Item Name: " + newitemname + "\n";
		newcat += "Item Description: " + newitemdesc + "\n";
		newcat += "Item start price: " + newstartprice + "\n";
		newcat += "Auction Start Date: " + formatstartdate + "\n";
		newcat += "Auction End Date: " + formatenddate + "\n";
		newcat += "Bid Increament: " + bidincreament + "\n";
		newcat += "Category Name: " + newcat1 + "\n";
	
		System.out.println(newcat);
	
		char confirmnewitem = Helper.readChar("Please type Y if confirmed else N : ");
	
		if (confirmnewitem == 'y' || confirmnewitem == 'Y') {
	
			boolean foundacc = false;
	
			String selleruser = Helper.readString("Please enter username: ");
			String sellerrole = Helper.readString("Enter role: ");
			String selleremail = Helper.readString("Please enter email: ");
			String sellerpassword = Helper.readString("Enter password: ");
	
			for (Useracc i : userlist) {
	
				if (i.getUsername().equals(selleruser) && i.getEmail().equals(selleremail)
						&& i.getPassword().equals(sellerpassword)) {
	
					foundacc = true;
	
				}
	
			}
	
			if (foundacc == true) {
	
				Item or = new Item(selleruser, sellerpassword, selleremail, newitemname, newitemdesc, newstartprice,
						formatstartdate, formatenddate, bidincreament, newcat1, sellerrole);
	
				itemlist.add(or);
	
				if (currentsize != itemlist.size()) {
	
					System.out.println("Adding Successful");
	
				} else {
	
					System.out.println("Adding new item failed!");
				}
	
			} else {
	
				System.out.println("Account Invalid. It is Case Sensitive.");
	
			}
	
		} else {
	
			System.out.println("No confirmation! User did not input 'Y' ");
	
		}
	
		return isadded;
	
	}

	public static String viewAll() { // PENG JIE 
	
		String output = "";
	
		output += "\n";
	
		output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n";
		output += ("All Auctionable Items") + "\n";
		output += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n";
	
		int count = 0;
	
		for (Item i : itemlist) {
	
			count++;
			output += ("\n");
	
			output += "Name: " + i.getItemname() + "\n";
			output += ("Description: " + i.getItemdesc()) + "\n";
			output += ("Auction Start Date: " + i.getStartdate()) + "\n";
			output += ("Auction End Date: " + i.getEnddate()) + "\n";
	
		}
	
		output += ("Total Number of auctionable items: " + count);
		return output;
	}

	public static boolean sellerdeleteitem() { // PENG JIE 
	
		boolean isdeleted = false;
		int currentsize = itemlist.size();
		boolean isfound = false;
	
		String deleteitem = Helper.readString("Enter item name you wish to delete: ");
	
		for (Item i : itemlist) {
	
			if (i.getItemname().equalsIgnoreCase(deleteitem) && i.getEmail().equals(email)) {
	
				isfound = true;
	
			}
	
		}
	
		if (isfound == true) {
	
			String newcat = "";
	
			for (Item i : itemlist) {
	
				if (i.getItemname().equalsIgnoreCase(deleteitem)) {
	
					Helper.line(50, "~");
					System.out.println("REVIEW PENDING DELETE");
					Helper.line(50, "~");
	
					newcat += "Item Name: " + i.getItemname() + "\n";
					newcat += "Item Description: " + i.getItemdesc() + "\n";
					newcat += "Item start price: " + i.getHighestprice() + "\n";
					newcat += "Auction Start Date: " + i.getStartdate() + "\n";
					newcat += "Auction End Date: " + i.getEnddate() + "\n";
					newcat += "Bid Increament: " + i.getBidincreament() + "\n";
					newcat += "Category Name: " + i.getCategory() + "\n";
	
					System.out.println(newcat);
	
					char confirmdelete = Helper.readChar("Please type Y if confirmed else N : ");
	
					if (confirmdelete == 'Y' || confirmdelete == 'y') {
	
						itemlist.remove(i);
	
						if (currentsize != itemlist.size()) {
	
							System.out.println("Successful Delete");
							isdeleted = true;
	
						} else {
	
							System.out.println("Failed to delete");
						}
	
					} else {
	
						System.out.println("No confirmation to delete");
	
					}
	
				} else {
	
					System.out.println("Item name is invalid");
	
				}
	
			}
		} else {
	
			System.out.println("Item does not belong to you");
	
		}
	
		return isdeleted;
	
	}

	public static void placebidsbuyers() { // WILLIAM 
	
		double bidprice = 0;
		boolean itemfound = false;
		String itemoutput = "";
		String itembidsearch = "";
	
		for (Item i : itemlist) {
	
			itemoutput += i.getItemname() + " | $" + i.getHighestprice() + " | \n";
	
		}
	
		Helper.line(50, "~");
		System.out.println("Place Your Bids :D");
		Helper.line(50, "~");
		System.out.println();
	
		System.out.println(itemoutput);
	
		itembidsearch = Helper.readString("Enter item name you want to bid > ");
	
		for (Item i : itemlist) {
	
			if (i.getItemname().equalsIgnoreCase(itembidsearch)) {
	
				itemfound = true;
	
				Helper.line(50, "~");
				System.out.println("Place Your Bids :D");
				Helper.line(50, "~");
				System.out.println("");
	
				System.out.println("Name: " + i.getItemname());
				System.out.println("Description: " + i.getItemdesc());
				System.out.println("Current Price: $" + i.getHighestprice());
				System.out.println("Auction Start Date: " + i.getStartdate());
				System.out.println("Auction End Date: " + i.getEnddate());
				System.out.println("Bid Increament: " + i.getBidincreament());
	
				System.out.println("Seller Username: " + i.getUsername());
				System.out.println("Seller Email: " + i.getEmail());
				System.out.println("Seller Rating: " + i.getRatings());
				System.out.println("");
	
				bidprice = i.getHighestprice() + i.getBidincreament();
	
				char authorise = Helper.readChar(
						"Do you want to bid for " + i.getItemname() + " at a price of" + "  $" + bidprice + " ? (Y/N)");
	
				if (authorise == 'Y' || authorise == 'y') {
	
					if (transactlog(i.getUsername(), i.getEmail(), i.getItemname(), bidprice) == true) {
	
						i.setHighestprice(bidprice);
						break;
	
					}
	
				} else {
	
					System.out.println("No authorisation");
	
				}
	
			}
		}
	
		if (itemfound == false) {
	
			System.out.println("Invalid Item Name.");
		}
	
	}

	public static String viewtransac() { // WILLIAM 
	
		String output = "";
	
		for (Bid i : bidlist) {
	
			output += ("");
			output += ("Category Name: " + i.getCategory()+ "\n");
			output += ("-------------------------------------"+ "\n");
			output += ("Bid ID: " + i.getBidid()+ "\n");
			output += ("Item Name: " + i.getItemname()+ "\n");
			output += ("Item Desc: " + i.getItemdesc()+ "\n");
			output += ("Seller Email: " + i.getEmail()+ "\n");
			output += ("Seller Username: " + i.getUsername()+ "\n");
			output += ("Seller Ratings: " + i.getRatings()+ "\n");
			output += ("Buyer Email: " + i.getBuyeremail()+ "\n");
			output += ("Buyer Username: " + i.getBuyerusername()+ "\n");
			output += ("Paid: $" + i.getHighestprice()+ "\n");
			output += ("-------------------------------------"+ "\n");
			output += (""+ "\n");
	
		}
	
		return output;
	}

	public static boolean admindeletebid() { // WILLIAM
		
		boolean isfound = false; 
		
		int findbidid = Helper.readInt("Enter bid ID you wish to delete > ");
		
		for (int i = 0; i < bidlist.size(); i++) { 
			
			if (bidlist.get(i).getBidid() == findbidid) {
				
				isfound = true;
				bidlist.remove(i);
				
			}
			
		}
		
		if (isfound == true) {
			
			System.out.println("Successfully deleted");
			
		} else { 
			
			System.out.println("Item failed to delete");
			
		}
		
		return isfound;
		
	}

	public static boolean sellerclosedeal() { // JUN YI 
	
		boolean isclosed = false;
		boolean isfound = false;
		int currentsize = deallist.size();
	
		String name = Helper.readString("Enter the item name you want to close > ");
	
		for (Item i : itemlist) {
	
			if (i.getItemname().equalsIgnoreCase(name)) {
	
				int dealid = getdealid();
	
				String buyeremail = Helper.readString("Enter your email > ");
				String buyeruser = Helper.readString("Enter username > ");
	
				for (Useracc x : userlist) {
	
					if (x.getEmail().equalsIgnoreCase(buyeremail) && x.getUsername().equalsIgnoreCase(buyeruser)) {
	
						isfound = true;
	
					}
	
				}
	
				if (isfound == true) {
	
					Bid t1 = new Bid(dealid, buyeremail, buyeruser, i.getEmail(), i.getUsername(), i.getItemname(),
							i.getHighestprice(), i.getEnddate());
	
					deallist.add(t1);
	
					if (currentsize != deallist.size()) {
	
						isclosed = true;
						System.out.println("Deal is closed. Congrats!!");
	
					} else {
	
						System.out.println("Deal failed to closed. :(");
	
					}
	
				}
	
			}
	
		}
	
		for (int i = 0; i < itemlist.size(); i++) {
	
			if (itemlist.get(i).getItemname().equalsIgnoreCase(name)) {
	
				itemlist.remove(i);
	
			}
		}
	
		return isclosed;
	
	}

	public static String adminviewdeals() { // JUN YI 
		
		String output = "";
		
		for (int i = 0; i < deallist.size(); i++) {
			
			output += ("Bid ID: " + deallist.get(i).getBidid() + "\n");
			output += ("Item Name: " + deallist.get(i).getItemname()+ "\n");
			output += ("Item Desc: " + deallist.get(i).getItemdesc()+ "\n");
			output += ("Price: " + deallist.get(i).getHighestprice()+ "\n");
			output += ("Seller Email: " + deallist.get(i).getEmail()+ "\n");
			output += ("Seller Username: " + deallist.get(i).getUsername()+ "\n");
			output += ("Buyer Email: " + deallist.get(i).getBuyeremail()+ "\n");
			output += ("Buyer username: " + deallist.get(i).getBuyerusername()+ "\n");
			output += (""+ "\n");
			
		}
		
		return output;
	}

	public static boolean admindeletedeal() { // JUN YI 
		
		boolean isfound = false; 
		
		int findbidid = Helper.readInt("Enter Deal ID you wish to delete > ");
		
		for (int i = 0; i < deallist.size(); i++) { 
			
			if (deallist.get(i).getDealid() == findbidid) {
				
				isfound = true;
				deallist.remove(i);
				
			}
			
		}
		
		if (isfound == true) {
			
			System.out.println("Successfully deleted");
			
		} else { 
			
			System.out.println("Item failed to delete");
			
		}
		
		return isfound;
		
	}
	
	// --------------------------------------------- miscellaneous -----------------------------------------------
	
	public static void adminmanagedealmenu() {
		
		Helper.line(50, "~");
		System.out.println("MANAGE USER DEAL");
		Helper.line(50, "~");
		System.out.println("");
		System.out.println("1. View all Deals");
		System.out.println("2. Delete all Deals");
		System.out.println("");
		
	}
	
	public static void adminmanagebidmenu() {
		
		Helper.line(50, "~");
		System.out.println("MANAGE USER BIDS");
		Helper.line(50, "~");
		System.out.println("");
		System.out.println("1. View all Bids");
		System.out.println("2. Delete all Bids");
		System.out.println("");
		
	}
	
	public static String viewmyauction() {
	
		String output = "";
		Helper.line(50, "~");
		System.out.println("");
		boolean isfound = false;
	
		for (Item i : itemlist) {
	
			if (i.getEmail().equalsIgnoreCase(email)) {
	
				isfound = true;
			}
		}
		if (isfound == true) {
	
			for (Item i : itemlist) {
	
				if (i.getEmail().equalsIgnoreCase(email)) {
	
					isfound = true;
					System.out.println("");
					Helper.line(50, "-");
					output += "Name: " + i.getItemname() + "\n";
					output += "Description: " + i.getItemdesc() + "\n";
					output += "Current Price: $" + i.getCurrentprice() + "\n";
					output += "Auction Start Date: " + i.getStartdate() + "\n";
					output += "Auction End Date: " + i.getEnddate() + "\n";
					output += "Bid Increament: $" + i.getBidincreament() + "\n";
					Helper.line(50, "-");
					System.out.println("");
	
				}
	
			}
	
		} else {
	
			output = "Invalid Category inputted/ Null Values Returned ";
	
		}
	
		System.out.println(output);
	
		return output;
	
	}

	public static boolean isvalidatecat() {

		boolean isfound = false;

		for (Item i : itemlist) {

			for (String x : catlist) {

				if (i.getCategory().equalsIgnoreCase(email) && x.equalsIgnoreCase(x)) {

					isfound = true;

				}

			}

		}

		return isfound;

	}

	public static boolean admindeleteuser() {

		boolean isdeleteuser = false;

		int currentsize = userlist.size();

		Helper.line(50, "~");
		System.out.println("MODERATION");
		Helper.line(50, "~");

		System.out.println("");

		String deleteusername = Helper.readString("Enter the username you want to delete > ");
		String deleteuseremail = Helper.readString("Enter the email you want to delete > ");

		if (isdelete(deleteusername, deleteuseremail) == true) {

			if (currentsize != userlist.size()) {

				System.out.println("Delete Successful!");
				isdeleteuser = true;

			} else {

				System.out.println("Delete Failed");

			}

		} else {

			System.out.println("Delete Failed");

		}

		return isdeleteuser;
	}

	public static boolean adminblockuser() {

		boolean isblockeduser = false;

		int currentsize = blocklist.size();

		Helper.line(50, "~");
		System.out.println("MODERATION");
		Helper.line(50, "~");

		System.out.println("");

		String banusername = Helper.readString("Enter the username you want to ban > ");
		String banuseremail = Helper.readString("Enter the email you want to ban > ");
		String modemail = email;
		String banreason = Helper.readString("Enter reason: ");
		LocalDate currenttime = LocalDate.now();

		if (isbanned(banusername, banuseremail) == true) {

			Moderation m1 = new Moderation(banusername, banuseremail, modemail, banreason, currenttime);
			blocklist.add(m1);

			if (currentsize != blocklist.size()) {

				System.out.println("Successful Ban. User: " + banusername);
				isblockeduser = true;

			} else {

				System.out.println("Failed to Ban User: " + banusername);

			}

		} else {

			System.out.println("Failed to Ban User: " + banusername);

		}
		return isblockeduser;
	}

	public static boolean sellerupdateitem() {

		boolean isupdated = false;
		boolean isfound = false;
		String updateitemname = Helper.readString("Enter item name > ");

		for (Item i : itemlist) {

			if (i.getItemname().equalsIgnoreCase(updateitemname) && i.getEmail().equals(email)) {

				isfound = true;

			}
		}

		if (isfound == true) {

			System.out.println("");

			Helper.line(50, "~");
			System.out.println("Item MANAGEMENT");
			Helper.line(50, "~");

			sellerupdate();

			int option = Helper.readInt("Enter which option you want to update: ");

			for (Item i : itemlist) {

				if (i.getItemname().equalsIgnoreCase(updateitemname) && i.getEmail().equals(email)) {

					if (option == 1) {

						String itemnewname = Helper.readString("Enter new item name > ");
						i.setItemname(itemnewname);
						isupdated = true;

					} else if (option == 2) {

						String itemnewdesc = Helper.readString("Enter new item description > ");
						i.setItemdesc(itemnewdesc);
						isupdated = true;

					} else if (option == 3) {

						double itemnewbidincreament = Helper.readDouble("Enter new Bid Increament > ");
						i.setBidincreament(itemnewbidincreament);
						isupdated = true;

					} else if (option == 4) {

						String itemnewenddate = Helper.readString("Enter new item end date(yyyy-mm-dd) > ");
						LocalDate formatenddate = LocalDate.parse(itemnewenddate);
						i.setEnddate(formatenddate);
						isupdated = true;

					} else if (option == 5) {

						System.out.println("Going Back...");

					} else {

						System.out.println("Invalid option inputted!");

					}

				}

			}

			if (isupdated == true) {

				System.out.println("Successful Update");

			}

		} else {

			System.out.println("Invalid Item Name");

		}

		return isupdated;
	}

	public void settingup() {

		// Adding members

		Useracc a1 = new Useracc("Darren123", "Admin", "darrenlee@rp.com", "1234");

		Useracc s1 = new Useracc("Ali123", "Seller", "Ali@gmail.com", "1234");
		Useracc s2 = new Useracc("Dickson123", "Seller", "PJ@gmail.com", "1234");
		Useracc s3 = new Useracc("1", "Seller", "1", "1");

		Useracc b1 = new Useracc("William123", "Buyer", "William@gmail.com", "1234");
		Useracc b2 = new Useracc("Jy123", "Buyer", "Jy123@gmail.com", "1234");
		Useracc b3 = new Useracc("2", "Buyer", "2", "2");

		String date = "2022-07-31";
		Moderation m1 = new Moderation("Barney12", "Barney12@gmail.com", "darrenlee", "Being a child",
				LocalDate.parse(date));

		userlist.add(a1);
		userlist.add(b1);
		userlist.add(b2);
		userlist.add(b3);
		userlist.add(s1);
		userlist.add(s2);
		userlist.add(s3);

		blocklist.add(m1);

		// Adding Items

		Item i1 = new Item("Ali123", "Ali@gmail.com", "Metal Straw", "It is very useful. ", 18.00, LocalDate.now(),
				LocalDate.now().plusWeeks(2), 1.50, 19.50, "Household");

		Item i2 = new Item("Dickson123", "PJ@gmail.com", "Condom", "It is user friendly. ", 17.20, LocalDate.now(),
				LocalDate.now().plusDays(5), 1.00, 18.20, "Safety");

		itemlist.add(i1);
		itemlist.add(i2);

		// Adding category

		catlist.add("Household");
		catlist.add("Safety");

	}

	public static boolean acclogin() {

		Helper.line(50, "~");
		System.out.println("LOG IN");
		Helper.line(50, "~");
		System.out.println("");
		email = Helper.readString("Enter email: ");
		password = Helper.readString("Enter password: ");

		boolean isfound = false;

		for (Useracc i : userlist) {

			if (i.getEmail().equals(email) && i.getPassword().equals(password)) {

				isfound = true;
			}
		}

		return isfound;
	}

	public static boolean viewdealhistory() {

		boolean isfound = false;

		for (Bid i : bidlist) {

			isfound = true;
			System.out.println("Deal ID: " + i.getBidid());
			System.out.println("Item Name: " + i.getItemname());
			System.out.println("Seller Email: " + i.getEmail());
			System.out.println("Buyer Email: " + i.getBuyeremail());
			System.out.println("Transaction Price: " + i.getHighestprice());
			System.out.println("Close Date: " + i.getEnddate());

		}

		return isfound;
	}

	public void viewauctionbycategory() {

		String output = "";
		Helper.line(50, "~");
		System.out.println("");
		boolean isfound = false;

		String catname = Helper.readString("Enter category name > ");

		for (String x : catlist) {

			if (x.equalsIgnoreCase(catname) == true) {

				for (Item i : itemlist) {

					if (i.getCategory().equalsIgnoreCase(catname)) {

						isfound = true;

						for (Item z : itemlist) {

							if (z.getCategory().equalsIgnoreCase(catname)) {

								isfound = true;
								System.out.println("");
								Helper.line(50, "-");
								output += "Name: " + i.getItemname() + "\n";
								output += "Description: " + i.getItemdesc() + "\n";
								output += "Current Price: $" + i.getCurrentprice() + "\n";
								output += "Auction Start Date: " + i.getStartdate() + "\n";
								output += "Auction End Date: " + i.getEnddate() + "\n";
								output += "Bid Increament: $" + i.getBidincreament() + "\n";
								Helper.line(50, "-");
								System.out.println("");

							}

						}

					}
				}
			}
		}

		if (isfound != true) {

			output = "Invalid Category inputted/ Null Values Returned ";

		}

		System.out.println(output);

	}

	public static void adminmenu() {

		Helper.line(50, "~");
		System.out.println("ADMINSTRATOR MENU");
		Helper.line(50, "~");
		System.out.println("");
		System.out.println("1. Manage Bids Records");
		System.out.println("2. Manage Deals Records");
		System.out.println("3. Manage User ");
		System.out.println("4. Manage Categories");
		System.out.println("5. Exit");
		System.out.println("");

	}
	
	public static void adminmanage() {
		
		Helper.line(50, "~");
		System.out.println("MANAGE USERS");
		Helper.line(50, "~");
		
		System.out.println("1. View all Users ");
		System.out.println("2. Add Adminstrator ");
		System.out.println("3. Delete Users");
		System.out.println("4. Ban User Account");
		System.out.println("5. Exit");
		
	}

	public static void admincatmenu() {

		Helper.line(50, "~");
		System.out.println("CATEGORY MENU");
		Helper.line(50, "~");

		System.out.println("");

		System.out.println("1. Add Category");
		System.out.println("2. Delete Category");
		System.out.println("3. View Category");
		System.out.println("4. Exit");
	}

	public static void sellermenu() {

		Helper.line(50, "~");
		System.out.println("Seller Menu");
		Helper.line(50, "~");

		System.out.println("1. View Auction by Category");
		System.out.println("2. View My Auction");
		System.out.println("3. Manage My Item Auction");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

	}

	public static void sellermenusecond() {

		Helper.line(50, "~");
		System.out.println("Manage My Items");
		Helper.line(50, "~");

		System.out.println("1. Add Auction Items");
		System.out.println("2. Delete Auction Items");
		System.out.println("3. Update Auction Items");
		System.out.println("4. Closed Auction Deals");
		System.out.println("5. View All Deals");
		System.out.println("6. Exit!");

		Helper.line(50, "~");

	}

	public static void buyermenu() {

		Helper.line(50, "~");
		System.out.println("Buyer Menu");
		Helper.line(50, "~");

		System.out.println("1. View Auction by Category");
		System.out.println("2. Place Bids");
		System.out.println("3. View previous bids");
		System.out.println("4. Delete Bids");
		System.out.println("5. Exit!");

		Helper.line(50, "~");

	}

	public static void newaccmenu() {

		Helper.line(50, "~");
		System.out.println("REGISTER NEW ACCOUNT");
		Helper.line(50, "~");

		System.out.println("");

		System.out.println("1. Buyer");
		System.out.println("2. Seller");
		System.out.println("3. Exit!");

		System.out.println("");

	}

	public static void signinmenu() {

		Helper.line(50, "~");
		System.out.println("CAOS Software");
		Helper.line(50, "~");

		System.out.println("1. Sign in Account!");
		System.out.println("2. Sign up Account!");
		System.out.println("3. View all Auction Items");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

	}

	public static boolean isdelete(String username, String email) {

		boolean isdelete = false;

		for (int i = 0; i < userlist.size(); i++) {

			if (userlist.get(i).getEmail().equalsIgnoreCase(email)
					&& userlist.get(i).getUsername().equalsIgnoreCase(username)) {

				userlist.remove(i);
				isdelete = true;

			}
		}

		return isdelete;

	}

	public static boolean isbanned(String username, String email) {

		boolean isban = false;

		for (Moderation i : blocklist) {

			if (i.getUsername().equals(username) && i.getEmail().equals(email)) {

				isban = true;

			}
		}

		return isban;

	}

	public static boolean addadmin() {

		boolean successadd = false;
		boolean isfound = false;
		int currentsize = userlist.size();

		Helper.line(50, "~");
		System.out.println("REGISTER NEW ADMIN ACCOUNT");
		Helper.line(50, "~");

		System.out.println("");

		String email = Helper.readString("Enter email address > ");
		String username = Helper.readString("Enter username > ");

		for (Useracc i : userlist) {

			if (i.getEmail().equalsIgnoreCase(email) && i.getUsername().equalsIgnoreCase(username)) {

				for (Moderation x : blocklist) {

					if (x.getEmail().equalsIgnoreCase(email) && i.getUsername().equalsIgnoreCase(username)) {

						isfound = true;
						break;

					}

				}

			}
		}

		if (isfound == false) {

			boolean pwconfirm = false;

			String newpw = Helper.readString("Enter new password > ");
			String newpw1 = Helper.readString("Enter password again > ");

			if (newpw.equals(newpw1)) {

				pwconfirm = true;

			}

			if (pwconfirm = true) {

				Useracc b1 = new Useracc(username, "Admin", email, newpw);
				userlist.add(b1);

				if (currentsize != userlist.size()) {

					successadd = true;

				}

			}

		}

		return successadd;

	}

	public static void sellerupdate() {

		System.out.println("1. Item Name");
		System.out.println("2. Item Description");
		System.out.println("3. Item Bid Increament");
		System.out.println("4. Item End Date");
		System.out.println("5. Back");

	}

	public static int rolechecker(String email) {

		int role = -1;

		// Buyers : 1
		// Seller : 2
		// Admin : 3

		for (Useracc i : userlist) {

			if (i.getEmail().equals(email)) {

				if (i.getRole().equalsIgnoreCase("Buyer")) {

					role = 1;

				} else if (i.getRole().equalsIgnoreCase("Seller")) {

					role = 2;

				} else if (i.getRole().equalsIgnoreCase("Admin")) {

					role = 3;

				}

			}
		}

		return role;
	}

	public static boolean transactlog(String sellerusername, String selleremail, String itemname, double amt) {

		double setrate = 0;
		boolean isauthorise = false;
		Bid b1 = null;

		String buyerusername = Helper.readString("Enter your username: ");
		String buyeremail = Helper.readString("Enter your email: ");

		int bidid = getbidid();

		for (Useracc i : userlist) {

			if (i.getEmail().equals(buyeremail) && i.getUsername().equals(buyerusername)) {

				bidid++;

				for (Item x : itemlist) {

					if (x.getItemname().equalsIgnoreCase(itemname)) {

						b1 = new Bid(bidid, buyeremail, buyerusername, selleremail, sellerusername, itemname,
								x.getItemdesc(), amt, x.getCategory());

						System.out.println("Waiting payment confirmation...");

						int currentsize = bidlist.size();
						bidlist.add(b1);

						if (currentsize != bidlist.size()) {

							System.out.println("Transaction Approved");
							isauthorise = true;

							double newrate = Helper.readDouble("Enter your rating for the buyer out of 5 : ");
							setrate = (i.getRatings() + newrate) / 2;
							i.setRatings(setrate);

						} else {

							System.out.println("Transaction Declined");

						}

						break;

					}

				}

			}
		}

		return isauthorise;

	}

	public static int getbidid() {

		int highestbidid = 1;

		for (Bid i : bidlist) {

			if (i.getBidid() > highestbidid) {

				highestbidid = i.getBidid();

			}

		}

		return highestbidid;
	}

	public static int getdealid() {

		int highestdealid = 1;

		for (Bid i : deallist) {

			if (i.getDealid() > highestdealid)
				;

		}

		return highestdealid;

	}

}