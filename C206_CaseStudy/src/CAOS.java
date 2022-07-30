/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 5:04:09 pm
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CAOS {

	ArrayList<String> catlist = new ArrayList<String>();
	ArrayList<Item> itemlist = new ArrayList<Item>();
	ArrayList<Useracc> userlist = new ArrayList<Useracc>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CAOS c1 = new CAOS();
		c1.start();

	}

	public void start() {

		settingup();

		int firstoption = -1;
		int buyersoption = -1;

		while (firstoption != 3) {

			if (signinmenu() == 1) {

				Helper.line(50, "~");
				System.out.println("LOG IN");
				Helper.line(50, "~");
				System.out.println("");
				String email = Helper.readString("Enter email: ");
				String password = Helper.readString("Enter password: ");

				if (login(email, password) == true) {

					if (rolechecker(email) == 1) { // checker role0

						while (buyersoption != 4) {
							
							buyermenu();
							
							buyersoption = Helper.readInt("Enter option : ");

							if (buyersoption == 1)  {

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

							} else if (buyersoption == 2) {

								double bidprice = 0;
								boolean itemfound = false;
								String itemoutput = "";
								String itembidsearch = "";

								for (Item i : itemlist) {

									itemoutput += i.getItemname() + " | $" + i.getHighestprice() + " | ";

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
											System.out.println("Seller Email: " + i.getRatings());
											System.out.println("");

											bidprice = i.getHighestprice() + i.getBidincreament();

											char authorise = Helper.readChar("Do you want to bid for " + i.getItemname()
													+ " at a price of" + "  $" + bidprice + " ? (Y/N)");

											if (authorise == 'Y' || authorise == 'y') {

												if (transaclog(i.getUsername(), i.getEmail(), i.getItemname(),
														bidprice) == true) {

													i.setHighestprice(bidprice);

												}
											}

										}
									}

								}

							}

						}

					}

				} else {

					System.out.println("Invalid email/password entered.\n");

				}

			}

		}

	}

	public void settingup() {

		// Adding members

		Useracc a1 = new Useracc("Darren123", "Admin", "darrenlee@rp.com", "1234");

		Useracc s1 = new Useracc("Ali123", "Seller", "Ali@gmail.com", "1234");
		Useracc s2 = new Useracc("Dickson123", "Seller", "PJ@gmail.com", "1234");

		Useracc b1 = new Useracc("William123", "Buyer", "William@gmail.com", "1234");
		Useracc b2 = new Useracc("Jy123", "Buyer", "Jy123@gmail.com", "1234");

		userlist.add(a1);
		userlist.add(b1);
		userlist.add(b2);
		userlist.add(s1);
		userlist.add(s2);

		// Adding Items

		Item i1 = new Item("Ali123", "Ali@gmail.com", "Metal Straw", "It is very useful. ", 18.00, LocalDate.now(),
				LocalDate.now().plusWeeks(2), 1.50, 19.50, "Household");

		Item i2 = new Item("Dickson123", "PJ@gmail.com", "Petrol", "It is eco. ", 17.20, LocalDate.now(),
				LocalDate.now().plusDays(5), 1.00, 18.20, "Motor Vehicles");

		itemlist.add(i1);
		itemlist.add(i2);

		// Adding category

		catlist.add("Household");
		catlist.add("Motor Vehicles");

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
		System.out.println("3. Exit!");

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

	public void viewAll() {

		System.out.println("");

		Helper.line(50, "~");
		System.out.println("All Auctionable Items");
		Helper.line(50, "~");

		int count = 0;

		for (Item i : itemlist) {
			count++;
			System.out.println("");

			System.out.println("Item Details " + i);
			System.out.println("Name: " + i.getItemname());
			System.out.println("Description: " + i.getItemdesc());
			System.out.println("Current Price: $" + i.getCurrentprice());
			System.out.println("Auction Start Date: " + i.getStartdate());
			System.out.println("Auction End Date: " + i.getEnddate());
			System.out.println("Bid Increament: " + i.getBidincreament());

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

			bw.write(output);
			bw.close();

			System.out.println("Payment Successful!");

			isauthorise = true;

		} catch (IOException io) {

			System.out.println("There was an error connecting to the payment server.");

		}

		return isauthorise;
	}

}
