package lifecycle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class MyRunner extends Runner {

	private Class<?> testedClass;
	private List<Method>testMethods = new ArrayList<>();
	private List<Description>testDescriptions = new ArrayList<>();
	private Description suiteD;
	private Method setUpMethod = null;


	public MyRunner(Class testedClass) {
		this.testedClass = testedClass;
		Method [] methods = testedClass.getMethods();

		suiteD = Description.createSuiteDescription(testedClass);
		for (Method m : methods) {
			if (m.getName().startsWith("shiva")) {
				testMethods.add(m);
				Description d = Description.createTestDescription(testedClass, m.getName());
				testDescriptions.add(d);
				suiteD.addChild(d);
			}
		}
		
		try {
			Method setUpMethod = testedClass.getMethod("doThisBefore");
		} catch (NoSuchMethodException ne) {}
	}

	@Override
	public Description getDescription() {
		return suiteD;
	}

	@Override
	public void run(RunNotifier notifier) {
		for (int i = 0; i < testMethods.size(); i++) {
			System.out.println("Testing method " + testMethods.get(i).getName());
			Object instance = null;
			try {
				instance = testedClass.newInstance();
				notifier.fireTestStarted(testDescriptions.get(i));
				if (setUpMethod != null) {
					setUpMethod.invoke(instance);
				}
				testMethods.get(i).invoke(instance);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				notifier.fireTestFinished(testDescriptions.get(i));
			}
		}
	}

}
