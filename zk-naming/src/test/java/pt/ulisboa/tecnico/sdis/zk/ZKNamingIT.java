package pt.ulisboa.tecnico.sdis.zk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Integration Tests
 * 
 * @author Rui Claro
 *
 */
public class ZKNamingIT extends BaseIT {
	
	// static members
	static final String TEST_PATH = "/TestServiceName";
	static final String TEST_PATH_CHILD = "/TestService/TestChild";
	static final String TEST_URI = "host:port";

	static final String TEST_PATH_WILDCARD = TEST_PATH.substring(0, 14) + "%";
	
	// one-time initialization and clean-up
	@BeforeClass
	public static void oneTimeSetUp() {
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
	}
	
	private ZKNaming zkNaming;
	
	
	// initialization and clean-up for each test
	
	@Before
	public void setUp() {
		zkNaming = new ZKNaming(testProps.getProperty("zk.host"), testProps.getProperty("zk.port"));
	}
	
	@After
	public void tearDown() throws Exception{
		zkNaming = null;
	}
	
	// tests 
	
	public void tearDownUnbind() throws ZKNamingException {
		zkNaming.unbind(TEST_PATH, TEST_URI);
	}
	public void tearDownUnbindChild() throws ZKNamingException  {
		zkNaming.unbind(TEST_PATH_CHILD, TEST_URI);
	}
	
	@Test
	public void testRebindLookup() throws Exception {
		
		// publish
		zkNaming.rebind(TEST_PATH, TEST_URI);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH);
		assertNotNull(outputRecord);
		
		assertEquals(TEST_URI, outputRecord.getURI());
		assertEquals(TEST_PATH, outputRecord.getPath());
		tearDownUnbind();
	}
	
	@Test
	public void testBindLookup() throws Exception {
		zkNaming.rebind(TEST_PATH, TEST_URI);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH);
		assertNotNull(outputRecord);
		
		assertEquals(TEST_URI, outputRecord.getURI());
		assertEquals(TEST_PATH, outputRecord.getPath());

		tearDownUnbind();
	}
	
	@Test
	public void testBindLookupChild() throws Exception {
		
		zkNaming.bind(TEST_PATH_CHILD,TEST_URI);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH_CHILD);
		assertNotNull(outputRecord);
		
		assertEquals(TEST_URI, outputRecord.getURI());
		assertEquals(TEST_PATH_CHILD, outputRecord.getPath());

		tearDownUnbindChild();
	}
	
	@Test
	public void testRebindLookupChild() throws Exception {
		
		zkNaming.rebind(TEST_PATH_CHILD,TEST_URI);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH_CHILD);
		assertNotNull(outputRecord);
		
		assertEquals(TEST_URI, outputRecord.getURI());
		assertEquals(TEST_PATH_CHILD, outputRecord.getPath());

		tearDownUnbindChild();
	}
	
	@Test
	public void testRebindLookupRecord() throws Exception {
		
		ZKRecord rec = new ZKRecord(TEST_PATH_CHILD, TEST_URI);
		zkNaming.rebind(rec);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH_CHILD);
		assertNotNull(outputRecord);
		
		assertEquals(rec, outputRecord);
		assertEquals(TEST_PATH_CHILD, outputRecord.getPath());

		tearDownUnbindChild();

	}
	
	
	//TODO test LIST and UNBIND ALL
	
	
	
	
	
	
	
	
}
