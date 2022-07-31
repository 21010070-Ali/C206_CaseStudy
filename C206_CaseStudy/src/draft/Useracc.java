/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 30 Jul 2022 3:35:55 pm
 */

package draft;

/**
 * @author 21013223
 * 
 *
 */
public class Useracc {
	
	private String username;
	private String password;
	private String email;
	private String role;
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	private double ratings; 
	
	// buyer 
	
	public Useracc(String username, String role, String email , String password) { // Buyer  & Admin
		
		this.username = username;
		this.role = role;
		this.password = password;
		this.email = email;
		
	}
	
	public Useracc(String username, String email) { // base item 
		
		this.username = username;
		this.password = "";
		this.email = email ;
		this.ratings = 0.0;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}


}
