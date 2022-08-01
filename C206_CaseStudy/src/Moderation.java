/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21013223, 31 Jul 2022 2:53:47 pm
 */


/**
 * @author 21013223
 *
 */

import java.time.LocalDate;

public class Moderation extends Useracc{
	
	private LocalDate localdate;
	private String reason;
	private String moderator;
	
	public Moderation(String username, String email, String moderator, String reason, LocalDate localdate) {
		
		super(username, email);
		this.moderator = moderator;
		this.reason = reason;
		
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getModerator() {
		return moderator;
	}

	public void setModerator(String moderator) {
		this.moderator = moderator;
	}
	

}
