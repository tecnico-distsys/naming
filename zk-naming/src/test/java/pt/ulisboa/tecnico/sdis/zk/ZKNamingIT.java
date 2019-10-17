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
		zkNaming.unbind(TEST_PATH, TEST_URI);
		zkNaming = null;
	}
	
	// tests 
	
	@Test
	public void testBindLookup() throws Exception {
		
		// publish
		zkNaming.bind(TEST_PATH, TEST_URI);
		
		//query
		ZKRecord outputRecord = zkNaming.lookup(TEST_PATH);
		assertNotNull(outputRecord);
		
		assertEquals(TEST_URI, outputRecord.getURI());
				
	}
	
	//TODO
}
