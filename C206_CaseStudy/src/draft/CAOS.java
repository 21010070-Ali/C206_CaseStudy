/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 5:04:09 pm
 */

package draft;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CAOS {

	ArrayList<String> catlist = new ArrayList<String>();
	ArrayList<Item> itemlist = new ArrayList<Item>();
	ArrayList<Useracc> userlist = new ArrayList<Useracc>();
	ArrayList<Moderation> blocklist = new ArrayList<Moderation>();

	private String email;
	private String password;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CAOS c1 = new CAOS();
		c1.start();

	}

	public void start() {

		settingup();

		int buyersoption = -1;
		int sellerfirstopt = -1;
		int mainopt = -1;

		while (mainopt != 4) {

			mainopt = signinmenu();
			
			if (mainopt == 1) {

				Helper.line(50, "~");
				System.out.println("LOG IN");
				Helper.line(50, "~");
				System.out.println("");
				email = Helper.readString("Enter email: ");
				password = Helper.readString("Enter password: ");

				if (login(email, password) == true) {

					if (rolechecker(email) == 1) { // checker role0

						while (buyersoption != 4) {

							buyermenu();

							buyersoption = Helper.readInt("Enter option : ");

							buyersopt(buyersoption);

						}

					} else if (rolechecker(email) == 2) {

						while (sellerfirstopt != 4) {

							sellermenu();
							sellerfirstopt = Helper.readInt("Enter option: ");

							sellersopt(sellerfirstopt);

						}

					} else if (rolechecker(email) == 3) {
						
						int adminmenu = -1;
						
						while (adminmenu != 5) {
							
							adminmenu();
							
							adminmenu = Helper.readInt("Enter option > ");
							
							if (adminmenu == 1) {
								
								viewtransac();
								
							} else if (adminmenu == 2) {
								
								if (addadmin() == true) {
									
									System.out.println("Successful Added! Welcome to CAOS Family ");
									
								} else { 
									
									System.out.println("Username/Email is Duplicated/Blocked");
								}
								
							} else if (adminmenu == 3) {
								
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
									
									if(currentsize != blocklist.size()) {
										
										System.out.println("Successful Ban. User: " + banusername);
										
									} else { 
										
										System.out.println("Failed to Ban User: " + banusername);
										
									}
									
								} else { 
									
									System.out.println("Failed to Ban User: " + banusername);
									
								}
								
							} else if (adminmenu == 4) {
								
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
										
									} else { 
										
										System.out.println("Delete Failed");
										
									}
									
								} else { 
									
									System.out.println("Delete Failed");
									
								}
								
							}

	
						}
						
					}

				} else {

					System.out.println("Invalid email/password entered.\n");

				}

			} else if (mainopt == 2) {

				int accregopt = newaccmenu();
				
				String newemail = Helper.readString("Enter email address > ");
				String newusername = Helper.readString("Enter username > ");

				if (accregopt == 1) {

					if (buyermenu(newemail, newusername) == true) {

						System.out.println("Successful Added! Welcome to CAOS Family " + newusername);
						System.out.println("Please relogin. ");

					} else { 
						
						System.out.println("Username/Email Duplicated");
					}

				} else if (accregopt == 2) {
					
					if (sellermenu(newemail, newusername) == true) {
						
						System.out.println("Successful Added! Welcome to CAOS Family " + newusername);
						System.out.println("Please relogin. ");
						
					} else { 
						
						System.out.println("Username/Email Duplicated");
					}
					
				} else if (accregopt == 3) {
					
					System.out.println("Exiting Registration");
					
				} else { 
					
					System.out.println("Invalid user input.");
					
				}

			} else if (mainopt == 3) {
				
				viewAll();
				
			} else if (mainopt == 4) {
				
				System.out.println("Thanks for using CAOS Software");
				
			} else { 
				
				System.out.println("Invalid user input");
			}

		}

	}
	
	public boolean isdelete(String username, String email) {
		
		boolean isdelete = false;
		
		for (int i = 0; i < userlist.size(); i++) {
			
			if (userlist.get(i).getEmail().equalsIgnoreCase(email) && userlist.get(i).getUsername().equalsIgnoreCase(username)) {
				
				userlist.remove(i);
				isdelete = true;
				
			}
		}
		
		return isdelete;
		
	}
	
	public boolean isbanned(String username, String email) {
		
		boolean isban = false;
		
		for (Moderation i : blocklist) {
			
			if (i.getUsername().equals(username) && i.getEmail().equals(email)) {
				
				isban = true;
				
			}
		}
		
		return isban;
		
	}
	
	public boolean addadmin() {
		
		boolean successadd = false;
		boolean isfound = true;
		int currentsize = userlist.size();
		
		Helper.line(50, "~");
		System.out.println("REGISTER NEW ACCOUNT");
		Helper.line(50, "~");

		System.out.println("");
		
		String email = Helper.readString("Enter email address > ");
		String username = Helper.readString("Enter username > ");
		
		for (Useracc i : userlist) {

			if (i.getEmail().equalsIgnoreCase(email) && i.getUsername().equalsIgnoreCase(username) ) {
				
				for (Moderation x : blocklist) {
					
					if (x.getEmail().equalsIgnoreCase(email) && i.getUsername().equalsIgnoreCase(username)) {
						
						isfound = true;
						break;
						
					}	
					
				}
				
			} else { 
				
				isfound = false; 
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
	
	public void viewtransac() {
		
		try { 
		
			File file = new File("transaction.txt");
			Scanner sc = new Scanner(file);
		
			while (sc.hasNextLine()) {

				System.out.println(sc.nextLine());

			}

			sc.close();

		} catch (FileNotFoundException e) {

			System.out.println("The file could not be found :(");
			e.printStackTrace();

		}
	}
	
	public void adminmenu() {
		
		Helper.line(50, "~");
		System.out.println("ADMINSTRATOR MENU");
		Helper.line(50, "~");
		System.out.println("");
		System.out.println("1. View Transaction Records");
		System.out.println("2. Add Adminstrator");
		System.out.println("3. Ban User Account");
		System.out.println("4. Delete User Account");
		System.out.println("5. Exit");
		System.out.println("");
		
	}
	
	public boolean sellermenu(String newemail, String newusername) {
		
		boolean successadd = false;
		boolean isfound = true;
		int currentsize = userlist.size();

		for (Useracc i : userlist) {

			if (i.getEmail().equalsIgnoreCase(newemail) && i.getUsername().equalsIgnoreCase(newusername)) {
				
				for (Moderation x : blocklist) {
					
					if (x.getEmail().equalsIgnoreCase(newemail) && i.getUsername().equalsIgnoreCase(newusername)) {
						
						isfound = true;
						break;
						
					}
				}

			} else { 
				
				isfound = false; 
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

				Useracc b1 = new Useracc(newusername, "Seller", newemail, newpw);
				userlist.add(b1);

				if (currentsize != userlist.size()) {

					successadd = true;

				}

			}

		} 

		return successadd;

		
		
	}

	public boolean buyermenu(String newemail, String newusername) {

		boolean successadd = false;
		boolean isfound = true;
		int currentsize = userlist.size();

		for (Useracc i : userlist) {

			if (i.getEmail().equalsIgnoreCase(newemail) && i.getUsername().equalsIgnoreCase(newusername) ) {
				
				for (Moderation x : blocklist) {
					
					if (x.getEmail().equalsIgnoreCase(newemail) && i.getUsername().equalsIgnoreCase(newusername)) {
						
						isfound = true;
						break;
						
					}
					
				}
				
			} else { 
				
				isfound = false; 
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

				Useracc b1 = new Useracc(newusername, "Buyer", newemail, newpw);
				userlist.add(b1);

				if (currentsize != userlist.size()) {

					successadd = true;

				}

			}

		} 

		return successadd;

	}

	public int newaccmenu() {

		Helper.line(50, "~");
		System.out.println("REGISTER NEW ACCOUNT");
		Helper.line(50, "~");

		System.out.println("");

		System.out.println("1. Buyer");
		System.out.println("2. Seller");
		System.out.println("3. Exit!");

		System.out.println("");

		int option = Helper.readInt("Enter option > ");

		return option;
	}

	public void sellersopt(int sellerfirstopt) {

		if (sellerfirstopt == 1) {

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

						}
					}
				}
			}

			if (isfound == true) {

				for (Item i : itemlist) {

					if (i.getCategory().equalsIgnoreCase(catname)) {

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

		} else if (sellerfirstopt == 2) {

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

		} else if (sellerfirstopt == 3) {

			int sellersecondopt = -1;
			sellermenusecond();

			sellersecondopt = Helper.readInt("Enter option > ");

			if (sellersecondopt == 1) {

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

						Item or = new Item(selleruser, sellerpassword, selleremail, newitemname, newitemdesc,
								newstartprice, formatstartdate, formatenddate, bidincreament, newcat1, sellerrole);

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

			} else if (sellersecondopt == 2) {

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

			} else if (sellersecondopt == 3) {

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
			}

		}

	}

	public void buyersopt(int buyersoption) {

		if (buyersoption == 1) {

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

						}
					}
				}
			}

			if (isfound == true) {

				for (Item i : itemlist) {

					if (i.getCategory().equalsIgnoreCase(catname)) {

						isfound = true;
						System.out.println("");
						Helper.line(50, "-");
						output += "Name: " + i.getItemname() + "\n";
						output += "Description: " + i.getItemdesc() + "\n";
						output += "Current Price: $" + i.getHighestprice() + "\n";
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

		} else if (buyersoption == 2) {

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

			while (itemfound != true) {

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
						System.out.println("");

						bidprice = i.getHighestprice() + i.getBidincreament();

						char authorise = Helper.readChar("Do you want to bid for " + i.getItemname() + " at a price of"
								+ "  $" + bidprice + " ? (Y/N)");

						if (authorise == 'Y' || authorise == 'y') {

							if (transaclog(i.getUsername(), i.getEmail(), i.getItemname(), bidprice) == true) {

								i.setHighestprice(bidprice);

							}
						}

					}
				}

			}

		} else if (buyersoption == 3) {

			try {

				File file = new File("transaction.txt");
				Scanner sc = new Scanner(file);

				while (sc.hasNextLine()) {

					System.out.println(sc.nextLine());

				}

				sc.close();

			} catch (FileNotFoundException e) {

				System.out.println("The file could not be found :(");
				e.printStackTrace();

			}

		} else if (buyersoption == 4) {

			System.out.println("Logging out...");

		} else {

			System.out.println("Invalid option input");

		}

	}

	public void settingup() {

		// Adding members

		Useracc a1 = new Useracc("Darren123", "Admin", "darrenlee@rp.com", "1234");

		Useracc s1 = new Useracc("Ali123", "Seller", "Ali@gmail.com", "1234");
		Useracc s2 = new Useracc("Dickson123", "Seller", "PJ@gmail.com", "1234");

		Useracc b1 = new Useracc("William123", "Buyer", "William@gmail.com", "1234");
		Useracc b2 = new Useracc("Jy123", "Buyer", "Jy123@gmail.com", "1234");
		
		String date = "2022-07-31";
		Moderation m1 = new Moderation("Barney12", "Barney12@gmail.com", "darrenlee", "Being a child", LocalDate.parse(date));

		userlist.add(a1);
		userlist.add(b1);
		userlist.add(b2);
		userlist.add(s1);
		userlist.add(s2);
		
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

	public void sellerupdate() {

		System.out.println("1. Item Name");
		System.out.println("2. Item Description");
		System.out.println("3. Item Bid Increament");
		System.out.println("4. Item End Date");
		System.out.println("5. Back");

	}

	public int rolechecker(String email) {

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

	public int signinmenu() {

		int firstoption = -1;

		Helper.line(50, "~");
		System.out.println("CAOS Software");
		Helper.line(50, "~");

		System.out.println("1. Sign in Account!");
		System.out.println("2. Sign up Account!");
		System.out.println("3. View all Auction Items");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

		firstoption = Helper.readInt("Enter option : ");

		return firstoption;

	}

	public void buyermenu() {

		Helper.line(50, "~");
		System.out.println("Buyer Menu");
		Helper.line(50, "~");

		System.out.println("1. View Auction by Category");
		System.out.println("2. Place Bids");
		System.out.println("3. View previous bids");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

	}

	public void sellermenu() {

		Helper.line(50, "~");
		System.out.println("Seller Menu");
		Helper.line(50, "~");

		System.out.println("1. View Auction by Category");
		System.out.println("2. View My Auction");
		System.out.println("3. Manage My Item Auction");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

	}

	public void sellermenusecond() {

		Helper.line(50, "~");
		System.out.println("Manage My Items");
		Helper.line(50, "~");

		System.out.println("1. Add Auction Items");
		System.out.println("2. Delete Auction Items");
		System.out.println("3. Update Auction Items");
		System.out.println("4. Exit!");

		Helper.line(50, "~");

	}

	public void viewAll() {

		System.out.println("");

		Helper.line(50, "~");
		System.out.println("All Auctionable Items");
		Helper.line(50, "~");

		int count = 0;

		for (Item i : itemlist) {
			count++;
			System.out.println("");

			System.out.println("Name: " + i.getItemname());
			System.out.println("Description: " + i.getItemdesc());
			System.out.println("Current Price: $" + i.getCurrentprice());
			System.out.println("Auction Start Date: " + i.getStartdate());
			System.out.println("Auction End Date: " + i.getEnddate());
			System.out.println("Bid Increament: " + i.getBidincreament() + "\n");

		}

		System.out.println("Total Number of auctionable items: " + count);
	}

	public boolean login(String email, String password) {

		boolean isfound = false;

		for (Useracc i : userlist) {

			if (i.getEmail().equals(email) && i.getPassword().equals(password)) {

				isfound = true;

			}

		}

		return isfound;

	}

	public boolean transaclog(String sellerusername, String selleremail, String itemname, double amt) {

		String output = "";
		int bidid = 0;
		boolean isfound = false;
		boolean isauthorise = false;
		String buyerusername = Helper.readString("Enter your username: ");
		String buyeremail = Helper.readString("Enter your email: ");

		for (Useracc i : userlist) {

			if (i.getEmail().equals(buyeremail) && i.getUsername().equals(buyerusername)) {

				isfound = true;

			}
		}

		if (isfound == true) {

			bidid++;
			output += "Bid ID: " + bidid + "\n";
			output += "Item Name: " + itemname + "\n";
			output += "Seller Username: " + sellerusername + "\n";
			output += "Seller Email: " + selleremail + "\n";
			output += "Buyer Username: " + buyerusername + "\n";
			output += "Buyer Email: " + buyeremail + "\n";
			output += "Total Price: " + amt + "\n";

		}

		System.out.println("Waiting for payment confirmation...");

		try {

			File file = new File("transaction.txt");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(output + "\n");
			bw.close();

			System.out.println("Payment Successful!");

			isauthorise = true;

		} catch (IOException io) {

			System.out.println("There was an error connecting to the payment server.");

		}

		return isauthorise;

	}

	public boolean viewcat(String catname) {

		boolean isfound = false;

		for (int i = 0; i < catlist.size(); i++) {

			if (catlist.get(i).equalsIgnoreCase(catname)) {

				isfound = true;
			}

		}

		Helper.line(50, "~");

		return isfound;
	}

}
