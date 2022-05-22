package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class TestAUsingJMockit {
	@Injectable B b;
	@Tested A a;
	
	@Test
	public void testMe() {
		assertTrue(a != null);
		assertTrue(b != null);
		
		System.out.println(b.getClass().getName());
		
		new Expectations() {{
			System.out.println("foo");
			b.complicatedMethod(); result = 4;
		}};
		
		assertEquals(4, a.doOp());
		
		new Verifications() {{
			//b.complicatedMethod();
		}};
	}
}
