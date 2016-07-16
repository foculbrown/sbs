package sbsTest.bruce.dataObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockEmployee {
	private static Map<Integer, Employee> EMP_MAP = new HashMap<Integer, Employee>();
	static {
		EMP_MAP.put(1, new Employee(1, "Bruce", "Brown", "", "", "", "Direct", new Date(), "", "", "", "", "", true));
	}

	public static void save(Employee user) {
		EMP_MAP.put(user.getId(), user);
	}

	public static Employee getById(Integer id) {
		return EMP_MAP.get(id);
	}

	public static List<Employee> getAll() {
		List<Employee> users = new ArrayList<Employee>(EMP_MAP.values());
		return users;
	}

	public static void delete(Integer id) {
		EMP_MAP.remove(id);
	}

	public static boolean update(Employee emp) {
		Employee old = EMP_MAP.get(emp.getId());
		if (old == null) {
			return false;
		} else {
			old.setFirstName(emp.getFirstName());
			old.setLastName(emp.getLastName());
			old.setMiddleInitial(emp.getMiddleInitial());
			old.setEmailAddress(emp.getEmailAddress());
			old.setPhoneNumber(emp.getPhoneNumber());
			old.setPositionCategory(emp.getPositionCategory());
			old.setDateHired(emp.getDateHired());
			old.setAddress1(emp.getAddress1());
			old.setAddress2(emp.getAddress2());
			old.setCity(emp.getCity());
			old.setState(emp.getState());
			old.setZipCode(emp.getZipCode());
			old.setActiveFlag(emp.isActiveFlag());
			return true;
		}
	}

	public static Employee searchLastName(String lastName) {
		Collection<Employee> temp = EMP_MAP.values();
		for (Employee emp : temp) {
			if (emp.getLastName().equals(lastName)) {
				return emp;
			}
		}

		return null;
	}

}
