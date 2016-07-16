package sbsTest.bruce;

import javax.ws.rs.core.Response;

import sbsTest.bruce.dataObjects.Employee;

public interface CRUDS {
	public Response createEmployee(Employee emp);

	public Response retrieveEmployeeXML();

	public Response retrieveEmployeeXMLById(Integer id);

	public Response updateEmployee(Employee emp);

	public Response deleteEmployee(Integer id);
	
	public Response searchEmploy(String lastName);
}
