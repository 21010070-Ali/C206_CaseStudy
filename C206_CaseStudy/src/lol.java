/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 1 Aug 2022 9:11:25 am
 */


import java.io.*;

/**
 * @author 21013223
 *
 */
public class lol {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

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

			}

			return isauthorise;

		}
		
		
	}

}
