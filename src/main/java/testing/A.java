package testing;

public class A {
	B myB;
	public A(B b) {
		this.myB = b;
	}
	
	public int doOp() {
		System.out.println("bar");
		return myB.complicatedMethod();
	}
}
