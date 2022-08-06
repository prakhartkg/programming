package programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

class Employee{
	int id;
	int importanceValue;
	List<Employee> subordinates;
	
	
	public Employee(int id, int importanceValue, List<Employee> subordinates) {
		super();
		this.id = id;
		this.importanceValue = importanceValue;
		this.subordinates = subordinates;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
}
public class SAP {

	/**
	 * 
	 * 
	 * You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
You are given an array of employees employees where:
 
employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
 
 
Example 1:
 
 
Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
They both have an importance value of 3.
Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> input = new ArrayList<Employee>();
		List<Employee> e1Subordinates = new ArrayList<>();
		Employee e2 = new Employee(2, 3, new ArrayList<>());
		Employee e3 = new Employee(3, 3, new ArrayList<>());
		Employee e = new Employee(1, 5, e1Subordinates);
		e1Subordinates.add(e3);
		e1Subordinates.add(e2);
		input.add(e);
		input.add(e2);
		input.add(e3);
		
		int totalImportance = getTotalImportance(1, input);
		System.out.println(totalImportance);
	}

	private static int getTotalImportance(int id, List<Employee> input) {	
		Stack<Employee> em = new Stack<>();
		int totalImpValue = 0;
		Employee emp = input.stream().filter(e->e.id==id).findFirst().get();
		if(emp==null) return -1;
		em.push(emp);
		while(!em.isEmpty()) {
			Employee current = em.pop();
			totalImpValue+=current.importanceValue;
			em.addAll(current.subordinates);
		}	
		return totalImpValue;
	}

}
