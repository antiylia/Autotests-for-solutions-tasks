package by.htp.exercise;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstTaskTesting {

	private FirstTask firstTask;
	private List<Integer> list;
	private Set<Integer> resultList;

	static final Logger userLogger = LogManager.getLogger(FirstTaskTesting.class.getSimpleName());
	static final Logger rootLogger = LogManager.getRootLogger();

	@BeforeClass
	public void init() {
		userLogger.info("Initialiazation...");
		firstTask = new FirstTask();
		list = new ArrayList<Integer>();
		list.add(234444);
		list.add(234444);
		list.add(2522);
		list.add(20);
		list.add(2522);
	}

	@Test(priority = 0)
	public void listIsFiltered() {
		resultList = firstTask.filterList(list);

		Integer[] arrayFirst = list.toArray(new Integer[list.size()]);
		Integer[] arrayResult = resultList.toArray(new Integer[resultList.size()]);

		userLogger.info("Filtered list is correct " + (!arrayFirst.equals(arrayResult)));

		assertNotEquals(arrayFirst, arrayResult);
	}

	@Test(priority = 1, expectedExceptions = IllegalArgumentException.class)
	public void filterListException() {
		try {
			resultList = firstTask.filterList(null);
		} catch (IllegalArgumentException e) {
			userLogger.error(e);
			throw new IllegalArgumentException();
		}
	}

	@DataProvider(name = "Strings with Dublicates")
	public static Object[][] getClient1Data() {
		return new Object[][] { { "qwertyuiop" }, { "qdfqwertyuiop" }, { "qqqqqqq" } };
	}

	@Test(priority = 2, dataProvider = "Strings with Dublicates")
	public void withoutDublicatesLetters(String param) {
		userLogger.info("Checking choice without dublicates, using " + param);
		String resultStr = firstTask.getSubStringWithoutDublicates(param);

		int count = 1;
		for (int i = 0; i < resultStr.length(); i++) {
			for (int j = i + 1; j < resultStr.length(); j++) {
				if (resultStr.charAt(i) == resultStr.charAt(j)) {
					System.out.println(count);
					count++;
				}
			}
			if (count > 1) {
				fail();
			}
		}
	}

	@DataProvider(name = "For exceptions")
	public static Object[][] getClient2Data() {
		return new Object[][] { { "" }, { null } };
	}

	@Test(priority = 3, dataProvider = "For exceptions", expectedExceptions = IllegalArgumentException.class)
	public void withoutDublicatesExceptions(String param) {
		try {
			firstTask.getSubStringWithoutDublicates(param);
		} catch (IllegalArgumentException e) {
			userLogger.error(e + " " + param);
			throw new IllegalArgumentException();
		}
	}

	@Test(enabled = false)
	public void f() {
		fail();
	}

}
