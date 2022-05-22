package lifecycle;

import org.junit.runner.RunWith;

@RunWith(MyRunner.class)
public class ShivaTest {
	
	public void doThisBefore() {
		System.out.println("DOING BEFORE ...");
	}
	
	public void shivaTest1() {
		System.out.println("Test 1");
	}
	public void shivaTest2() {
		System.out.println("Test 2");
	}
	public void testMe() {
		System.out.println("Regular test");
	}
}
