package sbsTest.bruce.dataObjects;

import junit.framework.TestCase;
import sbsTest.bruce.dataObjects.Employee;

public class EmployeeTest extends TestCase {

	public void testHashCode() {
		Employee emp = new Employee();
		assertNotNull(emp.hashCode());
	}

	public void testToString() {
		Employee emp = new Employee();
		assertNotNull(emp.hashCode());
	}

	public void testSetPositionCategory() {
		Employee emp = new Employee();
		try {
			emp.setPositionCategory("Direct");
		} catch (Exception e) {
			fail("setPositionCategory threw an error on set(Direct)");
		}
		try {
			emp.setPositionCategory("direct");
			fail("setPositionCatefory should have thrown an error.");
		} catch (Exception e) {
			assertNotNull("setPositionCategory failed to throw", e);
		}
	}

}
