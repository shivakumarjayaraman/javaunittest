package testing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestAUsingMockito {
	@Mock private B b;
	@InjectMocks private A a;
	
	@Before
	public void setUp() {
		//a = new A();
		//MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testA() {
		//new Exception().printStackTrace();
		when(b.complicatedMethod()).thenReturn(3);
		assertEquals(3, a.doOp());
		verify(b, times(1)).complicatedMethod();
	}
}
