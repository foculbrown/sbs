/**
 * 
 */
package sbsTest.bruce;

import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import junit.framework.TestCase;
import sbsTest.bruce.dataObjects.Employee;
import sbsTest.bruce.dataObjects.MockEmployee;

@Path("/users")
@Produces(MediaType.APPLICATION_XML)
public class TestWithMock extends TestCase implements CRUDS {
	@Path("/")
	@GET
	public Response retrieveEmployeeXML() {
		List<Employee> emps = MockEmployee.getAll();
		GenericEntity<List<Employee>> ge = new GenericEntity<List<Employee>>(emps) {
		};
		return Response.ok(ge).build();
	}

	@Path("/{id}")
	@GET
	public Response retrieveEmployeeXMLById(@PathParam("id") Integer id) {
		return Response.ok(MockEmployee.getById(id)).build();
	}

	@Path("/")
	@POST
	public Response createEmployee(Employee emp) {
		MockEmployee.save(emp);
		return Response.ok("<status>success</status>").build();
	}

	@Path("/{id}")
	@DELETE
	public Response deleteEmployee(@PathParam("id") Integer id) {
		MockEmployee.delete(id);
		return Response.ok("<status>success</status>").build();
	}

	@Path("/")
	@POST
	public Response updateEmployee(Employee emp) {
		boolean flag = MockEmployee.update(emp);
		if (flag) {
			return Response.ok("<status>success</status>").build();
		} else {
			return Response.serverError().build();
		}
	}

	@Path("/")
	@POST
	public Response searchEmploy(String lastName) {
		Employee results = MockEmployee.searchLastName(lastName);
		if(results == null){
		return Response.serverError().build();}
		else{
			return Response.ok(results).build();
		}
	}

	@SuppressWarnings("rawtypes")
	public void testGetEmployeeXML() {
		Response response = this.retrieveEmployeeXML();
		assertNotNull("shouldn't be null", response);
		Object ent = response.getEntity();
		Employee emp = (Employee) ((List) ent).get(0);
		assertTrue("first name wrong", emp.getFirstName().equals("Bruce"));
		//System.out.println(this.retrieveEmployeeXML().getEntity().toString());
	}

	public void testGetEmployeeXMLById() {
		Response response = this.retrieveEmployeeXMLById(1);
		assertNotNull("shouldn't be null", response);
		Object ent = response.getEntity();
		Employee emp = (Employee) ent;
		assertTrue("first name wrong", emp.getFirstName().equals("Bruce"));
	}

	public void testSaveEmployee() {
		Employee emp2 = new Employee(2, "Bruce", "Red", "", "", "", "Direct", new Date(), "", "", "", "", "", true);
		Response response = this.createEmployee(emp2);
		assertTrue("respose is not ok", response.getStatus() == Response.Status.OK.getStatusCode());
		response = this.retrieveEmployeeXMLById(2);
		assertTrue("respose is not ok", response.getStatus() == Response.Status.OK.getStatusCode());
		assertTrue("emp2 is bad", ((Employee) response.getEntity()).getId() == 2);
	}

	@SuppressWarnings("rawtypes")
	public void testDeleteEmployee() {
		Employee emp2 = new Employee(2, "Bruce", "Red", "", "", "", "Direct", new Date(), "", "", "", "", "", true);
		Response response = this.createEmployee(emp2);
		assertTrue("respose is not ok", response.getStatus() == Response.Status.OK.getStatusCode());
		response = this.retrieveEmployeeXML();
		assertTrue("wrong number of emps", ((List) response.getEntity()).size() == 2);
		response = this.deleteEmployee(1);
		assertTrue("respose is not ok", response.getStatus() == Response.Status.OK.getStatusCode());
		response = this.retrieveEmployeeXML();
		assertTrue("wrong number of emps", ((List) response.getEntity()).size() == 1);
	}

	public void testUpdateEmployee() {
		Employee emp2 = new Employee(2, "Bruce", "Blue", "", "", "", "Direct", new Date(), "", "", "", "", "", true);
		Response response = this.updateEmployee(emp2);
		assertTrue("respose is not ok", response.getStatus() == Response.Status.OK.getStatusCode());
		response = this.retrieveEmployeeXMLById(2);
		Employee emp = (Employee) response.getEntity();
		assertTrue("not updated", emp.getLastName().equals("Blue"));
	}
	
	public void testSearchEmployee(){
		Response response = this.searchEmploy("Blue");
		assertNotNull("shouldn't be null", response);
		Object ent = response.getEntity();
		Employee emp = (Employee) ent;
		assertTrue("first name wrong", emp.getFirstName().equals("Bruce"));
	}

}