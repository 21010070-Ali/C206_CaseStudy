import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class C206_CaseStudyTest {

	// Prepare test data

	private Useracc a1;

	private Useracc b1;
	private Useracc b2;

	private Useracc s1;
	private Useracc s2;

	private Moderation m1;

	private ArrayList<Useracc> userlist;
	private ArrayList<Item> itemlist;
	private ArrayList<String> catlist;
	private ArrayList<Moderation> blocklist;
	private ArrayList<Bid> bidlist;

	public C206_CaseStudyTest() {

		super();
	}

	@Before
	public void setUp() throws Exception {

		a1 = new Useracc("Darren123", "Admin", "darrenlee@rp.com", "1234");

		s1 = new Useracc("Ali123", "Seller", "Ali@gmail.com", "1234");
		s2 = new Useracc("Dickson123", "Seller", "PJ@gmail.com", "1234");

		b1 = new Useracc("William123", "Buyer", "William@gmail.com", "1234");
		b2 = new Useracc("Jy123", "Buyer", "Jy123@gmail.com", "1234");

		String date = "2022-07-31";
		m1 = new Moderation("Barney12", "Barney12@gmail.com", "darrenlee", "Being a child", LocalDate.parse(date));

		userlist = new ArrayList<Useracc>();
		itemlist = new ArrayList<Item>();
		catlist = new ArrayList<String>();
		blocklist = new ArrayList<Moderation>();
		bidlist = new ArrayList<Bid>();

	}

	// Peng Jie test
	@Test
	public void testviewAll() {

		// viewall not null
		assertNotNull(CAOS.viewAll());

		// test if the list of items from CAOS is not empty
		String allitem = CAOS.viewAll();
		String testOutput = "";
		assertNotEquals("Check that viewAll", testOutput, allitem);
	}

	@Test
	public void testselleraddnewitem() {
		boolean itemsize = CAOS.selleraddnewitem();
		String testOutput = "";
		// Test if it is possible to add item if account is invalid
		assertFalse(itemsize);
	}

	@Test
	public void testsellerdeleteitem() {
		boolean itemdelete = CAOS.sellerdeleteitem();
		String testOutput = "";
		assertTrue(CAOS.sellerdeleteitem());
	}

	// Darren test
	@Test
	public void testaddingselleracc() {

		// Test if userlist arraylist returns new seller account
		assertNotNull("Test if there is valid user arraylist to add to", userlist);

		// Test is account can be added to user arraylist
		boolean accaddseller = CAOS.addingselleracc();
		String testOutput = "";
		assertFalse(accaddseller);
	}

	@Test
	public void testaddingbuyeracc() {
		// Test if userlist arraylist returns new buyer account
		assertNotNull("Test if there is valid user arraylist to add to", userlist);

		// Test is account can be added to user arraylist
		boolean accaddbuyer = CAOS.addingbuyeracc();
		String testOutput = "";
		assertFalse(accaddbuyer);
	}

	@Test
	public void testviewalluseradmin() {

		// Test if viewalluseradmin not null
		assertNotNull(CAOS.viewalluseradmin());

		// test if the list of items from CAOS is not empty
		boolean alladmin = CAOS.viewalluseradmin();
		String testOutput = "";
		assertNotEquals("Check that viewuseradmin", testOutput, alladmin);
	}

	// Ali test
	@Test
	public void testaddallcat() {
		// Test if category arraylist returns not null
		assertNotNull("Test if there is valid user arraylist to add to", catlist);

		// Test if new category can be added to arraylist
		boolean addcat = CAOS.addallcat();
		String testOutput = "";
		assertFalse(addcat);
	}

	@Test
	public void testviewallcat() {

		// Test if viewallcat not null
		assertNotNull(CAOS.viewallcat());

		// test if all category is not empty
		boolean allcat = CAOS.viewallcat();
		String testOutput = "";
		assertNotEquals("Check that viewuseradmin", testOutput, allcat);
	}

	@Test
	public void testdeletecat() {

		// normal
		CAOS.deletecat();
		boolean isReturned = CAOS.deletecat();
		assertTrue("Check that item delete - true", isReturned);

		// error
		isReturned = CAOS.deletecat();
		assertFalse("Check that category delete - false?", isReturned);
	}

	// Junyi Test
	@Test
	public void testsellercloseddeal() {

		// Write your code here
		assertNotNull("Test if there is valid bidlist arraylist to add to", bidlist);
		CAOS.sellerclosedeal();

		// error
		Boolean isReturned = CAOS.sellerclosedeal();
		assertFalse("Test if deal is not close -false?", isReturned);

		// normal
		CAOS.selleraddnewitem();
		isReturned = CAOS.sellerclosedeal();
		assertTrue("Test if closed deal- true", isReturned);

		// error
		isReturned = CAOS.selleraddnewitem();
		assertFalse("Test if non-existing amcorder CC0013 is returned - false?", isReturned);

	}

	@Test
	public void testadmindeletedeal() {

		// normal
		CAOS.admindeletebid();
		boolean isReturned = CAOS.sellerdeleteitem();
		assertTrue("Check that item delete - true", isReturned);

		// error
		isReturned = CAOS.sellerdeleteitem();
		assertFalse("Check that item delete - false?", isReturned);

	}

	@Test
	public void testadminviewdeals() {
		// Test if adminviewdeals not null
		assertNotNull(CAOS.adminviewdeals());

		// test if all transaction returned is not empty
		String alldeals = CAOS.adminviewdeals();
		String testOutput = "";
		assertNotEquals("Check that adminviewdeals", testOutput, alldeals);
	}

	// William test
	@Test
	public void testadmindeletebid() {

		// normal
		CAOS.admindeletebid();
		boolean isReturned = CAOS.admindeletebid();
		assertTrue("Check that item delete - true", isReturned);

		// error
		isReturned = CAOS.sellerdeleteitem();
		assertFalse("Check that item delete - false?", isReturned);

	}

	@Test
	public void testplacebidsbuyers() {

		// normal
		CAOS.placebidsbuyers();

		boolean isReturned = CAOS.admindeletebid();
		assertTrue("Check that item delete - true", isReturned);

		// error
		isReturned = CAOS.sellerdeleteitem();
		assertFalse("Check that item delete - false?", isReturned);

	}

	@Test
	public void testviewtransac() {
		// Test if viewtransac not null
		assertNotNull(CAOS.viewtransac());

		// test if all transaction returned is not empty
		String alltransac = CAOS.viewtransac();
		String testOutput = "";
		assertNotEquals("Check that viewuseradmin", testOutput, alltransac);
	}

	@After
	public void tearDown() throws Exception {

		a1 = null;
		s1 = null;
		s2 = null;
		b1 = null;
		b2 = null;
		userlist = null;
		itemlist = null;
		catlist = null;
		blocklist = null;
		bidlist = null;

	}

}