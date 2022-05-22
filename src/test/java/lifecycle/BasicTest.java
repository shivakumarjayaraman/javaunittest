package lifecycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

public class BasicTest {
	@Rule
	public CustomRule cr = new CustomRule();
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
	}
	
	@Test
	public void testOne() {
		System.out.println("Inside test 1");
		
	}
	
	@Test
	public void testTwo() {
		System.out.println("Inside test 2");
	}
	
	
	@After
	public void after() {
		System.out.println("After");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
}
