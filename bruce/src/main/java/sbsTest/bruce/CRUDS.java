package sbsTest.bruce;

import javax.ws.rs.core.Response;

import sbsTest.bruce.dataObjects.Employee;

/**
 * This is an interface to keep the real and the mock objects in sync.
 * 
 * @author Bruce Brown
 *
 */
public interface CRUDS {
	/**
	 * Create an <code>Employee</code>.
	 * 
	 * @param emp
	 *            the new <code>Employee</code>
	 * @return A <code>Response</code> with a <code>Status</code>.
	 */
	public Response createEmployee(Employee emp);

	/**
	 * Returns all of the <code>Employee</code> objects in the database
	 * 
	 * @return A <code>Response</code> with a <code>List</code> of
	 *         <code>Employee</code> objects.
	 */
	public Response retrieveEmployeeXML();

	/**
	 * Returns the employee with the desired ID.
	 * 
	 * @param id
	 *            the ID of the desired employee.
	 * @return A <code>Response</code> with the desired <code>Employee</code>
	 *         objects.
	 */
	public Response retrieveEmployeeXMLById(Integer id);

	/**
	 * Updates the desired employee
	 * 
	 * @param emp
	 *            the <code>Employee</code> with the updated fields.
	 * @return A <code>Response</code> with a <code>Status</code>.
	 */
	public Response updateEmployee(Employee emp);

	/**
	 * Removes an <code>Employee</code> from the database.
	 * 
	 * @param id
	 *            the ID of the <code>Employee</code> to be deleted.
	 * @return A <code>Response</code> with a <code>Status</code>.
	 */
	public Response deleteEmployee(Integer id);

	/**
	 * Search the database for all the <code>Employee</code> objects with the
	 * desired last name.
	 * 
	 * @param lastName
	 *            the last name to search for.
	 * @return A <code>Response</code> with a <code>List</code> of
	 *         <code>Employee</code> objects.
	 */
	public Response searchEmploy(String lastName);
}
