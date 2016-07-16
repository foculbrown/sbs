package sbsTest.bruce;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import sbsTest.bruce.dataObjects.Employee;

public class restCruds implements CRUDS {

	@Path("/")
	@GET
	public Response retrieveEmployeeXML() {
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			DBCursor cursor = col.find();
			List<Employee> emps = new ArrayList<Employee>();
			while (cursor.hasNext()) {
				emps.add(toEmployee(cursor.next()));
			}

			GenericEntity<List<Employee>> ge = new GenericEntity<List<Employee>>(emps) {
			};
			return Response.ok(ge).build();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}

	}

	@Path("/{id}")
	@GET
	public Response retrieveEmployeeXMLById(@PathParam("id") Integer id) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", id).get();
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			DBCursor cursor = col.find(query);
			return Response.ok(toEmployee(cursor.next())).build();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
	}

	@Path("/")
	@POST
	public Response createEmployee(Employee emp) {
		DBObject doc = createDBOject(emp);
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			col.insert(doc);
			mongo.close();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
		return Response.ok("<status>success</status>").build();
	}

	@Path("/{id}")
	@DELETE
	public Response deleteEmployee(@PathParam("id") Integer id) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", id).get();
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			col.remove(query);
			mongo.close();
			return Response.ok("<status>success</status>").build();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
	}

	@Path("/")
	@POST
	public Response updateEmployee(Employee emp) {
		DBObject doc = createDBOject(emp);
		MongoClient mongo = null;
		DBObject query = BasicDBObjectBuilder.start().add("_id", emp.getId()).get();
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			col.update(query, doc);
			mongo.close();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
		return Response.ok("<status>success</status>").build();
	}

	@Path("/")
	@POST
	public Response searchEmploy(String lastName) {
		DBObject query = BasicDBObjectBuilder.start().add("lastName", lastName).get();
		MongoClient mongo = null;
		try {
			mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("bruce");
			DBCollection col = db.getCollection("employee");
			List<Employee> emps = new ArrayList<Employee>();
			DBCursor cursor = col.find(query);
			while (cursor.hasNext()) {
				emps.add(toEmployee(cursor.next()));
			}

			GenericEntity<List<Employee>> ge = new GenericEntity<List<Employee>>(emps) {
			};

			return Response.ok(ge).build();
		} catch (UnknownHostException e) {
			return Response.serverError().build();
		} finally {
			if (mongo != null) {
				mongo.close();
			}
		}
	}

	private static DBObject createDBOject(Employee emp) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", emp.getId());
		docBuilder.append("firstName", emp.getFirstName());
		docBuilder.append("lastName", emp.getLastName());
		docBuilder.append("middleInitial", emp.getMiddleInitial());
		docBuilder.append("emailAddress", emp.getEmailAddress());
		docBuilder.append("phoneNumber", emp.getPhoneNumber());
		docBuilder.append("positionCategory", emp.getPositionCategory());
		docBuilder.append("dateHired", emp.getDateHired());
		docBuilder.append("address1", emp.getAddress1());
		docBuilder.append("address2", emp.getAddress2());
		docBuilder.append("city", emp.getCity());
		docBuilder.append("state", emp.getState());
		docBuilder.append("zipCode", emp.getZipCode());
		docBuilder.append("activeFlag", emp.isActiveFlag());
		return docBuilder.get();
	}

	private static Employee toEmployee(DBObject dbo) {
		Employee results = new Employee();
		results.setId((Integer) dbo.get("_id"));
		results.setFirstName((String)dbo.get("firstName"));
		results.setLastName((String)dbo.get("lastName"));
		results.setMiddleInitial((String)dbo.get("middleInitial"));
		results.setEmailAddress((String)dbo.get("emailAddress"));
		results.setPhoneNumber((String)dbo.get("phoneNumber"));
		results.setPositionCategory((String)dbo.get("positionCategory"));
		results.setDateHired((Date)dbo.get("dateHired"));
		results.setAddress1((String)dbo.get("address1"));
		results.setAddress2((String)dbo.get("address2"));
		results.setCity((String)dbo.get("city"));
		results.setState((String)dbo.get("state"));
		results.setZipCode((String)dbo.get("zipCode"));
		results.setActiveFlag((Boolean)dbo.get("activeFlag"));
		
		return results;
	}
}