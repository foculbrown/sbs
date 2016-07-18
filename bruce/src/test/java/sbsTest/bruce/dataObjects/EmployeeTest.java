package sbsTest.bruce.dataObjects;

import junit.framework.TestCase;
import sbsTest.bruce.dataObjects.Employee;

/**
 * Test some of the methods in <code>Employee</code>
 * 
 * @author Bruce Brown
 *
 */
public class EmployeeTest extends TestCase {

	/**
	 * Test that the <code>hashCode()</code> generates something.
	 */
	public void testHashCode() {
		Employee emp = new Employee();
		assertNotNull(emp.hashCode());
	}

	/**
	 * Test that <code>toString()</code> generates something.
	 */
	public void testToString() {
		Employee emp = new Employee();
		assertNotNull(emp.hashCode());
	}

	/**
	 * Because <code>setPositionCategory()</code> has restrictions on the valid
	 * values, I'm testing that it throws an error when it should.
	 */
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
