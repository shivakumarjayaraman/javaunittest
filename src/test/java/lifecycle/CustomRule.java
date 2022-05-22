package lifecycle;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRule implements TestRule {
	@Override
	public Statement apply( Statement base,  Description description) {
		System.out.println("Creating rule with " + base + " and " + description);
		
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				System.out.println("GOING TO EVALUATE");
				
				base.evaluate();
				System.out.println("FINISHED EVALUATING");
			}
		};
	}

}
