import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    m1 = new Moderation("Barney12", "Barney12@gmail.com", "darrenlee", "Being a child",
        LocalDate.parse(date));
    
    userlist = new ArrayList<Useracc>();
    itemlist = new ArrayList<Item>();
    catlist = new ArrayList<String>();
    blocklist = new ArrayList<Moderation>();
    bidlist = new ArrayList<Bid>();
    
  }
  
  @Test
  public void testviewAll() {
    
    // viewall not null 
    assertNotNull(CAOS.viewAll());
    
    //test if the list of items from CAOS is not empty
  	String allitem = CAOS.viewAll();
  	String testOutput = "";
  	assertNotEquals("Check that viewAll", testOutput, allitem);
  	
  
    
    
    
    
    
    
    
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

  @Test
  public void c206_test() {
    //fail("Not yet implemented"); 
    assertTrue("C206_CaseStudy_SampleTest ",true);
  }

}