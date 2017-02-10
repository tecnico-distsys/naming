package pt.ulisboa.tecnico.sdis.ws.uddi;

import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;


public class BaseIT {

	private static final String TEST_PROP_FILE = "/test.properties";
	protected static Properties TEST_PROPS;

	@BeforeClass
	public static void oneTimeSetup() throws IOException {
		TEST_PROPS = new Properties();
		try {
			TEST_PROPS.load(BaseIT.class.getResourceAsStream(TEST_PROP_FILE));
			System.out.println("Loaded test properties:");
			System.out.println(TEST_PROPS);
		} catch (IOException e) {
			final String msg = String.format(
					"Could not load properties file {}", TEST_PROP_FILE);
			System.out.println(msg);
			throw e;
		}
	}

	@AfterClass
	public static void cleanup() {
	}

}
