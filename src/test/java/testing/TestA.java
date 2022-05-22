package testing;

import static org.junit.Assert.assertEquals;


import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

import org.junit.Test;

public class TestA {
	@Test
	public void testMe() {
		B b = createMock("mockB", B.class);
		A a = new A(b);
		
		expect(b.complicatedMethod()).andReturn(3);
		replay(b);
		assertEquals(3, a.doOp());
		
		
		verify(b);
	}
}
