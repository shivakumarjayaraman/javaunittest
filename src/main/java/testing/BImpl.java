package testing;

public class BImpl implements B {
	public int complicatedMethod() {
		try { Thread.sleep(10000); } catch (Exception e) {}
		return 3;
	}
}
