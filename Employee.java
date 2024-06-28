/**
* Employee.java
* Jon Fuller / Thursday 2:30
* The program manages employee data through an Employee class. It allows for the creation of employees with attributes like 
name, ID number, and pay details. Methods are provided to calculate gross pay, check employee ID existence, and retrieve employee 
information. Overall, it facilitates basic employee data management tasks within an organization.
*/
import java.util.*;
public class Employee{
		
	private String name;
	private String idNumber;
	private char employeeType;
	private double payRate;
	private int yearlySalary;
	private final int  WEEKS_IN_YEAR = 52;
		
		
/**
 * Constructs an Employee object with the specified attributes.
 *
 * @param n The name of the employee.
 * @param id The ID number of the employee.
 * @param t The type of the employee ('S' for salaried, 'H' for hourly).
 * @param pr The pay rate of the employee (either hourly rate or yearly salary).
 *
 * @return An Employee object with the given attributes.
 */		
		public Employee(String n, String id, char t, double pr){
			name = n;
			idNumber = id;
			employeeType = t;
			payRate = pr;
			yearlySalary = -1;
				
			
		}

/**
 * Constructs an Employee object with the specified attributes.
 *
 * @param n The name of the employee.
 * @param id The ID number of the employee.
 * @param t The type of the employee ('S' for salaried, 'H' for hourly).
 * @param pr The yearly salary of the employee.
 *
 * @return An Employee object with the given attributes.
 */
		public Employee(String n, String id, char t, int pr){
			name = n;
			idNumber = id;
			employeeType = t;
			payRate = -1;
			yearlySalary = pr;
			
		}
/**
 * Calculates the gross pay for an employee based on the given number of hours worked.
 *
 * @param hours The number of hours worked by the employee.
 * @return The gross pay for the employee.
 */		
		public double getGrossPay(double hours){
			double grossPay = 0;
			if(hours>40){
				double ot = hours - 40;
				grossPay = (ot * (payRate*1.5)) + ((hours-ot) * payRate);
			}//end if
			else{
				grossPay = hours * payRate;
			}// end else
			return grossPay;
		}// end getGrossPay(double hours)
/**
 * Calculates the gross pay for an employee based on the yearly salary.
 *
 * @return The gross pay for the employee.
 */		
		public double getGrossPay(){
			return (double) yearlySalary / WEEKS_IN_YEAR;
		}// end getGrossPay()
/**
 * Returns a string representation of the employee.
 *
 * @return A string containing the name and ID number of the employee.
 */
		public String toString(){
			return(
			name + 
			"\nID #" + idNumber
			);
		}// end toString()	
/**
 * Checks if the current employee's ID number is equal to any ID number in the provided list of employees.
 *
 * @param employeeList The list of employees to compare against.
 * @return true if the current employee's ID number is found in the list, otherwise false.
 */		
		public boolean equals(ArrayList<Employee> employeeList){
			boolean ans = false;
			for(Employee em : employeeList){
				
				if((this.idNumber).equals(em.idNumber)){
					ans =  true;
				}
				else{
					ans =  false;
				}
			}
			return ans;
		}// end equals()
/**
 * Determines if the employee type is salaried.
 *
 * @return true if the employee type is salaried ('S'), otherwise false.
 */		
		public boolean getType(){
			if(employeeType == 'S'){
				return true;
			}
			else{
				return false;
			}
		}
	
/**
 * Gets the name of the employee.
 *
 * @return The name of the employee.
 */
		public String getName(){
			return name;
		}
/**
 * Gets the ID number of the employee.
 *
 * @return The ID number of the employee.
 */	
		public String getID(){
			return idNumber;
			
		}
}// end class